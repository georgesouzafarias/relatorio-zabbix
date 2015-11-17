package br.jus.tjrr.javaclasses;

import java.util.Date;

public class Evento {
	
	private int idEvento;
	private Date dataEvento;
	private Date horaEvento;
	private Host host;
	private GrupoHost grupoHost;
	private int duracaoEvento;
	private String tipoEvento;
	
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Date getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(Date horaEvento) {
		this.horaEvento = horaEvento;
	}
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	public int getDuracaoEvento() {
		return duracaoEvento;
	}
	public void setDuracaoEvento(int duracaoEvento) {
		this.duracaoEvento = duracaoEvento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public GrupoHost getGrupoHost() {
		return grupoHost;
	}
	public void setGrupoHost(GrupoHost grupoHost) {
		this.grupoHost = grupoHost;
	}
	
	
	

}
