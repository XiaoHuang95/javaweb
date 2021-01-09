function searchByType(){
    $.ajax({
        url: '../TypeData',
        dataType: 'json',
        type: 'post',
        success: function (data) {
            console.log(data)
            $('#middle').empty()
            $.each(data, function (i, n) {
                $('#text').text("为您找到如下书籍：")
                $('#type').text("属于："+n.type+"类")
                $('#middle').append("<div style='display: inline-block;text-align: center;'>" + "<img src=" + n.imgurl + ">" + "&nbsp&nbsp&nbsp<br>"
                    + "<a href=" + "../show?id=" + n.id + ">" + "&nbsp&nbsp&nbsp" + n.name + "</a>" + "</div>")
            })
        }
    })
}
$(function () {
    searchByType()
})
