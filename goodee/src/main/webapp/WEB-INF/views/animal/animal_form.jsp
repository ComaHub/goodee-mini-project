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
		<section class="col-6 offset-3 mt-5">
			<div class="text-center">
				<h2><b>보호 대상 동물 등록</b></h2>
			</div>
			
			<div class="mt-5">
				<form:form modelAttribute="animalDTO" method="POST" enctype="multipart/form-data">
					<form:hidden path="animalNumber"/>
					
					<div class="mb-3">
						<img id="preview" width="150" height="150" class="border border-1 border-dark p-1 rounded me-3" <c:if test="${ not empty animalDTO.animalProfileDTO }">src="/files/animal/${ animalDTO.animalProfileDTO.saved }"</c:if> />
						<label for="animalAttach">
							<div class="btn btn-outline-primary">등록</div>
						</label>
						<input type="file" class="d-none" id="animalAttach" name="animalAttach" />
					</div>
				
					<div class="row mb-2">
						<div class="col-4">
							<form:label path="name" cssClass="form-label">이름</form:label>
							<form:input path="name" cssClass="form-control" />
						</div>
						
						<div class="col-4">
							<form:label path="species" cssClass="form-label">생물종</form:label>
							<form:input path="species" cssClass="form-control" />
						</div>
						
						<div class="col-4">
							<form:label path="breed" cssClass="form-label">품종</form:label>
							<form:input path="breed" cssClass="form-control" />
						</div>
					</div>
					
					<div class="row mb-3">
						<div class="col-4">
							<form:label path="gender" cssClass="form-label">성별</form:label>
							<form:input path="gender" cssClass="form-control" />
						</div>
						
						<div class="col-4">
							<form:label path="weight" cssClass="form-label">체중</form:label>
							<form:input path="weight" cssClass="form-control" />
						</div>
						
						<div class="col-4">
							<form:label path="neutered" cssClass="form-label">중성화 여부</form:label>
							<form:input path="neutered" cssClass="form-control" />
						</div>
					</div>
					
					<div class="d-flex gap-2 justify-content-center align-items-center">
						<button type="submit" class="btn btn-primary mr-2">등록</button>
						<button type="button" class="btn btn-outline-secondary">취소</button>
					</div>
				</form:form>
			</div>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script src="/js/animal/animal-form.js"></script>
</body>

</html>