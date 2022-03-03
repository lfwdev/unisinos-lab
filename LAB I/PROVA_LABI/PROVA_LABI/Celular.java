/**
 * Crie uma classe chamada Celular, 
 * que é uma subclasse de DispositivoMovel. 
 * Esta subclasse deve possuir um atributo 
 * referente ao número deste celular (armazene como String). 
 * Crie o construtor, os métodos de acesso necessários e 
 * sobrescreva o método exibeDados, para exibir as 
 * informações da classe.
 */
public class Celular extends DispositivoMovel
{
    private String numero;
    
    public Celular(String marca, String modelo, String numero)
    {
        super(marca,modelo);
        this.setNumero(numero);
    }
    public void setNumero(String numero)
    {
        this.numero = numero;
    }
    public String getNumero()
    {
        return this.numero;
    }
    public void exibeDados()
    {
        super.exibeDados();
        System.out.println("Número: " + this.getNumero());
    }
}
