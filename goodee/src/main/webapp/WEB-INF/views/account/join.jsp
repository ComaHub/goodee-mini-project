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
		<h2>Join</h2>
		<section>
			<form:form modelAttribute="accountDTO" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">ID</label>
					<form:input path="id" class="form-control"/>
					<form:errors path="id"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">비밀번호</label>
					<form:password path="password" class="form-control"/>
					<form:errors path="password"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">이름</label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">이메일</label>
					<form:input path="email" class="form-control"/>
					<form:errors path="email"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">전화 번호</label>
					<form:input path="phone" class="form-control"/>
					<form:errors path="phone"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">우편 번호</label>
				<form:input path="postcode" class="form-control"/>
					<form:errors path="postcode"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">주소</label>
					<form:input path="address" class="form-control"/>
					<form:errors path="address"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">상세 주소</label>
					<form:input path="addressDetail" class="form-control"/>
					<form:errors path="addressDetail"/>
				</div>
				<form:button>회원 가입</form:button>
			</form:form>
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>