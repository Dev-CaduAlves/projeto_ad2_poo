
package projetoad2poo;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class ProjetoAd2POO {

   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cardapio> cardapios = new ArrayList<Cardapio>();
        Locale locale = new Locale("pt", "BR");
        NumberFormat formato = NumberFormat.getCurrencyInstance(locale);
        
        System.out.println("Seja bem-vindo(a)!");
        System.out.print("Quantas unidades serão cadastradas? ");
        int totUnidades = sc.nextInt(); //Recebe a entrada de quantidade de Cardápios
        sc.nextLine(); //Faz o debuffer do Scanner
        ArrayList<BufferedReader> listaCardapio = new ArrayList<BufferedReader>();
        for(int i=1; i<=totUnidades; i++){
            String unidade = "";
            System.out.print("Arquivo da Unidade " + i + ": ");
            unidade += sc.next();
            String path = System.getProperty("user.dir");
            path += "\\src\\projetoad2poo\\doc\\" + unidade;
            try{
                File file = new File(path);
                FileReader fileReader = new FileReader(file);
                BufferedReader arq = new BufferedReader(fileReader);
                
                Cardapio c = new Cardapio();
                String texto = arq.readLine();
                
                //Realiza a leitura do nome da Unidade
                //(primeira linha do arquivo de texto
                if (texto != null){
                    c.setUnidade(texto);
                }
                texto = arq.readLine();
                
                //Adiciona os pratos ao cardápio
                while(texto != null){
                    String[] textoSplited = texto.split(";");
                    c.addCardapio(new Prato(textoSplited[0].strip(),textoSplited[1].strip(), textoSplited[2].strip()));
                    texto = arq.readLine();
                }
                cardapios.add(c);
                }catch(FileNotFoundException e){
                System.err.println("Erro na abertura do arquivo: " + e.getMessage());
                System.exit(0);
            }
        }
        String opcao = "";
        sc.nextLine();
        while(!"0".equals(opcao)){
            System.out.print("Escolha uma categoria, ou digite “0” para encerrar: ");
            opcao = sc.nextLine().toLowerCase();
            switch (opcao){
                case "prato principal" : case "sobremesa" : case "entrada": {
                    String categoria = opcao;
                    int quantidadePratos = 0;
                    float precoPratos = 0f;
                    for(Cardapio cardapio: cardapios){
                        quantidadePratos += cardapio.infoQuantidadePorCategoria(categoria);
                        precoPratos += cardapio.infoPrecoPorCategoria(categoria);
                        System.out.println(cardapio.infoCardapioGeral(categoria));
                    }
                    System.out.println("Total: Quantidade = " + quantidadePratos + ", Preço = " + formato.format(precoPratos));
                    System.out.println("");
                    System.out.print("Exibir Detalhes (“s” ou “n”)? ");
                    switch (opcao = sc.nextLine()) {
                        case "s" -> {
                            for(Cardapio cardapio: cardapios){
                                System.out.println(cardapio.getUnidade() + ":");
                                System.out.println(cardapio.infoCardapioDetalhe(categoria));
                            }
                        }
                        case "n" -> {
                            break;
                        }
                        default -> {
                            System.err.println("Entrada Inválida");
                        }    
                    }
                }
            }    
        }
    }
}
