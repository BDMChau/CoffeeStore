<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="login-page pt-150 pb-150">
    <div class="container">
        <div class="form-layout" style="width: 80%">
            <div class="page-header title">
                <h3>Login</h3>
            </div>

            <form name="formLogin" action="/auth/login" method="POST"
                  class="form-horizontal">

                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="email">Email:</label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" placeholder="Enter Email" name="email"
                               id="email"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="password">Password:</label>
                    <div class="col-xs-9">
                        <input type="password" class="form-control" name="password" placeholder="Enter Password"
                               id="password"/>
                    </div>
                </div>


                <%--                <div class="form-group has-success">--%>
                <%--                    <label class="col-xs-3 control-label"></label>--%>
                <%--                    <div class="col-xs-9">--%>
                <%--                        Remember Me: <input type="checkbox" name="remember-me"/>--%>
                <%--                    </div>--%>
                <%--                </div>--%>

                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <c:if test="${not empty errorMsg}">
                            <div class="error" style="color:#ff0000">
                                    ${errorMsg}
                            </div>
                        </c:if>
                    </div>
                </div>

                <div>
                    <button class="btn btn-md btn-primary" type="submit"
                            style="margin-bottom: 10px; width: 10rem; height: 2.5rem">
                        Login
                    </button>

                    <div>
                        <a href="/auth/register">Register new account?</a>
                    </div>
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>

    </div>
</div>

<%@include file="/WEB-INF/pages/template/footer.jsp" %>