<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.open4job.model.vo.ParadaTaxiVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ParadaTaxiVO parada = (ParadaTaxiVO) request.getAttribute("taxi");

		out.println(parada.getId());
		out.println(parada.getTitle());
	%>


</body>
</html>