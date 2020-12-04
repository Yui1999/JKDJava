<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seller/category/save">
                        <div class="form-group">
                            <label for="productName">名字</label>
                            <input name="categoryName" id="categoryName" type="text" class="form-control" value="${(productInfo.productName)!''}" />
                        </div>

                        <div class="form-group">
                            <label for="productPrice">Type</label>
                            <input name="categoryType" type="text" class="form-control" id="productPrice" value="${(productInfo.productPrice)!''}"/>
                        </div>

                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <input type="submit" class="btn btn-default" value="提交">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>