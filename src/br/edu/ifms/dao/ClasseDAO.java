package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.edu.ifms.modelo.Classe;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;


public class ClasseDAO implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Classe fabricante) {
		em.merge(fabricante);
	}
	
	@SuppressWarnings("uncheked")
	public List<Classe> buscarTodos(){

		return em.createQuery("From Fabricante").getResultList();
		
	}
	@Transactional
	
	public void excluir(Classe fabricante) throws NegocioException{
		Classe fabricanteTemp=em.find(Classe.class, fabricante.getCodigo());
		em.remove(fabricanteTemp);
		em.flush();
	}
	
	public Classe buscarPeloCodigo(Long codigo) {
		return em.find(Classe.class, codigo);
	}
	
	
}
