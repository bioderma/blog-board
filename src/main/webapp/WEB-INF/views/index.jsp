<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="search-bar.css">
<style>
	.search-form {
		width: 80%;
		margin: 0 auto;
		margin-top: 1rem;
	}

	.search-form input {
		height: 100%;
		background: transparent;
		border: 0;
		display: block;
		width: 100%;
		padding: 1rem;
		height: 100%;
		font-size: 1rem;
	}

	.search-form select {
		background: transparent;
		border: 0;
		padding: 1rem;
		height: 100%;
		font-size: 1rem;
	}

	.search-form select:focus {
		border: 0;
	}

	.search-form button {
		height: 100%;
		width: 100%;
		font-size: 1rem;
	}

	.search-form button svg {
		width: 24px;
		height: 24px;
	}

	.search-body {
		margin-bottom: 1.5rem;
	}

	.search-body .search-filters .filter-list {
		margin-bottom: 1.3rem;
	}

	.search-body .search-filters .filter-list .title {
		color: #3c4142;
		margin-bottom: 1rem;
	}

	.search-body .search-filters .filter-list .filter-text {
		color: #727686;
	}

	.search-body .search-result .result-header {
		margin-bottom: 2rem;
	}

	.search-body .search-result .result-header .records {
		color: #3c4142;
	}

	.search-body .search-result .result-header .result-actions {
		text-align: right;
		display: flex;
		align-items: center;
		justify-content: space-between;
	}

	.search-body .search-result .result-header .result-actions .result-sorting {
		display: flex;
		align-items: center;
	}

	.search-body .search-result .result-header .result-actions .result-sorting span {
		flex-shrink: 0;
		font-size: 0.8125rem;
	}

	.search-body .search-result .result-header .result-actions .result-sorting select {
		color: #68CBD7;
	}

	.search-body .search-result .result-header .result-actions .result-sorting select option {
		color: #3c4142;
	}

	@media (min-width: 768px) and (max-width: 991.98px) {
		.search-body .search-filters {
			display: flex;
		}
		.search-body .search-filters .filter-list {
			margin-right: 1rem;
		}
	}

	.card-margin {
		margin-bottom: 1.875rem;
	}

	@media (min-width: 992px){
		.col-lg-2 {
			flex: 0 0 16.66667%;
			max-width: 16.66667%;
		}
	}

	.card-margin {
		margin-bottom: 1.875rem;
	}
	.card {
		border: 0;
		box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
		-webkit-box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
		-moz-box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
		-ms-box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
	}
	.card {
		position: relative;
		display: flex;
		flex-direction: column;
		min-width: 0;
		word-wrap: break-word;
		background-color: #ffffff;
		background-clip: border-box;
		border: 1px solid #e6e4e9;
		border-radius: 8px;
	}

</style>
<main class="container" style ="width: 1000px">
	<div class="row">
		<div class="col-lg-12 card-margin">
			<div class="card search-form">
				<div class="card-body p-0">
					<form action="/" method="get">
						<div class="row">
							<div class="col-12">
								<div class="row no-gutters">
									<div class="col-lg-3 col-md-3 col-sm-12 p-0">
										<label for="search-type" hidden>검색유형</label>
										<select class="form-control" id="search-type" name="searchType">
											<option>제목</option>
										</select>
									</div>
									<div class="col-lg-8 col-md-6 col-sm-12 p-0">
										<input type="text" placeholder="Search..." class="form-control" id="search-value"
											   name="searchValue">
									</div>
									<div class="col-lg-1 col-md-3 col-sm-12 p-0">
										<button type="submit" class="btn btn-base">
											<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
												 viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
												 stroke-linecap="round" stroke-linejoin="round"
												 class="feather feather-search">
												<circle cx="11" cy="11" r="8"></circle>
												<line x1="21" y1="21" x2="16.65" y2="16.65"></line>
											</svg>
										</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div style="margin: 20px 20px"></div>


<div class="container">
	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2" >
			<div class="card-body">
				<h4 class="card-title" style="font-size: 20px">${board.title}</h4>

				<a href="/board/${board.id}" class="btn btn-primary" style="font-size: 13px">상세보기</a>
			</div>
		</div>
	</c:forEach>
</div>

		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${boards.first}">
					<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
				</c:otherwise>
			</c:choose>

			<c:forEach var="i" begin="1" end="${boards.totalPages}">
				<li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
			</c:forEach>

			<c:choose>
				<c:when test="${boards.last}">
					<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
<%@ include file="layout/footer.jsp"%>
