import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>(); 
        List<Pagamento> pagamentos = new ArrayList<>();     

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastro de cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Consulta CPF");
            System.out.println("4 - Cadastrar pagamento");
            System.out.println("5 - Listar pagamentos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

        if (opcao == 1) {
            try{
                System.out.println("Informe o código do cliente: ");
                String codigo = scanner.nextLine();
                System.out.println("Informe o cpf do cliente: ");   
                String cpf = scanner.nextLine();
                System.out.println("Informe o nome do cliente: ");
                String nome = scanner.nextLine();

                for (Cliente cliente : clientes) {
                    if (cliente.getCodigo().equals(codigo)) {
                        throw new Exception("Código já cadastrado");
                    }
                    if (cliente.getCpf().equals(cpf)) {
                        throw new Exception("CPF já cadastrado");
                    }
                }

                Cliente cl = new Cliente(codigo, cpf, nome);
                clientes.add(cl);

                voltarMenu(scanner);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                //scanner.nextLine();
                voltarMenu(scanner);
            }
        } else if (opcao == 2) {
            if (clientes.isEmpty()) {
                System.out.println("Não há clientes cadastrados.");
            }else{
                clientes.sort(new ComparadorNome());
                System.out.println("Clientes cadastrados:");
                for (Cliente cliente : clientes) {
                 System.out.printf("Nome: %s - CPF: %s - Código: %s \n", cliente.getNome(), cliente.getCpf(), cliente.getCodigo());   
                }
            }

            voltarMenu(scanner);
        } else if (opcao == 3) {
            boolean verificar = false;
            if (clientes.isEmpty()) {
                System.out.println("Não há clientes cadastrados.");
            }else{
                System.out.println("Informe o CPF que busca: ");   
                String cpf = scanner.nextLine();

                for (Cliente cliente : clientes) {
                  if (cliente.getCpf().equals(cpf)) {
                    System.out.println("Cliente encontrado:");
                    System.out.printf("Nome: %s - CPF: %s - Código: %s \n", cliente.getNome(), cliente.getCpf(), cliente.getCodigo());
                    verificar = true;
                  }
                }
            if (!verificar) {
                    System.out.println("Nenhum cliente encontrado");
            }
            }


            voltarMenu(scanner);
        }else if (opcao == 4) {
            if (clientes.isEmpty()) {
                System.out.println("Não há clientes cadastrados");
            }else{
                System.out.println("Informe o valor: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Código do cliente: ");
                String codigo = scanner.nextLine(); 
                
                Cliente cl = null;
                boolean verificar = false;
                for (Cliente cliente : clientes) {
                   if (cliente.getCodigo().equals(codigo)) {
                      cl = cliente; 
                      verificar = true; 
                   } 
                }
                if (!verificar) {
                    System.out.println("Nenhum cliente encontrado");
                }else{
                Pagamento pg = new Pagamento(valor, cl);
                pagamentos.add(pg);
                }
            }    
            voltarMenu(scanner);
        }else if (opcao == 5) {
            if (pagamentos.isEmpty()) {
                System.out.println("Não existem pagamentos cadastrados");
            }else{
                pagamentos.sort(new ComparadorValor());
                System.out.println("Pagamentos cadastrados:");
                for (Pagamento pagamento : pagamentos) {
                   System.out.printf("Valor: %f - Nome: %s \n", pagamento.getValor() , pagamento.getCl().getNome()); 
                }
            }

                
                
            voltarMenu(scanner);
            }
        else if (opcao != 0) {
            System.out.println("\nOpção inválida!");
        }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        scanner.close();
    }

    private static void voltarMenu(Scanner scanner) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        scanner.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}