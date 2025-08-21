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
		<header class="bg-dark py-5">
      <div class="container px-5">
        <div class="row gx-5 align-items-center justify-content-center">
          <div class="col-6">
            <div class="my-5">
              <h1 class="display-5 fw-bolder text-white mb-2">Introduction to an Animal Shelter for Stray Animals</h1>
              <p class="lead fw-normal text-white-50 mb-4">Welcome to our animal shelter, a safe haven for stray and abandoned animals. We provide food, medical care, and loving attention while working to find them forever homes. Join us in giving these animals a second chance at life.</p>
              <div class="gap-3 d-flex justify-content-start">
              	<c:if test="${ empty logined }">
	                <a class="btn btn-primary btn-lg px-4 me-sm-3" href="/account/join">Register</a>
              	</c:if>
                <a class="btn btn-outline-light btn-lg px-4" href="/animal/list">Search Animals</a>
              </div>
            </div>
          </div>
          <div class="col-6 text-center"><img class="img-fluid rounded-3 my-5" src="/images/home/homeImg.jpg" alt="Home Image" /></div>
        </div>
      </div>
    </header>
    
    <section class="py-5" id="features">
      <div class="container px-5 my-5">
        <div class="row gx-5">
          <div class="col-lg-4 mb-5 mb-lg-0"><h2 class="fw-bolder mb-0">A better way to protect animals.</h2></div>
          <div class="col-lg-8">
            <div class="row gx-5 row-cols-1 row-cols-md-2">
              <div class="col mb-5 h-100">
                <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-collection"></i></div>
                <h2 class="h5">Safe Environment</h2>
                <p class="mb-0">The shelter provides a safe and clean place where abandoned and stray animals are protected from danger and harsh conditions.</p>
              </div>
              <div class="col mb-5 h-100">
                <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-building"></i></div>
                <h2 class="h5">Medical Care</h2>
                <p class="mb-0">Animals receive necessary vaccinations, treatments, and regular check-ups to ensure they stay healthy and recover from any illnesses or injuries.</p>
              </div>
              <div class="col mb-5 mb-md-0 h-100">
                <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-toggles2"></i></div>
                <h2 class="h5">Adoption Opportunities</h2>
                <p class="mb-0">The shelter works to find caring, permanent homes for animals, giving them a second chance at a happy and loving life.</p>
              </div>
              <div class="col h-100">
                <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-toggles2"></i></div>
                <h2 class="h5">Education and Awareness</h2>
                <p class="mb-0">Shelters help educate the community about animal welfare, the importance of spaying/neutering, and how to be a responsible pet owner.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
		
		<div class="py-5 bg-light">
      <div class="container px-5 my-5">
        <div class="row gx-5 justify-content-center">
          <div class="col-lg-10 col-xl-7">
            <div class="text-center">
              <div class="fs-4 mb-4 fst-italic">"Every animal deserves love and compassion — not because they are flawless, but because they feel fear, pain, and joy just like we do. Giving them a second chance is not just saving a life; it's reminding ourselves what kindness truly means."</div>
              <div class="d-flex align-items-center justify-content-center">
                <img class="rounded-circle me-3" width="40" height="40" src="/images/home/homeMan.jpg" alt="..." />
                <div class="fw-bold">
                  Emma Hart
                  <span class="fw-bold text-primary mx-1">/</span>
                  Director of Shelter
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
	
	</main>
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</body>

</html>