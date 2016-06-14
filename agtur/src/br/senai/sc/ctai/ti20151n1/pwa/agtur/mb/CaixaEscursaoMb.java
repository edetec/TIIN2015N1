package br.senai.sc.ctai.ti20151n1.pwa.agtur.mb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.CaixaEscursao;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.rn.CaixaEscursaoRN;

@ManagedBean
public class CaixaEscursaoMb {
	private List<CaixaEscursao> caixasEscursao;
	private Date fim;
	private Date inicio;
	private CaixaEscursaoRN rn;
	
	@PostConstruct
	public void init(){
		rn = new CaixaEscursaoRN();
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public List<CaixaEscursao> getCaixasEscursao() {
		if (caixasEscursao == null) {
			inicio = getValorOuData(inicio, true);
			fim = getValorOuData(fim, false);
			
			caixasEscursao = rn.buscarPorPeriodo(inicio, fim);
		}
		return caixasEscursao;
	}

	private Date getValorOuData(Date data, boolean ehInicio) {
		if (data != null) {
			return data;
		}
		Calendar date = Calendar.getInstance();
		int dia = ehInicio ? 1 : date.getActualMaximum(Calendar.DAY_OF_MONTH);
		int hora = ehInicio ? 0 : date.getActualMaximum(Calendar.HOUR);
		int periodo = ehInicio ? Calendar.AM: Calendar.PM;
		int minuto = ehInicio ? 0 : date.getActualMaximum(Calendar.MINUTE);
		int segundo = ehInicio ? 0 : date.getActualMaximum(Calendar.SECOND);
		
		date.set(Calendar.AM_PM, periodo);
		date.set(Calendar.DAY_OF_MONTH, dia);
		date.set(Calendar.HOUR, hora);
		date.set(Calendar.MINUTE, minuto);
		date.set(Calendar.SECOND, segundo);

		return date.getTime();
	}

	public void setCaixasEscursao(List<CaixaEscursao> caixasEscursao) {
		this.caixasEscursao = caixasEscursao;
	}
	
	public String buscar() {
		caixasEscursao = null;
		return "";
	}
}
