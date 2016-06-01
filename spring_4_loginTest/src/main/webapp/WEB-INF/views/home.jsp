<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p> ${message}</p>
<c:choose>
<c:when test="${member eq null }">
	<p><a href="member/login">로그인</a></p>
	<p><a href="member/join">회원가입</a></p>
</c:when>
<c:otherwise>
	<p>${member.id}님 로그인 되셨습니다</p>
	<p><a href="member/logout">로그아웃</a><p>
</c:otherwise>
</c:choose>
</body>
</html>
