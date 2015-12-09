<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Relatório Zabbix</title>

<script src="<c:url value='/js/jquery.js'/>"></script>
<script src="<c:url value='/js/bootstrap-datepicker.js'/>"></script>
<link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />

</head>
<body>
	<nav>
		<ul class="nav nav-tabs">
			<li><a href="${linkto[ZabbixController].index()}">Home</a></li>
		</ul>

	</nav>
	<div class="container thumbnail jumbotron bg-success">
		<main class="col-sm-8 thumbnail text-center ">
	
		
		 <!--  Conteudo -->