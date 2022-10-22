import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao;
        int qtdProdutos = 0;
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<Produto>();
        

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período - detalhado");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

        if (opcao == 1) {
                
            
            Produto produto = new Produto();
                
            System.out.println("Código: ");
            produto.setCodigo(scanner.next());
            System.out.println("Nome: ");
            produto.setNome(scanner.next());
            System.out.println("Valor: ");
            produto.setValor(scanner.nextDouble());
            System.out.println("Estoque: ");
            produto.setEstoque(scanner.nextInt());

            produtos.add(qtdProdutos, produto);

            qtdProdutos++;

            voltarMenu(scanner);
        } else if (opcao == 2) {
                
                System.out.print("Digite o código do produto que você procura: \n");
                String buscaProduto = scanner.nextLine();
    
                for (Produto p : produtos) {

                if (buscaProduto.equals(p.getCodigo())) {
                System.out.println("\nProduto correspondente: ");
                System.out.println(p.getNome());
                
                }
            }              
                voltarMenu(scanner);
        } else if (opcao == 3) {
                if (produtos.isEmpty() == true) {

                    System.err.println("Não existem produtos cadastrados.");

                }else{
                    System.out.println( "Produtos e seus dados:\n============================");                
                
                    for (Produto p2 : produtos) {

                    System.out.println(p2 + "\n");

                    }
                    System.out.println("=========================\n");
                }  

                voltarMenu(scanner);
        }else if (opcao == 4) {
                
                
                
                voltarMenu(scanner);
        }else if (opcao == 5) {
                
                
                
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