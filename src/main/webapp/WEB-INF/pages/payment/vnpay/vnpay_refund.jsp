
<%@include file="/WEB-INF/pages/template/header.jsp" %>

    <body>

        <div class="container">
            <div class="header clearfix">

                <h3 class="text-muted">VNPAY DEMO</h3>
            </div>
            <h3>Refund</h3>
            <div class="table-responsive">
                <form action="/vnpay_jsp/vnpayrefund" id="frmrefund" method="Get">
                    <div class="form-group">
                        <label for="order_id">Mã hóa đơn</label>
                        <input class="form-control" id="order_id"
                               name="order_id" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="amount">Số tiền hoàn</label>
                        <input class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." id="amount" max="100000000" min="1" name="amount" type="number" value="10000" />
                    </div>
                    <div class="form-group">
                        <label for="trantype">Kiểu hoàn tiền</label>
                        <select name="trantype" id="trantype" class="form-control">
                            <option value="02">Hoàn tiền toàn phần</option>
                            <option value="03">Hoàn tiền một phần</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="trans_date">Thời gian thanh toán</label>
                        <input class="form-control" id="trans_date"
                               name="trans_date" type="text" placeholder="yyyyMMddHHmmss"/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email khởi tạo hoàn</label>
                        <input class="form-control" id="email"
                               name="email" type="text"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Refund</button>
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