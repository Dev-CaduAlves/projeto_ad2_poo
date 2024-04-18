
package projetoad2poo;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProjetoAd2POO {

   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
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
            System.out.println(path);
            try{
                File file = new File(path);
                FileReader fileReader = new FileReader(file);
                BufferedReader arq = new BufferedReader(fileReader);
                Cardapio c = new Cardapio();
                String texto = arq.readLine();
                if (texto != null){
                    c.setUnidade(texto);
                }
                texto = arq.readLine();
                while(texto != null){
                    String[] textoSplited = texto.split(";");
                    c.addCardapio(new Prato(textoSplited[0],textoSplited[1], textoSplited[2]));
                    texto = arq.readLine();
                }
                c.infoCardapio();
            }catch(FileNotFoundException e){
                System.err.println("Erro na abertura do arquivo: " + e.getMessage());
            }
            
        }
        
    }
    
}
