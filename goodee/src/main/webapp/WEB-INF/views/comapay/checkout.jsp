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
		<section class="col-4 offset-4">
			<div class="text-center">
	      <h2 class="fw-bolder">결제</h2>
	      <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
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