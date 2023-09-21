<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Sản Phẩm</h3>
        <a href="/admin/san-pham/index" class="btn btn-success">EXIT</a>
        <f:form action="${action}" modelAttribute="sp" method="post" enctype="multipart/form-data">
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <f:input type="text" path="ten" cssClass="form-control" />
                    <f:errors path="ten" element="span" cssClass="text-danger" />
                </div>
                <div class="col-6">
                    <label class="form-label">Hình ảnh</label>
                    <f:input type="file" path="imageSP" class="form-control" />
                    <f:errors path="imageSP" element="span" cssClass="text-danger" />
                </div>
            </div>
            <div class="row mt-4" style="justify-content: center">
                <button class="btn btn-primary col-1 m-3">SUBMIT</button>
            </div>
        </f:form>
    </div>
</body>
</html>