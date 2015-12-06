<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"></c:import>

<!-- <script src="<c:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='js/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='js/bootstrap.js'/>"></script>
 -->

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>


<form action=" <c:url value='/produto/adiciona'/>" method="post">


	<label for="grupo" class="text-center"> Selecione um Grupo</label>


	<div>


		<select id="idgrupo" class=".selectpicker">
			<c:forEach items="${grupoLista}" var="grupo">
				<option value="${grupo.idGrupo}">${grupo.nomeGrupo}</option>
				<br />
			</c:forEach>

		</select>

	</div>

	<div>
		<select class=".selectpicker" id="host"></select>
	</div>

	<div>
		<input type="submit" value="adicionar">
	</div>


</form>

<h1 id="texto"></h1>



<script>
	$('#idgrupo').on("change", function() {
		var id = document.getElementById("idgrupo").value;
		var uri = "http://www.casa.com.br:8080/zabbixprojeto/host?grupoid=";
		var url = uri.concat(id);
		var appenddata = '<option>Selecione o Host</option>';
		$.ajax({
			url : url,
			dataType : "json",
			success : function(retorno) {
				$.each(retorno.list, function() {
					var host = this;					
					appenddata += "<option value=\"" + host.hostId + "\">"	+ host.nomeHost + " </option>";
				});
				$('#host').html(appenddata);}
		});
	});
</script>




<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>