<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>首页</title>
<!-- <link type="text/css" rel="stylesheet" href="../css/frame.css" -->

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

</head>

<body>

	<!-- 头部 -->
	<%@include file="../includes/head.jsp"%>

	<div id="mainbox">
		<div id="menu">
			<!-- 一级导航 -->
			<%@include file="../includes/primary_nav.jsp"%>
		</div>


		<!-- 二级导航 -->
				<%@include file="../includes/second_nav.jsp"%>  

		<div id="content">
			<div id="search">搜索区</div>
			<div id="list">
			
			<!-- <table id="list"></table> 
				<div id="pager"></div> -->
			
				<table align="center" border="1">
					<thead>
						<tr>
							<th>列一</th>
							<th>列二</th>
							<th>列三</th>
							<th>列四</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>内容一</td>
							<td>内容二</td>
							<td>内容三</td>
							<td>内容四</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<!-- 尾部 -->
		<%@include file="../includes/footer.jsp"%>  

</body>
</html>
