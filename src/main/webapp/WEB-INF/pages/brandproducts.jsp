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
<c:forEach var="item" items="${list_top_products}">
    <p>${item.bra_id}</p>
    <p>${item.bra_description}</p>
    <p>${item.bra_logo}</p>
    <p>${item.bra_name}</p>

    <p>${item.pr_id}</p>
    <p>${item.pr_description}</p>
    <p>${item.pr_name}</p>
    <p>${item.pr_price}</p>

    <p>${item.prImg_id}</p>
    <p>${item.prImg_url}</p>
</c:forEach>
    </div>

    <%@include file="/WEB-INF/pages/template/footer.jsp" %>