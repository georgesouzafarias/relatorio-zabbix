package br.jus.tjrr.zabbix.model;

public class Trigger {
	
	
	private String triggerid;
	private String description;
	private int prioridade;
		
		
	
	public String getTriggerid() {
		return triggerid;
	}
	public void setTriggerid(String triggerid) {
		this.triggerid = triggerid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	

}
