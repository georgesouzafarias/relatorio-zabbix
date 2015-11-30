package br.jus.tjrr.zabbix.dao;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import br.jus.tjrr.zabbix.model.GrupoHost;
import br.jus.tjrr.zabbix.utils.DefaultZabbixApi;
import br.jus.tjrr.zabbix.utils.Request;
import br.jus.tjrr.zabbix.utils.RequestBuilder;

public class ZabbixDao {

	// final String url = "http://10.50.1.16/api_jsonrpc.php";
	private final String url = "http://200.222.41.3:1502/api_jsonrpc.php";

	private final String user = "";
	private final String senha = "";
	DefaultZabbixApi zabbixApi = new DefaultZabbixApi(url);

	public ZabbixDao() {	
		this.zabbixApi.init();
		this.zabbixApi.login(user, senha);

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

		zabbixApi.destory();
		return listaGrupos;

	}
	
	
	public ArrayList<String> listHost(String groupids) {
		ArrayList<String> listaHost = new ArrayList<>();
		Request getRequest = RequestBuilder.newBuilder().method("host.get").paramEntry("groupids", groupids)
				.paramEntry("monitored_hosts", true).build();
		JSONObject getResponse = zabbixApi.call(getRequest);
		JSONArray resultado = getResponse.getJSONArray("result");

		for (int i = 0; i < resultado.size(); i++) {
			JSONObject item = (JSONObject) resultado.get(i);
			listaHost.add((String) item.get("name"));
		}

		zabbixApi.destory();
		return listaHost;

	}

}
