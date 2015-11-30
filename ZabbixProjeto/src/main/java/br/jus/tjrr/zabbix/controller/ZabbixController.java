package br.jus.tjrr.zabbix.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.jus.tjrr.zabbix.dao.ZabbixDao;

@Controller
public class ZabbixController {

	private Result result;
	private ZabbixDao dao;	

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
		result.include("grupoLista", dao.listGrupos());
	}

	/*@Get
	public void lista() {
		result.include("grupoLista", dao.listGrupos());
	}
	*/
}
