
package projetoad2poo;

import java.util.ArrayList;

public class Cardapio {
    ArrayList<Prato> cardapioUnidade;
    
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
    
} 
