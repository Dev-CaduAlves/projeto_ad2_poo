
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
        ArrayList<Cardapio> cardapios = new ArrayList<>(); //Lista que receberá as instâncias da classe Cardápio
        Locale locale = new Locale("pt", "BR");
        NumberFormat formato = NumberFormat.getCurrencyInstance(locale);
        int totUnidades = 0;
        System.out.println("Seja bem-vindo(a)!");
        System.out.print("Quantas unidades serão cadastradas? ");
        totUnidades = sc.nextInt(); //Recebe a entrada de quantidade de Cardápios
        sc.nextLine(); //Faz o debuffer do Scanner
        for(int i=1; i<=totUnidades; i++){ //Realiza a leitura para cada cardapio fornecido
            String unidade = "";                  
            System.out.print("Arquivo da Unidade " + i + ": ");
            unidade += sc.nextLine();
            String path = System.getProperty("user.dir");
            path += "\\src\\projetoad2poo\\doc\\" + unidade;
            //Bloco que tenta realizar a leitura dos arquivos TXT
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
                
                //Faz um loop enquanto houver linha escrita no arquivo TXT e realiza a 
                //instanciação da classe Prato diretamente na lista de pratos da Classe Cardapio
                while(texto != null){ 
                    String[] textoSplited = texto.split(";");
                    c.addCardapio(new Prato(textoSplited[0].strip()
                            ,textoSplited[1].strip(), textoSplited[2].strip()));
                    texto = arq.readLine();
                }
                cardapios.add(c);
                }catch(FileNotFoundException e){
                System.err.println("Erro na abertura do arquivo: " + e.getMessage()+"\nTente Novamente!");
                i--;
            }
        }
        String opcao = "";
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
