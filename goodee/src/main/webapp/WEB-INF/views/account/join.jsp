<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<div class="my-5 text-center">
			<h2 class="fw-bolder">회원 가입</h2>
		</div>
		<section class="mb-3 col-8 m-auto">
			<form:form modelAttribute="accountDTO" method="post" enctype="multipart/form-data">
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
					<label for="exampleFormControlInput1" class="form-label">프로필 사진</label>
					<input class="form-control" type="file" name="attach">
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
					<button type="button" id="postBtn" class="btn btn-primary">주소 입력</button>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">우편 번호</label>
					<form:input path="postcode" class="form-control" readonly="true"/>
					<form:errors path="postcode"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">주소</label>
					<form:input path="address" class="form-control" readonly="true"/>
					<form:errors path="address"/>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">상세 주소</label>
					<form:input path="addressDetail" class="form-control"/>
					<form:errors path="addressDetail"/>
				</div>
				<form:button class="btn btn-primary">회원 가입</form:button>
			</form:form>
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script type="text/javascript" src="/js/account/post.js"></script>
</body>

</html>