<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
</head>
<body>
<div class="d-flex mt-5" style="margin-left: 20px" id="wrapper" >
    <!-- Sidebar-->
    <div class="border-end bg-white" id="sidebar-wrapper">
        <div class="sidebar-heading border-bottom bg-light">ADMIN</div>
        <div class="list-group list-group-flush">
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/chuc-vu/index">Chức vụ</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/cua-hang/index">Cửa Hàng</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/nhan-vien/index">Nhân Viên</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/khach-hang/index">Khách Hàng</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/san-pham/index">Sản phẩm</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/nsx/index">Nhà sản xuất</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/mau-sac/index">Màu sắc</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/dong-sp/index">Dòng sản phẩm</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/ctsp/index">Chi tiết Sản phẩm</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3"
               href="/admin/gio-hang/index">Giỏ hàng</a>
        </div>
    </div>
    <div class="container-fluid">
        <h1></h1>
        <jsp:include page="${views}" />
    </div>
</div>
</body>
</html>