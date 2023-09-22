<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <f:form action="${action}" modelAttribute="ctsp" method="post">
        <h3 style="text-align: center;margin-top:15px;">Thông tin Chi Tiết Sản Phẩm</h3>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Sản phẩm</label>
                <f:select class="form-control" path="sanPham" required="true">
                    <c:forEach items="${listSanPham}" var="sp">
                        <option value="${sp.id}">${sp.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
            <div class="col-6">
                <label class="form-label">Màu sắc</label>
                <f:select class="form-control" path="mauSac" required="true">
                    <c:forEach items="${listMauSac}" var="ms">
                        <option value="${ms.id}">${ms.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Nhà sản xuất</label>
                <f:select class="form-control" path="nsx" required="true">
                    <c:forEach items="${listNSX}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
            <div class="col-6">
                <label class="form-label">Dòng sản phẩm</label>
                <f:select class="form-control" path="dongSP" required="true">
                    <c:forEach items="${listDongSP}" var="dsp">
                        <option value="${dsp.id}">${dsp.ten}</option>
                    </c:forEach>
                </f:select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Năm bảo hành</label>
                <f:input type="number" min="1" class="form-control" path="namBH" />
            </div>
            <div class="col-6">
                <label class="form-label">Số lượng tồn</label>
                <f:input type="number" min="1" class="form-control" path="soLuongTon" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label class="form-label">Giá nhập</label>
                <f:input type="number" min="1" class="form-control" path="giaNhap" />
            </div>
            <div class="col-6">
                <label class="form-label">Giá bán</label>
                <f:input type="number" min="1" class="form-control" path="giaBan" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label for="moTa" class="form-label">Mô tả</label>
                <f:textarea class="form-control" id="moTa" path="moTa" rows="3" />
            </div>
            <div class="col-6"></div>
        </div>
        <div class="row mt-4" style="justify-content: center">
            <button class="btn btn-success col-1 m-3">SUBMIT</button>
        </div>
    </f:form>
</div>
</body>
</html>