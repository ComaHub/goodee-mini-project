<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>결제</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
	<script src="https://js.tosspayments.com/v2/standard"></script>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<section class="col-4 offset-4 mb-5">
			<div class="text-center mt-5">
	      <h2 class="fw-bolder">결제 요청</h2>
	      <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
      </div>
      
      <div class="text-center mt-5">
	      <h4 class="fw-bolder">구매 품목</h4>
      </div>
      
      <div class="mt-4">
      	<table class="table text-center">
					<thead>
						<tr>
							<th class="col-3">이미지</th>
							<th class="col-4">상품명</th>
							<th class="col-2">카테고리</th>
							<th class="col-3">가격</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="product" items="${ productList }">
							<tr>
								<td valign="middle"><img width="100" height="100" class="border border-1 border-dark" style="object-fit: cover;" src="/files/product/${ product.productImageDTO.saved }" /></td>
								<td valign="middle"><a href="/product/detail?productNumber=${ product.productNumber }">${ product.name }</a></td>
								<td valign="middle">${ product.category }</td>
								<td valign="middle" class="productPrice" data-product-price="${ product.price }">${ product.price } 원</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
      </div>
      
      <div class="text-center mt-5">
      	<h5 class="fw-bolder">총 결제 금액: <span id="totalPrice"></span>원</h5>
      </div>
      
      <div id="payment-method"></div>
      
      <div id="agreement"></div>
      
      <div class="d-grid col-6 offset-3">
	      <button class="btn btn-primary" id="payBtn">결제하기</button>
      </div>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script src="/js/payment/comapay-checkout.js"></script>
</body>

</html>