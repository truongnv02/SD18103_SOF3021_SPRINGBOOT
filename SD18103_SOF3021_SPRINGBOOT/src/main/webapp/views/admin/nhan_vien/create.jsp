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
    <h3 style="text-align: center;margin-top:15px;">Thêm thông tin nhân viên</h3>
    <a href="/admin/nhan-vien/index" class="btn btn-success">EXIT</a>
    <f:form action="${action}" modelAttribute="nv" method="post">
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
                <label class="form-label">Ngày sinh</label>
                <f:input type="date" path="ngaySinh" cssClass="form-control" />
                <f:errors path="ngaySinh" element="span" cssClass="text-danger" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Địa chỉ</label>
                <f:input type="text" path="diaChi" cssClass="form-control" />
                <f:errors path="diaChi" element="span" cssClass="text-danger" />
            </div>
            <div class="col-6">
                <label class="form-label">SDT</label>
                <f:input type="tel" path="sdt" cssClass="form-control" />
                <f:errors path="sdt" element="span" cssClass="text-danger" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Email</label>
                <f:input type="text" path="email" cssClass="form-control" />
                <f:errors path="email" element="span" cssClass="text-danger" />
            </div>
            <div class="col-6">
                <label class="form-label">Mật khẩu</label>
                <f:password path="matKhau" cssClass="form-control" />
                <f:errors path="matKhau" element="span" cssClass="text-danger" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Cửa hàng</label>
                <f:select cssClass="form-control" path="cuaHang">
                    <c:forEach items="${listCuaHang}" var="ch">
                        <option value="${ch.id}" ${ch.id == nv.cuaHang.id ? "selected" : ""}>${ch.ten}</option>
                    </c:forEach>
                </f:select>
                <f:errors path="cuaHang" element="span" cssClass="text-danger" />
            </div>
            <div class="col-6">
                <label class="form-label">Chức vụ</label>
                <f:select cssClass="form-control" path="chucVu">
                    <c:forEach items="${listChucVu}" var="cv">
                        <option value="${cv.id}" ${cv.id == nv.chucVu.id ? "selected" : ""}>${cv.ten}</option>
                    </c:forEach>
                </f:select>
                <f:errors path="chucVu" element="span" cssClass="text-danger" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <f:radiobutton cssClass="form-check-input" path="gioiTinh" value="Nam" checked="true" />
                    <label class="form-check-label">Nam</label>
                </div>
                <div class="form-check">
                    <f:radiobutton cssClass="form-check-input" path="gioiTinh" value="Nữ" />
                    <label class="form-check-label">Nữ</label>
                </div>
                <f:errors path="gioiTinh" element="span" cssClass="text-danger" />
            </div>
            <div class="col-6">
                <label class="form-label">Trạng thái</label>
                <div class="form-check">
                    <f:radiobutton cssClass="form-check-input" path="trangThai" value="1" checked="true" />
                    <label class="form-check-label">Đang làm</label>
                </div>
                <div class="form-check">
                    <f:radiobutton cssClass="form-check-input" path="trangThai" value="0" />
                    <label class="form-check-label">Đã nghỉ</label>
                </div>
                <f:errors path="trangThai" element="span" cssClass="text-danger" />
            </div>
        </div>
        <div class="row mt-4" style="justify-content: center">
            <button class="btn btn-primary col-1 m-3">SUBMIT</button>
        </div>
    </f:form>
</div>
</body>
</html>