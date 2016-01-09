<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"></c:import>


<h1>Listagem de Eventos</h1>

<form class="form-horizontal"
		action=" <c:url value='/removerhosts'/>" method="post">

	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Selecionar</th>				
				<th>Id Evento</th>
				<th>Nome do Grupo</th>
				<th>Nome do Host</th>
				<th>Trigger</th>
				<th>Data do Evento</th>
				<th>Duracão do Evento</th>	
			</tr>
		</thead>
		<tbody>
			<c:set var="index" value="${0}"></c:set>
			<c:forEach items="${listaDeEventos}" var="evento">
				<tr>
					<td><input type="checkbox" id="cbox1" name="index" value="${index}"></td>
					<td>${evento.idEvento}</td>				
					<td>${evento.nomeGrupo}</td>
					<td>${evento.nomeHost}</td>
					<td>${evento.triggerDescricao}</td>
					<td>${evento.dataDoEventoConvertida}</td>
					<td>${evento.duracaoDoEventoCompleta}</td>
				</tr>
				<c:set var="index" value="${index+1}"></c:set>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
				<input type="submit" value="Remover Selecionados"
				class="btn btn-primary btn-lg active">
				
				<input value="Gerar Relatório" class="btn btn-primary btn-lg active" onclick="document.location = '<c:url value='/gerarRelatorio'/>'"/>
				
				
		</div>
		
	
	
	</form>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>