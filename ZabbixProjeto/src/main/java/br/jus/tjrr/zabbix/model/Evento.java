package br.jus.tjrr.zabbix.model;

import java.sql.Timestamp;

/**Classe que representará um evento vindo do Zabbix
 * 
 * @author George Farias
 *
 */

public class Evento {
	
	
	private int idEvento;
	private Timestamp dataEvento;
	private Long horaEvento;	
	private int duracaoEvento;	
	
	
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
	public Timestamp getDataEvento() {
		return dataEvento;
	}
	
	/**
	 *  Método que seta a Data do Evento.
	 * @param dataEvento Parametro do tipo Date.
	 */
	public void setDataEvento(Timestamp dataEvento) {
		this.dataEvento = dataEvento;
	}
	/**
	 *  Método que pega a Hora do Evento.
	 * @return Um objeto do Tipo Date.
	 */
	
	public Long getHoraEvento() {
		return horaEvento;
	}
	/**
	 * Método que seta a Hora do Evento.
	 * @param horaEvento
	 */
	
	public void setHoraEvento(Long horaEvento) {
		this.horaEvento = horaEvento;
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
	
	
	
	
	

}
