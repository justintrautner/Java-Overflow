<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Question</title>
</head>
<body class="ml-3 mt-2 mr-3">

	<h1>
		<c:out value="${question.question}" />
	</h1>

	<h2 class="d-inline">Tags:</h2>
	
		<c:forEach items="${question.tags}" var="tag">
			<p class="d-inline"><c:out value="${tag.subject}" /></p>
		</c:forEach>
	<div class="row">

		<div class="col-md-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Answers</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${question.answers}" var="answer">
						<tr>
							<td><c:out value="${answer.answer}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="col-md-2"></div>

		<div class="col-md-6">
			<h3>Add your answer:</h3>
			<form:form action="/questions/${question.id}" method="post" modelAttribute="newAnswer">
				<p>
					<form:label path="answer">Answer: </form:label>
					<form:input path="answer" />
				</p>
				<p>
					<form:errors class="text-danger" path="answer" />
				</p>
				<input type="submit" value="Answer"/>
			</form:form>
		</div>
	</div>
</body>
</html>