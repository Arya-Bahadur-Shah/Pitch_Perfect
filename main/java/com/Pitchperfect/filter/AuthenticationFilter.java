package com.Pitchperfect.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    // Public URLs that don't require authentication
    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";
    private static final String HOME = "/home";
    private static final String ROOT = "/";
    private static final String ABOUT = "/about";
    private static final String CONTACT = "/contact";
    
    // Authenticated user URLs
    private static final String ACCOUNT = "/account";
    private static final String EDIT_PROFILE = "/edit-profile";
    private static final String CHANGE_PASSWORD = "/change-password";
    private static final String PRODUCTS = "/products";
    private static final String ACCESSORIES = "/accessories";
    
    // Admin URLs (if applicable)
    private static final String ADMIN_DASHBOARD = "/admin/dashboard";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        
        // Allow access to static resources
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".jpg")) {
            chain.doFilter(request, response);
            return;
        }
        
        // Check if user is logged in
        boolean isLoggedIn = req.getSession().getAttribute("user") != null;
        String userRole = (String) req.getSession().getAttribute("role"); // "user" or "admin"

        // Public access routes
        if (uri.equals(contextPath + ROOT) || 
            uri.equals(contextPath + HOME) || 
            uri.equals(contextPath + LOGIN) || 
            uri.equals(contextPath + REGISTER) || 
            uri.equals(contextPath + ABOUT) || 
            uri.equals(contextPath + CONTACT)) {
            
            // If already logged in, redirect from login/register to home
            if (isLoggedIn && (uri.equals(contextPath + LOGIN) || uri.equals(contextPath + REGISTER))) {
                res.sendRedirect(contextPath + HOME);
                return;
            }
            chain.doFilter(request, response);
            return;
        }
        
        // If not logged in, redirect to login
        if (!isLoggedIn) {
            res.sendRedirect(contextPath + LOGIN);
            return;
        }
        
        // User role based access control
        if ("admin".equals(userRole)) {
            // Admin specific routes
            if (uri.startsWith(contextPath + ADMIN_DASHBOARD)) {
                chain.doFilter(request, response);
            } else {
                // Redirect non-admin pages to admin dashboard
                res.sendRedirect(contextPath + ADMIN_DASHBOARD);
            }
        } else {
            // Regular user routes
            if (uri.equals(contextPath + ACCOUNT) || 
                uri.equals(contextPath + EDIT_PROFILE) || 
                uri.equals(contextPath + CHANGE_PASSWORD) || 
                uri.equals(contextPath + PRODUCTS) || 
                uri.equals(contextPath + ACCESSORIES)) {
                
                chain.doFilter(request, response);
            } else {
                // Redirect unauthorized pages to home
                res.sendRedirect(contextPath + HOME);
            }
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic
    }
}