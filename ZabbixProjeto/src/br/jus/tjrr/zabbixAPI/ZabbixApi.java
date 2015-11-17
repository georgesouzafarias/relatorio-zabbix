package br.jus.tjrr.zabbixAPI;

import com.alibaba.fastjson.JSONObject;

public interface ZabbixApi {

	public void init();

	public void destory();

	public String apiVersion();

	public JSONObject call(Request request);

	public boolean login(String user, String password);
}
