<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String language="korea";
	String cookie = request.getHeader("Cookie");
	if(cookie != null){
		Cookie cookies[] = request.getCookies();
		for(int i=0; i<cookie.length(); i++){
			if(cookies[i].getName().equals("language")){
				language = cookies[i].getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(language.equals("korea")) { %>
	<h3>안녕하세요. 이것을 쿠키 예제입니다</h3>
<%} else { %>
	<h3>Hello. This is Cookie example.</h3>
<%} %>
<form action="cookieExample2.jsp" method="post">
	<input type="radio" name="language" value="korea" <%if(language.equals("korea")){%> checked <%} %> %>>
	<input type="radio" name="language" value="english" <%if(language.equals("korea")){%> checked <%} %> %>>
</form>
</body>
</html>