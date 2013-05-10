<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/pages/includes/header.jsp"%>
<%@include file="/pages/includes/struts-tags.jsp"%>
<title><s:property value="%{getText('user.list.title')}"/></title>
</head>
<body>
	<div id="user">
	<input type="hidden" id="id" value="${user.id}" />
	用户名：<input type="text" id="userName" value="${user.userName}" /><br/>
	工号：<input type="text" id="empNo" value="${user.empNo}" /><br/>
	密码：<input type="text" id="password" value="${user.password}" /><br/>
	<input type="button" value="提交" onclick="save();" />
	</div>
</body>
</html>
<script type="text/javascript">
function save() {
	$.validity.setup({ outputMode:'custom' });

	function valid() {
		$.validity.start();
		$("#userName").require("用户名必须输入！");
		$("#password").require("密码必须输入！");
		var result = $.validity.end();
		alert(result.messages);
		return result.valid;
	}

	if(!valid()) {
		return false;
	}

	//前面还有验证的代码

	var user = getInput("user", true);
	top.showBox();
	$.ajax({
		url : "user_save",
		data : user,
		type : "POST",
		success : function(result) {
			if(result && result.isSuccess)
			{
				top.showBox("提交成功", MSG_TYPE.SUCCESS, parent.search);
			} else if(result) {
				if(result.message) {
					top.showBox(result.message, MSG_TYPE.ERROR);
				} else if(result.fieldErrors) {
					var error = "";
					for(var key in result.fieldErrors) {
						if(result.fieldErrors[key]) {
							for(var i in result.fieldErrors[key]) {
								error += result.fieldErrors[key][i] + "<br / >"
							}
						}
					}
					top.showBox(error, MSG_TYPE.ERROR);
				} else {
					top.showBox("服务器异常!", MSG_TYPE.ERROR);
				}
			} else {
				top.showBox("提交失败", MSG_TYPE.ERROR);
			}
		}
	});
}
</script>