<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Change Password</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Changepassword.css" />
</head>
<body>
  <div class="container">
    <div class="sidebar">
      <div class="logo"> 
        <a href="${pageContext.request.contextPath}/pages/home.jsp">
          <img src="${pageContext.request.contextPath}/images/logo.png" alt="Pitch Perfect Logo" class="logo-img" />
        </a>
      </div>
      <nav class="nav">
        <a href="${pageContext.request.contextPath}/pages/account.jsp" class="nav-link">My Account</a>
        <a href="#" class="nav-link active">Change Password</a>
        <a href="${pageContext.request.contextPath}/logout" class="nav-link">Log Out</a>
      </nav>
    </div>

    <main class="main-content">
      <h2>Change Password</h2>
      
      <form class="account-form" action="${pageContext.request.contextPath}/account/change-password" method="post">
        <div class="form-group">
          <label>Current Password:</label>
          <input type="password" name="currentPassword" required />
        </div>
        <div class="form-group">
          <label>New Password:</label>
          <input type="password" name="newPassword" required 
                 pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                 title="Must contain at least 8 characters, including uppercase, lowercase, and numbers" />
        </div>
        <div class="form-group">
          <label>Confirm New Password:</label>
          <input type="password" name="confirmPassword" required />
        </div>
        <div class="button-group">
          <button type="submit" class="save-btn">Save Changes</button>
          <button type="button" class="discard-btn" onclick="window.location.href='${pageContext.request.contextPath}/pages/account.jsp'">
            Don't Save
          </button>
        </div>
      </form>
    </main>
  </div>
</body>
</html>