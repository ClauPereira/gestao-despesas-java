public class Main {

    // Cores ANSI
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestorDespesas gestor = new GestorDespesas();

        int opcao;

        mostrarBoasVindas();

        do {

            mostrarMenu();

            System.out.print(CYAN + "  Escolha uma opção: " + RESET);

            while (!scanner.hasNextInt()) {
                System.out.println(RED + "  ✖ Opção inválida. Digite um número." + RESET);
                scanner.next();
                System.out.print(CYAN + "  Escolha uma opção: " + RESET);
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (opcao) {

                case 1:
                    System.out.println(BLUE + "  ─── NOVA DESPESA ───" + RESET);
                    gestor.adicionarDespesa(scanner);
                    break;

                case 2:
                    System.out.println(BLUE + "  ─── SUAS DESPESAS ───" + RESET);
                    gestor.listarDespesas();
                    break;

                case 3:
                    System.out.println(BLUE + "  ─── RESUMO FINANCEIRO ───" + RESET);
                    gestor.mostrarTotal();
                    break;

                case 4:
                    System.out.println(BLUE + "  ─── PESQUISA ───" + RESET);
                    gestor.pesquisarPorCategoria(scanner);
                    break;

                case 5:
                    System.out.println(BLUE + "  ─── REMOVER DESPESA ───" + RESET);
                    gestor.removerDespesa(scanner);
                    break;

                case 0:
                    System.out.println(
                            GREEN + "\n  ✔ Obrigado por utilizar o Gestão de Despesas!" + RESET
                    );
                    System.out.println(
                            CYAN + "  Até breve! 👋\n" + RESET
                    );
                    break;

                default:
                    System.out.println(
                            RED + "  ✖ Opção inválida. Escolha uma opção do menu." + RESET
                    );
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void mostrarBoasVindas() {

        System.out.println(CYAN + BOLD);
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║                                          ║");
        System.out.println("║       💰 GESTÃO DE DESPESAS 💰           ║");
        System.out.println("║                                          ║");
        System.out.println("║        Controle suas despesas            ║");
        System.out.println("║        de forma simples e rápida         ║");
        System.out.println("║                                          ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println(RESET);

    }

    private static void mostrarMenu() {

        System.out.println(YELLOW + BOLD);
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║                 MENU                     ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1  ➜  Adicionar despesa                 ║");
        System.out.println("║  2  ➜  Listar despesas                   ║");
        System.out.println("║  3  ➜  Ver resumo financeiro             ║");
        System.out.println("║  4  ➜  Pesquisar por categoria           ║");
        System.out.println("║  5  ➜  Remover despesa                   ║");
        System.out.println("║  0  ➜  Sair                              ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println(RESET);

    }
}

