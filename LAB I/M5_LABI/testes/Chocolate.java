public class Chocolate
{
    private String marca;
    private int peso;
    private int calorias;

    public Chocolate(String marca, int peso, int calorias){
        this.marca = marca;
        this.peso = peso;
        this.calorias = calorias;
    }

    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String novaMarca){
        marca = novaMarca;
    }
    
    public int getPeso(){
        return peso;
    }
    
    public void setPeso(int novoPeso){
        peso = novoPeso;
    }
    
    public int getCalorias(){
        return calorias;
    }
    
    public void setCalorias(int novaCalorias){
        calorias = novaCalorias;
    }
    
    public void exibeDados(){
    System.out.println("\n*** Informações do chocolate ***");
    System.out.println("Marca: " + marca + ";");
    System.out.println("Peso: " + peso + " gramas;");
    System.out.println("Calorias: " + calorias + " calorias;");
    }
}