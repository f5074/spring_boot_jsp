<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Drawing Design</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="/static/assets/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons_2.0.1  -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/static/assets/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="/static/assets/css/_all-skins.min.css">
<!-- F5074 Common style -->
<link rel="stylesheet" href="/static/assets/css/style.css">

<!-- JQuery 2.1.4 -->
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/static/assets/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/static/assets/js/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/assets/js/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/assets/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/static/assets/js/demo.js"></script>

<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a href="/index" class="navbar-brand">
					<b>Drawing</b> Design
				</a>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="collapse navbar-collapse pull-left" id="navbar-collapse">


				<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">등록관리<span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="drawing/user/drawingPage">도면 등록</a></li>
									<li><a href="drawing/user/iconPage">Icon 등록</a></li>
									<li><a href="drawing/user/equipmentPage">장비 등록</a></li>
								</ul></li>
					<li><a href="drawing/user/managementPage">도면-장비 관리</a></li>
					<li><a href="drawing/user/uploadFilePage">파일 관리</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>