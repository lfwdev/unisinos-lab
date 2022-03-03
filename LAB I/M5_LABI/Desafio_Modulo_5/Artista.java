/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-05-26
 */
public class Artista
{
    // instance variables - replace the example below with your own
    private String nome;
    private String dataNasc;
    private String nacionalidade;
    /**
     * Constructor
     */
    public Artista(String nome,String dataNasc,String nacionalidade)
    {
        // initialise instance variables
        this.setNome(nome);
        this.setDataNasc(dataNasc);
        this.setNacionalidade(nacionalidade);
    }
    /*
     * Nome setters and getters
    */
    public void setNome(String name)
    {
        this.nome = name;
    }
    public String getNome()
    {
        return this.nome;
    }
    /*
     * DataDeNascimento setters and getters
    */
    public void setDataNasc(String dataDeNascimento)
    {
        this.dataNasc = dataDeNascimento;
    }
    public String getDataNasc()
    {
        return this.dataNasc;    
    }
    /*
     * nacionalidade setters and getters
    */
    public void setNacionalidade(String nacionalidade)
    {
        this.nacionalidade = nacionalidade;
    }
    public String getNacionalidade()
    {
        return this.nacionalidade;    
    }
    /*
     * Cadastro - Faz a parte mais básica da coleta dos dados de cadastro e retorna uma array de strings
    */
    public static String[] cadastro()  
    {
        //
        String[] dados =
        {
            Teclado.leString("Nome:"),
            Teclado.leString("Data de Nascimento:"),
            Teclado.leString("Nacionalidade:")
        };
        //
        return dados;
    }
    /*
     * exibeDados - método que exibe os dados do artista no console
    */
    public void exibeDados()  
    {
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println("\n");
        System.out.println("** Dados do artista *");
        // Exibir todos os dados da classe
        System.out.printf("Nome: %s \n",this.getNome());
        System.out.printf("Data de Nascimento: %s \n",this.getDataNasc());
        System.out.printf("Nacionalidade: %s \n",this.getNacionalidade());
    }
}