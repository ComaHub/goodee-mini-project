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
		<h2>Detail</h2>
		<section class="col-10 m-auto">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">ID</label>
				<p>${ account.id }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">비밀번호</label>
				<p>${ account.password }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">이름</label>
				<p>${ account.name }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">이메일</label>
				<p>${ account.email }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">전화 번호</label>
				<p>${ account.phone }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">우편 번호</label>
				<p>${ account.postcode }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">주소</label>
				<p>${ account.address }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">상세 주소</label>
				<p>${ account.addressDetail }</p>
			</div>
			<div class="mb-3 d-flex justify-content-end">
				<a class="btn btn-outline-primary" href="./update">수정</a>
				<button id="dropOut" class="btn btn-outline-primary">회원 탈퇴</button>
			</div>
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>