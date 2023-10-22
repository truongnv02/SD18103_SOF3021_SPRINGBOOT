<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="../../../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../assets/css/bootstrap-icons.css">
    <script src="../../../assets/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../../../assets/css/style.css">
</head>
<body>
    <jsp:include page="../trang/header.jsp" />
    <section>
        <div class="container pt-4">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="#">Sản phẩm</a></li>
                    <li class="breadcrumb-item">Chi tiết sản phẩm</li>
                </ol>
            </nav>
        </div>
    </section>
    <section>
        <div class="container">
            <div class="row">
                <!-- img -->
                <div class="col-md-5">
                    <div class="card bder">
                        <c:if test="${productDetail.sanPham.imageSP != null}">
                            <img class="img" src="<c:url value="../../../images/${productDetail.sanPham.imageSP}"/>" alt="">
                        </c:if>
                    </div>
                </div>
                <!-- thong-tin -->
                <div class="col-md-4">
                    <p class="title-khuyen-mai">${productDetail.sanPham.ten}</p>
                    <div class="row">
                        <p>Mã sản phẩm: <span class="title-chinh-sach">${productDetail.sanPham.ma}</span></p>
                    </div>
                    <div class="row">
                        <p class="title-gia"><fmt:formatNumber value="${productDetail.giaBan}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</p>
                    </div>
                    <div class="row mt-3">
                        <p>Màu sắc: <span class="title-chinh-sach">${productDetail.mauSac.ten}</span></p>
                    </div>
                    <form action="/giohang/${productDetail.id}" method="post">
                        <div class="row">
                            Số lượng:<input type="number" class="ms-3 w-25" id="quantity-input" name="soLuong" value="1"
                                            min="1" max="${productDetail.soLuongTon}">
                        </div>
                        <p class="text-danger mt-3">Còn ${productDetail.soLuongTon} sản phẩm</p>
                        <c:if test="${user != null}">
                            <div class="row mt-5">
                                <button class="btn-them-ghang" type="submit">
                                    <div class="row">
                                        <div class="col-md-2 pt-3">
                                            <span><i class="bi bi-bag icon-gio-hang"></i></span>
                                        </div>
                                        <div class="col-md-10">
                                            <p class="title-btn mt-2">THÊM VÀO GIỎ HÀNG</p>
                                            <p>Giao hàng tận nơi miễn phí</p>
                                        </div>
                                    </div>
                                </button>
                            </div>
                        </c:if>
                    </form>
                    <c:if test="${user == null}">
                        <a class="nav-link text-white btn-them-ghang" href="/login">
                            Bạn hãy đăng nhập để thực hiện chức năng này
                        </a>
                    </c:if>
                </div>
                <!-- chinh-sach -->
                <div class="col-md-3">
                    <div class="card bground bder">
                        <p class="title-khuyen-mai">Chính sách cửa hàng</p>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="../../../assets/img/chinhsach_1.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Miễn phí vẫn chuyển</p>
                                <p>Cho tất cả đơn hàng trong nội thành Hồ Chí Minh</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="../../../assets/img/chinhsach_2.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Miễn phí đổi - trả</p>
                                <p>Đối với sản phẩm lỗi sản xuất hoặc vận chuyển</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="../../../assets/img/chinhsach_3.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Hỗ trợ nhanh chóng</p>
                                <p>Gọi Hotline: 19006750 để được hỗ trợ ngay</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <img src="../../../assets/img/chinhsach_4.webp" alt="">
                            </div>
                            <div class="col-md-9">
                                <p class="title-chinh-sach">Ưu đãi combo</p>
                                <p>Mua theo combo,mùa càng mua nhiều giá càng rẻ</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row py-4">
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-3">
                            <button class="btn-them-ghang">HƯỚNG DẪN MUA HÀNG</button>
                        </div>
                        <div class="col-md-3">
                            <button class="btn-them-ghang">HƯỚNG DẪN MUA HÀNG</button>
                        </div>
                    </div>
                    <div class="row py-3">
                        <div class="card">
                            <p>${productDetail.moTa}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="row py-3">
                <div class="col-md-9">
                    <div class="row">
                        <p class="title-khuyen-mai">Sản phẩm liên quan</p>
                    </div>
                    <hr>
                    <div class="row">
                        <c:forEach items="${listCTSPByCategory}" var="ctsp" begin="0" end="4">
                            <div class="col-md-3">
                                <div class="card bder">
                                    <a href="/product-detail/${ctsp.id}" class="img">
                                        <img src="../../../images/${ctsp.sanPham.imageSP}" class="card-img-top" alt="..." />
                                        <p class="card-title img  text-center">${ctsp.sanPham.ten}</p>
                                    </a>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="text-center">
                                                <p class="card-text"><fmt:formatNumber value="${ctsp.giaBan}" type="currency" currencySymbol="" minFractionDigits="0"/>₫</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <form action="#" method="post">
                                                <div class="row pt-2 text-center" style="display: flex;justify-content: center">
                                                    <div class="col-md-4">
                                                        <button type="submit" class="fs- btn btn-primary"><i class="bi bi-bag"></i></button>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <button type="submit" class="fs- btn btn-primary"><i class="bi bi-heart"></i></button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </section>
    <jsp:include page="../trang/footer.jsp" />
</body>
</html>
