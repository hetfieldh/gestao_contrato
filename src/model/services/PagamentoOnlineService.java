package model.services;

public interface PagamentoOnlineService {
	
	double taxaPagamento(double montante);
	double calcularJuros(double montante, int meses);
}
