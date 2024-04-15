
package projetoad2poo;


public class Prato {
    private String nome;
    private float preco;
    private String categoria;
    
    public Prato (){
        
    }
    
    public String getNome(){return nome;}
    public float getPreco(){return preco;}
    public String getCategoria(){return categoria;}
    
    public void setNome(String nome){this.nome = nome;}
    public void setPreco(float preco){this.preco = preco;}
    public void setCategoria(String categoria){this.categoria = categoria;}
    
    @Override
    public String toString(){
        return this.nome + " -> " + this.preco;
    }
}
