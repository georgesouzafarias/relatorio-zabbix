package br.jus.tjrr.zabbix.model;

import java.util.ArrayList;

import br.jus.tjrr.zabbix.dao.ZabbixDao;

public class ConexaoZabbixTeste {

	public static void main(String[] args) {

		ZabbixDao dao = new ZabbixDao();
	

		ArrayList<String> listaGrupo = dao.listGrupos();
		
		for (String nome : listaGrupo){
			System.out.println(nome);
		}

	}
}