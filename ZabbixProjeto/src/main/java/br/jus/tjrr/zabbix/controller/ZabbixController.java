package br.jus.tjrr.zabbix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.jus.tjrr.zabbix.dao.ZabbixDao;
import br.jus.tjrr.zabbix.model.FiltroEventos;
import br.jus.tjrr.zabbix.model.Host;

@Controller
public class ZabbixController {

	private Result result;
	private ZabbixDao dao;	
	private String groupid = "0";


	@Inject
	public ZabbixController(Result result, ZabbixDao dao) {
		this.dao = dao;
		this.result = result;		
	}

	public ZabbixController() {
		this(null,null);
	}
	


	@Get("/")
	public void index() {		
		result.include("grupoLista", dao.listGrupos()).include("hostlista", dao.listHost(groupid));
	}

	
	
    @Get("/host")
    public void getHosts(String grupoid) {      
    	ArrayList<Host> hosts = new ArrayList<>();
    	hosts = dao.listHost(grupoid);    	
        result.use(Results.json()).from(hosts).serialize();

    }
	
		
	@Post
	public void listarEventos(FiltroEventos filtroEventos) {
		/*
		System.out.println(filtroEventos.getIdGrupo());
		System.out.println(filtroEventos.getIdHost());
		System.out.println(filtroEventos.getPeriodoInicial());
		System.out.println(filtroEventos.getPeriodoFinal());
		System.out.println(filtroEventos.getPeriodoInicialConvertido());
		System.out.println(filtroEventos.getPeriodoFinalConvertido());
		*/
		result.include("listaDeEventos", dao.listaEvento(filtroEventos));
	}
	
}
