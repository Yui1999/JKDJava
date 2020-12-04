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
                    订单列表页
                </h3>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>订单编号</th>
                        <th>姓名</th>
                        <th>手机号</th>
                        <th>地址</th>
                        <th>金额</th>
                        <th>订单状态</th>
                        <th>支付状态</th>
                        <th>创建时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list masterList as master>
                        <tr class="success">
                            <td>${master.orderId}</td>
                            <td>${master.buyerName}</td>
                            <td>${master.buyerPhone}</td>
                            <td>${master.buyerAddress}</td>
                            <td>${master.orderAmount}</td>
                            <td>
                                <#if master.orderStatus == 0>
                                    新订单
                                <#elseif master.orderStatus == 1>
                                    完结
                                <#elseif master.orderStatus == 2>
                                    已取消
                                </#if>
                            </td>
                            <td>
                                <#if master.payStatus == 0>
                                    等待支付
                                <#elseif master.payStatus == 1>
                                    支付成功
                                </#if>
                            </td>

                            <td>${master.createTime}</td>
                            <td><a href="/seller/master/details?detailId=${master.buyerOpenid}&orderId=${master.orderId}">详情</a></td>
                            <td>
                                <#if master.orderStatus == 0>
                                    <a href="/seller/master/cancel?orderId=${master.orderId}">取消订单</a>
                                <#elseif master.orderStatus == 1>
                                    完结
                                <#else>
                                </#if>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>