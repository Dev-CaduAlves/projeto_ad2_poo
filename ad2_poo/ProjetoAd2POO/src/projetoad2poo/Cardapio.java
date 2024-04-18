
package projetoad2poo;

import java.util.ArrayList;

public class Cardapio {
    private String unidade;
    private ArrayList<Prato> cardapioUnidade;
    
    public Cardapio(){}
    
    public void addCardapio(Prato prato){
        this.cardapioUnidade.add(prato);
    }
    
    public String infoCardapio(){
        String info = null;
        for(Prato prato: cardapioUnidade){
            info += prato.toString();
        }
        return info;
    }
    
    public void setUnidade(String unidade){
        this.unidade = unidade;
    }
    
    public String getUnidade() {return this.unidade;}
    
} 
