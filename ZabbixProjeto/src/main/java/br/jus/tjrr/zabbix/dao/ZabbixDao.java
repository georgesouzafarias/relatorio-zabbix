package br.jus.tjrr.zabbix.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.enterprise.context.RequestScoped;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import br.jus.tjrr.zabbix.model.Evento;
import br.jus.tjrr.zabbix.model.FiltroEventos;
import br.jus.tjrr.zabbix.model.GrupoHost;
import br.jus.tjrr.zabbix.model.Host;
import br.jus.tjrr.zabbix.model.Trigger;
import br.jus.tjrr.zabbix.utils.DefaultZabbixApi;
import br.jus.tjrr.zabbix.utils.Request;
import br.jus.tjrr.zabbix.utils.RequestBuilder;
import br.jus.tjrr.zabbix.utils.Utilitarios;

public class ZabbixDao {

	//private final String url = "http://10.50.1.16/api_jsonrpc.php";
	private final String url = "http://200.222.41.3:1502/api_jsonrpc.php";

	// private final String user = "";
	// private final String senha = "";
	DefaultZabbixApi zabbixApi = new DefaultZabbixApi(url);

	public ZabbixDao() {
		this.zabbixApi.init();
		// this.zabbixApi.login(user, senha);
		this.zabbixApi.login();

	}

	@RequestScoped

	public ArrayList<GrupoHost> listGrupos() {
		ArrayList<GrupoHost> listaGrupos = new ArrayList<>();

		Request getRequest = RequestBuilder.newBuilder().method("hostgroup.get").paramEntry("monitored_hosts", true)
				.paramEntry("real_hosts", true).build();

		JSONObject getResponse = zabbixApi.call(getRequest);

		JSONArray resultado = getResponse.getJSONArray("result");

		for (int i = 0; i < resultado.size(); i++) {
			GrupoHost grupo = new GrupoHost();

			JSONObject item = (JSONObject) resultado.get(i);

			grupo.setNomeGrupo((String) item.get("name"));

			grupo.setIdGrupo((String) item.get("groupid"));
			listaGrupos.add(grupo);
		}

		return listaGrupos;

	}

	public ArrayList<Host> listHost(String groupid) {

		ArrayList<Host> listaHost = new ArrayList<>();

		Request getRequest = RequestBuilder.newBuilder().method("host.get").paramEntry("groupids", groupid)
				.paramEntry("monitored_hosts", true).build();

		JSONObject getResponse = zabbixApi.call(getRequest);

		JSONArray resultado = getResponse.getJSONArray("result");

		for (int i = 0; i < resultado.size(); i++) {
			Host host = new Host();
			JSONObject item = (JSONObject) resultado.get(i);

			host.setNomeHost((String) item.get("name"));
			host.setHostId((String) item.get("hostid"));
			host.setGrupoHost(groupid);
			listaHost.add(host);
		}
		
		return listaHost;

	}

	public ArrayList<Evento> listaEvento(FiltroEventos filtroEvento) {

		ArrayList<Evento> listaEventoFinal = new ArrayList<>();
		ArrayList<Evento>  listaEvento = new ArrayList<>();

		Request getRequest = RequestBuilder.newBuilder().method("event.get")
				.paramEntry("groupids", filtroEvento.getIdGrupo())
				.paramEntry("hostids", filtroEvento.getIdHost())
				.paramEntry("time_from", filtroEvento.getPeriodoInicialConvertido())
				.paramEntry("time_till", filtroEvento.getPeriodoFinalConvertido())
				.paramEntry("sortorder", "DESC")				
				.build();

		JSONObject getResponse = zabbixApi.call(getRequest);

		JSONArray resultado = getResponse.getJSONArray("result");

		for (int i = 0; i < resultado.size(); i++) {
			Evento evento = new Evento();
			JSONObject item = (JSONObject) resultado.get(i);
			
			evento.setIdEvento(item.getIntValue("eventid"));	
			evento.setDataEHoraDoEvento(item.getLong("clock"));	
			evento.setTriggerId(item.getString("objectid"));
			evento.setValue(item.getIntValue("value"));	
			
	
			listaEvento.add(evento);
		}
		
		Collections.sort(listaEvento);
		
		Utilitarios util = new Utilitarios();
		for ( Evento evento : listaEvento){
			for (Evento eventoSeguinte : listaEvento){
				if (evento.equals(eventoSeguinte)){
					eventoSeguinte.setDuracaoDoEvento(util.converteDataParaDateFormatESubtrai(evento.getDataEHoraDoEvento(), eventoSeguinte.getDataEHoraDoEvento()));			
				}
			}				
		}
		
		
		for ( Evento evento : listaEvento){
			if (evento.getValue() == 1) {
				System.out.println(listaEventoFinal.add(evento));
				
			}
		}
				
				
		zabbixApi.destory();
		return listaEventoFinal;

	}


	/*
	public void listaTrigger() {
		ArrayList<Trigger> listaTrigger = new ArrayList<>();
		
		
		
		Request getRequest = RequestBuilder.newBuilder().method("trigger.get")
				.paramEntry("triggerids", triggerId)				
				.build();
		JSONObject getResponse = zabbixApi.call(getRequest);
		JSONArray resultado = getResponse.getJSONArray("result");	
		
		for (int i = 0; i < resultado.size(); i++) {			
			JSONObject item = (JSONObject) resultado.get(i);
			System.out.println(item.getString("triggerid"));			
			Utilitarios util = new Utilitarios();
			System.out.println(util.converteDataParaDateFormat(item.getLong("lastchange")));					
			System.out.println(item.getString("description"));
			System.out.println(item.getString("value"));
			System.out.println();
			System.out.println();
			
			
			
		}
		
	} */
	
}
