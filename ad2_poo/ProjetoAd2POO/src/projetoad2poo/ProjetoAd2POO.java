
package projetoad2poo;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class ProjetoAd2POO {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem-vindo(a)!");
        System.out.print("Quantas unidades serão cadastradas? ");
        int totUnidades = sc.nextInt();
        ArrayList<String> listaCardapio = new ArrayList<String>();
        for(int i = 1; i <= totUnidades; i++){
            System.out.print("Arquivo da Unidade " + i + ": ");
            String unidade = sc.nextLine();
            listaCardapio.add(unidade);
            
        }
    }
    
}
