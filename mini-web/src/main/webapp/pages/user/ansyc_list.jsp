<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/pages/includes/header.jsp"%>
<%@include file="/pages/includes/struts-tags.jsp"%>
<%@include file="/pages/includes/jqgrid.jsp"%>
<title><s:property value="%{getText('user.list.title')}"/></title>
</head>
<body>
	<input type="button" value="添加" onclick="showEdit(0);" />
	用户名：<input type="text" name="user.userName" value="" />
	工号：<input type="text" name="user.empNo" value="" />
	<input type="button" value="搜索" id="search" onclick="ansyc_search();" />
	<table id="list"></table> 
	<div id="pager"></div>
</body>
</html>
<script type="text/javascript">
	function showEdit(id) {
		var title = "新增客户";
		var url = "user_view";
		if (id) {
			title = "编辑客户";
			url = url + "?id=" + id;
		}
		showWindow(title, url, 500, 500);
	}

	function search() {
		$("#search").click();
	}
	
	function ansyc_search() {
		$.ajax({
			url : "user_list_json",
			type : "POST",
			success : function(result) {
				alert(result);
				alert($.toJSON(result));
			}
		});
	}

	function del(id) {
		top.showBox();
		$.ajax({
			url : "user_delete",
			data : {
				"id" : id
			},
			success : function(result) {
				if(result && result.isSuccess)
				{
					top.showBox("删除成功", MSG_TYPE.SUCCESS, search);
				} else if(result) {
					top.showBox(result.message, MSG_TYPE.ERROR);
				} else {
					top.showBox("删除失败", MSG_TYPE.ERROR);
				}
			}
		});
	}
</script>