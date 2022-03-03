public class DispositivoMovel
{
    // instance variables - replace the example below with your own
    private String marca;
    private String modelo;
    //
    public DispositivoMovel(String marca, String modelo)
    {
        this.setMarca(marca);
        this.setModelo(modelo);
    }
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }
    public String getMarca()
    {
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    //
    public void exibeDados(){
        System.out.println("Marca" + this.marca);
        System.out.println("Modelo" + this.modelo);
    }
}
