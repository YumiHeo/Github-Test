<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
		if('${message}' != ''){
			alert('${message}');
		}
	
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p>${message}</p>
<c:choose>
	<c:when test="${member eq null }">
		<p><a href="member/login">login</a></p>
		<p><a href="member/join">join</a></p>
	</c:when>
	<c:otherwise>
		
		<p>${member.name}</p>
		<p><a href="member/logout">logout</a></p>
	</c:otherwise>
</c:choose>
<a href="notice/list?curPage=1">notice</a>
</body>
</html>
