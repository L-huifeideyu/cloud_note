function loadNotes() {
    $("#book_list li a").removeClass("checked")
    $(this).find("a").addClass("checked")
    var bookId = $(this).data("dataId")
    var data = {
        "bookId": bookId
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/cloud_note/note/loadnotes.do",
        data: data,
        dataType: "json",
        success: function(response) {
            //1.清除原来的笔记列表
            let data = response.data
            $("#note_list").empty();

            if (response.status == 0) {
                //2.根据返回数据，循环将数据添加到 id= note_list ul 上
                //使用jquery。append方法将li内容添加

                for (let i = 0; i < response.data.length; i++) {
                    let dataId = data[i].cn_note_id
                    let dataName = data[i].cn_note_title
                    let str = `<li class="online">`
                    str += `<a>`
                    str += `<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>${dataName}`
                    str += `<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>`
                    str += `</a>`
                    str += `<div class="note_menu" tabindex='-1'>`
                    str += `<dl>`
                    str += `<dt><button type="button" class="btn btn-default btn-xs btn_move" title='移动至...'><i class="fa fa-random"></i></button></dt>`
                    str += `<dt><button type="button" class="btn btn-default btn-xs btn_share" title='分享'><i class="fa fa-sitemap"></i></button></dt>`
                    str += `<dt><button type="button" class="btn btn-default btn-xs btn_delete" title='删除'><i class="fa fa-times"></i></button></dt>`
                    str += `</dl></div></li>`
                    let $li = $(str)
                    $li.data("dataId", dataId)
                    $("#note_list").append($li);
                }
            }
        }
    });
}

function loadNote() {
    $("#note_list li a").removeClass("checked")
    $(this).find("a").addClass("checked")
    var noteId = $(this).data("dataId")
    var data = {
        "noteId": noteId
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/cloud_note/note/load.do",
        data: data,
        dataType: "json",
        success: function(response) {
            let data = response.data
            let noteTitle = data.cn_note_title
            let noteBody = data.cn_note_body

            if (response.status == 0) {
                $("#input_note_title").val(noteTitle)
                um.setContent(" ")
                if (noteBody) {
                    um.setContent(noteBody)
                }

            }
        }
    });
}

function sureAddNote() {
    var noteTitle = $("#input_note").val().trim()
    var ele = $("#book_list li a.checked").parent()
    var bookId = $(ele).data("dataId")
    var data = {
        "cn_user_id": userId,
        "cn_notebook_id": bookId,
        "cn_note_title": noteTitle
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/cloud_note/note/add.do",
        data: data,
        dataType: "json",
        success: function(response) {
            let data = response.data

            if (response.status == 0) {
                closeWindow()
                alert("笔记本添加成功")
                $("#book_list li a.checked").click();
                // loadNotes(bookId);
            }
        }
    });
}

function saveNote() {
    var noteTitle = $("#input_note_title").val().trim()
    var noteBody = um.getContent();
    var ele = $("#note_list li a.checked").parent()
    var noteId = $(ele).data("dataId")
    if (noteId) {
        var data = {
            "cn_note_id": noteId,
            "cn_note_title": noteTitle,
            "cn_note_body": noteBody
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/cloud_note/note/saveBody.do",
            data: data,
            dataType: "json",
            success: function(response) {
                if (response.status == 0) {
                    alert("保存成功！")
                }
            }
        });
    } else {
        alert("请选择笔记")
    }

}