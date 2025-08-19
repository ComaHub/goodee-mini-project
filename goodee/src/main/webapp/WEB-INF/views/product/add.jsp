<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<h2>Add</h2>
		<section class="col-10 m-auto">
			<form:form modelAttribute="productDTO" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">상품명</label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">종류</label>
					<form:input path="category" class="form-control"/>
					<form:errors path="category"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">가격</label>
					<form:input path="price" class="form-control"/>
					<form:errors path="price"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">재고</label>
					<form:input path="amount" class="form-control"/>
					<form:errors path="amount"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">가격</label>
					<form:input path="price" class="form-control"/>
					<form:errors path="price"/>
				</div>
				<div class="mb-3 d-flex justify-content-end">
					<form:button class="btn btn-primary">상품 등록</form:button>
				</div>
			</form:form>
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>