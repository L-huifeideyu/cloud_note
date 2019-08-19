$(function() {
    //1.获取输入的用户名和密码
    //2.向后台发送ajax
    //3.根据请求结果判断是否登录成功
    //3.1如果登录成功，将后台返回的userId存入cookie
    //3.2如果失败，判断用户名还是密码错误，分别显示给前台
    $("#login").click(function() {
        //清除原有提示信息
        $("#count_span").html("")
        $('#password_span').html("")
        var username = $("#count").val()
        var password = $("#password").val()
        var flag = true

        if (username == "") {
            flag = false
            $("#count_span").html("用户名为空")
        }
        if (password == "") {
            flag = false
            $("#password_span").html("密码为空")
        }
        var data = {
            "username": username,
            "password": password
        }
        if (flag) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/cloud_note/user/login.do",
                data: data,
                dataType: "json",
                success: function(result) {
                    if (result.status == "0") {
                        var userId = result.data
                        addCookie("userId", userId)
                        window.location.href = "edit.html"
                    } else
                    if (result.status == "1") {
                        $("#count_span").html("用户名不存在")
                    } else
                    if (result.status == "2") {
                        $("#password_span").html("密码错误")
                    }
                },
                error: function(error) {
                    console.error("登录请求出错" + error)
                }
            });
        }

    })
})