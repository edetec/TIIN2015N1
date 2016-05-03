package br.senai.sc.tiin20151n1.pwa.introjpa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.tiin20151n1.pwa.introjpa.model.PerfilAcessoRN;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.PerfilAcesso;

@FacesConverter(forClass=PerfilAcesso.class)
public class PerfilAcessoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String idParam) {
		PerfilAcessoRN dao = new PerfilAcessoRN();
		Long id = Long.parseLong(idParam);
		return dao.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		PerfilAcesso perfilAcesso = (PerfilAcesso) object;
		return perfilAcesso.getId().toString();
	}

}
