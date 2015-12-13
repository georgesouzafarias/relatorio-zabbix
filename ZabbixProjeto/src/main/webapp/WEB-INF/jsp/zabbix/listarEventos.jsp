<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"></c:import>


<h1>Listagem de Eventos</h1>

	<table class="table table-stripped table-hover table-bordered">
		<thead>
			<tr>
				<th>Id do Evento</th>
				<th>Data do Evento</th>
				<th>Duracão do Evento</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaDeEventos}" var="evento">
				<tr>
					<td>${evento.idEvento}</td>
					<td>${evento.dataDoEventoConvertida}</td>
					<td>${evento.duracaoDoEvento}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>