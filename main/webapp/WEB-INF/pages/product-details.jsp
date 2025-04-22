<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Dhuku Sports Hub</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/productdetails.css">
</head>
<body>

<div class="container">
  <h1>Dhuku Sports Hub</h1>

  <div class="photos">
    <div class="large-image">
      <img src="${pageContext.request.contextPath}/images/image.png" alt="Main Field">
    </div>
    <div class="small-images">
      <img src="${pageContext.request.contextPath}/images/image11.png" alt="Small 1">
      <img src="${pageContext.request.contextPath}/images/image12.png" alt="Small 2">
      <img src="${pageContext.request.contextPath}/images/image21.png" alt="Small 3">
      <img src="${pageContext.request.contextPath}/images/image22.png" alt="Small 4">
    </div>
  </div>

  <div class="content">
    <div class="description">
      <h2>5 v 5 Futsal in Kathmandu, Nepal</h2>
      <p>2 Futsal Pitches . Changing Room . Showers .</p>
      <p>Contact number: 55334412, 52152362</p>
      <div class="posted-by">
        <img src="${pageContext.request.contextPath}/images/profile-image.jpg" alt="Profile Image">
        <div>
          <p>Posted by Jeeyuth Shresthan</p>
          <p>Lamtingtar Marg 4, Kathmandu 44600</p>
        </div>
      </div>
    </div>

    <div class="booking">
      <div class="price">
        <h3>Rs 1200<span>/hr</span></h3>
      </div>
      <div class="time-slots">
        <div class="days">
          <button type="button">Sun</button>
          <button type="button">Mon</button>
          <button type="button">Tue</button>
          <button type="button">Wed</button>
          <button type="button">Thu</button>
          <button type="button">Fri</button>
          <button type="button">Sat</button>
        </div>
        <div class="slots">
          <button type="button">5-10</button>
          <button type="button">10-11</button>
          <button type="button">11-12</button>
          <button type="button">12-13</button>
          <button type="button">13-14</button>
          <button type="button">14-15</button>
          <button type="button">15-16</button>
          <button type="button">16-17</button>
        </div>
      </div>
      <button type="button" class="cart">Add to Cart</button>
    </div>
  </div>
</div>

</body>
</html>