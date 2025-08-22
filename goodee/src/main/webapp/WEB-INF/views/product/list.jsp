<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<div class="container px-5 my-5">
			<div class="row gx-5 justify-content-center">
        <div class="col-8">
          <div class="text-center">
          	<c:choose>
          		<c:when test="${ isCartList }">
			          <h2 class="fw-bolder">장바구니 목록</h2>          		
          		</c:when>
          		
          		<c:when test="${ isLikeList }">
          			<h2 class="fw-bolder">찜 목록</h2>
          		</c:when>
          		
          		<c:otherwise>
          			<h2 class="fw-bolder">상품 목록</h2>    
          		</c:otherwise>
          	</c:choose>
          
	          <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
          </div>
        </div>
	    </div>
		</div>
		
		<section class="col-8 offset-2">
			<form id="cartForm">
				<table class="table text-center">
					<thead>
						<tr>
							<c:if test="${ isCartList }"><th class="col-1"><input type="checkbox" class="form-check-input mt-0" id="checkAll" /></th></c:if>
							<th class="col-2">이미지</th>
							<th class="col-3">상품명</th>
							<th class="col-2">가격</th>
							<th class="col-1">카테고리</th>
							<th class="col-3">메뉴</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="product" items="${ productList }">
							<tr>
								<c:if test="${ isCartList }"><td valign="middle"><input type="checkbox" class="form-check-input mt-0 checkedProduct" name="checkedProduct" value="${ product.productNumber }" /></td></c:if>
								<td valign="middle"><img width="100" height="100" class="border border-1 border-dark" style="object-fit: cover;" src="/files/product/${ product.productImageDTO.saved }" /></td>
								<td valign="middle"><a href="/product/detail?productNumber=${ product.productNumber }">${ product.name }</a></td>
								<td valign="middle">${ product.price } 원</td>
								<td valign="middle">${ product.category }</td>
								<td valign="middle">
									<div class="d-flex gap-4 justify-content-center">
										<c:if test="${ not isLikeList }"><a class="addLikeBtn" data-product-number="${ product.productNumber }" ><span class="material-symbols-outlined">favorite</span></a></c:if>
										<c:if test="${ isLikeList }"><a class="removeLikeBtn" data-product-number="${ product.productNumber }" ><span class="material-symbols-outlined">heart_minus</span></a></c:if>
										<c:if test="${ not isCartList }"><a class="addCartBtn" data-product-number="${ product.productNumber }" ><span class="material-symbols-outlined">add_shopping_cart</span></a></c:if>
										<c:if test="${ isCartList }"><a class="removeCartBtn" data-product-number="${ product.productNumber }" ><span class="material-symbols-outlined">shopping_cart_off</span></a></c:if>
										<a class="comaPayBtn" data-product-number="${ product.productNumber }" ><span class="material-symbols-outlined">credit_card</span></a>
									</div>
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
				
				<c:if test="${ isCartList }">
					<div class="d-flex gap-3 justify-content-end align-items-center">
						<button type="button" class="btn btn-primary" id="comaPayAllBtn">선택 상품 결제</button>
					</div>
				</c:if>
			</form>
			<c:if test="${ logined.admin and not isCartList and not isLikeList }">
				<div class="mb-3 d-flex justify-content-end">
					<a class="btn btn-primary" href="/product/add">상품 추가</a>
				</div>
			</c:if>
			<!-- 페이징 -->
			<c:import url="/WEB-INF/views/includes/paging.jsp"></c:import>
			<!-- 페이징 -->
		</section>
		
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script>
		const username = "${ sessionScope.logined.name }";
	</script>
	<script src="/js/product/product-list.js"></script>
	<script src="/js/payment/kakao-pay.js"></script>
</body>

</html>