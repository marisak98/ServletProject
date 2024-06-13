<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>My APP</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/iconfonts/mdi/css/materialdesignicons.min.css">

    <!--css plugins-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared/style.css">
    <!--Layout styles-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo_1/style.css">
    <!--End layout styles-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/img/favicon.ico">
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
        </div>
        <%@include file="sidebar.jsp"%>
    </div>

    <div class="main-content">
        <div class="container-scroller">
        <jsp:include page="${page}" />
      </div>
    </div>

    <script>
        const btn = document.querySelector("#btn");
        const sidebar = document.querySelector(".sidebar");

        btn.onclick = function() {
            sidebar.classList.toggle("active");
        }
    </script>
</body>
</html>
