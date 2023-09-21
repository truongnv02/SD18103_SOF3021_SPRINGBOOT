<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Quản lý Nhân Viên</h3>
    <a href="/admin/nhan-vien/create" class="btn btn-success">Add</a>
    <c:if test="${ f:length(listNhanVien) == 0 }">
        <h4 class="text-center">Không có dữ liệu</h4>
    </c:if>
    <c:if test="${f:length(listNhanVien) != 0}">
        <table class="table">
            <thead>
            <tr>
                <td>Mã</td>
                <td>Họ Và Tên</td>
                <td>Giới Tính</td>
                <td>Ngày Sinh</td>
                <td>Địa Chỉ</td>
                <td>SDT</td>
                <td>Email</td>
                <td>Cửa Hàng</td>
                <td>Chức Vụ</td>
                <td>Trạng Thái</td>
                <td colspan="2">Active</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${listNhanVien}" var="nv">
                    <tr>
                        <td>${nv.ma}</td>
                        <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                        <td>${nv.gioiTinh}</td>
                        <td>${nv.ngaySinh}</td>
                        <td>${nv.diaChi}</td>
                        <td>${nv.sdt}</td>
                        <td>${nv.email}</td>
                        <td>${nv.cuaHang.getTen()}</td>
                        <td>${nv.chucVu.ten}</td>
                        <td>${nv.trangThai == 1 ? "Đang làm" : "Đã nghỉ"}</td>
                        <td>
                            <a href="/admin/nhan-vien/edit/${nv.id}" class="btn btn-primary">Detail</a>
                            <a href="/admin/nhan-vien/remove/${nv.id}" class="btn btn-danger"
                               onclick="return confirm('Bạn có muốn xóa không ?')">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>