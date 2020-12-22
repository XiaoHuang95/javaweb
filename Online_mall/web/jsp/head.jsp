<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2020/11/3
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    .search_btn {
        width: 10%;
        height: 36px;
        border: 2px solid red;
        background: url("${pageContext.request.contextPath}/img/搜索图标.png") -10px -15px no-repeat;
    }

    .car_icon {
        width: 50%;
        height: 100%;
        background: url("${pageContext.request.contextPath}/img/购物车图标.png") -10px -7px no-repeat;
    }
</style>
    <!--书城顶部-->
    <div class="wel_log_reg">
        <span class="welcome_text">hi，欢迎来到乌托邦书城</span>
        <a href="${pageContext.request.contextPath}/html/login.html" class="login_href" id="login_href">请登录</a>
        <a href="${pageContext.request.contextPath}/jsp/register.jsp" class="register_href">没有账号？立即注册</a>
    </div>
    <!--logo和搜索框-->
    <div class="logo_search">
        <!--logo-->
        <div class="logo">
            <img src="${pageContext.request.contextPath}/img/logo.png">
        </div>
        <!--搜索框-->
        <div class="search">
            <input type="text" name="bookName" id="search_text" class="search_text" placeholder="请输入书名"/>
            <a href="" class="search_btn"></a>
        </div>
        <!--购物车-->
        <div class="car">
            <a href="">
                <div class="car_icon"></div>
            </a>
            <div class="car_text">
                <a href="" class="car_href">
                    购物车
                    <b id="cart_count">0</b>
                </a>
            </div>
        </div>
        <!--订单-->
        <div class="order">
            <a href="" class="order_href">我的订单</a>
        </div>
    </div>
    <!--分类-->
    <div class="div_menu">
        <div class="sort_all">
            <a href="" class="all_classify">全部商品分类</a>
        </div>
        <div class="sort">
            <a href="" class="classify">文学</a>
            <a href="" class="classify">生活</a>
            <a href="" class="classify">科技</a>
            <a href="" class="classify">社科</a>
            <a href="" class="classify">计算机</a>
            <a href="" class="classify">医学</a>
            <a href="" class="classify">考试</a>
            <a href="" class="classify">艺术</a>
            <a href="" class="classify">外语</a>
            <a href="" class="classify">少儿</a>
            <a href="" class="classify">考试</a>
            <a href="" class="classify">励志</a>
        </div>
    </div>
    <div class="hr"/>
