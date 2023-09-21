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
    <h3 style="text-align: center;margin-top:15px;">Quản lý Khách Hàng</h3>
    <a href="/admin/khach-hang/create" class="btn btn-success">Add</a>
    <c:if test="${ f:length(listKhachHang) == 0 }">
        <h4 class="text-center">Không có dữ liệu</h4>
    </c:if>
    <c:if test="${f:length(listKhachHang) != 0}">
        <table class="table">
            <thead>
            <tr>
                <td>Mã</td>
                <td>Họ Và Tên</td>
                <td>Ngày Sinh</td>
                <td>SDT</td>
                <td>Email</td>
                <td>Địa Chỉ</td>
                <td>Thành Phố</td>
                <td>Quốc Gia</td>
                <td colspan="2">Active</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listKhachHang}" var="kh">
                <tr>
                    <td>${kh.ma}</td>
                    <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                    <td>${kh.ngaySinh}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.email}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.thanhPho}</td>
                    <td>${kh.quocGia}</td>
                    <td>
                        <a href="/admin/khach-hang/edit/${kh.id}" class="btn btn-primary">Detail</a>
                        <a href="/admin/khach-hang/remove/${kh.id}" class="btn btn-danger"
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