$(function() {
    $("#regist_button").click(function() {
        $("#warning_1 span").html("")
        $("#warning_2 span").html("")
        $("#warning_3 span").html("")
        $("#warning_4 span").html("")
        $("#warning_1").hide()
        $("#warning_2").hide()
        $("#warning_3").hide()
        $("#warning_4").hide()
        var username = $("#regist_username").val().trim();
        var nickname = $("#nickname").val().trim();
        var password = $("#regist_password").val().trim();
        var final_password = $("#final_password").val().trim();
        var flag = true
        if (username == "") {
            flag = false
            $("#warning_1 span").html("用户名不能为空")
            $("#warning_1").show()
            console.log($("#warning_1 span").html())
        }
        if (nickname == '') {
            flag = false
            $("#warning_4 span").html("请设置昵称")
            $("#warning_4").show()
        }
        if (password.length < 6) {
            flag = false
            $("#warning_2 span").html("密码不能小于六位")
            $("#warning_2").show()
        }
        if (password != final_password) {
            flag = false
            $("#warning_3 span").html("密码输入不一致")
            $("#warning_3").show()
        }
        var data = {
            "username": username,
            "password": password,
            "nickname": nickname
        }
        console.log(data)
        if (flag) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/cloud_note/user/regist.do",
                data: data,
                dataType: "json",
                success: function(result) {
                    if (result.status == 1) {
                        alert(result.msg)
                        $("#back").click();
                    } else if (result.status == 0) {
                        $("#warning_1 span").html(result.msg)
                        $("#warning_1").show()
                    }
                },
                error: function(error) {
                    console.error("用户注册错误" + error)
                }
            });
        }
    })

})