<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/templates/header.jsp" />
<jsp:include page="/WEB-INF/views/templates/footer.jsp" />

<script src="/static/assets/js/drawing/drawing_common.js" ></script>
<script src="/static/assets/js/drawing/drawing_tootip.js" ></script>

<script>
	$(document).ready(function() {
		selectIconList();
	});

	$(document).ready(function() {
		$("#frm").submit(function(e) {
			var form = $('#frm')[0];
			// FormData 객체 생성
			var formData = new FormData(form);
			// 코드로 동적으로 데이터 추가 가능.
			e.preventDefault();
			$.ajax({
				method : "POST",
				enctype : 'multipart/form-data',
				url : "insertIcon",
				data : formData,
				processData : false,
				contentType : false,
				cache : false,
				timeout : 600000,
				success : function(result) {
					$("#modalContent").html("저장을 성공했습니다.");
					$("#modal").modal("show");
					$("#iconNm").val("");
					$("#iconContent").val("");
					$("#uploadFile").val("");
					$("#prieviewImg").remove();
					selectIconList();
				}
			})
		});
	});
</script>

<body class="hold-transition skin-red layout-top-nav">
	<div class="wrapper">
		<div class="content-wrapper">
			<div class="container">
				<!-- Content Header -->
				<!-- <section class="content-header"></section> -->
				<!-- .Content Header -->
				<!-- Content Body-->
				<section class="content">
					<!-- Content Row -->
					<div class="row">
						<form enctype="multipart/form-data" method="post" action="#" name="frm" id="frm">
							<!-- Content -->
							<div class="col-md-12">
								<div class="box box-danger">
									<div class="box-header with-border">
										<h3 class="box-title">Icon 등록</h3>
										<div class="box-tools pull-right">
											<input type="submit" class="btn btn-success" value="등록" />
										</div>
									</div>
									<div class="box-body" style="height: 400px;">
										<div class="table-responsive" style="width:100%; height:100%; overflow:auto">
											<div>
												<div class="f5074-layout-left">
													<table class="table no-margin">
														<thead>
															<tr>
																<td><p>Icon 명</p></td>
																<td><input type="text" id="iconNm" name="iconNm" style="width: 100%; border: none;" placeholder="Icon 명" required></td>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td><p>Icon 내용</p></td>
																<td><input type="text" id="iconContent" name="iconContent" style="width: 100%; border: none;" placeholder="Icon 내용" required></td>
															</tr>
															<tr>
																<td><p>Icon 파일</p></td>
																<td><input type="file" id="uploadFile" name="uploadFile" placeholder="Icon 파일(.png)" onchange="previewImage(event);" required></td>
															</tr>
														</tbody>
													</table>
												</div>
												<div class="f5074-layout-right">
													<h5>&#60;Icon파일 미리보기&#62;</h5>
													<div id="image_container" style="width: 300px; height: 300px;"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- .Content -->
						</form>
					</div>
					<!-- .Content Row -->

					<!-- Content Row -->
					<div class="row">
						<!-- Content -->
						<div class="col-md-12">
							<div class="box box-danger">
								<div class="box-header with-border">
									<h3 class="box-title">Icon List</h3>
									<div class="box-tools pull-right">
										<input type="button" class="btn btn-danger" onclick="selectIconList();" value="조회">
									</div>
								</div>
								<div class="box-body" style="height: 200px;">
									<div id="iconView" class="table-responsive" style="width:100%; height:100%; overflow:auto"></div>
								</div>
							</div>
						</div>
						<!-- .Content -->
					</div>
					<!-- .Content Row -->
				</section>
				<!-- Content Body-->
			</div>
		</div>
	</div>
</body>