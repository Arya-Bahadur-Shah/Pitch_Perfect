<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Edit Profile</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit-profile.css" />
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
        <a href="${pageContext.request.contextPath}/pages/account.jsp" class="nav-link active">My Account</a>
        <a href="${pageContext.request.contextPath}/pages/change-password.jsp" class="nav-link">Change Password</a>
        <a href="${pageContext.request.contextPath}/logout" class="nav-link">Log Out</a>
      </nav>
    </div>

    <main class="main-content">
      <h2>Edit Profile</h2>
      <div class="profile-section">
        <img src="${pageContext.request.contextPath}/images/profile.jpg" alt="Profile" class="profile-pic" />
        <label for="profile-upload" class="change-photo">Change Photo</label>
        <input type="file" id="profile-upload" accept="image/*" style="display: none;" />
      </div>
      
      <form class="account-form" action="${pageContext.request.contextPath}/account/update" method="post" enctype="multipart/form-data">
        <div class="form-row">
          <div class="form-group">
            <label>First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}" required />
          </div>
          <div class="form-group">
            <label>Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}" required />
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
          <input type="tel" name="phoneNumber" value="${user.phoneNumber}" 
                 pattern="[0-9]{10}" title="10 digit phone number" required />
        </div>
        <div class="form-group">
          <label>Date of Birth:</label>
          <input type="date" name="dob" value="${user.dob}" required />
        </div>
        
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        
        <div class="button-group">
          <button type="submit" class="save-btn">Save Changes</button>
          <button type="button" class="discard-btn" 
                  onclick="window.location.href='${pageContext.request.contextPath}/pages/account.jsp'">
            Don't Save
          </button>
        </div>
      </form>
    </main>
  </div>
</body>
</html>