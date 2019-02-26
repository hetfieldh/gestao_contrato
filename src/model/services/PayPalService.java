package model.services;

public class PayPalService implements PagamentoOnlineService {

	private static final double PERCENTUAL_TAXA = 0.02;
	private static final double JUROS_MENSAL = 0.01;

	@Override
	public double taxaPagamento(double montante) {
		return montante * PERCENTUAL_TAXA;
	}

	@Override
	public double calcularJuros(double montante, int meses) {
		return montante * JUROS_MENSAL * meses;
	}

}