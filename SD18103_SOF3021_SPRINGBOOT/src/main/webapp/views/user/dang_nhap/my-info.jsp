<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sản phẩm</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../assets/css/bootstrap-icons.css">
    <script src="../../../assets/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../../../assets/css/style.css">
</head>
<body>
<jsp:include page="../trang/header.jsp" />
<section>
    <div class="container pt-4">
        <h3 style="text-align: center;margin-top:15px;">Thông tin của ${name}</h3>
        <div class="row">
            <div class="col-md-3">
                <div class="cate-lst">
                    <ul class="list-group">
                        <li class="list-group-item text-white list-unstyled">
                            <a href="/view-user">Chỉnh sửa thông tin cá nhân</a>
                        </li>
                        <li class="list-group-item text-white">
                            <a href="/log-out">Đăng xuất</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-9">
                <jsp:include page="${viewUser}" />
            </div>
        </div>
    </div>
</section>
<jsp:include page="../trang/footer.jsp" />
</body>
</html>