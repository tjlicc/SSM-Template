<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>验证码示例</title>
</head>
<body>
	<form>
		<img src="${ctx}/getCode">
		<input type="submit" value="提交">
	</form>
</body>
</html>