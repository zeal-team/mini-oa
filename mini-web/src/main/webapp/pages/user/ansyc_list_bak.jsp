<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@include file="/pages/includes/struts-tags.jsp"%>
<%@include file="/pages/includes/jqgrid.jsp"%>
<title><s:property value="%{getText('user.list.title')}" /></title>
<style type="text/css">
#header {
	border: #000000 solid;
}

#mainbox {
	border: #FF0000 solid;
}

#menu {
	border: #FF9933 solid;
}

#sidebar {
	border: #996600 solid;
	float: left;
	height: 300px;
	width: 19%;
}

#content {
	border: #66CC00 solid;
	float: right;
	height: 50%;
	width: 80%;
}

#search {
	border: #000099 solid;
	height: 35px;
}

#list {
	border: #990099 solid;
	height: 250px;
}

#footer {
	border: #FFCCCC solid;
	height: auto;
}
</style>

<style type="text/css">
#bg {
	width: 700px;
	align:center;
}

#bg li.bt {
	list-style-type: none;
	width: 100px;
	height: 20px;
	line-height: 20px;
	text-align: center;
	float: left;
	margin-left: 1px;
	margin-bottom: 1px;
	background: #666; 
	/* background: #999;  */
}

#bg li {
list-style-type: none;
	width: 100px;
	height: 40px;
	line-height: 20px;
	text-align: center;
	float: left;
	margin-left: 1px;
	margin-bottom: 1px;
	background: #999; 
	 
}
</style>
</head>
<body>
	<!-- 头部 -->
	<%@include file="../includes/head.jsp"%>
	<div id="mainbox">
		<!-- 一级导航 -->
		<%@include file="../includes/primary_nav.jsp"%>
		<!-- 二级导航 -->
		<%@include file="../includes/second_nav.jsp"%>
		<div id="content">
			<input type="button" value="添加" onclick="showEdit(0);" /> <input
				type="button" value="搜索" onclick="ansyc_search();" />
			<div action="user_list" method="post"
				enctype="application/x-www-form-urlencoded">
				用户名：<input type="text" name="user.userName" value="${user.userName}" />
				工号：<input type="text" name="user.empNo" value="${user.empNo}" /> <input
					type="button" value="搜索" id="ansycsearch" onclick="ansyc_search();" />
			</div>
			<div id="list">


				<div align="center">
					<ul id="bg">

						<li class="bt">用户名</li>
						<li class="bt">密码</li>
						<li class="bt">添加日期</li>
						<li class="bt">是否有效</li>
						<li class="bt">是否删除</li>
						<li class="bt">操作</li>
					
					<tbody>
						<s:iterator value="list" id="user">
							
								<li><s:property value="#user.userName" /></li>
								<li>${password}</li>
								<li>${createTime}</li>
								<li><s:if test='%{#user.valid}'>是</s:if> <s:else>否</s:else>
								</li>
								<li><s:if test='%{#user.deleted}'>是</s:if> <s:else>否</s:else>
								</li>
								<li><a
									href="javascript:showEdit(<s:property value="#user.id" />);">编辑</a>
									| <a href="javascript:del(${id});">删除</a></li>
								
						</s:iterator>
					</tbody>
</ul>
				</div>


				<div id="pager"></div>

			</div>
		</div>
	</div>
	<!-- 尾部 -->
	<%@include file="../includes/footer.jsp"%>



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
				if (result && result.isSuccess) {
					top.showBox("删除成功", MSG_TYPE.SUCCESS, search);
				} else if (result) {
					top.showBox(result.message, MSG_TYPE.ERROR);
				} else {
					top.showBox("删除失败", MSG_TYPE.ERROR);
				}
			}
		});
	}

	$(function() {
		$("#list")
				.jqGrid(
						{
							url : 'user_list_json', //请求数据的url地址
							datatype : "json", //请求的数据类型
							colNames : [ '名称', '工号', '密码', '创建日期', '操作' ], //数据列名称（数组）
							colModel : [ //数据列各参数信息设置
							{
								name : 'userName',
								index : 'userName',
								editable : true,
								width : 80,
								align : 'center',
								title : false
							}, {
								name : 'empNo',
								index : 'empNo',
								width : 180,
								title : false
							}, {
								name : 'password',
								index : 'password',
								width : 120,
								hidden : true
							}, {
								name : 'createTime',
								index : 'createTime',
								width : 120
							}, {
								name : 'opt',
								index : 'opt',
								width : 80,
								sortable : false,
								align : 'center'
							} ],
							rowNum : 10, //每页显示记录数
							rowList : [ 10, 20, 30 ], //分页选项，可以下拉选择每页显示记录数
							pager : '#pager', //表格数据关联的分页条，html元素
							autowidth : true, //自动匹配宽度
							height : 275, //设置高度
							gridview : true, //加速显示
							viewrecords : true, //显示总记录数
							multiselect : true, //可多选，出现多选框
							multiselectWidth : 25, //设置多选列宽度
							sortable : false, //可以排序
							//sortname: 'id',  //排序字段名
							//sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
							loadComplete : function(data) { //完成服务器请求后，回调函数
								// 获取所有的数据的标识,如果你的数据里面有id这个字段，恭喜，你不需要做什么改变了。
								// 否则它会虚拟一个id的字段并按照顺序填充上值
								var ids = $(this).jqGrid('getDataIDs');
								var length = ids.length;
								for ( var i = 0; i < length; i++) {
									var id = ids[i];
									// 获取id标识所在行的行数据，即是模型数据了
									//var model = $(this).jqGrid('getRowData', id);
									var opt = '<a href="javascript:showEdit(0);">编辑</a> | <a href="javascript:del(0);">删除</a>';
									$(this).jqGrid('setRowData', ids[i], {
										"opt" : opt
									});
								}
							},
							jsonReader : {
								root : "list",
								page : "pager.index",
								total : "pager.totalPage",
								records : "pager.count",
								repeatitems : false
							}
						});
	});
</script>