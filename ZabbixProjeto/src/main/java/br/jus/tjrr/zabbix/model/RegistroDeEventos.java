package br.jus.tjrr.zabbix.model;

import java.util.ArrayList;

/**
 * Essa classe é responsável por receber os eventos selecionados e manipula-los.
 * @author George Farias
 *
 */

public class RegistroDeEventos {
	
	private ArrayList<Evento> eventos = new ArrayList<>();
	
	
	
	
	/**
	 *  Método reponsável por adicionar os eventos selecionados.
	 * 
	 * @param evento É um Objeto da Classe Evento
	 */
		
	public void addEvento(Evento evento){
			this.eventos.add(evento);
		
	}
	
	/** Método que removerá os eventos não desejados.
	 * 
	 * @param idEvento Index do Evento que será apagado
	 */
	
	public void removerEvento(int idEvento){
		this.eventos.remove(idEvento);
		
	}
	
	/**
	 *  Método que produzir o relatório final.
	 */
	
	public void gerarRelatorio(){
		//IMPLEMENTAR
	}

	/** Método que retornará todos os eventos adcionados. 
	 * 
	 * @return Um ArrayList do tipo Eventos.
	 */
	public ArrayList<Evento> listarEventos(){
		return eventos;
		
	}
}
