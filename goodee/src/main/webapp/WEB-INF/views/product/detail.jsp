<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>굿즈</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<section class="col-4 offset-4 mt-5">
			<div class="text-center">
         <h2 class="fw-bolder">상품 상세 정보</h2>
         <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
      </div>
      
      <div class="col-6 offset-3">
   			<img width="100%" style="aspect-ratio: 1 / 1; object-fit: cover;" class="border border-dark border-1 rounded p-1" src="/files/product/${ requestScope.productDTO.productImageDTO.saved }" alt="Product Img" />
   		</div>
   		
   		<div class="col-6 offset-3 mt-5">
   			<table class="table table-bordered border-dark text-center">
	 				<tbody>
	 					<tr>
	 						<td class="table-primary border-dark col-4">상품명</td>
	 						<td class="col-8">${ requestScope.productDTO.name }</td>
	 					</tr>
	 					
	 					<tr>
	 						<td class="table-primary border-dark">카테고리</td>
	 						<td>${ requestScope.productDTO.category }</td>
	 					</tr>
	 					
	 					<tr>
	 						<td class="table-primary border-dark">재고</td>
	 						<td>${ requestScope.productDTO.amount }</td>
	 					</tr>
	 					
	 					<tr>
	 						<td class="table-primary border-dark">가격</td>
	 						<td>${ requestScope.productDTO.price }</td>
	 					</tr>
	 				</tbody>
	 			</table>
   		</div>
		
			<div class="mt-5">
				<c:choose>
					<c:when test="${ logined.admin eq true }">
						<div class="mb-3 gap-3 d-flex justify-content-center">
							<button type="button" id="updateBtn" data-product-number="${ productDTO.productNumber }" class="btn btn-primary">상품 수정</button>
							<button type="button" id="deleteBtn" data-product-number="${ productDTO.productNumber }" class="btn btn-danger">상품 삭제</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="mb-3 gap-3 d-flex justify-content-center">
							<a id="addLikeBtn" data-product-number="${ productDTO.productNumber }" class="btn btn-outline-danger">찜하기</a>
							<a id="addCartBtn" data-product-number="${ productDTO.productNumber }" class="btn btn-outline-primary">장바구니</a>
							<a href="/comapay/checkout?productNumber=${ productDTO.productNumber }" class="btn btn-outline-success">구매하기</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</section>
	
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script>
		const username = "${ sessionScope.logined.name }";
	</script>
	<script src="/js/product/product-detail.js"></script>
</body>

</html>