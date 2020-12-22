<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>乌托邦书店</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_panel.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/autoplay.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                url: "../one",
                type: "post",
                success: function (data) {
                    var count = 0;
                    if (data != null) {
                        if (count==0){
                            var name = $("#login_href")[0];
                            name.innerHTML = data + "欢迎您！" + "<a href='../loginOut'>[退出]</a>";
                            alert("欢迎您" + data);
                        }
                        count++;
                    }
                }
            })
        })
    </script>
</head>
<body>
<div class="welcome_panel">
    <!--书城顶部-->
<%@include file="head.jsp"%>
</div>
<!--详细分类-->
<table class="table">
    <tr>
        <td>
            <div class="left">
                <div id="edu" class="edu">
                    <span>教育</span>
                    <div>
                        <a href="">教材|</a>
                        <a href="">外语|</a>
                        <a href="">考试|</a>
                        <a href="">教辅|</a>
                        <a href>工具书</a>
                    </div>
                    <hr>
                </div>
                <div id="novel" class="novel">
                    <span>小说</span>
                    <div>
                        <a href="">四大名著|</a>
                        <a href="">外国名著|</a>
                        <a href="">当代小说|</a>
                        <a href="">悬疑小说|</a>
                        <a href="">科幻小说|</a>
                    </div>
                    <hr>
                </div>
                <div id="resk" class="rwsk">
                    <span>人文社科</span>
                    <div>
                        <a href="">历史|</a>
                        <a href="">哲学|</a>
                        <a href="">军事/政治|</a>
                        <a href="">社会科学|</a>
                        <a href>法律</a>
                    </div>
                    <hr>
                </div>
                <div id="kj" class="kj">
                    <span>科技</span>
                    <div>
                        <a href="">计算机|</a>
                        <a href="">医学|</a>
                        <a href="">建筑|</a>
                        <a href="">生物|</a>
                        <a href="">工业</a>
                    </div>
                    <hr>
                </div>
                <div id="sh" class="sh">
                    <span>生活</span>
                    <div>
                        <a href="">美食|</a>
                        <a href="">运动|</a>
                        <a href="">旅游|</a>
                        <a href="">家居|</a>
                        <a href="">育儿</a>
                    </div>
                    <hr>
                </div>
                <div id="jg" class="jg">
                    <span>经管</span>
                    <div>
                        <a href="">经济|</a>
                        <a href="">管理|</a>
                        <a href="">投资理财</a>
                    </div>
                    <hr>
                </div>
                <div id="cg/lz" class="cg/lz">
                    <a href="" style="font-weight:bold;font-size:16px;color: black">成功/励志</a>
                    <hr>
                </div>
                <div id="ts" class="ts">
                    <span>童书</span>
                    <div>
                        <a href="">科普/百科|</a>
                        <a href="">绘本|</a>
                        <a href="">文学|</a>
                        <a href="">英语</a>
                    </div>
                </div>
            </div>
        </td>
        <td>
            <!--轮播图-->
            <div class="warp" id="box_autoplay">
                <div class="broadcast" id="broadcast">
                    <ul id="img_list">
                        <li><img src="${pageContext.request.contextPath}/img/index1.jpg"></li>
                        <li><img src="${pageContext.request.contextPath}/img/index2.jpg"></li>
                        <li><img src="${pageContext.request.contextPath}/img/index3.jpg"></li>
                        <li><img src="${pageContext.request.contextPath}/img/index4.jpg"></li>
                        <li><img src="${pageContext.request.contextPath}/img/index5.jpg"></li>
                    </ul>
                    <ol id="button_list"><!--轮播按钮-->
                        <li class="first_li" id="li_1">1</li>
                        <li id="li_2">2</li>
                        <li id="li_3">3</li>
                        <li id="li_4">4</li>
                        <li id="li_5">5</li>
                    </ol>
                </div>
            </div>
            <!--书城主页中间下面新书栏-->
            <div class="new_book">
                <div class="title_item">
                    <span style="color: red;font-size: 30px">新书上架</span>
                    <hr color="orangered">
                </div>
                <div class="new_book_list">
                    <div>
                        <div style="text-align: center">
                            <img src="${pageContext.request.contextPath}/img/岛.png"/>
                            &nbsp&nbsp
                            <br>
                            <a href=" " style="color: #555555">岛</a>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <img src="${pageContext.request.contextPath}/img/戴高乐将军.jpg">
                        &nbsp&nbsp
                        <br>
                        <a href="" style="color: #555555">戴高乐将军</a>
                    </div>
                    <div style="text-align: center">
                        <img src="${pageContext.request.contextPath}/img/疯犬少年的天空.jpg">
                        &nbsp&nbsp
                        <br>
                        <a href="" style="color: #555555">疯犬少年的天空</a>
                    </div>
                    <div>
                        <img src="${pageContext.request.contextPath}/img/紫金陈刑侦推理三部曲.jpg">
                        &nbsp&nbsp&nbsp
                        <br>
                        <a href="" style="color: #555555">紫金陈刑侦推理三部曲</a>
                    </div>
                    <div style="text-align: center">
                        <img src="${pageContext.request.contextPath}/img/1.jpg">
                        &nbsp
                        <br>
                        <a href="" style="color: #555555">万万没想到：321个</a>
                    </div>
                </div>
            </div>
        <td/>
        <!--书城主页右侧栏-->
        <td>
            <div class="right">
                <div class="right_top">
                    <font style="font-weight: bold;">最新动态</font><br>
                    <a href="" style="font-size: 14px;color:#555555">1.精选图书满100减40</a>
                    <br>
                    <a href="" style="font-size: 14px;color:#555555">2.谈古今人生满100减50</a>
                    <br>
                    <a href="" style="font-size: 14px;color:#555555">3.万种图书五折封顶</a>
                </div>
                <br>
                <font style="font-size: 20px;font-weight: bold" color="#ff4500">图书热卖榜</font>
                <div class="right_mid" style="padding-left: 5px">
                    <a href="" style="font-size: 13px">1&nbsp&nbsp余华:活着</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">2&nbsp&nbsp刘同:你的孤独,虽败尤荣</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">3&nbsp&nbsp三毛:撒哈拉的故事</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">4&nbsp&nbsp了不起的盖茨比</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">5&nbsp&nbsp挪威的森林</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">6&nbsp&nbsp不能承受的生命之轻</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">7&nbsp&nbsp肖申克的救赎</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">8&nbsp&nbsp时间简史</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">9&nbsp&nbsp雨季不再来</a>
                    <hr style="color: #555555;">
                    <a href="" style="font-size: 13px">10&nbsp&nbsp梦里花落知多少</a>
                    <hr style="color: #555555;">
                </div>
            </div>
        </td>
    </tr>
</table>
<div id="foot">
    <!--书城底部-->
    <%@include file="foot.jsp"%>
</div>
</body>
</html>
