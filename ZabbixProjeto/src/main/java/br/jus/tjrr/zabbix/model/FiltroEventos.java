package br.jus.tjrr.zabbix.model;

import java.util.ArrayList;


import br.jus.tjrr.zabbix.utils.Utilitarios;

public class FiltroEventos {

	private Long duracaoMinima = (long) 4;
	private int prioridadeMinima = 4;
	private String duracaoMinimaConvertida;
	private String periodoInicial;
	private String periodoFinal;

	private Long periodoInicialConvertido;
	private Long periodoFinalConvertido;

	private String idGrupo;
	private String idHost;
	
	Utilitarios util = new Utilitarios();
	
	public FiltroEventos() {
		this.duracaoMinimaConvertida = util.converteMinutosEmFormatoComparavel(this.duracaoMinima);
	}
	
	

	public Long getDuracaoMinima() {
		return duracaoMinima;
	}

	public void setDuracaoMinima(Long duracaoMinima) {
		this.duracaoMinima = duracaoMinima;
	}

	public String getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(String periodoInicial) {
		this.periodoInicialConvertido = util.converteDataParaLong(periodoInicial);
		this.periodoInicial = periodoInicial;
	}

	public String getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(String periodoFinal) {
		this.periodoFinalConvertido = util.converteDataParaLong(periodoFinal);
		this.periodoFinal = periodoFinal;

	}

	public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String grupoHost) {
		this.idGrupo = grupoHost;
	}

	public String getIdHost() {
		return idHost;
	}

	public void setIdHost(String host) {
		this.idHost = host;
	}

	public ArrayList<Evento> buscarEventos(FiltroEventos filtro) {
		return null;
	}
	

	public Long getPeriodoInicialConvertido() {
		return periodoInicialConvertido;
	}

	public Long getPeriodoFinalConvertido() {
		return periodoFinalConvertido;
	}

	public String getDuracaoMinimaConvertida() {
		return duracaoMinimaConvertida;
	}



	public int getPrioridadeMinima() {
		return prioridadeMinima;
	}



	public void setPrioridadeMinima(int prioridadeMinima) {
		this.prioridadeMinima = prioridadeMinima;
	}


}
