<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">

    <link href="<c:url value="/resources/style/main.css"/>" rel="stylesheet">


    <title>Coffee Store</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<div class="navbar-wrapper" style="margin-top:0;">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">

                    <li><a href="#"> <img src="<c:url value="/resources/images/logo.png"/>" alt="logo" class="logo">
                    </a></li>
                    <li class=""><a href="#">Coffee Online Shop</a></li>
                    <li>
                        <a href="<c:url value="/"/>">
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/products" />">
                            Products
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/about" />">
                            About
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/contact" />">
                            Contact
                        </a>
                    </li>


                </ul>

                <div class="line"></div>

                <ul class="nav navbar-nav pull-right">
                    <c:if test="${pageContext.request.userPrincipal.name!=null}">
                        <form id="logoutForm" method="POST" action="/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>

                        <li><a>Welcome: ${pageContext.request.userPrincipal.name} </a></li>
                        <li><a href="<c:url value="/user/cart"/>">Cart</a></li>
                        <li><a onclick="document.forms['logoutForm'].submit()" style="cursor: pointer">Logout</a></li>


                        <c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">
                            <li><a href="<c:url value="/admin"/>">Admin Page</a></li>
                        </c:if>

                    </c:if>

                    <c:if test="${pageContext.request.userPrincipal.name == null}">

                        <li><a href="<c:url  value="/auth/login"/>">
                            Login
                        </a></li>
                        <li><a href="<c:url  value="/auth/register"/>">
                            Register
                        </a></li>
                    </c:if>


                </ul>


            </div>
        </div>
    </nav>

</div>
</body>

</html>