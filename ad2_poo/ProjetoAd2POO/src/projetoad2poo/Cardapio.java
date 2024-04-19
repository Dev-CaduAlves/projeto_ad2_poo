
package projetoad2poo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Cardapio {
    private String unidade; //Nome da Unidade do Cardápio
    private int totalPratos; //Total de Pratos presentes no Cardápio
    private ArrayList<Prato> pratos; //Lista que armazenará os pratos do Cardápio
    
    //Método Construtor da Classe Cardapio
    public Cardapio(){
        this.totalPratos = 0; //Inicializa o atributo totalPratos
        pratos = new ArrayList<>(); //Inicializa o atributo lista de pratos
    }
    
    //Método que adiciona o prato à lista pratos do Cardápio
    public void addCardapio(Prato prato){
        this.pratos.add(prato); //Adiciona o prato ao cardápio
        this.totalPratos++; //Incrementa no total de pratos
    }
    
    //Método que retorna as informações de todos os pratos do cardápio
    public String infoCardapio(){
        String info = ""; //Inicializa a variável como String vazia
        for(Prato prato: pratos){ //Em cada prato, incrementa na info as informações dele
            info += prato.toString() + "\n";
        }
        return info;
    }
    
    //Método que retorna as informações resumidas dos pratos de determinada
    //categoria
    public String infoCardapioGeral(String categoria){
        int quantidade = 0; //Inicializa a variável quantidade
        float preco = 0f; //Inicializa a variável preço
        for(Prato prato: pratos){ //Em cada prato do cardápio
            String pratoCat = prato.getCategoria();
            if(categoria.equals(pratoCat)){ //Verifica a categoria
                quantidade++; //Incrementa na quantidade
                preco += prato.getPreco(); //Incrementa o preco
            }
        }
        NumberFormat valor = NumberFormat.getCurrencyInstance(new Locale("pt","BR")); //Classe Abstrata para formatar a variável preço em Currency (Real)
        String info = this.unidade + ": Quantidade = " + quantidade + ", Preço = " +  valor.format(preco);
        return info;
    }
    
    //Método que retorna as informações detalhadas dos pratos de determinada
    //categoria
    public String infoCardapioDetalhe(String categoria){
        String info = "";
        for(Prato prato: pratos){
            if(categoria.equals(prato.getCategoria())){
                info += prato.toString() + "\n";
            }
        }
        return info;
    }
    
    //Método que retorna a quatidade de pratos de determinada categoria
    public int infoQuantidadePorCategoria (String categoria){
        int quantidade = 0;
        for(Prato prato: pratos){
            if(categoria.equals(prato.getCategoria())){
                quantidade++;
            }
        }
        return quantidade;
    }
    
    //Método que retorna o preço total de pratos de determinada categoria
    public float infoPrecoPorCategoria (String categoria){
        float preco = 0f;
        for(Prato prato: pratos){
            if(categoria.equals(prato.getCategoria())){
                preco += prato.getPreco();
            }
        }
        return preco;
    }
    
    //Bloco de métodos setters e getters da Classe Cardapio
    public void setUnidade(String unidade){this.unidade = unidade;}
    
    public String getUnidade() {return this.unidade;}
  
    
} 
