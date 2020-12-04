<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3>
                    订单详情页
                </h3>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>订单编号</th>
                        <th>订单总金额</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr class="success">
                        <td>${master.orderId}</td>
                        <td>${master.orderAmount}</td>
                    </tr>

                    </tbody>
                </table>
                <#--                商品-->
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>商品编号</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>总额</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr class="success">
                        <td>${detail.productId}</td>
                        <td>${detail.productName}</td>
                        <td>${detail.productPrice}</td>
                        <td>${detail.productQuantity}</td>
                        <td>${detail.productQuantity * detail.productPrice}</td>
                    </tr>

                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
</body>
</html>