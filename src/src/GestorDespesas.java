import java.util.ArrayList;
import java.util.Scanner;

public class GestorDespesas {

    private ArrayList<Despesa> despesas;

    public GestorDespesas() {
        despesas = new ArrayList<>();
    }

    public void adicionarDespesa(Scanner scanner) {

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor (€): ");
        String valorTexto = scanner.nextLine().replace(",", ".");

        double valor;

        try {
            valor = Double.parseDouble(valorTexto);

            if (valor <= 0) {
                System.out.println("O valor deve ser maior que zero.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Valor inválido.");
            return;
        }

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Despesa despesa = new Despesa(descricao, valor, categoria);
        despesas.add(despesa);

        System.out.println("Despesa adicionada com sucesso!");
    }

    public void listarDespesas() {

        if (despesas.isEmpty()) {
            System.out.println("Não existem despesas registadas.");
            return;
        }

        System.out.println("\n========== DESPESAS ==========");

        for (int i = 0; i < despesas.size(); i++) {
            System.out.println((i + 1) + ". " + despesas.get(i));
        }
    }

    public void mostrarTotal() {

        double total = 0;

        for (Despesa despesa : despesas) {
            total += despesa.getValor();
        }

        System.out.printf("Total de despesas: €%.2f%n", total);
    }

    public void pesquisarPorCategoria(Scanner scanner) {

        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();

        boolean encontrada = false;

        for (Despesa despesa : despesas) {

            if (despesa.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(despesa);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("Nenhuma despesa encontrada nessa categoria.");
        }
    }

    public void removerDespesa(Scanner scanner) {

        if (despesas.isEmpty()) {
            System.out.println("Não existem despesas para remover.");
            return;
        }

        listarDespesas();

        System.out.print("Digite o número da despesa que deseja remover: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Número inválido.");
            scanner.next();
            return;
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > despesas.size()) {
            System.out.println("Despesa não encontrada.");
            return;
        }

        despesas.remove(numero - 1);

        System.out.println("Despesa removida com sucesso!");
    }
}
