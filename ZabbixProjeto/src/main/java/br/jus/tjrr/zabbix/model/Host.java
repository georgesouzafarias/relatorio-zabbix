package br.jus.tjrr.zabbix.model;

public class Host {
	
	
	private String nomeHost;
	private String hostId;
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	private String grupoHost;
	
	
	public String getNomeHost() {
		return nomeHost;
	}
	public void setNomeHost(String nomeHost) {
		this.nomeHost = nomeHost;
	}
	public String getGrupoHost() {
		return grupoHost;
	}
	public void setGrupoHost(String grupoHost) {
		this.grupoHost = grupoHost;
	}
	
	
	

}
