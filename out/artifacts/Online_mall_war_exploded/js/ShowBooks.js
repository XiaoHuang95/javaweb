function searchByType(){
    $.ajax({
        url: '../TypeData',
        dataType: 'json',
        type: 'post',
        success: function (data) {
            $('#middle').empty()
            $.each(data, function (i, n) {
                $('#type').text(n.type+"类总共有："+data.length+"种书")
                $('#middle').append("<div style='display: inline-block;'>" + "<img src=" + n.imgurl + ">" + "&nbsp&nbsp&nbsp<br>"
                    + "<a href=" + "../show?id=" + n.id + ">" + "&nbsp&nbsp&nbsp" + n.name + "</a>" + "</div>")
            })
        }
    })
}
$(function () {
    searchByType()
})
