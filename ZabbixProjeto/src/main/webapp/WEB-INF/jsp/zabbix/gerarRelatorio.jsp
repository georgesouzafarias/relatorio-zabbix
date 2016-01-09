<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<c:import url="/WEB-INF/jsp/header.jsp"></c:import>



<h1>Listagem de Eventos</h1>



<display:table name="${listaDeEventos}" class="table table-striped table-hover" export="true" requestURI="/gerarRelatorio">
	<display:column property="idEvento" title="ID do Evento" />
	<display:column property="nomeGrupo" title="Nome do Grupo"/>
	<display:column property="nomeHost" title="Nome do Host" />
	<display:column property="triggerDescricao" title="Trigger" />	
	<display:column property="dataDoEventoConvertida" title="Data do Evento" />
	<display:column property="duracaoDoEventoEmMinutos" title="Duracao do Envento" />	
	<display:setProperty name="export.excel.filename" value="zabbix.xls" />
	<display:setProperty name="export.pdf" value="false" />
	<display:setProperty name="export.csv.filename" value="zabbix.csv" />
	<display:setProperty name="export.csv" value="true" />	
	<display:setProperty name="export.xml" value="false" />	
</display:table>



<div></div>

<c:import url="/WEB-INF/jsp/footer.jsp"></c:import>