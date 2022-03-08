<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bdmch
  Date: 02/24/2022
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h3>Register</h3>
            <h5 class="form-product-heading">product Info</h5>

        </div>

        <%--@elvariable id="product" type=""--%>
        <form:form method="GET" modelAttribute="product" class="form-product" autocomplete="false">
        <spring:bind path="name">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-xs-3 control-label" for="name">Name:</label>
            <form:input type="text" path="name" class="form-control" placeholder="Name"
            />
            <form:errors path="name"/>
        </div>
        </spring:bind>
        </form:form>
    </div>
</div>

