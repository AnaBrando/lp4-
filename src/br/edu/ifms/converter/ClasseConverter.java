package br.edu.ifms.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.edu.ifms.dao.ClasseDAO;
import br.edu.ifms.modelo.Classe;
import br.edu.ifms.util.cdi.CDIServiceLocator;

public class ClasseConverter implements Converter {

	private ClasseDAO classeDao;
	
	public ClasseConverter() {
		this.classeDao = CDIServiceLocator.getBean(ClasseDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Classe retorno = null;
		
		if(value != null) {
			retorno=this.classeDao.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value !=null) {
			Long codigo = ((Classe) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}
			
}
