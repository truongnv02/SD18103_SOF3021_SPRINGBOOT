<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;margin-top:15px;">Quản lý NSX</h3>
    <a href="/admin/nsx/create" class="btn btn-success">Add</a>
    <c:if test="${ f:length(listNSX) == 0 }">
        <h4 class="text-center">Không có dữ liệu</h4>
    </c:if>
    <c:if test="${f:length(listNSX) != 0}">
        <table class="table">
            <thead>
            <tr>
                <td>Mã</td>
                <td>Tên</td>
                <td colspan="2">Active</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${listNSX}" var="nsx">
                    <tr>
                        <td>${nsx.ma}</td>
                        <td>${nsx.ten}</td>
                        <td>
                            <a href="/admin/nsx/edit/${nsx.id}" class="btn btn-primary">Detail</a>
                            <a href="/admin/nsx/remove/${nsx.id}" class="btn btn-danger"
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