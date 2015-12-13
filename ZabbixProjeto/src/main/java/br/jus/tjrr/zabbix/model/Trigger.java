package br.jus.tjrr.zabbix.model;

public class Trigger {
	
	
	private String triggerid;
	private String description;
	private Long lastchange;
	private int value;
	
	
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
	public Long getLastchange() {
		return lastchange;
	}
	public void setLastchange(Long lastchange) {
		this.lastchange = lastchange;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
