<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>My APP</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="../../css/styles.css">
  </head>
  <body>
    <div class="sidebar">
      <div class="top">
        <div class="logo">
         <%@include file="./components/logo.jsp"%>
        </div>
        <i class='bx bx-menu' id="btn"></i>
      </div> 
      <div class="user">
        <img src="https://i.pinimg.com/564x/b6/62/d6/b662d679db4da7f3f87018c6cc30674a.jpg" alt="user" class="user-img">
        <div>
          <p class="bold">Client.B</p>
          <p>Admin</p>
        </div>
        </img>
      </div>
      <%@include file="sidebar.jsp"%>
      </body>
  </html>
