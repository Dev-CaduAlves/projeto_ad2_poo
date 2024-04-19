
package projetoad2poo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Cardapio {
    private String unidade;
    private int totalPratos;
    private ArrayList<Prato> pratos;
    
    public Cardapio(){
        this.totalPratos = 0;
        pratos = new ArrayList<>();
    }
    
    public void addCardapio(Prato prato){
        this.pratos.add(prato);
        this.totalPratos++;
    }
    
    public String infoCardapio(){
        String info = "";
        for(Prato prato: pratos){
            info += prato.toString() + "\n";
        }
        return info;
    }
    
    public void setUnidade(String unidade){
        this.unidade = unidade;
    }
    
    public String getUnidade() {return this.unidade;}
  
    public String infoCardapioGeral(String categoria){
        int quantidade = 0;
        float preco = 0f;
        for(Prato prato: pratos){
            String pratoCat = prato.getCategoria();
            if(categoria.equals(pratoCat)){
                quantidade++;
                preco += prato.getPreco();
            }
        }
        NumberFormat valor = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        String info = this.unidade + ": Quantidade = " + quantidade + ", Preço = " +  valor.format(preco);
        return info;
    }
    
    public String infoCardapioDetalhe(String categoria){
        String info = "";
        for(Prato prato: pratos){
            if(categoria.equals(prato.getCategoria())){
                info += prato.toString() + "\n";
            }
        }
        return info;
    }
    
    public int infoQuantidadePorCategoria (String categoria){
        int quantidade = 0;
        for(Prato prato: pratos){
            if(categoria.equals(prato.getCategoria())){
                quantidade++;
            }
        }
        return quantidade;
    }
    
    public float infoPrecoPorCategoria (String categoria){
        float preco = 0f;
        for(Prato prato: pratos){
            if(categoria.equals(prato.getCategoria())){
                preco += prato.getPreco();
            }
        }
        return preco;
    }
} 
