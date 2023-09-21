<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Dòng Sản Phẩm</h3>
    <a href="/admin/dong-sp/index" class="btn btn-success">EXIT</a>
    <f:form action="${action}" modelAttribute="dsp" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Tên</label>
                <f:input type="text" path="ten" cssClass="form-control" />
                <f:errors path="ten" element="span" cssClass="text-danger" />
            </div>
            <div class="col-6">

            </div>
        </div>
        <div class="row mt-4" style="justify-content: center">
            <button class="btn btn-primary col-1 m-3">SUBMIT</button>
        </div>
    </f:form>
</div>
</body>
</html>