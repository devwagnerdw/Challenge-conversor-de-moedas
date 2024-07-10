import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            System.out.print("Escolha uma opção válida: ");
            int opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("\nObrigado por utilizar o Conversor de Moedas! Fim do programa.");
                break;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            switch (opcao) {
                case 1 -> exibirResultado("USD", "BRL", valor);
                case 2 -> exibirResultado("EUR", "BRL", valor);
                case 3 -> exibirResultado("GBP", "BRL", valor);
                case 4 -> exibirResultado("JPY", "BRL", valor);
                case 5 -> exibirResultado("ARS", "BRL", valor);
                case 6 -> exibirResultado("UYU", "BRL", valor);
                default -> System.out.println("\nOpção Inválida! Por favor, escolha uma opção válida!");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        String menu = """
                ╔═════════════════════════════════════════════════╗
                ║                   CONVERSOR DE MOEDAS           ║
                ╠═════════════════════════════════════════════════╣
                ║ [1] Dólar (USD) para Real (BRL)                 ║
                ║ [2] Euro (EUR) para Real (BRL)                  ║
                ║ [3] Libra Esterlina (GBP) para Real (BRL)       ║
                ║ [4] Iene (JPY) para Real (BRL)                  ║
                ║ [5] Peso Argentino (ARS) para Real (BRL)        ║
                ║ [6] Peso Uruguaio (UYU) para Real (BRL)         ║
                ╠═════════════════════════════════════════════════╣
                ║ [7] Sair                                        ║
                ╚═════════════════════════════════════════════════╝
                """;
        System.out.println(menu);
    }

    private static void exibirResultado(String from, String to, double valor) {
        double resultado = Conversor.converterMoeda(from, to, valor);
        System.out.printf("\nO valor de %.2f [%s] corresponde ao valor final de %.2f [BRL]\n", valor, from, resultado);
    }
}