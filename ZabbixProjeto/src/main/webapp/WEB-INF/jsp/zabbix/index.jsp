<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/header.jsp"></c:import>
		

			<div class="center-block">
				<form class="form-horizontal"
					action=" <c:url value='/zabbix/filtrarEventos'/>" method="post">

					<div class="form-group">
						<label for="grupo" class="text-left"> Selecione um Grupo</label>
						<div>
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
							<select class=".selectpicker" id="host"
								name="filtroEventos.idHost"></select>
						</div>
					</div>


					<div class="form-group">
						<div>

							<label for="host"> Selecione o Periodo Inicial</label><br /> <input
								type="text" id="calendario_inicial"
								name="filtroEventos.periodoInicial"
								data-date-format="dd/mm/yyyy" />

						</div>

						<br>

						<div>

							<label for="host"> Selecione o Periodo Final</label> <br /> <input
								type="text" id="calendario_final"
								name="filtroEventos.periodoFinal" data-date-format="dd/mm/yyyy" />

						</div>
					</div>
					<br>
					<div class="form-group">
						<div>
							<label for="grupo" class="text-left"> Selecione a
								Serveridade Mínima</label>
						</div>
						<div>
							<select class=".selectpicker" id="host"
								name="filtroEventos.severidadeMinima">
								<option>Selecione</option>
								<option value=1>Informação</option>
								<option value=2>Atenção</option>
								<option value=3>Média</option>
								<option value=4>Alta</option>
								<option value=5>Desastre</option>
							</select>
						</div>
					</div>
					<br />
					<div class="form-group">
						<div>
							<label for="grupo" class="text-left">Informe a duração
								minima do Evento em Minutos</label>
						</div>
						<div>
							<input type="number" name="filtroEventos.duracaoMinima"><br>
						</div>
					</div>
					<br>
					<div>
						<input type="submit" value="Buscar Eventos"
							class="btn btn-primary btn-lg active">
					</div>


				</form>

			</div> <script>
				$(function() {
					$("#calendario_inicial").datepicker()
				});
			</script> <script>
				$(function() {
					$("#calendario_final").datepicker()
				});
			</script> <script>
				$('#idgrupo')
						.on(
								"change",
								function() {
									var id = document.getElementById("idgrupo").value;
									var uri = "http://www.casa.com.br:8080/zabbixprojeto/host?grupoid=";
									//var uri = "http://zabbix.tjrr.jus.br:8080/zabbixprojeto/host?grupoid=";
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
			</script> <c:forEach items="${errors}" var="erro">
	${erro.category} - ${erro.message} <br>

			</c:forEach>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>