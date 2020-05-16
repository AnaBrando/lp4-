package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.ClasseDAO;
import br.edu.ifms.modelo.Classe;


public class CadastroClasseService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClasseDAO FabricanteDao;

	@br.edu.ifms.util.jpa.Transactional
	public void salvar(Classe fabricante) throws NegocioException {
		if(fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		this.FabricanteDao.salvar(fabricante);
	}
	
	
}
