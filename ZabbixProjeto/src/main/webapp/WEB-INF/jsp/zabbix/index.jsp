<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml"  
    xmlns:h="http://java.sun.com/jsf/html"  
    xmlns:f="http://java.sun.com/jsf/core"  
    xmlns:p="http://primefaces.org/ui">

<h:head>
	<title>Relatorio Zabbix</title>
</h:head>


<h:body>
 <h1> FOOOOIII</h1>

	<!-- 
	<form action=" <c:url value='/produto/adiciona'/>" method="post">


		<select>
			<c:forEach items="${grupoLista}" var="grupo">

				<option value="${grupo}">${grupo}</option>
				<br />
			</c:forEach>

			<select>
				<c:forEach items="${hostLista}" var="host">

					<option value="${host}">${host}</ option>
					<br />
				</c:forEach>
		</select> 


			<input type=>
			<input type="submit" value="adicionar">
	</form>
	
	-->

	<p:fieldset legend="objetos">
		<p:panelGrid columns="2">
			<h:outputLabel value="Nome do Grupo"></h:outputLabel>
			<c:forEach items="${grupoLista}" var="grupo">
				<p:selectOneListbox id="basic" value="${grupo}">
					<f:selectItem itemLabel="Option 1" itemValue="1" />
					<f:selectItem itemLabel="Option 2" itemValue="2" />
					<f:selectItem itemLabel="Option 3" itemValue="3" />

				</p:selectOneListbox>
			</c:forEach>

			<h:outputLabel value="Nome do Host"></h:outputLabel>

		</p:panelGrid>

	</p:fieldset>




</h:body>
</html>