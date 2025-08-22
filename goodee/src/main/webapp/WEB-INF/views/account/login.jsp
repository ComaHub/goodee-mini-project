<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class=" h-100 flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<div class="my-5 text-center">
			<h2 class="fw-bolder">로그인</h2>
		</div>
		<section class="h-25 col-8 m-auto">
			<div class="h-100 d-flex flex-column justify-content-center">
				<form:form modelAttribute="accountDTO" method="post">
					<div class="mb-3 d-flex justify-content-center">
						<div class="mb-1 d-flex flex-column gap-3">
							<form:input path="id" class="form-control" placeholder="ID"/>
							<form:password path="password" class="form-control"  placeholder="PW"/>
						</div>
					</div>
					<div class="mb-3 d-flex justify-content-center gap-3">
						<form:button class="btn btn-primary">로그인</form:button>
						<a href="./join" class="btn btn-outline-primary">회원가입</a>
					</div>
				</form:form>
			</div>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>