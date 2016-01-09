package br.jus.tjrr.zabbix.model;

import java.util.ArrayList;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.jus.tjrr.zabbix.utils.Utilitarios;

public class FiltroEventos {

	
	@Min(value=0) 
	@NotNull
	private Long duracaoMinima;
	
	private int prioridadeMinima = 4;
	
	@NotNull
	private int severidadeMinima;
	
	private String duracaoMinimaConvertida;
	
	@NotNull
	@NotEmpty
	private String periodoInicial;
	
	@NotNull
	@NotEmpty
	private String periodoFinal;

	private Long periodoInicialConvertido;
	
	private Long periodoFinalConvertido;
	
	@NotNull
	@NotEmpty
	private String idGrupo;
	
	@NotNull
	@NotEmpty
	private String idHost;
	
	Utilitarios util = new Utilitarios();
	
	
	public Long getDuracaoMinima() {
		return duracaoMinima;
	}

	public void setDuracaoMinima(Long duracaoMinima) {
		this.duracaoMinima = duracaoMinima;
		this.duracaoMinimaConvertida = util.converteMinutosEmFormatoComparavel(this.duracaoMinima);
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



	public int getSeveridadeMinima() {
		return severidadeMinima;
	}



	public void setSeveridadeMinima(int severidadeMinima) {
		this.severidadeMinima = severidadeMinima;
	}


}
