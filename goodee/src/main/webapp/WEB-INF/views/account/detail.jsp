<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	
	<link href="/css/account/detail.css" rel="stylesheet">
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
</head>

<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
	
		<!-- Contents here! -->
		<section class="col-6 offset-3 mt-5">
      <div class="text-center">
         <h2 class="fw-bolder">회원 정보</h2>
         <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
      </div>

     	<div class="col-8 offset-2">
     		<div class="col-8 offset-2">
     			<img width="100%" style="aspect-ratio: 1 / 1; object-fit: cover;" class="border border-dark border-1 rounded p-1" src="/files/account/${ fileDTO.saved }" alt="Profile Img" />
     		</div>
     		
     		<div class="col-8 offset-2 mt-5 mb-5">
     			<table class="table table-bordered border-dark text-center">
     				<tbody>
     					<tr>
     						<td class="table-primary border-dark col-4">아이디</td>
     						<td class="col-8">${ accountDTO.id }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">이름</td>
     						<td>${ accountDTO.name }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">이메일</td>
     						<td>${ accountDTO.email }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">전화번호</td>
     						<td>${ accountDTO.phone }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">우편번호</td>
     						<td>${ accountDTO.postcode }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">주소</td>
     						<td>${ accountDTO.address }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">상세주소</td>
     						<td>${ accountDTO.addressDetail }</td>
     					</tr>
     				</tbody>
     			</table>
     		</div>
     		
     		<div class="d-flex gap-2 justify-content-center mb-5">
     			<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#dropModal">회원 탈퇴</button>
					<a class="btn btn-outline-primary" href="./update">정보 수정</a>
     		</div>
     	</div>
		</section>
		
		<div class="modal fade" id="dropModal" tabindex="-1" aria-labelledby="dropModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    	<form:form modelAttribute="accountDTO" action="dropOut" method="POST">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="exampleModalLabel">정말 탈퇴하시겠습니까?</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p>탈퇴하시려면 비밀번호를 입력해주세요.<br>탈퇴한 회원의 정보는 복구할 수 없습니다.</p>
			        <form:password path="password" cssClass="form-control"/>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
			        <form:button class="btn btn-danger">회원 탈퇴</form:button>
			      </div>
		    	</form:form>
		    </div>
		  </div>
		</div>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script type="text/javascript" src="/js/account/detail.js"></script>
</body>

</html>