
package projetoad2poo;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProjetoAd2POO {

   
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem-vindo(a)!");
        System.out.print("Quantas unidades serão cadastradas? ");
        int totUnidades = sc.nextInt();
        sc.nextLine();
        ArrayList<BufferedReader> listaCardapio = new ArrayList<BufferedReader>();
        for(int i =3; i<=totUnidades; i++){
            String unidade = "";
            System.out.print("Arquivo da Unidade " + i + ": ");
            unidade += sc.next();
            try{
                FileReader f = new FileReader(unidade);
                BufferedReader arq = new BufferedReader(f);
                listaCardapio.add(arq);    
            }catch(FileNotFoundException e){
                System.err.println("Erro na abertura do arquivo.");
            }
            
        }
        
    }
    
}
