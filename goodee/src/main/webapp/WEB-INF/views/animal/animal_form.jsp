<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<section class="col-4 offset-4 mt-5">
			<div class="text-center">
				<c:if test="${ empty animalDTO.animalNumber }"><h2><b>보호 동물 등록</b></h2></c:if>
				<c:if test="${ not empty animalDTO.animalNumber }"><h2><b>보호 동물 정보 수정</b></h2></c:if>
			</div>
			
			<div class="mt-5">
				<form:form modelAttribute="animalDTO" method="POST" enctype="multipart/form-data">
					<form:hidden path="animalNumber"/>
					
					<div class="col-6 offset-3 mb-3">
						<img id="preview" width="150" height="150" style="object-fit: cover;" class="border border-1 border-dark p-1 rounded me-3" <c:if test="${ not empty animalDTO.animalProfileDTO }">src="/files/animal/${ animalDTO.animalProfileDTO.saved }"</c:if> />
						<label for="animalAttach">
							<c:if test="${ empty animalDTO.animalProfileDTO }"><div class="btn btn-outline-primary">프로필 사진 등록</div></c:if>
							<c:if test="${ not empty animalDTO.animalProfileDTO }"><div class="btn btn-outline-primary">프로필 사진 변경</div></c:if>
						</label>
						<input type="file" class="d-none" id="animalAttach" name="animalAttach" />
					</div>
				
					<div class="row mb-2">
						<div class="col-6">
							<form:label path="name" cssClass="form-label">이름</form:label>
							<form:input path="name" cssClass="form-control" />
						</div>
						
						<div class="col-6">
							<form:label path="species" cssClass="form-label">생물종</form:label>
							<form:input path="species" cssClass="form-control" />
						</div>
					</div>
					
					<div class="row mb-2">
						<div class="col-6">
							<form:label path="breed" cssClass="form-label">품종</form:label>
							<form:input path="breed" cssClass="form-control" />
						</div>
						
						<div class="col-6">
							<form:label path="weight" cssClass="form-label">체중 (kg)</form:label>
							<form:input path="weight" cssClass="form-control" />
						</div>
					</div>
					
					<div class="row mb-5">
						<div class="col-6">
							<form:label path="gender" cssClass="form-label">성별</form:label>
							<form:select path="gender" cssClass="form-select">
								<form:option value="">-- 선택 --</form:option>
								<form:option value="M">남</form:option>
								<form:option value="F">여</form:option>
							</form:select>
						</div>
						
						<div class="col-6">
							<form:label path="neutered" cssClass="form-label">중성화 여부</form:label>
							<form:select path="neutered" cssClass="form-select">
								<form:option value="">-- 선택 --</form:option>
								<form:option value="true">예</form:option>
								<form:option value="false">아니오</form:option>
							</form:select>
						</div>
					</div>
					
					<div class="d-flex gap-2 justify-content-center align-items-center">
						<button type="submit" class="btn btn-primary mr-2">등록</button>
						<button type="button" onclick="history.back();" class="btn btn-outline-secondary">취소</button>
					</div>
				</form:form>
			</div>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script src="/js/animal/animal-form.js"></script>
</body>

</html>