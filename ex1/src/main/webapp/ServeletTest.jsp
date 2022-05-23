<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--CDN 링크 -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" rel="stylesheet"> 
<%
Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int minute = c.get(Calendar.MINUTE);
int second = c.get(Calendar.SECOND);
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:black;">
	<h1 id='now' style="color:white;">
		현재 시간은 <%= hour %>시 <%= minute %>분 <%= second %>초 입니다.
	</h1>
	<h1 id='clock'>00:00:00</h1>
	<script type='text/javascript' src='js/clock.js'></script>
</body>
</html>
