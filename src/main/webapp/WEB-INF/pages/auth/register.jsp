<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h3>Register</h3>
            <h5 class="form-signin-heading">Create your account</h5>

        </div>

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
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
                    <label class="col-xs-3 control-label" for="passwordConfirm">Confirm Password:</label>

                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"/>
                    <form:errors path="passwordConfirm"/>
                </div>
            </spring:bind>

            <c:if test="${not empty errMsg}">
                <div class="error" style="color:#FF4D4F">
                        ${errMsg}
                </div>
            </c:if>

            <c:if test="${not empty msg}">
                <div class="error" style="color:#337AB7">
                        ${msg}
                </div>
            </c:if>

            <button class="btn btn-primary btn-block" type="submit">Register</button>
        </form:form>
    </div>

</div>

</div>


<%@include file="/WEB-INF/pages/template/footer.jsp" %>