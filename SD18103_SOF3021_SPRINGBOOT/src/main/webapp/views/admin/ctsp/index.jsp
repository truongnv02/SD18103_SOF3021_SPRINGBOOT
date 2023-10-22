<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Quản lý Chi Tiết Sản Phẩm</h3>
    <a href="/admin/ctsp/create" class="btn btn-primary">Add</a>
    <c:if test="${ f:length(listCTSP) ==0}">
        <h3 style="text-align: center;margin-top:15px;">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(listCTSP) != 0}">
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>Hình ảnh</td>
                <td>Sản phẩm</td>
                <td>Màu sắc</td>
                <td>Nhà sản xuất</td>
                <td>Dòng sản phẩm</td>
                <td>Năm bảo hành</td>
                <td>Số lượng</td>
                <td>Giá nhập</td>
                <td>Giá bán</td>
                <td>Mô tả</td>
                <td>Active</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCTSP}" var="ctsp" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td><img src="../../../images/${ctsp.sanPham.imageSP}" alt="Ảnh Sản Phẩm" style="width:70px; height: 60px;"></td>
                    <td>${ctsp.sanPham.ten}</td>
                    <td>${ctsp.mauSac.ten}</td>
                    <td>${ctsp.nsx.ten}</td>
                    <td>${ctsp.dongSP.ten}</td>
                    <td>${ctsp.namBH}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.giaNhap}</td>
                    <td>${ctsp.giaBan}</td>
                    <td>${ctsp.moTa}</td>
                    <td>
                        <a href="/admin/ctsp/edit/${ctsp.id}" class="btn btn-primary">Detail</a>
                        <a href="/admin/ctsp/remove/${ctsp.id}" class="btn btn-danger"
                            onclick="return confirm('Bạn có muốn xóa không ?')">
                            Delete
                        </a>
                        <a href="#" class="btn btn-success">Add to cart</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>