<%@include file="/WEB-INF/pages/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h3>Login with Email and Password</h3>
        </div>

        <div class="form-layout">
            <form name="loginForm" action="<c:url value="/login" />" method="post"
                  class="form-horizontal">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

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


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        Remember Me: <input type="checkbox" name="remember-me"/>
                    </div>
                </div>


                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <input type="submit" value="Submit" class="btn btn-default">

                    </div>
                </div>
            </form>
        </div>

    </div>

</div>


<%@include file="/WEB-INF/pages/template/footer.jsp" %>