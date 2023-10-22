<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets/css/bootstrap-icons.css">
    <script src="../../assets/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../../assets/css/style.css">
</head>
<body>
<%--    header--%>
<jsp:include page="trang/header.jsp" />
<jsp:include page="trang/slides.jsp" />

<section>
    <div class="container">
        <p class="title-khuyen-mai">Khuyến mãi hấp dẫn</p>
        <span>Chương trình khuyến mãi hấp dẫn đang chờ đợi bạn</span>
        <hr>
        <div class="row">
            <c:forEach items="${listCTSP}" var="ctsp" begin="0" end="6">
                <div class="col-md-2 py-2">
                    <div class="card bder">
                        <a href="/product-detail/${ctsp.id}" class="img">
                            <img src="../../../images/${ctsp.sanPham.imageSP}" class="card-img-top" alt="..." />
                            <p class="card-title text-center">${ctsp.sanPham.ten}</p>
                        </a>
                        <div class="card-body">
                            <div class="row">
                                <div class="text-center">
                                    <p class="card-text"><fmt:formatNumber value="${ctsp.giaBan}" type="currency" currencySymbol="" minFractionDigits="0"/>₫</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="row pt-2 text-center" style="display: flex;justify-content: center">
                                    <div class="col-md-4">
                                        <a href="/add-to-cart?ctspId=${ctsp.id}" type="submit" class="fs- btn btn-primary"><i class="bi bi-bag"></i></a>
                                    </div>
                                    <div class="col-md-4">
                                        <button type="submit" class="fs- btn btn-primary"><i class="bi bi-heart"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<%--    dich-vu--%>
<section>
    <div class="container py-5">
        <p class="title-khuyen-mai">Dịch vụ đặc biệt của chúng tôi</p>
        <span>Những dịch vụ tốt nhất dành cho khách hàng của chúng tôi</span>
        <hr>
        <div class="row">
            <div class="col-md-4 item">
                <div class="card bder">
                    <img src="../../assets/img/dichvu_1.webp" alt="" class="img">
                    <h5 class="title-dich-vu">Rau hữu cơ tươi</h5>
                    <div class="card-body">
                        <p>Được trồng theo phương pháp hiện đại nhất, đạt tiêu chuẩn quốc tế, vô cùng an toàn khi sử
                            dụng.</p>
                        <a href="#" class="btn-tht">Tìm hiểu thêm</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 item">
                <div class="card bder">
                    <img src="../../assets/img/dichvu_2.webp" alt="" class="img">
                    <h5 class="title-dich-vu">Giao hàng nhanh chóng</h5>
                    <div class="card-body">
                        <p>Giao hàng trong thời gian nhanh nhất để đảm bảo chất lượng tốt nhất cho những sản phẩm
                            bạn đã đặt.</p>
                        <a href="#" class="btn-tht">Tìm hiểu thêm</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 item">
                <div class="card bder">
                    <img src="../../assets/img/dichvu_3.webp" alt="" class="img">
                    <h5 class="title-dich-vu">Thanh toán dễ dàng</h5>
                    <div class="card-body">
                        <p>Nhiều hình thức thanh toán làm cho việc đặt hàng của bạn và shop trở nên dễ dàng và tiện
                            lợi.</p>
                        <a href="#" class="btn-tht">Tìm hiểu thêm</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- list-product -->
<section>
    <div class="container py-3">
        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <img src="../../assets/img/image_product1.webp" alt="">
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <p class="title-khuyen-mai">Rau củ</p>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="card bder">
                            <a href="#" class="img">
                                <img src="../../assets/img/kim-chi-cai-thao.webp"
                                     class="card-img-top" alt="..." />
                                <p class="card-title img">Kim chi cải thảo</p>
                            </a>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="card-text">12.000đ</p>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="#" class="fs-3"><i class="bi bi-bag"></i></a>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="#" class="fs-3"><i class="bi bi-heart"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="item-btn">
                    <a href="#" class="btn-tht">Xem tất cả</a>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container py-5">
        <div class="row">
            <div class="col-md-4">
                <img class="bder" src="../../assets/img/banner_three_1.webp" alt="">
            </div>
            <div class="col-md-4">
                <img class="bder" src="../../assets/img/banner_three_2.webp" alt="">
            </div>
            <div class="col-md-4">
                <img class="bder" src="../../assets/img/banner_three_3.webp" alt="">
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container py-3">
        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <img src="../../assets/img/image_product2.webp" alt="">
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <p class="title-khuyen-mai">Trái cây</p>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="card bder">
                            <a href="#" class="img">
                                <img src="../../assets/img/kim-chi-cai-thao.webp"
                                     class="card-img-top" alt="..." />
                                <p class="card-title img">Kim chi cải thảo</p>
                            </a>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="card-text">12.000đ</p>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="#" class="fs-3"><i class="bi bi-bag"></i></a>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="#" class="fs-3"><i class="bi bi-heart"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="item-btn">
                    <a href="#" class="btn-tht">Xem tất cả</a>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container py-5">
        <div class="row">
            <img src="../../assets/img/banner.webp" alt="">
        </div>
    </div>
</section>

<section>
    <div class="container py-3">
        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <img src="../../assets/img/image_product3.webp" alt="">
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <p class="title-khuyen-mai">Đồ khô</p>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="card bder">
                            <a href="#" class="img">
                                <img src="../../assets/img/kim-chi-cai-thao.webp"
                                     class="card-img-top" alt="..." />
                                <p class="card-title img">Kim chi cải thảo</p>
                            </a>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="card-text">12.000đ</p>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="#" class="fs-3"><i class="bi bi-bag"></i></a>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="#" class="fs-3"><i class="bi bi-heart"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="item-btn">
                    <a href="#" class="btn-tht">Xem tất cả</a>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container py-5">
        <div class="row">
            <img src="../../assets/img/banner2.webp" alt="">
        </div>
    </div>
</section>

<%--    footer--%>
<jsp:include page="trang/footer.jsp" />
</body>
</html>
