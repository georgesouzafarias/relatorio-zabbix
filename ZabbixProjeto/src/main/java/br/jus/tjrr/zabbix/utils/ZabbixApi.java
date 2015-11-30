package br.jus.tjrr.zabbix.utils;

import com.alibaba.fastjson.JSONObject;

public interface ZabbixApi {

	public void init();

	public void destory();

	public String apiVersion();

	public JSONObject call(Request request);

	public boolean login(String user, String password);
}
