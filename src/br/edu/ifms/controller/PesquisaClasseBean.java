package br.edu.ifms.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.dao.ClasseDAO;
import br.edu.ifms.modelo.Classe;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaClasseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	ClasseDAO fabricanteDao;
	private List<Classe> fabricantes = new ArrayList<Classe>();
	
	private Classe fabricanteSelecionado;
	
	public List<Classe> getFabricantes(){
		return fabricantes;
	}
	
	public void excluir() {
		try {
			fabricanteDao.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante "+ fabricanteSelecionado.getNome()+"excluído com sucesso");
		}catch(Exception ex) {
			FacesUtil.addErrorMessage(ex.getMessage());
		}
	}
	
	public Classe getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	public void setFabricanteSelecionado(Classe fabricanteSelecionado) {
		this.fabricanteSelecionado=fabricanteSelecionado;
	}
	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteDao.buscarTodos();
	}
}
