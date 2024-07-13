import com.google.gson.JsonObject;
import controle.ConexaoApiController;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ConexaoApiController api = new ConexaoApiController("https://v6.exchangerate-api.com/v6/ca744abd942dce7f81b60c01/latest/USD");

        //Cotação das moedas em relação ao dolar
        JsonObject rates = api.getJsonResponse().get("conversion_rates").getAsJsonObject();

        //Salvando os valores das cotações em um dicipnário
        Dictionary<String, Double> cotacoesMoedas= new Hashtable<>();

        cotacoesMoedas.put("USD", rates.get("USD").getAsDouble());
        cotacoesMoedas.put("BRL", rates.get("BRL").getAsDouble());
        cotacoesMoedas.put("ARS", rates.get("ARS").getAsDouble());
        cotacoesMoedas.put("COP", rates.get("COP").getAsDouble());


        double valor, valorConvertido;
        int escolha = 0;

        Scanner input = new Scanner(System.in);

        while (escolha != 7) {
            System.out.println("""
                    *********************************************
                    Seja bem-vindo/a ao Conversor de Moeda
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileiro
                    4) Real brasileiro =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Sair
                    Escolha uma opção válida:
                    *********************************************
                    """);
            escolha = input.nextInt();


            switch (escolha) {
                case 1:
                    System.out.println("Qual o valor que deseja converter? ");
                    valor = input.nextDouble();

                    //Saber se a cotação da moeda em relção ao dolar é maior ou menor
                    if (cotacoesMoedas.get("USD") <= cotacoesMoedas.get("ARS")){

                        valorConvertido =  valor * cotacoesMoedas.get("ARS");
                    }
                    else {
                        valorConvertido =  valor / cotacoesMoedas.get("ARS");
                    }

                    System.out.println("Valor " + valor + "[USD] corresponde ao valor final de =>>> " + valorConvertido + "[ARS]");
                    break;

                case 2:
                    System.out.println("Qual o valor que deseja converter? ");
                    valor = input.nextDouble();

                    //Saber se a cotação da moeda em relção ao dolar é maior ou menor
                    if (cotacoesMoedas.get("ARS") <= cotacoesMoedas.get("USD")){

                        valorConvertido =  valor * cotacoesMoedas.get("ARS");
                    }
                    else {
                        valorConvertido =  valor / cotacoesMoedas.get("ARS");
                    }

                    System.out.println("Valor " + valor + "[ARS] corresponde ao valor final de =>>> " + valorConvertido + "[USD]");
                    break;

                case 3:

                    System.out.println("Qual o valor que deseja converter? ");
                    valor = input.nextDouble();

                    //Saber se a cotação da moeda em relção ao dolar é maior ou menor
                    if (cotacoesMoedas.get("USD") <= cotacoesMoedas.get("BRL")){

                        valorConvertido =  valor * cotacoesMoedas.get("BRL");
                    }
                    else {
                        valorConvertido =  valor / cotacoesMoedas.get("BRL");
                    }

                    System.out.println("Valor " + valor + "[USD] corresponde ao valor final de =>>> " + valorConvertido + "[BRL]");
                    break;

                case 4:

                    System.out.println("Qual o valor que deseja converter? ");
                    valor = input.nextDouble();

                    //Saber se a cotação da moeda em relção ao dolar é maior ou menor
                    if (cotacoesMoedas.get("BRL") <= cotacoesMoedas.get("USD")){

                        valorConvertido =  valor * cotacoesMoedas.get("BRL");
                    }
                    else {
                        valorConvertido =  valor / cotacoesMoedas.get("BRL");
                    }

                    System.out.println("Valor " + valor + "[BRL] corresponde ao valor final de =>>> " + valorConvertido + "[USD]");
                    break;

                case 5:
                    System.out.println("Qual o valor que deseja converter? ");
                    valor = input.nextDouble();

                    //Saber se a cotação da moeda em relção ao dolar é maior ou menor
                    if (cotacoesMoedas.get("USD") <= cotacoesMoedas.get("COP")){

                        valorConvertido =  valor * cotacoesMoedas.get("COP");
                    }
                    else {
                        valorConvertido =  valor / cotacoesMoedas.get("COP");
                    }

                    System.out.println("Valor " + valor + "[USD] corresponde ao valor final de =>>> " + valorConvertido + "[COP]");
                    break;
                case 6:
                    System.out.println("Qual o valor que deseja converter? ");
                    valor = input.nextDouble();

                    //Saber se a cotação da moeda em relção ao dolar é maior ou menor
                    if (cotacoesMoedas.get("COP") <= cotacoesMoedas.get("USD")){

                        valorConvertido =  valor * cotacoesMoedas.get("COP");
                    }
                    else {
                        valorConvertido =  valor / cotacoesMoedas.get("COP");
                    }

                    System.out.println("Valor " + valor + "[COP] corresponde ao valor final de =>>> " + valorConvertido + "[USD]");
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
