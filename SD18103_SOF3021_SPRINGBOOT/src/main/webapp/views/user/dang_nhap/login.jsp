<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Đăng nhập hoặc đăng ký thành viên</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Đăng nhập hoặc đăng ký thành viên</h3>
    <hr>
    <div class="timeline">
        <div class="row">
            <div class="col-6 text-center mt-5">
                <sf:form modelAttribute="user" method="post" action="/check-login" >
                    <h3>Đăng nhập thành viên</h3>
                    <div class="mb-3 pe-5">
                        <sf:input type="email" path="email" class="form-control" placeholder="Email" />
                        <sf:errors path="email" cssClass="text-danger" element="span" />
                    </div>
                    <div class="mb-3 pe-5">
                        <sf:input type="password" path="matKhau" class="form-control" placeholder="Mật khẩu" />
                        <sf:errors path="matKhau" cssClass="text-danger" element="span" />
                    </div>
                    <c:if test="${not empty error}">
                        <p style="color: red">${error}</p>
                    </c:if>
                    <button class="btn btn-success w-75 h-30 mt-3 fs-4">Đăng nhập</button>
                    <p class="fw-semibold mt-2">Đăng nhập nhanh/Đăng ký thành viên bằng tài khoản mạng xã hội:</p>
                    <a class="btn text-white me-2" href="#" role="button" style="background-color: #3B5998;">Facebook</a>
                    <a class="btn text-white" href="#" role="button" style="background-color: #EA4335;">Google</a>
                    <br>
                    <span>
                                <p>* Có thể đăng nhập nhanh hoặc đăng ký thành viên mới bằng tài khoản mạng xã hội.</p>
                                <p>* Thành viên Innisfree chưa liên kết với tài khoản mạng xã hội có thể đăng nhập và thiết lập liên kết một cách nhanh chóng</p>
                            </span>
                </sf:form>
            </div>
            <div class="col-5 text-center ps-5 mt-5">
                <h3>Đăng ký thành viên mới</h3>
                <br>
                <span class="ms-3">Đăng ký ngay để mua sắm dễ dàng hơn và tận hưởng thêm nhiều ưu đãi độc quyền cho thành viên Innisfree.</span>
                <br>
                <a href="/register" class="btn btn-primary">Đăng ký</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>