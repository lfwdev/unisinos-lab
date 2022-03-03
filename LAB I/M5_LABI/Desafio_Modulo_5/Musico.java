/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-05-26
 */
public class Musico extends Artista
{
    // instance variables - replace the example below with your own
    private String genero;
    private String instrumento;
    /**
     * Constructor
     */
    public Musico(String nome,String dataNasc,String nacionalidade,String genero,String instrumento)
    {
        super(nome,dataNasc,nacionalidade);
        this.setGenero(genero);
        this.setInstrumento(instrumento);
    }
    /*
     * Estilo setters and getters
    */
    public void setGenero(String genero)
    {
        this.genero = genero;
    }
    public String getGenero()
    {
        return this.genero;
    }
    /*
     * Instrumento setters and getters
    */
    public void setInstrumento(String instrumento)
    {
        this.instrumento = instrumento;
    }
    public String getInstrumento()
    {
        return this.instrumento;
    }
    /*
     * exibeDados - método que exibe os dados do musico no console
    */
    public void exibeDados()  
    {
        super.exibeDados();
        System.out.printf("Gênero Musical: %s \n",this.genero);
        System.out.printf("Instrumento: %s \n",this.instrumento);
    }
    /*
     * Cadastro - Recebe boolean para definir se exibe dados após cadastrar ou não
    */
    public static void cadastro(boolean exibeDados){
        String[] dados       = Artista.cadastro();
        //
        String genero        = Teclado.leString("Gênero Musical:");
        String instrumento   = Teclado.leString("Instrumento:");
        //
        Musico artista = new Musico(dados[0],dados[1],dados[2],genero,instrumento);
        //
        if(exibeDados)
            artista.exibeDados();
    }
}
