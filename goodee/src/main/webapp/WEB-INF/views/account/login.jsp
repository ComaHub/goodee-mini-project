<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<h1>Login</h1>
		<section class="col-10 m-auto">
			<form:form modelAttribute="accountDTO" method="post">
				<div class="mb-3 d-flex justify-content-center">
					<form:input path="id"/>
					<form:password path="password"/>
				</div>
				<div class="mb-3 d-flex justify-content-center">
					<form:button class="btn btn-primary">로그인</form:button>
					<a href="./join" class="btn btn-outline-primary">회원가입</a>
				</div>
			</form:form>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>