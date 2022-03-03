/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-04-19
 */
/*
    4: Crie a classe: Estudante com os seguintes atributos:
        Código = tipo de dados inteiro
        Nome = tipo de dados texto
        Data de nascimento = tipo de dados texto
        Email = tipo de dados texto
        Senha = tipo de dados texto
        Cidade = tipo de dados Cidade
    
    5: Crie os seguintes métodos na classe Estudante:
        Construtor que receba como parâmetro os valores dos atributos:
            Código
            Nome
            Data de nascimento
            Email
            Senha
            Cidade
            (
                o método construtor deve fazer uso também do método 
                adicionaNovoEstudante da classe Cidade, para que, a 
                cada novo estudante cadastrado para um determinado 
                curso (associação simples entre classes), seja calculada e 
                armazenada a quantidade de estudantes para a cidade selecionada
            )
        
    Métodos de acesso (GET) para todos os atributos
    Métodos de configuração (SET) para todos os atributos
    Método exibeDados para apresentar todos os dados da classe   
*/
public class Estudante
{
    /*
     * Atributos
    */
    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private String dataDeNascimento;
    private Cidade cidade;
    /*
     * Construtor
    */
    public Estudante(
         int codigo,
         String nome,
         String email,
         String senha,
         String dataDeNascimento,
         Cidade cidade
    )
    {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setDataDeNascimento(dataDeNascimento);
        this.setCidade(cidade);
        cidade.adicionaNovoEstudante();
    }
    /*
     * Código setters and getters
    */
    public void setCodigo(int cod)
    {
        this.codigo = cod;
    }
    public int getCodigo()
    {
        return this.codigo;
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
     * Email setters and getters
    */
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;    
    }
    /*
     * Senha setters and getters
    */
    public void setSenha(String senha)
    {
        this.senha = senha;
    }
    public String getSenha()
    {
        return this.senha;    
    }
    /*
     * DataDeNascimento setters and getters
    */
    public void setDataDeNascimento(String dataDeNascimento)
    {
        this.dataDeNascimento = dataDeNascimento;
    }
    public String getDataDeNascimento()
    {
        return this.dataDeNascimento;    
    }
    /*
     * Cidade setters and getters
    */
    public void setCidade(Cidade cidade)
    {
        this.cidade = cidade;
    }
    public Cidade getCidade()
    {
        return this.cidade;    
    }
    /*
     * Possibilita a troca de senha
    */
    public static void resetPassword(Estudante estudante)
    {
        String msgSuccess = "Senha alterada!";
        String tryAgain = "Tente novamente...";
        String msgFail = "Senhas não coincidem, senha não alterada!";
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println();
        System.out.println("* Troca de senha para " + estudante.getNome() + " *");
        // Solicita a senha atual do estudante em questão.
        String currPassPrompt = "Digite a senha atual: ";
        String currPass = Teclado.leString(currPassPrompt);
        // Compara duas strings de senha e caso estejam corretas,
        // procede com a troca de senha, caso contrário, avisa o usuário e reinicia.
        if(estudante.comparePassword(estudante.getSenha(),currPass))
        {
            String newPassPrompt1 = "Digite a nova senha: ";
            String newPass1 = Teclado.leString(newPassPrompt1);
            String newPassPrompt2 = "Repita a nova senha: ";
            String newPass2 = Teclado.leString(newPassPrompt2);
            if(estudante.comparePassword(newPass2,newPass1))
            {
                estudante.setSenha(newPass2);
                System.out.println(msgSuccess);
            }
            else
            {
                System.out.println(msgFail);
                System.out.println(tryAgain);
                estudante.resetPassword(estudante);
            }
        }
        else
        {
            System.out.println(msgFail);
            System.out.println(tryAgain);
            estudante.resetPassword(estudante);
        }
    }
    /*
     * Compara duas strings de senha e retorna true ou false, 
     * foi colocado em método separado para possiblitar expansão da lógica
     * case necessário no futuro
    */
    public Boolean comparePassword(String p1, String p2)
    {
        return p1.equals(p2);
    }
    /*
     * exibeDados - método que exibe os dados do Estudante no console
    */
    public void exibeDados()  
    {
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println();
        System.out.println("* Dados Pessoais *");
        // Exibir todos os dados da classe
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senha);
        System.out.println("Data de Nascimento: " + dataDeNascimento);
        System.out.println("Cidade: " + cidade.getDescricao());
        System.out.println("UF: " + cidade.getUf());
    }
}
