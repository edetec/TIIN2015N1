package br.senai.sc.ctai.ti20151n1.pwa.agtur.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Usuario;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.UsuarioRN;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		UsuarioRN usuarioRN = new UsuarioRN();
		Long id = Long.parseLong(value);
		return usuarioRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Usuario usuario = (Usuario) value;
		return usuario.getId().toString();
	}
}
