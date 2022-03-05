<%@include file="/WEB-INF/pages/template/header.jsp" %>



<h2>hello page</h2>
<button type="button" class="btn btn-primary">Primary</button>
    <h2><%=session.getAttribute("userId")%></h2>

<%@include file="/WEB-INF/pages/template/footer.jsp" %>