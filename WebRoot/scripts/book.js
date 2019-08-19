function loadBooks() {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/cloud_note/notebook/loadbooks.do",
        data: { "userId": userId },
        dataType: "json",
        success: function(response) {
            //1.清除原来的笔记本列表
            let data = response.data
            $("#book_list").empty();
            if (response.status == 0) {
                //2.根据返回数据，循环将数据添加到 id= book_list ul 上
                //使用jquery。append方法将li内容添加

                for (let i = 0; i < response.data.length; i++) {
                    let dataId = data[i].cn_notebook_id
                    let dataName = data[i].cn_notebook_name
                    let str = `<li class="online">`
                    str += `<a>`
                    str += `<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>${dataName}`
                    str += `</a></li>`
                    let $li = $(str)
                    $li.data("dataId", dataId)
                    $("#book_list").append($li);
                }
            }
        }
    });
}

function sureAddBook() {
    var bookName = $("#input_notebook").val().trim()
    var data = {
        "userId": userId,
        "bookName": bookName
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/cloud_note/notebook/add.do",
        data: data,
        dataType: "json",
        success: function(response) {
            let data = response.data
                // console.log(response)
            if (response.status == 0) {
                alert("笔记本添加成功")
                closeWindow()
                loadBooks();
            }
        }
    });
}