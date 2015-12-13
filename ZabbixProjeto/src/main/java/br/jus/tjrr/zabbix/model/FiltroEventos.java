package br.jus.tjrr.zabbix.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.jus.tjrr.zabbix.utils.Utilitarios;

public class FiltroEventos {

	private int duracaoMinima = 4;
	// private Date periodoInicial;
	// private Date periodoFinal;

	private String periodoInicial;
	private String periodoFinal;

	private Long periodoInicialConvertido;
	private Long periodoFinalConvertido;

	private String idGrupo;
	private String idHost;
	
	Utilitarios util = new Utilitarios();

	public int getDuracaoMinima() {
		return duracaoMinima;
	}

	public void setDuracaoMinima(int duracaoMinima) {
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

}
