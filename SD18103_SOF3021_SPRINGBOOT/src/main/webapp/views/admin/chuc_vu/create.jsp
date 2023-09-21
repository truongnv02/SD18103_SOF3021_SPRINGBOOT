<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Chức Vụ</h3>
        <a href="/admin/chuc-vu/index" class="btn btn-success">EXIT</a>
        <f:form action="${action}" modelAttribute="cv" method="post">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <f:input type="text" path="ma" cssClass="form-control" />
                <f:errors path="ma" element="span" cssClass="text-danger" />
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <f:input type="text" path="ten" cssClass="form-control" />
                <f:errors path="ten" element="span" cssClass="text-danger" />
            </div>
            <div class="row mt-4" style="justify-content: center">
                <button class="btn btn-success col-1 m-3">SUBMIT</button>
            </div>
        </f:form>
    </div>
</body>
</html>