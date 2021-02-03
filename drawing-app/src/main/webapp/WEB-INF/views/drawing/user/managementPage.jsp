<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/templates/header.jsp" />
<jsp:include page="/WEB-INF/views/templates/footer.jsp" />

<script src="/static/assets/js/drawing/drawing_common.js" ></script>
<script src="/static/assets/js/drawing/drawing_tootip.js" ></script>

<script>
	$(document).ready(function() {
		selectDrawingList(1);
	})
</script>
<script>
	function updateEquipment(){
		var myTableArray = [];


		$("#equipmentView tr").each(function() {
			var arrayOfThisRow = [];
			var tableData = $(this).find('td');
			if (tableData.length > 0) {
				tableData.each(function() {
					arrayOfThisRow.push($(this).text());
				});
				myTableArray.push(arrayOfThisRow);
			}
		});

		for (var rowIdx = 0; rowIdx < myTableArray.length; rowIdx++) {
			$.ajax({
				url : "updateEquipment",
				method : "POST",
				data : {
					eqpX : myTableArray[rowIdx][7],
					eqpY : myTableArray[rowIdx][8],
					eqpId : myTableArray[rowIdx][2]
				},
				success : function(result) {
				}
			});
			$("#modalContent").html("등록한 설비를 모두 저장 했습니다.");
			$("#modal").modal("show");
		}

	};
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
					<div class="row">
						<!-- Content -->
						<div class="col-md-8">
							<div class="box box-danger">
								<div class="box-header with-border">
									<h3 class="box-title">도면 디자인</h3>
									<div class="box-tools pull-right">
										<input type="button" class="btn btn-danger" onclick="showTooltip();" value="On" />
										<input type="button" class="btn btn-secondary" onclick="hideTooltip();" value="Off" />
									</div>
								</div>
								<div class="box-body" style="height: 500px;">
									<div id="image_container">
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="box box-danger">
								<div class="box-header with-border">
									<h3 class="box-title">Icon List</h3>
									<div class="box-tools pull-right">
									</div>
								</div>
								<div class="box-body" style="height: 200px;">
									<div id="equipmentIconView" class="table-responsive" style="width:100%; height:100%; overflow:auto">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="box box-danger">
								<div class="box-header with-border">
									<h3 class="box-title">도면 List</h3>
									<div class="box-tools pull-right">
										<input type="button" class="btn btn-danger" onclick="selectDrawingList(1);" value="조회">
									</div>
								</div>
								<div class="box-body" style="height: 200px;">
									<div id="drawingView" class="table-responsive" style="width:100%; height:100%; overflow:auto"></div>
								</div>
							</div>
						</div>
						<!-- Content -->
						<div class="col-md-8">
							<div class="box box-danger">
								<div class="box-header with-border">
									<h3 class="box-title">장비 List</h3>
									<div class="box-tools pull-right">
										<input type="button" class="btn btn-success" onclick="updateEquipment();" value="저장">
									</div>
								</div>
								<div class="box-body" style="height: 200px;">
									<div id="equipmentView" class="table-responsive" style="width:100%; height:100%; overflow:auto"></div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- Content Body-->
			</div>
		</div>
	</div>
</body>
