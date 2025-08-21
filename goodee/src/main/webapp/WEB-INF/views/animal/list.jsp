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
	          <h2 class="fw-bolder">보호 동물 조회</h2>
	          <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
          </div>
          
          <c:if test="${ sessionScope.logined.admin }">
	          <div class="text-center mb-5">
	          	<a href="add" class="btn btn-primary">보호 동물 등록</a>
	          </div>
          </c:if>
        </div>
	    </div>
	    <div class="row gx-5">
	    
	    	<c:choose>
	    		<c:when test="${ not empty requestScope.animalList }">
	    			<c:forEach var="animal" items="${ requestScope.animalList }">
	    			
	    				<div class="col-4 mb-5">
			          <div class="card h-100 shadow border-0">
			            <img class="card-img-top" style="aspect-ratio: 1 / 1; object-fit: cover;" src="/files/animal/${ animal.animalProfileDTO.saved }" alt="..." />
			            <div class="card-body p-4">
			               <div class="badge bg-primary bg-gradient rounded-pill mb-2">${ animal.status }</div>
			               <a class="text-decoration-none link-dark stretched-link" href="./detail?num=${ animal.animalNumber }"><h5 class="card-title mb-3">${ animal.name }</h5></a>
			            </div>
			            <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
			              <div class="small">
	                    <div class="fw-bold">[${ animal.species }] ${ animal.breed }</div>
	                    <div class="text-muted">등록일: ${ animal.dateToString }</div>
	                  </div>
			            </div>
			          </div>
			        </div>
	    	
	    			</c:forEach>
	    		</c:when>
	    	</c:choose>
	    
	    </div>
	  </div>
	  
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>