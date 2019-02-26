package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcelas;
import model.services.ContratoService;
import model.services.PayPalService;

public class GestaoContrato {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Informe os dados contrato");
		System.out.print("Número: ");
		int numeroContrato = sc.nextInt();
		System.out.print("Data (dd/MM/aaaa): ");
		Date dataContrato = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();

		Contrato contrato = new Contrato(numeroContrato, dataContrato, valorTotal);

		System.out.print("Número de parcelas: ");
		int n = sc.nextInt();

		ContratoService contratoService = new ContratoService(new PayPalService());

		contratoService.gerarContrato(contrato, n);

		System.out.println("Parcelas:");

		for (Parcelas x : contrato.getParcelas()) {
			System.out.println(x);
		}
		sc.close();
	}
}