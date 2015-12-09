<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"></c:import>



<div class="bg-success center-block">
	<form class="form-horizontal"
		action=" <c:url value='/zabbix/listarEventos'/>" method="post">

		<div class="form-group">
			<label for="grupo" class="text-left"> Selecione um Grupo</label>

			<div class="col-sm-10">

				<select id="idgrupo" class=".selectpicker"
					name="filtroEventos.idGrupo">
					<c:forEach items="${grupoLista}" var="grupo">
						<option value="${grupo.idGrupo}">${grupo.nomeGrupo}</option>
						<br />
					</c:forEach>

				</select>

			</div>
		</div>

		<br />

		<div class="form-group">
			<label for="host" class="text-left"> Selecione o Host</label> <br />

			<div class="col-sm-10">
				<select class=".selectpicker" id="host" name="filtroEventos.idHost"></select>
			</div>
		</div>


		<div>

			<label for="host"> Selecione o Periodo Inicial</label><br /> <input
				type="text" id="calendario_inicial"
				name="filtroEventos.periodoInicial" data-date-format="dd/mm/yyyy"/>

		</div>


		<div>

			<label for="host"> Selecione o Periodo Final</label> <br /> <input
				type="text" id="calendario_final" name="filtroEventos.periodoFinal"  data-date-format="dd/mm/yyyy"/>

		</div>
		<br />
		<div>
			<input type="submit" value="Buscar Eventos"
				class="btn btn-primary btn-lg active">
		</div>


	</form>

</div>



<script>
	$(function() {
		$("#calendario_inicial").datepicker() });
</script>




<script>
	$(function() {
		$("#calendario_final").datepicker()	});
</script>



<script>
	$('#idgrupo')
			.on(
					"change",
					function() {
						var id = document.getElementById("idgrupo").value;
						var uri = "http://www.casa.com.br:8080/zabbixprojeto/host?grupoid=";
						var url = uri.concat(id);
						var appenddata = '<option>Selecione o Host</option>';
						$
								.ajax({
									url : url,
									dataType : "json",
									success : function(retorno) {
										$
												.each(
														retorno.list,
														function() {
															var host = this;
															appenddata += "<option value=\"" + host.hostId + "\">"
																	+ host.nomeHost
																	+ " </option>";
														});
										$('#host').html(appenddata);
									}
								});
					});
</script>


<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>