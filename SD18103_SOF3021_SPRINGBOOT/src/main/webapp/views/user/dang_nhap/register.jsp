<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
</head>
<body>
<c:if test="${not empty message}">
    <div class="alert alert-success" role="alert">
            ${message}
    </div>
</c:if>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Register</h3>
    <sf:form method="post" action="/register" modelAttribute="kh">
        <div class="form-group">
            <label>Họ:</label>
            <sf:input path="ho" type="text" class="form-control" />
        </div>
        <div class="form-group">
            <label >Tên đệm:</label>
            <sf:input path="tenDem" type="text" class="form-control" />
        </div>
        <div class="form-group">
            <label>Tên:</label>
            <sf:input path="ten" type="text" class="form-control" />
        </div>
        <div class="form-group">
            <label>Email:</label>
            <sf:input path="email" type="email" class="form-control" />
        </div>
        <div class="form-group">
            <label>Mật khẩu:</label>
            <sf:input path="matKhau" type="password" class="form-control" />
        </div>
        <div class="row mt-4" style="justify-content: center">
            <button type="submit" class="btn btn-success col-1 m-3">Đăng ký</button>
        </div>
    </sf:form>
</div>
</body>
</html>