package br.edu.ifms.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.service.*;
import br.edu.ifms.util.jsf.FacesUtil;
import br.edu.ifms.modelo.*;

@Named
@ViewScoped
public class CadastroClasseBean implements Serializable{
			private static final long serialVersionUID = 1L;
			
			@Inject
			private CadastroClasseService CadastroClasseService;
			
			private Classe classe;
			
			public void salvar() {
				try {
					this.CadastroClasseService.salvar(classe);
					FacesUtil.addSuccessMessage("Fabricante Salvo com Sucesso!");
					this.limpar();
				}
				
				catch(NegocioException e) {
					FacesUtil.addErrorMessage(e.getMessage());
				}
			}
			
			@PostConstruct
			public void init() {
				this.limpar();
			}

			private void limpar() {
				this.classe = new Classe();
				
			}
			
			public Classe getFabricante() {
				return classe;
			}
			
			public void setFabricante(Classe classe) {
				this.classe=classe;
			}
}
