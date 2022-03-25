<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bdmch
  Date: 02/24/2022
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>


<div>
    <h3>Thương hiệu</h3>
    <c:forEach var="item" items="${brand_list}">
        <p>${item.id}</p>
        <p>${item.name}</p>
        <img src="${item.logo}">
        <p>${item.description}</p>
    </c:forEach>

</div>
<div>
    <h3>Danh mục</h3>
    <c:forEach var="item" items="${cate_list}">
        <p>${item.id}</p>
        <p>${item.name}</p>
        <p>${item.description}</p>
    </c:forEach>
</div>
<div>
    <h3>Sản phẩm</h3>
    <c:forEach var="item" items="${product_list}">
        <p>${item.id}</p>
        <p>${item.name}</p>
        <p>${item.description}</p>
    </c:forEach>
</div>

<%@include file="/WEB-INF/pages/template/footer.jsp" %>