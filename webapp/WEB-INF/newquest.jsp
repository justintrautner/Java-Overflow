<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Add Question</title>
</head>
<body class="ml-3 mt-2 mr-3">
	<h1>What is your question?</h1>

	<form action="/questions/new" method="post">
	
	<p>Question:</p>
	<textarea name="question"></textarea>
	<p>Tags:</p>
	<p><input type="text" name="tags"></p>
	<p>
	<input type="submit" value="Post Question">
	</p>
	</form>


</body>
</html>