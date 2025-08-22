<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
						<h2 class="fw-bolder">주문 내역</h2>  
	          <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
          </div>
        </div>
	    </div>
		</div>
		
		<c:forEach var="order" items="${ requestScope.orderList }">
			<div class="col-6 offset-3 my-5">
				<div class="col-8 offset-2 mb-3 d-flex justify-content-between align-items-center">
					<h5><span class="material-symbols-outlined align-bottom">box</span> 주문번호: ${ order.orderId }</h5>
					<button type="button" class="btn btn-outline-danger">결제취소</button>
				</div>
				
				<div class="col-8 offset-2 mb-3">
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
							
							<c:forEach var="product" items="${ order.productDTOs }">
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
			</div>
		</c:forEach>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>