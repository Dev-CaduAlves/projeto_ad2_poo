
package projetoad2poo;

public class Prato {
    private String nome;
    private float preco;
    private String categoria;
    
    //Método Constutor da Classe Prato
    public Prato (String nome, String preco, String categoria){
        this.nome = nome;
        this.preco = Float.parseFloat(preco);
        this.categoria = categoria.toLowerCase();    
    }
    
    //Bloco de Métodos Getters e Setters
    public String getNome(){return this.nome;}
    public float getPreco(){return this.preco;}
    public String getCategoria(){return this.categoria;}
    public void setNome(String nome){this.nome = nome;}
    public void setPreco(float preco){this.preco = preco;}
    public void setCategoria(String categoria){this.categoria = categoria;}
    
    //Faz uma sobrecarga no método toString
    @Override
    public String toString(){
        return this.nome + " -> " + this.preco;
    }
}
