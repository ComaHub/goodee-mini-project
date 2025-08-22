<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<section class="col-4 offset-4 mt-5">
			<div class="text-center">
				<h2><b>회원 정보 수정</b></h2>
			</div>
			
			<div class="my-5">
				<form:form modelAttribute="accountDTO" method="POST" enctype="multipart/form-data">					
					<div class="col-8 offset-2 mb-3">
						<img id="preview" width="150" height="150" style="object-fit: cover;" class="border border-1 border-dark p-1 rounded me-3" src="/files/account/${fileDTO.saved}"/>
						<label for="attach">
							<div class="btn btn-outline-primary">프로필 사진 수정</div>
						</label>
						<input type="file" class="d-none" id="attach" name="attach" />
					</div>
					
					<div class="row mb-2">
						<div class="col-6">
							<form:label path="name" cssClass="form-label">이름</form:label>
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name"/>
						</div>
					</div>
					
					<div class="row mb-5">
						<div class="col-6">
							<form:label path="email" cssClass="form-label">이메일</form:label>
							<form:input path="email" cssClass="form-control" />
							<form:errors path="email"/>
						</div>
						
						<div class="col-6">
							<form:label path="phone" cssClass="form-label">전화번호</form:label>
							<form:input path="phone" cssClass="form-control" />
							<form:errors path="phone"/>
						</div>
					</div>
					
					<div class="row mb-2">
						<div class="col-6">
							<form:label path="postcode" cssClass="form-label">우편번호</form:label>
							<form:input path="postcode" cssClass="form-control" readonly="true" />
							<form:errors path="postcode"/>
						</div>
						
						<div class="col-6 d-flex align-items-end">
							<button type="button" id="postBtn" class="btn btn-primary m-0">주소 입력</button>
						</div>
					</div>
					
					<div class="row mb-2">
						<div class="col-12">
							<form:label path="address" cssClass="form-label">주소</form:label>
							<form:input path="address" cssClass="form-control" readonly="true" />
							<form:errors path="address"/>
						</div>
					</div>
					
					<div class="row mb-5">
						<div class="col-12">
							<form:label path="addressDetail" cssClass="form-label">상세주소</form:label>
							<form:input path="addressDetail" cssClass="form-control" />
							<form:errors path="addressDetail"/>
						</div>
					</div>
					
					<div class="d-flex gap-2 justify-content-center align-items-center">
						<button type="submit" class="btn btn-primary mr-2">수정</button>
						<button type="button" onclick="history.back();" class="btn btn-outline-secondary">취소</button>
					</div>
				</form:form>
			</div>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script type="text/javascript" src="/js/account/post.js"></script>
</body>

</html>