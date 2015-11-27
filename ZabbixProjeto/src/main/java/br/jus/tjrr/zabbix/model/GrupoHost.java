package br.jus.tjrr.zabbix.model;

import java.util.ArrayList;

/** Classe responsável por receber da API os grupos do Zabbix
 * 
 * @author George Farias
 *
 */

public class GrupoHost {
	
		
	private String nomeGrupo;
	private ArrayList<Host> listHost;
	private int idGrupo;
	
	
	/**
	 * Método para pegar o nome do Grupo
	 * @return O nome do Grupo.
	 */
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	
	/**
	 * Método resposável por setar o nome do Grupo.
	 * @param nomeGrupo String que representa o Nome do Grupo
	 */
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	
	/**
	 *  Método para listar os Hosts do Grupo
	 * @return Um Array de Hots.
	 */
	public ArrayList<Host> getListHost() {
		return listHost;
	}
	
	/**Método resposável por adicionar Hosts num Array.
	 * 
	 * @param host Recebe um Objeto do Tipo Host. 
	 */
	public void adicionarHost(Host host) {
		this.listHost.add(host);
	}
	
	/**
	 * Método para pegar o ID do grupo
	 * @return Retorna um Id do Grupo do tipo Inteiro. 
	 */
	public int getIdGrupo() {
		return idGrupo;
	}
	
	/**
	 * Método para setar o ID do Grupo
	 * @param idGrupo ID do grupo do tipo inteiro.
	 */
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
	

}
