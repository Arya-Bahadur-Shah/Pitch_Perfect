<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Login - Pitch Perfect</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Registration.css" />
</head>
<body>
  <div class="container">
    <div class="left-panel">
      <h1>Welcome</h1>
      <p>to <span class="title-name">Pitch Perfect</span></p>
      <img src="${pageContext.request.contextPath}/images/footform.png" />
    </div>
    <div class="right-panel">
      <h2>Sign In to your Account</h2>
      <form class="signup-form" action="${pageContext.request.contextPath}/login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" placeholder="Username" required />
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Password" required />
        <button type="submit">Sign In</button>
        <p class="login-link">Don't have an account? <a href="${pageContext.request.contextPath}/pages/Registration.jsp">Sign up</a></p>
      </form>
    </div>
  </div>
</body>
</html>	