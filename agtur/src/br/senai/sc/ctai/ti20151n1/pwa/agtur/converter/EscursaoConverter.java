package br.senai.sc.ctai.ti20151n1.pwa.agtur.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.EscursaoRN;

@FacesConverter(forClass=Escursao.class)
public class EscursaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String valor) {
		Long id = Long.parseLong(valor);
		
		EscursaoRN rn = new EscursaoRN();
		
		return rn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object valor) {
		Escursao escursao = (Escursao) valor;
		return escursao.getId().toString();
	}

}
