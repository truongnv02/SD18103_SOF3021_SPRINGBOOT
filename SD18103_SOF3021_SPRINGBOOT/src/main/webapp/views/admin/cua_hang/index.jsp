<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Quản lý Cửa Hàng</h3>
    <a href="/admin/cua-hang/create" class="btn btn-success">Add</a>
    <c:if test="${ f:length(listCuaHang) == 0 }">
        <h4 class="text-center">Không có dữ liệu</h4>
    </c:if>
    <c:if test="${f:length(listCuaHang) != 0}">
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>Mã</td>
                <td>Tên</td>
                <td>Địa Chỉ</td>
                <td>Thành Phố</td>
                <td>Quốc Gia</td>
                <td colspan="2">Active</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCuaHang}" var="ch" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${ch.ma}</td>
                    <td>${ch.ten}</td>
                    <td>${ch.diaChi}</td>
                    <td>${ch.thanhPho}</td>
                    <td>${ch.quocGia}</td>
                    <td>
                        <a href="/admin/cua-hang/edit/${ch.id}" class="btn btn-primary">Detail</a>
                        <a href="/admin/cua-hang/remove/${ch.id}" class="btn btn-danger"
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