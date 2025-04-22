<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>My Account</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/account.css" />
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
        <a href="#" class="nav-link active">My Account</a>
        <a href="${pageContext.request.contextPath}/pages/change-password.jsp" class="nav-link">Change Password</a>
        <a href="${pageContext.request.contextPath}/logout" class="nav-link">Log Out</a>
      </nav>
    </div>

    <main class="main-content">
      <h2>My Account</h2>
      <div class="profile-section">
        <img src="${pageContext.request.contextPath}/images/profile.jpg" alt="Profile" class="profile-pic" />
      </div>
      <form class="account-form" action="${pageContext.request.contextPath}/account/update" method="post">
        <div class="form-row">
          <div class="form-group">
            <label>First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}" />
          </div>
          <div class="form-group">
            <label>Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}" />
          </div>
        </div>
        <div class="form-group">
          <label>Email:</label>
          <input type="email" name="email" value="${user.email}" readonly />
        </div>
        <div class="form-group">
          <label>Username:</label>
          <input type="text" name="username" value="${user.username}" readonly />
        </div>
        <div class="form-group">
          <label>Phone Number:</label>
          <input type="tel" name="phone" value="${user.phoneNumber}" />
        </div>
        <div class="form-group">
          <label>Date of Birth:</label>
          <input type="date" name="dob" value="${user.dob}" />
        </div>
        <div class="button-group">
          <button type="submit" class="btn">Save Changes</button>
          <a href="${pageContext.request.contextPath}/pages/change-password.jsp">
            <button type="button" class="btn">Change Password</button>
          </a>
        </div>
      </form>
    </main>
  </div>
</body>
</html>