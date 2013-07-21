<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/pages/includes/header.jsp"%>
<%@include file="/pages/includes/struts-tags.jsp"%>
<title><s:property value="%{getText('systemInfo.list.title')}"/></title>
</head>
<body>
	<div id="systemInfo">
	<input type="hidden" id="id" value="${systemInfo.id}" />
	系统名：<input type="text" id="sysName" value="${systemInfo.sysName}" /><br/>
	Url：<input type="text" id="sysUrl" value="${systemInfo.sysUrl}" /><br/>
	详情：<input type="text" id="sysDesc" value="${systemInfo.sysDesc}" /><br/>
	<input type="button" value="提交" onclick="save();" />
	</div>
</body>
</html>
<script type="text/javascript">
function save() {
	$.validity.setup({ outputMode:'systeminfo' });

	function valid() {
		$.validity.start();
		$("#sysName").require("系统名必须输入！");
		$("#sysUrl").require("Url必须输入！");
		var result = $.validity.end();
		alert(result.messages);
		return result.valid;
	}

	if(!valid()) {
		return false;
	}

	//前面还有验证的代码

	var systemInfo = getInput("systemInfo", true);
	top.showBox();
	$.ajax({
		url : "system_info_save",
		data : systemInfo,
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