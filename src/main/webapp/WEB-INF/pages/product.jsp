<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bdmch
  Date: 02/24/2022
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:forEach var ="pr" items="${product_info}">
        <td>${pr.bra_id}</td>
        <td>${pr.bra_description}</td>
        <td>${pr.bra_logo}</td>
        <td>${pr.bra_name}</td>

        <td>${pr.pr_id}</td>
        <td>${pr.pr_description}</td>
        <td>${pr.pr_name}</td>
        <td>${pr.pr_price}</td>

        <td>${pr.prImg_id}</td>
        <td>${pr.prImg_url}</td>


    </c:forEach>

</div>

