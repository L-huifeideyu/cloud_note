//弹出创建笔记本对话框
function alertAddBookWindow(){
	//显示背景色div
	$(".opacity_bg").show();
	//弹出对话框div
	$("#can").load("http://localhost:8080/cloud_note/alert/alert_notebook.html");
};
//关闭对话框
function closeWindow(){
	$(".opacity_bg").hide();//隐藏背景色div
	$("#can").empty();//清空对话框内容
};

//弹出创建笔记对话框
function alertAddNoteWindow(){
	//检测是否选中笔记本
	var $a = $("#book_list li a.checked");
	if($a.length==0){//未选中提示错误
		alert("请选择笔记本");
	}else{//选中弹出对话框
		//显示背景色div
		$(".opacity_bg").show();
		//弹出对话框div
		$("#can").load("http://localhost:8080/cloud_note/alert/alert_note.html");
	}
};

//弹出确认删除笔记对话框
function alertRecycleNoteWindow(){
	//显示背景色div
	$(".opacity_bg").show();
	//弹出对话框div
	$("#can").load("http://localhost:8080/cloud_note/alert/alert_delete_note.html");
};

//弹出移动笔记对话框
function alertMoveNoteWindow(){
	//显示背景色div
	$(".opacity_bg").show();
	//弹出对话框div
	var url = path+"/alert/alert_move.html";
	$("#can").load(url,function(){
		//获取笔记本信息填充下拉单选项
		var bookLis = $("#book_list li");//获取所有笔记本li
		for(var i=0;i<bookLis.length;i++){
			var $li = $(bookLis[i]);//循环每个笔记本li
			var bookName = $li.text().trim();//获取笔记本名
			var bookId = $li.data("bookId");//获取笔记本ID
			//拼成一个option
			var opt = "<option value='"+bookId+"'>"
				+bookName+"</option>";
			//将option添加到select
			$("#moveSelect").append(opt);
		}
	});
};



