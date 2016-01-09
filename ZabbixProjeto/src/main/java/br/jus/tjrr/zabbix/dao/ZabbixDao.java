package br.jus.tjrr.zabbix.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	// private final String url = "http://zabbix.tjrr.jus.br/api_jsonrpc.php";
	private final String url = "http://200.222.41.3:1502/api_jsonrpc.php";

	// private final String user = "";
	// private final String senha = "";
	DefaultZabbixApi zabbixApi = new DefaultZabbixApi(url);

	private ArrayList<Evento> listaEvento;

	public ZabbixDao() {
		zabbixApi.init();
		// zabbixApi.login(user, senha);
		zabbixApi.login();
	}

	public ArrayList<GrupoHost> listGrupos() {
		ArrayList<GrupoHost> listaGrupos = new ArrayList<>();
		;

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

	public ArrayList<Trigger> listaTrigger(String hostId) {
		ArrayList<Trigger> listaTrigger = new ArrayList<>();

		Request getRequest = RequestBuilder.newBuilder().method("trigger.get").paramEntry("hostids", hostId)
				// .paramEntry("min_severity", 3)
				.build();

		JSONObject getResponse = zabbixApi.call(getRequest);
		JSONArray resultado = getResponse.getJSONArray("result");

		for (int i = 0; i < resultado.size(); i++) {
			JSONObject item = (JSONObject) resultado.get(i);
			Trigger trigger = new Trigger();
			trigger.setTriggerid(item.getString("triggerid"));
			trigger.setDescription(item.getString("description"));
			trigger.setPrioridade(item.getInteger("priority"));

			listaTrigger.add(trigger);

		}
		return listaTrigger;

	}

	public ArrayList<Evento> listaEvento(FiltroEventos filtroEvento) {

		ArrayList<Evento> eventos = new ArrayList<>();
		listaEvento = new ArrayList<Evento>();

		String idGrupo = filtroEvento.getIdGrupo();
		String nomeGrupo = getNomeGrupo(filtroEvento.getIdGrupo());

		String idHost = filtroEvento.getIdHost();
		String nomeHost = getNomeHost(filtroEvento.getIdHost());

		ArrayList<Trigger> listaTrigger = new ArrayList<>();
		listaTrigger = listaTrigger(idHost);

		List<String> listaEventoId = new ArrayList<>();
		for (Trigger trigger : listaTrigger) {
			listaEventoId.add(trigger.getTriggerid());
		}
		// Cria um vertor com os filtros necessarios
		String sortfield[] = { "clock", "eventid" };
		Request getRequest = RequestBuilder.newBuilder().method("event.get")
				.paramEntry("hostids", filtroEvento.getIdHost()).paramEntry("obejectid", listaEventoId)
				.paramEntry("time_from", filtroEvento.getPeriodoInicialConvertido())
				.paramEntry("time_till", filtroEvento.getPeriodoFinalConvertido())
				.paramEntry("output", "eventid, obcjectid").paramEntry("sortfield", sortfield)
				.paramEntry("sortorder", "DESC").build();

		JSONObject getResponse = zabbixApi.call(getRequest);
		JSONArray resultado = getResponse.getJSONArray("result");

		// Cria um vetor com todos os eventosid recebidos
		ArrayList<String> eventoid = new ArrayList<>();

		for (int i = 0; i < resultado.size(); i++) {
			JSONObject item = (JSONObject) resultado.get(i);
			eventoid.add(item.getString("eventid"));
		}

		getRequest = RequestBuilder.newBuilder().method("event.get").paramEntry("eventids", eventoid)
				.paramEntry("sortfield", sortfield).paramEntry("sortorder", "DESC").build();

		getResponse = zabbixApi.call(getRequest);
		resultado = getResponse.getJSONArray("result");

		for (int i = 0; i < resultado.size(); i++) {
			Evento evento = new Evento();
			JSONObject item = (JSONObject) resultado.get(i);

			evento.setIdEvento(item.getIntValue("eventid"));
			evento.setDataEHoraDoEvento(item.getLong("clock"));
			evento.setTriggerId(item.getString("objectid"));
			evento.setValue(item.getIntValue("value"));
			evento.setIdGrupo(idGrupo);
			evento.setIdHost(idHost);
			evento.setNomeGrupo(nomeGrupo);
			evento.setNomeHost(nomeHost);

			eventos.add(evento);
		}

		for (Evento evento : eventos) {
			for (Trigger trigger : listaTrigger)
				if (evento.getTriggerId().equals(trigger.getTriggerid())) {					
					evento.setTriggerDescricao(trigger.getDescription().replaceAll("\\{HOSTNAME\\}", evento.getNomeHost()));
					evento.setTriggerPrioridade(trigger.getPrioridade());
				}
		}

		// Collections.sort(eventos);

		Utilitarios util = new Utilitarios();

		for (Evento evento : eventos) {
			for (Evento eventoSeguinte : eventos) {
				if (evento.equals(eventoSeguinte)) {
					// Analisar
					eventoSeguinte.setDuracaoDoEventoCompleta(util.converteDataParaDateFormatESubtrai(
							evento.getDataEHoraDoEvento(), eventoSeguinte.getDataEHoraDoEvento()));
					eventoSeguinte.setDuracaoDoEventoEmMinutos(util.converteDataParaDateFormatEmMinutosESubtrai(
							evento.getDataEHoraDoEvento(), eventoSeguinte.getDataEHoraDoEvento()));
					
				}
			}
		}

		// Faz todos os Filtros Necessários
		for (Evento evento : eventos) {
			if (evento.getValue() == 1) {
				try {
					if ((evento.getDuracaoDoEventoCompleta().compareTo(filtroEvento.getDuracaoMinimaConvertida()) > 0)
							&& (evento.getTriggerPrioridade() >= filtroEvento.getPrioridadeMinima())) {
						this.getListaEvento().add(evento);
					}
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}

			}
		}

		// this.zabbixApi.destory();
		return this.getListaEvento();

	}

	public String getNomeGrupo(String idGrupo) {

		Request getRequest = RequestBuilder.newBuilder().method("hostgroup.get").paramEntry("groupids", idGrupo)
				.build();

		JSONObject getResponse = zabbixApi.call(getRequest);

		JSONArray resultado = getResponse.getJSONArray("result");

		JSONObject item = (JSONObject) resultado.get(0);
		return item.getString(("name"));

	}

	public String getNomeHost(String idHost) {

		Request getRequest = RequestBuilder.newBuilder().method("host.get").paramEntry("hostids", idHost).build();

		JSONObject getResponse = zabbixApi.call(getRequest);

		JSONArray resultado = getResponse.getJSONArray("result");

		JSONObject item = (JSONObject) resultado.get(0);
		return item.getString(("host"));

	}

	public ArrayList<Evento> removeEventosSelecionados(String[] index) {
		for (int i = 0, x = 0; i < index.length; i++) {
			int j = Integer.parseInt(index[i]);
			this.getListaEvento().remove(j - x);
			x++;
		}

		return this.getListaEvento();

	}

	public ArrayList<Evento> getListaEvento() {
		return listaEvento;
	}

}
