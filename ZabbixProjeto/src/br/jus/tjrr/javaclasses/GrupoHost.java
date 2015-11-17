package br.jus.tjrr.javaclasses;

import java.util.ArrayList;

public class GrupoHost {
	
	private String nomeGrupo;
	private ArrayList<Host> listHost;
	private int idGrupo;
	
	
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	public ArrayList<Host> getListHost() {
		return listHost;
	}
	public void setListHost(ArrayList<Host> listHost) {
		this.listHost = listHost;
	}
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
	

}
