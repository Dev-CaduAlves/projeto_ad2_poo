
package projetoad2poo;

import java.util.ArrayList;

public class Cardapio {
    private String unidade;
    private int totalPratos;
    private ArrayList<Prato> Pratos;
    
    public Cardapio(){
        this.totalPratos = 0;
        Pratos = new ArrayList<>();
    }
    
    public void addCardapio(Prato prato){
        this.Pratos.add(prato);
        this.totalPratos++;
    }
    
    public String infoCardapio(){
        String info = "";
        for(Prato prato: Pratos){
            info += prato.toString() + "\n";
        }
        return info;
    }
    
    public void setUnidade(String unidade){
        this.unidade = unidade;
    }
    
    public String getUnidade() {return this.unidade;}
  
    public String infoCardapio(String categoria){
        int quantidade = 0;
        float preco = 0f;
        for(Prato prato: Pratos){
            String pratoCat = prato.getCategoria();
            if(pratoCat.equals(categoria)){
                quantidade++;
                preco += prato.getPreco();
            }
        }
        String info = this.unidade + ": Quantidade = " + quantidade + ", Preço = R$ " +  String.format("%s.2f",preco);
        return info;
    }
} 
