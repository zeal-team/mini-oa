<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 头部 -->
	<%@include file="pages/includes/head.jsp"%>
	<div id="mainbox">
		<!-- 一级导航 -->
		<%@include file="pages/includes/primary_nav.jsp"%>
		<!-- 二级导航 -->
		<%@include file="pages/includes/second_nav.jsp"%>
		<div id="content">
			<div id="search">搜索区</div>
			<div id="list">
				<table border="1">
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
	<%@include file="pages/includes/footer.jsp"%>

</body>
</html>