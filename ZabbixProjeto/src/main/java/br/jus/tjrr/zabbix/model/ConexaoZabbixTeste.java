package br.jus.tjrr.zabbix.model;

import com.alibaba.fastjson.JSONObject;

import br.jus.tjrr.zabbix.dao.*;



public class ConexaoZabbixTeste {
	
	
	public static void main(String[] args) {
		
		final String url = "http://10.50.1.16/api_jsonrpc.php";
	    DefaultZabbixApi zabbixApi = new DefaultZabbixApi(url);
	    zabbixApi.init();    
	    

	    //boolean login = zabbixApi.login("f3011467", "0535sf");    
	    //System.err.println("login:" + login);
	    zabbixApi.login("f3011467", "0535sf");
	    
	    String host = "tepequem";
	    JSONObject filter = new JSONObject();

	    filter.put("host", new String[] { host });
	    Request getRequest = RequestBuilder.newBuilder()
	            .method("host.get").paramEntry("filter", filter)
	            .build();
	    JSONObject getResponse = zabbixApi.call(getRequest);
	    //System.err.println(getResponse);
	    String hostid = getResponse.getJSONArray("result")
	            .getJSONObject(0).getString("hostid");
	    
	    String hostName = getResponse.getJSONArray("result")
	            .getJSONObject(0).getString("name");	    
	     
	    String descricao = getResponse.getJSONArray("result")
	            .getJSONObject(0).getString("description");
	    
	    
	    
	    System.err.println(hostid);
	    System.err.println(hostName);
	    System.err.println(descricao);
	    
	    zabbixApi.destory();; 
	    
	    
		
	}
    
}
