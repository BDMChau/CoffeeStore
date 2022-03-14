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

    <p>${brand_info.id}</p>
<%--    <img>${brand_info.background_img}</img>--%>
    <img src="${brand_info.background_img}">
    <p>${brand_info.description}</p>
    <p>${brand_info.logo}</p>

    <p>${brand_info.name}</p>

</div>
<%@include file="/WEB-INF/pages/template/footer.jsp" %>