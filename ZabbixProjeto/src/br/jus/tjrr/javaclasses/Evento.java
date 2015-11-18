package br.jus.tjrr.javaclasses;

import java.util.Date;

/**Classe que representará um evento vindo do Zabbix
 * 
 * @author George Farias
 *
 */

public class Evento {
	
	private int idEvento;
	private Date dataEvento;
	private Date horaEvento;
	private String nomeHost;
	private String nomeGrupoHost;
	private int duracaoEvento;
	private String tipoEvento;
	
	
	/**
	 * Método que que pega o Identificado do Evendo
	 * @return Retorna o ID do Evento
	 */
	
	public int getIdEvento() {
		return idEvento;
	}
	
	/**
	 *  Método que seta o ID do Evendo.
	 * @param idEvento é um inteiro.
	 */
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	/**
	 * Metódo que retornará a Data do Evento.
	 * @return Um Objeto do tipo Date.
	 */
	public Date getDataEvento() {
		return dataEvento;
	}
	
	/**
	 *  Método que seta a Data do Evento.
	 * @param dataEvento Parametro do tipo Date.
	 */
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	/**
	 *  Método que pega a Hora do Evento.
	 * @return Um objeto do Tipo Date.
	 */
	
	public Date getHoraEvento() {
		return horaEvento;
	}
	/**
	 * Método que seta a Hora do Evento.
	 * @param horaEvento
	 */
	
	public void setHoraEvento(Date horaEvento) {
		this.horaEvento = horaEvento;
	}
	
	/**
	 * Metódo que pega o nome do host do Evento.
	 * @return Um Objeto do tipo String.
	 */
	public String getNomeHost() {
		return nomeHost;
	}
	
	/**
	 * Metódo que seta o nome do host do Evento.
	 * @param host Objeto do tipo String.
	 */
	public void setHost(String nomeHost) {
		this.nomeHost = nomeHost;
	}
	
	/**
	 * Método que retorna a duração do evento em Minutos.
	 * @return Um a duração do Evento em Minutos.
	 */
	public int getDuracaoEvento() {
		return duracaoEvento;
	}
	/**
	 * Método que seta a duração do evento em Minutos.
	 * @param duracaoEvento Tempo de duração do Evento em Minutos
	 */
	
	public void setDuracaoEvento(int duracaoEvento) {
		this.duracaoEvento = duracaoEvento;
	}
	
	/**
	 * Método que retorna o tipo do Evento.
	 * @return Um String.
	 */
	public String getTipoEvento() {
		return tipoEvento;
	}
	/**
	 * Método que seta o tipo do Evento.
	 * @param tipoEvento Tipo do Evento
	 */
	
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	/**
	 * Método que retorna o nome do Grupo do Host do Evento.
	 * @return String
	 */
	public String getNomeGrupoHost() {
		return nomeGrupoHost;
	}
	
	/**
	 * Método que seta o nome do Grupo do Host do Evento.
	 * @param grupoHost O nome da Grupo do Host.
	 */
	public void setGrupoHost(String grupoHost) {
		this.nomeGrupoHost = grupoHost;
	}
	
	
	

}
