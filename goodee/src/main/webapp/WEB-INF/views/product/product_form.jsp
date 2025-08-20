<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>상품 정보 관리</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<section class="col-4 offset-4 mt-5">
			<div class="text-center">
				<c:if test="${ empty productDTO.productNumber }"><h2><b>상품 등록</b></h2></c:if>
				<c:if test="${ not empty productDTO.productNumber }"><h2><b>상품 정보 수정</b></h2></c:if>
			</div>
			
			<div class="mt-5">
				<form:form modelAttribute="productDTO" method="POST" enctype="multipart/form-data">
					<form:hidden path="productNumber"/>
					
					<div class="col-6 offset-3 mb-3">
						<img id="preview" width="150" height="150" style="object-fit: cover;" class="border border-1 border-dark p-1 rounded me-3" <c:if test="${ not empty productDTO.productImageDTO }">src="/files/product/${ productDTO.productImageDTO.saved }"</c:if> />
						<label for="productImage">
							<c:if test="${ empty productDTO.productImageDTO }"><div class="btn btn-outline-primary">상품 사진 등록</div></c:if>
							<c:if test="${ not empty productDTO.productImageDTO }"><div class="btn btn-outline-primary">상품 사진 변경</div></c:if>
						</label>
						<input type="file" class="d-none" id="productImage" name="productImage" />
					</div>
				
					<div class="row mb-5">
						<div class="col-6">
							<form:label path="name" cssClass="form-label">상품명</form:label>
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name"></form:errors>
						</div>
						
						<div class="col-6">
							<form:label path="category" cssClass="form-label">카테고리</form:label>
							<form:input path="category" cssClass="form-control" />
							<form:errors path="category"></form:errors>
						</div>
					</div>
					
					<div class="row mb-5">
						<div class="col-6">
							<form:label path="amount" cssClass="form-label">재고</form:label>
							<form:input path="amount" cssClass="form-control" />
							<form:errors path="amount"></form:errors>
						</div>
						
						<div class="col-6">
							<form:label path="price" cssClass="form-label">가격</form:label>
							<form:input path="price" cssClass="form-control" />
							<form:errors path="price"></form:errors>
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
	<script src="/js/product/product-form.js"></script>
</body>

</html>