package br.jus.tjrr.zabbix.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import br.jus.tjrr.zabbix.utils.Utilitarios;


/**
 * Classe que representará um evento vindo do Zabbix
 * 
 * @author George Farias
 *
 */

public class Evento implements Comparable<Evento>{

	private int idEvento;
	private Long dataEHoraDoEvento;
	private String dataDoEventoConvertida;	
	private String duracaoDoEvento;
	private String triggerId;
	private int value;

	/**
	 * Método que que pega o Identificado do Evendo
	 * 
	 * @return Retorna o ID do Evento
	 */

	public int getIdEvento() {
		return idEvento;
	}

	/**
	 * Método que seta o ID do Evendo.
	 * 
	 * @param idEvento
	 *            é um inteiro.
	 */
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	/**
	 * Metódo que retornará a Data do Evento.
	 * 
	 * @return Um Objeto do tipo Date.
	 */
	public Long getDataEHoraDoEvento() {
		return dataEHoraDoEvento;
	}

	/**
	 * Método que seta a Data do Evento.
	 * 
	 * @param dataEHoraDoEvento
	 *            Parametro do tipo Date.
	 */
	public void setDataEHoraDoEvento(Long dataEHoraDoEvento) {
		this.dataEHoraDoEvento = dataEHoraDoEvento;
		Utilitarios util = new Utilitarios();
		this.dataDoEventoConvertida =  util.converteDataParaDateFormat(this.dataEHoraDoEvento);				
	}

	/**
	 * Método que retorna a duração do evento em Minutos.
	 * 
	 * @return Um a duração do Evento em Minutos.
	 */
	public String getDuracaoDoEvento() {
		return duracaoDoEvento;
	}

	/**
	 * Método que seta a duração do evento em Minutos.
	 * 
	 * @param duracaoEvento
	 *            Tempo de duração do Evento em Minutos
	 */

	public void setDuracaoDoEvento(String duracaoEvento) {		
		this.duracaoDoEvento = duracaoEvento;
	}


	public String getDataDoEventoConvertida() {
		return dataDoEventoConvertida;
	}

	public String getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(String triggerId) {
		this.triggerId = triggerId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		Evento outra = (Evento) obj;
		if ((outra.triggerId.equals(this.triggerId)) && (outra.value != this.value) && (outra.getDataEHoraDoEvento() < this.getDataEHoraDoEvento())){
			return true;
			
		}else{
			return false;
		}		
	}

	@Override
	public int compareTo(Evento outro) {
		if ( this.getDataEHoraDoEvento() > outro.getDataEHoraDoEvento()){
			return -1;
		}
		if (this.getDataEHoraDoEvento() < outro.getDataEHoraDoEvento()) {
			return +1;
		}
		return 0;
	}

	
}
