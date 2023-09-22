<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Quản lý Sản Phẩm</h3>
    <a href="/admin/san-pham/create" class="btn btn-primary">Add</a>
    <c:if test="${ f:length(listSanPham) == 0 }">
        <h3 style="text-align: center;margin-top:15px;">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listSanPham) != 0 }">
        <table class="table">
            <thead>
            <tr>
                <td>Mã</td>
                <td>Tên</td>
                <td>Hình ảnh</td>
                <td>Active</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSanPham}" var="sp">
                <tr>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td><img src="../../../images/${sp.imageSP}" alt="Ảnh Sản Phẩm" style="width:70px; height: 60px;"></td>
                    <td>
                        <a href="/admin/san-pham/edit/${sp.ma}" class="btn btn-success">Detail</a>
                        <a href="/admin/san-pham/remove${sp.ma}" class="btn btn-danger"
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