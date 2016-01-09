package br.jus.tjrr.zabbix.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.jus.tjrr.zabbix.dao.ZabbixDao;
import br.jus.tjrr.zabbix.model.FiltroEventos;


@Controller @ApplicationScoped
public class ZabbixController {

	private final Result result;
	private final ZabbixDao dao;
	private final Validator validator;	
	//private String groupid = "0";
	

	@Inject
	public ZabbixController(Result result, ZabbixDao dao, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;		
	}

	public ZabbixController() {
		this(null,null, null);
	}
	


	@Get("/")
	public void index() {		
		result.include("grupoLista", dao.listGrupos());
	}

	
	
    @Get("/host")
    public void getHosts(String grupoid) {     
        result.use(Results.json()).from(dao.listHost(grupoid)).serialize();

    }
	
    @Post("/removerhosts")
    public void removerhosts(String[] index){		
    	result.include("listaDeEventos", dao.removeEventosSelecionados(index));
    	//result.redirectTo(this).listarEventos();
    	result.forwardTo(this).listarEventos();
    	
    }
    
    @Get
    public void listarEventos() {	
	}
		
    @Post
	public void filtrarEventos(@NotNull @Valid FiltroEventos filtroEventos) {	
    	
    	validator.onErrorForwardTo(this).index();
    	
		result.include("listaDeEventos", dao.listaEvento(filtroEventos));
		result.forwardTo(this).listarEventos();
	}
    
    @Get("/gerarRelatorio")
    public void gerarRelatorio() {
    	result.include("listaDeEventos", dao.getListaEvento());
		
	}
	
}
