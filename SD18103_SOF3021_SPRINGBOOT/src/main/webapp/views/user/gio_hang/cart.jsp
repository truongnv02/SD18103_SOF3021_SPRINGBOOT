<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../assets/css/bootstrap-icons.css">
    <script src="../../../assets/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../../../assets/css/style.css">
</head>
<body>
<jsp:include page="../trang/header.jsp" />
<section>
    <div class="container">
        <h3 class="text-center">Shopping Cart</h3>
        <table class="table">
            <thead>
                <tr>
                    <td>Image</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Total Amount</td>
                    <td>Delete</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.cart}" var="cart">
                    <tr>
                        <td>
                            <a href="/product-detail/${cart.value.chiTietSPDTO.id}" class="img">
                                <img src="../../../images/${cart.value.chiTietSPDTO.sanPham.imageSP}" class="card-img-top" alt="..." />
                            </a>
                        </td>
                        <td><p class="card-title text-center">${cart.value.chiTietSPDTO.sanPham.ten}</p></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<jsp:include page="../trang/footer.jsp" />
</body>
</html>
