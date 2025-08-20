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
		<h2>Update</h2>
		<section class="col-10 m-auto">
			<form:form modelAttribute="accountDTO" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="attach">
						<img alt="" src="/files/account/${fileDTO.saved}" height="300">
					</label>
				</div>
				<div class="mb-3">
					<input type="file" class="form-control" name="attach" id="attach">
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
					<button type="button" id="postBtn" class="btn btn-primary">주소 변경</button>
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
				<div class="mb-3 d-flex justify-content-end">
					<form:button class="btn btn-primary">변경</form:button>
				</div>
			</form:form>
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script type="text/javascript" src="/js/account/post.js"></script>
</body>

</html>