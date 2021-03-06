<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/templates/header.jsp" />
<jsp:include page="/WEB-INF/views/templates/footer.jsp" />

<script src="/static/assets/js/drawing/drawing_common.js?ver=20210211616" ></script>
<script src="/static/assets/js/drawing/drawing_tootip.js" ></script>
<script src="/static/assets/js/drawing/drawing_file_upload.js?ver202102181340" ></script>

<script>
	$(document).ready(function() {
		selectFileList('C:\\DEV\\Downloads\\');
        $('#btnDownload').hide();
		$('#fileDir').val('C:\\DEV\\Downloads\\');
		$('#fileDownloadDir').val('C:\\DEV\\Downloads\\');

		$('#btnUpload').click(function(event){
			onClickUpload(event);
		});

		$('#btnDownload').click(function(event){
			onClickDownload(event);
		});

		$('#btnLocalDownload').click(function(event){
			onClickLocalDownload(event);
		});

		$('#btnSelectFileList').click(function(event){
			onClickSelectFileList(event);
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
										<h3 class="box-title">File Upload</h3>
										<div class="box-tools pull-right">
											<input type="button" id="btnUpload" name="btnUpload" class="btn btn-success" value="Upload" />
										</div>
									</div>
									<div class="box-body" style="height: 150px;">
										<div class="table-responsive" style="width:100%; height:100%; overflow:auto">
											<div>
												<table class="table no-margin">
													<tr>
														<td><p>경로</p></td>
														<td><input type="text" id="fileDir" name="fileDir" style="width: 100%; border: none;" placeholder="파일경로" required></td>
													</tr>
													<tr>
														<td><p>파일</p></td>
														<td><input multiple="multiple" type="file" id="file" name="file" placeholder="도면 파일(.png)" required></td>
													</tr>
												</table>
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
									<h3 class="box-title">File Download</h3>
									<div class="box-tools pull-right">
										<input type="button" id="btnDownload" name="btnDownload" class="btn btn-danger" value="다운로드">
										<input type="button" id="btnLocalDownload" name="btnLocalDownload" class="btn btn-danger" value="Download">
										<input type="button" id="btnSelectFileList" name="btnSelectFileList" class="btn btn-danger" value="FileList">
									</div>
								</div>
								<div class="box-body" style="height: 450px;">
									<div>
										<div>
											<table class="table no-margin">
												<tr>
													<td><p>경로</p></td>
													<td><input type="text" id="fileDownloadDir" name="fileDownloadDir" style="width: 100%; border: none;" placeholder="파일경로" required></td>
												</tr>
												<tr>
													<td><p>파일명</p></td>
													<td><input type="text" id="fileNm" name="fileNm" style="width: 100%; border: none;" placeholder="파일명" required></td>
												</tr>
											</table>
										</div>
										<div>
                                            <table class="table no-margin">
                                                <thead><tr><th style='text-align:left'>File List</th></tr></thead>
                                            </table>
                                            <table class="table no-margin">
                                                <tr>
                                                    <div id="fileView" class="table-responsive" style="width:100%; height:65%; overflow:auto">
                                                </tr>
                                            </table>
										</div>
									</div>
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