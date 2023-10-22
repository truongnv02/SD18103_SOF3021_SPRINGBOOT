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
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/trang-chu">Trang chủ</a></li>
                <li class="breadcrumb-item"><a href="#">Sản phẩm</a></li>
            </ol>
        </nav>
    </div>
</section>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-md-3">
                <div class="card mb-3">
                    <div class="card-header">
                        <span>
                            <a href="/product"><i class="bi bi-list"></i>   Tất cả sản phẩm</a>
                        </span>
                    </div>
                    <div class="cate-lst">
                        <ul class="list-group">
                            <c:forEach items="${listDongSP}" var="dsp">
                                <li class="list-group-item text-white ${tag == dsp.id ? "active" : ""}">
                                    <a href="/product-category/${dsp.id}">${dsp.ten}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

            </div>
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-2">
                        <h5>Sắp xếp theo :</h5>
                    </div>
                    <div class="col-md-10">
                        <ul style="display: flex;list-style: none;">
                            <li><a href="#" class="btn-tht btn-li">Tên A-Z</a></li>
                            <li><a href="#" class="btn-tht btn-li">Tên Z-A</a></li>
                            <li><a href="#" class="btn-tht btn-li">Hàng mới</a></li>
                            <li><a href="#" class="btn-tht btn-li">Giá thấp đến cao</a></li>
                            <li><a href="#" class="btn-tht btn-li">Giá cao đến thấp</a></li>
                        </ul>
                    </div>
                </div>
                <!-- product -->
                <div class="row">
                    <div class="row py-2">
                        <c:forEach items="${listCTSP.content}" var="ctsp">
                            <div class="col-md-3 py-2">
                                <div class="card bder">
                                    <a href="/product-detail/${ctsp.id}" class="img">
                                        <img src="../../../images/${ctsp.sanPham.imageSP}" class="card-img-top" alt="..." />
                                        <p class="card-title text-center">${ctsp.sanPham.ten}</p>
                                    </a>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="text-center">
                                                <p class="card-text"><fmt:formatNumber value="${ctsp.giaBan}" type="currency" currencySymbol="" minFractionDigits="0"/> VNĐ</p>
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
                <!-- page -->
                <div class="row">
                    <div class="col page">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:forEach begin="0" end="${listCTSP.totalPages - 1}" varStatus="i">
                                    <li class="page-item">
                                        <a class="page-link" href="/product?page=${i.begin + i.count - 1}">
                                                ${i.begin + i.count}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../trang/footer.jsp" />
</body>
</html>
