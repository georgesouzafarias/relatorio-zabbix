package br.jus.tjrr.zabbix.model;

import java.util.ArrayList;
import java.util.Date;

public class FiltrarEventos {
	
	private int duracaoMinima;
	private Date periodoInicial;
	private Date periodoFinal;
	private String grupoHost;
	private String host;
	
	
	public int getDuracaoMinima() {
		return duracaoMinima;
	}
	public void setDuracaoMinima(int duracaoMinima) {
		this.duracaoMinima = duracaoMinima;
	}
	public Date getPeriodoInicial() {
		return periodoInicial;
	}
	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	public Date getPeriodoFinal() {
		return periodoFinal;
	}
	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	public String getGrupoHost() {
		return grupoHost;
	}
	public void setGrupoHost(String grupoHost) {
		this.grupoHost = grupoHost;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	
	public ArrayList<Evento> buscarEventos(FiltrarEventos filtro){
		return null;
	}
	
	
	
	
	

}
