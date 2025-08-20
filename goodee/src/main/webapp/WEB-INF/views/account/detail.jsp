<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	
	<link href="/css/account/detail.css" rel="stylesheet">
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<div class="my-5 text-center">
			<h2 class="fw-bolder">회원 정보</h2>
		</div>
		<section class="col-10 m-auto">
			<div class="mb-3">
				<img alt="" src="/files/account/${fileDTO.saved}" height="300">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">ID</label>
				<p>${ accountDTO.id }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">이름</label>
				<p>${ accountDTO.name }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">이메일</label>
				<p>${ accountDTO.email }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">전화 번호</label>
				<p>${ accountDTO.phone }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">우편 번호</label>
				<p>${ accountDTO.postcode }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">주소</label>
				<p>${ accountDTO.address }</p>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">상세 주소</label>
				<p>${ accountDTO.addressDetail }</p>
			</div>
			<div class="mb-3 d-flex justify-content-between">
				<button id="dropOut" class="btn btn-danger">회원 탈퇴</button>
				<a class="btn btn-outline-primary" href="./update">수정</a>
			</div>
		</section>
		
		<div id="modal">
			<form:form modelAttribute="accountDTO" action="./dropOut" method="post">
				<p>비밀 번호를 입력해주세요</p>
				<form:input path="password"/>
				<form:button class="btn btn-danger">회원 탈퇴</form:button>
			</form:form>
		</div>
	
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script type="text/javascript" src="/js/account/detail.js"></script>
</body>

</html>