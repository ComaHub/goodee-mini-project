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
		<section class="col-6 offset-3 mt-5">
      <div class="text-center">
         <h2 class="fw-bolder">보호동물 정보</h2>
         <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
      </div>

     	<div class="col-8 offset-2">
     		<div class="col-8 offset-2">
     			<img width="100%" class="border border-dark border-1 rounded p-1" src="/files/animal/${ animalDTO.animalProfileDTO.saved }" alt="Animal Profile Img" />
     		</div>
     		
     		<div class="col-8 offset-2 mt-5 mb-5">
     			<table class="table table-bordered border-dark text-center">
     				<tbody>
     					<tr>
     						<td class="table-primary border-dark col-4">이름</td>
     						<td class="col-8">${ animalDTO.name }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">생물종</td>
     						<td>${ animalDTO.species }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">품종</td>
     						<td>${ animalDTO.breed }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">이름</td>
     						<td>${ animalDTO.name }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">성별</td>
     						<td>${ animalDTO.gender }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">등록일</td>
     						<td>${ animalDTO.dateToString }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">체중</td>
     						<td>${ animalDTO.weight } Kg</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark">중성화 여부</td>
     						<td>${ animalDTO.neutered ? "예" : "아니오" }</td>
     					</tr>
     					
     					<tr>
     						<td class="table-primary border-dark" >상태</td>
     						<td>${ animalDTO.status }</td>
     					</tr>	
     				</tbody>
     			</table>
     		</div>
     		
     		<div class="d-flex gap-2 justify-content-center mb-5">
     			<button type="button" id="adoptBtn" class="btn btn-primary">입양 신청</button>
     			<button type="button" id="updateBtn" data-animal-number="${ animalDTO.animalNumber }" class="btn btn-success">수정</button>
     			<button type="button" id="deleteBtn" class="btn btn-danger">삭제</button>
     		</div>
     	</div>
     	
		</section>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	<script src="/js/animal/animal-detail.js"></script>
</body>

</html>