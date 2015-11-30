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
	public void index(String grupid) {
		
		result.include("grupoLista", dao.listGrupos()).include("hostlista", dao.listHost(groupid));
	}

	
	@Post
	public ArrayList<Host> listaHost(String grupoid) {	
		return dao.listHost(groupid);		
		//result.redirectTo(this).index(grupoid);
		
	}
	
    @Get("/host")
    public void getHosts(String grupoid) {      
    	ArrayList<Host> hosts = new ArrayList<>();
    	hosts = dao.listHost(grupoid);    	
        result.use(Results.json()).from(hosts).serialize();

    }
	
	
	/*@Get
	public void lista() {
		result.include("grupoLista", dao.listGrupos());
	}
	*/
}
