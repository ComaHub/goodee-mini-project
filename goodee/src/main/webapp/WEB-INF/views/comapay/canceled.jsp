<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>구매 취소</title>
	
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<section class="col-4 offset-4 mb-5">
			<div class="text-center mt-5">
	      <h2 class="fw-bolder">구매 취소</h2>
	      <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
      </div>
      
      <div class="text-center mt-5">
      	<h2><span class="material-symbols-outlined" style="font-size: 30px; color: blue;">check_circle</span></h2>
      	<h3 style="color: blue;">구매가 취소되었습니다.</h3>
      </div>
      
      <div class="col-8 offset-2 mt-5 d-flex justify-content-center align-items-center">
				<h5><span class="material-symbols-outlined align-bottom">box</span> 주문번호: ${ cancelOrder.orderId }</h5>
			</div>
      
      <div class="col-8 offset-2 mt-4">
      	<table class="table text-center">
      		<thead>
						<tr>
							<th class="col-4">이미지</th>
							<th class="col-4">상품명</th>
							<th class="col-4">가격</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="product" items="${ cancelOrder.productDTOs }">
							<tr>
								<td class="col-4" valign="middle"><img width="100" height="100" class="border border-1 border-dark" style="object-fit: cover;" src="/files/product/${ product.productImageDTO.saved }" /></td>
								<td class="col-4" valign="middle"><a href="/product/detail?productNumber=${ product.productNumber }">${ product.name }</a></td>
								<td class="col-4" valign="middle" class="productPrice" data-product-price="${ product.price }">${ product.price } 원</td>
							</tr>
						</c:forEach>
						
						
					</tbody>
				</table>
      </div>
      
      <div class="text-center mt-5">
      	<a href="/account/order" class="btn btn-primary">주문내역으로 이동하기</a>
      </div>
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>