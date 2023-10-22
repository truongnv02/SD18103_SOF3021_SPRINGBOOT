<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
</head>
<body>
<div>
    <f:form action="/admin/check-loginAdmin" method="post" modelAttribute="admin">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="text-center">Đăng nhập</h4>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="form-group">
                                    <label >Email</label>
                                    <f:input path="email" type="email" class="form-control" required="true"/>
                                    <f:errors path="email" element="span" cssClass="text-danger"/>
                                </div>
                                <div class="form-group">
                                    <label >Mật khẩu</label>
                                    <f:input path="matKhau" type="password" class="form-control" required="true"/>
                                    <f:errors path="matKhau" element="span" cssClass="text-danger"/>
                                </div>
                                <c:if test="${not empty error}">
                                    <p style="color: red">${error}</p>
                                </c:if>
                                <div class="form-group text-center mt-4">
                                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </f:form>
</div>
</body>
</html>
