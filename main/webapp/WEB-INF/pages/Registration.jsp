<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Create Account - Pitch Perfect</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Registration.css" />
</head>
<body>
  <div class="container">
    <div class="left-panel">
      <h1>Welcome</h1>
      <p>to <span class="title-name">Pitch Perfect</span></p>
      <img src="${pageContext.request.contextPath}/images/footform.png" alt="Pitch Perfect Logo"/>
    </div>
    <div class="right-panel">
      <h2>Create Account</h2>
      <form class="signup-form" action="register" method="post">
        <div class="form-row">
          <div>
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" placeholder="First Name" required />
          </div>
          <div>
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" placeholder="Last Name" required />
          </div>
        </div>
        <div class="insideform">
          <label for="email">Email:</label>
          <input type="email" id="email" name="email" placeholder="Email" required />
        </div>
        <div class="insideform"> 
          <label for="username">Username:</label>
          <input type="text" id="username" name="username" placeholder="Username" required />
        </div>
        <div class="insideform">
          <label for="phone">Phone Number:</label>
          <input type="tel" id="phone" name="phone" placeholder="Phone Number" required />
        </div>
        <div class="insideform"> 
          <label for="dob">Date of Birth:</label>
          <input type="date" id="dob" name="dob" placeholder="Date of Birth" required />
        </div>
        <div class="insideform"> 
          <label for="password">Password:</label>
          <input type="password" id="password" name="password" placeholder="Password" required />
        </div>
        <div class="insideform"> 
          <label for="retype-password">Re-Type Password:</label>
          <input type="password" id="retype-password" name="retypePassword" placeholder="Re-Type Password" required />
        </div> 
        <button type="submit">Sign Up</button>
        <p class="login-link">Already have an account? <a href="${pageContext.request.contextPath}/pages/Login.jsp">Log in</a></p>
      </form>
    </div>
  </div>
</body>
</html>
    