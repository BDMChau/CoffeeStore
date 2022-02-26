<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h3>Register</h3>
            <h5 class="form-signin-heading">Create a new account</h5>

        </div>

        <form:form method="POST" modelAttribute="userForm" class="form-signin" autocomplete="false">
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-xs-3 control-label" for="name">Name:</label>

                    <form:input type="text" path="name" class="form-control" placeholder="Name"
                    />
                    <form:errors path="name"/>
                </div>
            </spring:bind>

            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-xs-3 control-label" for="email">Email:</label>

                    <form:input type="text" path="email" class="form-control" placeholder="Email"
                    />
                    <form:errors path="email"/>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-xs-3 control-label" for="password">Password:</label>

                    <form:input type="password" path="password" class="form-control"
                                placeholder="Password"/>
                    <form:errors path="password"/>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-xs-3 control-label" for="passwordConfirm" style="width: 16rem">Confirm Password:</label>

                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"/>
                    <form:errors path="passwordConfirm"/>
                </div>
            </spring:bind>

            <c:if test="${not empty errMsg}">
                <div class="error" style="color:#FF4D4F; font-size: 20px">
                        ${errMsg}
                </div>
            </c:if>

            <c:if test="${not empty msg}">
                <div class="error" style="color:#45BD62; font-size: 20px">
                        ${msg}
                </div>
            </c:if>

            <button class="btn btn-md btn-primary btn-block" type="submit" style="margin-bottom: 10px">Register</button>


            <a href="/auth/login">Already have an account?</a>
        </form:form>
    </div>

</div>

</div>


<%@include file="/WEB-INF/pages/template/footer.jsp" %>