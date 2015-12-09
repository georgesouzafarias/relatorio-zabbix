package br.jus.tjrr.zabbix.dao;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import br.jus.tjrr.zabbix.model.Evento;
import br.jus.tjrr.zabbix.model.FiltroEventos;
import br.jus.tjrr.zabbix.model.GrupoHost;
import br.jus.tjrr.zabbix.model.Host;
import br.jus.tjrr.zabbix.utils.DefaultZabbixApi;
import br.jus.tjrr.zabbix.utils.Request;
import br.jus.tjrr.zabbix.utils.RequestBuilder;

public class ZabbixDao {

	// private final String url = "http://10.50.1.16/api_jsonrpc.php";
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

		//zabbixApi.destory();
		return listaHost;

	}

	public ArrayList<Evento> listaEvento(FiltroEventos filtroEvento) {

		ArrayList<Evento> listaEvento = new ArrayList<>();

		Request getRequest = RequestBuilder.newBuilder().method("event.get").paramEntry("groupids", filtroEvento.getIdGrupo()).paramEntry("hostids", filtroEvento.getIdHost())
				.paramEntry("time_from", filtroEvento.getPeriodoInicialConvertido()).paramEntry("time_till", filtroEvento.getPeriodoFinalConvertido()).paramEntry("value", 1).build();

		JSONObject getResponse = zabbixApi.call(getRequest);

		JSONArray resultado = getResponse.getJSONArray("result");

		for (int i = 0; i < resultado.size(); i++) {
			Evento evento = new Evento();
			JSONObject item = (JSONObject) resultado.get(i);
			
			evento.setIdEvento(item.getIntValue("eventid"));
			evento.setDataEvento(item.getTimestamp("clock"));
			evento.setDuracaoEvento(item.getIntValue("ns"));		
			
			//evento.setHostId((String) item.get("hostid"));
			//evento.setGrupoHost(groupid);

			listaEvento.add(evento);
		}

		zabbixApi.destory();
		return listaEvento;

	}

}
