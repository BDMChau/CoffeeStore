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

    <p>${product_info.bra_id}</p>
    <p>${product_info.bra_description}</p>
    <p>${product_info.bra_logo}</p>
    <p>${product_info.bra_name}</p>

    <p>${product_info.pr_id}</p>
    <p>${product_info.pr_description}</p>
    <p>${product_info.pr_name}</p>
    <p>${product_info.pr_price}</p>

    <p>${product_info.prImg_id}</p>
    <p>${product_info.prImg_url}</p>

</div>

<div>
    <p>${product.id}</p>
    <p>${product.count_views}</p>
</div>

<%@include file="/WEB-INF/pages/template/footer.jsp" %>



<%@include file="/WEB-INF/pages/template/footer.jsp" %>

