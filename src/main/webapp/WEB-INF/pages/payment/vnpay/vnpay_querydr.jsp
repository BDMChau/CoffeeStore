<%@include file="/WEB-INF/pages/template/header.jsp" %>


<body>

        <div class="container">
            <div class="header clearfix">

                <h3 class="text-muted">VNPAY DEMO</h3>
            </div>
            <h3>Query</h3>
            <div class="table-responsive">
            <form action="/vnpay_jsp/vnpayquery" id="frmQerydr" method="Get">
                <div class="form-group">
                <label for="order_id">OrderId</label>
                <input class="form-control" id="order_id"
                       name="order_id" type="text"/>
                </div>
                <div class="form-group">
                <label for="trans_date">Payment Date</label>
                <input class="form-control" id="trans_date"
                       name="trans_date" type="text" placeholder="yyyyMMddHHmmss"/>
            </div>
                <div class="form-group">
                <button type="submit" class="btn btn-primary">QueryDr</button>
            </div>
            </form>   
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2017</p>
            </footer>
        </div> 
        </div>
    </body>
<%@include file="/WEB-INF/pages/template/footer.jsp" %>