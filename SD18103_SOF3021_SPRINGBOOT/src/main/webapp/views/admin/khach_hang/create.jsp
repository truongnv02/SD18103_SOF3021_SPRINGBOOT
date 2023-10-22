<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h3 style="text-align: center;margin-top:15px;">Thêm thông tin Khách Hàng</h3>
        <a href="/admin/khach-hang/index" class="btn btn-success">EXIT</a>
        <f:form action="${action}" modelAttribute="kh" method="post">
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Họ</label>
                    <f:input type="text" path="ho" cssClass="form-control" />
                    <f:errors path="ho" element="span" cssClass="text-danger" />
                </div>
                <div class="col-6">
                    <label class="form-label">Tên đệm</label>
                    <f:input type="text" path="tenDem" cssClass="form-control" />
                    <f:errors path="tenDem" element="span" cssClass="text-danger" />
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Tên</label>
                    <f:input type="text" path="ten" cssClass="form-control" />
                    <f:errors path="ten" element="span" cssClass="text-danger" />
                </div>
                <div class="col-6">
                    <label class="form-label">SDT</label>
                    <f:input type="tel" path="sdt" cssClass="form-control" />
                    <f:errors path="sdt" element="span" cssClass="text-danger" />
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Ngày sinh</label>
                    <f:input type="date" path="ngaySinh" cssClass="form-control" />
                    <f:errors path="ngaySinh" element="span" cssClass="text-danger" />
                </div>
                <div class="col-6">
                    <label class="form-label">Địa chỉ</label>
                    <f:input type="text" path="diaChi" cssClass="form-control" />
                    <f:errors path="diaChi" element="span" cssClass="text-danger" />
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Email</label>
                    <f:input type="email" path="email" cssClass="form-control" />
                    <f:errors path="email" element="span" cssClass="text-danger" />
                </div>
                <div class="col-6">

                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label class="form-label">Thành phố</label>
                    <f:input type="text" path="thanhPho" cssClass="form-control" />
                    <f:errors path="thanhPho" element="span" cssClass="text-danger" />
                </div>
                <div class="col-6">
                    <label class="form-label">Quốc gia</label>
                    <f:input type="text" path="quocGia" cssClass="form-control" />
                    <f:errors path="quocGia" element="span" cssClass="text-danger" />
                </div>
            </div>
            <div class="row mt-4" style="justify-content: center">
                <button class="btn btn-success col-1 m-3">SUBMIT</button>
            </div>
        </f:form>
    </div>
</body>
</html>