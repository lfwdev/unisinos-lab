/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-05-26
 */
public class Pintor extends Artista
{
    // instance variables - replace the example below with your own
    private String estilo;
    /**
     * Constructor
     */
    public Pintor(String nome,String dataNasc,String nacionalidade,String estilo)
    {
        super(nome,dataNasc,nacionalidade);
        this.setEstilo(estilo);
    }
    /*
     * Estilo setters and getters
    */
    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }
    public String getEstilo()
    {
        return this.estilo;
    }
    /*
     * exibeDados - método que exibe os dados do pintor no console
    */
    public void exibeDados()  
    {
        super.exibeDados();
        System.out.printf("Estilo: %s \n",this.estilo);
    }
    /*
     * Cadastro - Recebe boolean para definir se exibe dados após cadastrar ou não
    */
    public static void cadastro(boolean exibeDados){
        String[] dados = Artista.cadastro();
        Pintor artista = new Pintor(dados[0],dados[1],dados[2],Teclado.leString("Estilo:"));
        if(exibeDados)
            artista.exibeDados();
    }
}