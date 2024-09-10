/******************************************************************************

programa java que contenha interface, classes abstratas e na
classe principal seja tratada o funcionamento de
uma padaria.
Sendo que a padaria deve ter em seu siatema de caixa
os valores de seus produtos e o registro de pedidos de seus clientes
para itens especiais como por exemplo:
bolos de aniversario,
pizzas
e salgados para festas.
O seu cod. deve mostrar na saida os valores
dos produtos adquiridos considerando produtos convencionais como
por exemplo:
pao de sal, de queijo, biscoito doces e salgados,
totelex,
e que cada um tenha seu respectivo valor. também deve constexpros itens
bebidas, como por exemplo: cafe expresso, com leite, leite quente, sucos em geral
refrigerantes em geral, e outras bebidas.

*******************************************************************************/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.text.DecimalFormat;

//interface
interface Informacao{
    String getNomeProduto();
    double getPrecoProduto();
}

// superclasse abstrata com implementacao da interface INFORMACAO
abstract class Itens implements Informacao{
    private String nomeProduto; //objetos herdados da interface INFORMACAO
    private double precoProduto;
    
    //Metodo construtor que inicializa os objetos da classe ITENS
    public Itens(String nomeProduto, double precoProduto){
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        
    }
    
    //implementacao da interface INFORMACAO para retornar os objetos NOMEPRODUTO e precoProduto
    public String getNomeProduto(){
        return nomeProduto;
    }
    public double getPrecoProduto(){
        return precoProduto;
    }
}
// Classe comida extendendo a classe mae
class Comidas extends Itens{
    public Comidas(String nomeProduto, double precoProduto){
        super(nomeProduto, precoProduto);
    }
}
// Classe bebidas extendendo a classe mae
class Bebidas extends Itens{
    public Bebidas(String nomeProduto, double precoProduto){
        super(nomeProduto, precoProduto);
    }
}

//classe principal
public class Main{
        // Método para limpar a tela do console (para Windows)
        public static void cls() {
    String os = System.getProperty("os.name").toLowerCase();
    try {
        ProcessBuilder processBuilder;
        if (os.contains("win")) {
            processBuilder = new ProcessBuilder("cmd", "/c", "cls");
        } else {
            processBuilder = new ProcessBuilder("clear");
        }
        processBuilder.inheritIO().start().waitFor();
    } catch (IOException | InterruptedException e) {
        System.out.println("Erro ao limpar o console: " + e.getMessage());
    }
}
    
        public static void main(String[] args){
            Scanner leia = new Scanner(System.in);//execucao da biblioteca SCANNER
            List<Itens> compras = new ArrayList<>();//Arrey para armazenar as informacoes
            double totalPedido = 0.0;//variavel de armazernamento dos pedidos
            
            DecimalFormat df = new DecimalFormat("#.00");
        
            //loop de menu
            while(true){
                //cls();
                System.out.println("__________Nostro Pane de Dio__________");
                System.out.println("Por gentileza escolha o(s) seu(s) Pedido(s)");
                System.out.println("__________----------------__________");
                System.out.println("[1] - Para Comidas [2] Para Bebidas [3] Sair.");
                int escolhas = leia.nextInt();
                
                if (escolhas == 1){
                    cls();
                    System.out.println("\n");
                    System.out.println("[1] Bolo de Aniversário.");
                    System.out.println("[2] Pizza Doce.");
                    System.out.println("[3] Pizza Salgada.");
                    System.out.println("[4] Salgado para festas.");
                    System.out.println("[5] Gabriella do 302.");
                    System.out.println("[6] Pão de Sal.");
                    System.out.println("[7] Pão de Queijo..");
                    System.out.println("[8] Biscoito de Doce.");
                    System.out.println("[9] Biscoito de Sal.");
                    System.out.println("[10] Tortilex.");
                    //System.out.println("[0] ENCERRAR");
            
                    int opcao = leia.nextInt();
                    cls();
                    //if (opcao == 0) break;
                    //cls();
                    Itens selecionados = null; //inicializador da variavel SELECIONADOS
                    switch(opcao){
                        case 1: selecionados = new Comidas("Bolo de Aniversário", 80.00); break;
                        case 2: selecionados = new Comidas("Pizza Doce",66.00); break;
                        case 3: selecionados = new Comidas("Pizza Salgada",56.00); break;
                        case 4: selecionados = new Comidas("Salgado para Festas",82.00); break;
                        case 5: selecionados = new Comidas("Gabriela do 302",250.00); break;
                        case 6: selecionados = new Comidas("Pão de sal - Unidade",0.15); break;
                        case 7: selecionados = new Comidas("Pão de Queijo Unidade",1.50); break;
                        case 8: selecionados = new Comidas("Biscoito Doce Unidade",2.00); break;
                        case 9: selecionados = new Comidas("Biscoito Salgado Unidade",1.50); break;
                        case 10: selecionados = new Comidas("Tortilex Unidade",3.00); break;
                        default: System.out.println("*OPÇÃO INVALIDA! TENTE NOVAMENTE.*");
                    }
           
                    if (selecionados != null){
                        compras.add(selecionados);
                        totalPedido += selecionados.getPrecoProduto();
                        System.out.println("ADICIONADO A LISTA >> ["+selecionados.getNomeProduto()+"]\n");
                    }
                }
                if (escolhas == 2){
                    cls();
                        System.out.println("\n");
                        System.out.println("[1] Café Expresso.");
                        System.out.println("[2] Café com Leite.");
                        System.out.println("[3] Chocolate Quente.");
                        System.out.println("[4] Refrigerante.");
                        System.out.println("[5] Suco.");
                        System.out.println("[0] RETORNAR.");
            
                        int opcao = leia.nextInt();
                        cls();
                        if (opcao == 0) break;
                        //cls();
                        Itens selecionados = null; //inicializador da variavel SELECIONADOS
                        switch(opcao){
                            case 1: selecionados = new Comidas("Café EExpresso", 2.80); break;
                            case 2: selecionados = new Comidas("Café com Leite",2.00); break;
                            case 3: selecionados = new Comidas("Chocolate Quente",6.00); break;
                            case 4: selecionados = new Comidas("Refrigerante",5.50); break;
                            case 5: selecionados = new Comidas("Suco",3.00); break;
                            //case 0: break;
                            default: System.out.println("*OPÇÃO INVALIDA! TENTE NOVAMENTE.*");
                        }
           
                        if (selecionados != null){
                            //cls();
                            compras.add(selecionados);
                            totalPedido += selecionados.getPrecoProduto();
                            System.out.println("Adicionado a Lista ["+selecionados.getNomeProduto()+"]");
                        }
                    
                }
                if (escolhas == 3)break;
            }
            cls();
            System.out.println("______________________________");
                System.out.println("****|TENS SELECIONADOS|****\n");
                for (Itens item : compras){
                    System.out.println("[>"+item.getNomeProduto() +" R$"+ item.getPrecoProduto());
                    }
            System.out.println("\nTotal a Pagar: R$" + df.format(totalPedido));
                leia.close();
        }
    }