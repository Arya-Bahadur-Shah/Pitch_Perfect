<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<div class="navi-main">
  <header class="top-header">
    <div class="logo">
      <img src="${pageContext.request.contextPath}/images/logo.png" alt="Pitch Perfect Logo">
    </div>

    <nav class="nav-links">
      <a href="${pageContext.request.contextPath}/pages/home.jsp" class="active">Futsal</a>
      <a href="${pageContext.request.contextPath}/pages/accessories.jsp">Accessories</a>
    </nav>
    <div class="icons">
      <i class="fas fa-shopping-cart"></i>
      <a href="${pageContext.request.contextPath}/pages/account.jsp"><i class="fas fa-user-circle"></i></a>
    </div>
  </header>
  <div class="search-bar">
    <input type="text" placeholder="Search">
    <button class="filter-btn"><i class="fas fa-sliders-h"></i></button>
    <button class="search-btn"><i class="fas fa-search"></i></button>
  </div>
</div>