package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcelas;

public class ContratoService {

	private PagamentoOnlineService pagamentoOnlineService;

	public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
		this.pagamentoOnlineService = pagamentoOnlineService;
	}

	public void gerarContrato(Contrato contrato, int meses) {

		double valorBaseParcela = contrato.getValorTotal() / meses;

		for (int i = 1; i <= meses; i++) {
			Date data = addMonths(contrato.getDataContrato(), i);
			double atualizarValorParcela = valorBaseParcela + pagamentoOnlineService.calcularJuros(valorBaseParcela, i);
			double parcelaTotal = atualizarValorParcela + pagamentoOnlineService.taxaPagamento(atualizarValorParcela);
			contrato.adicionarParcelas(new Parcelas(data, parcelaTotal));
		}

	}

	private Date addMonths(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}