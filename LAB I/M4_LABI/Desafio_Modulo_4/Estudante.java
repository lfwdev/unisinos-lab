/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-05-02
 */
/*
 * Instruções no README
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
    // Limpa o console
    public static void cc(){
        System.out.print('\u000C');
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
     * Monta String de opções de mudança de atributo dos estudantes e solicita via Teclado qual opção a ser alterada
    */
    public int alteraDadosEstudantesOptPrompt(){
        // definições de variáveis
        int objectSize = 5;
        int iteration  = 0;
        String optionsPrompt = "Qual informação será alterada? \n [Digite:";
        Object[] options = new Object[objectSize];
        options[0] = "código do estudante";
        options[1] = "nome";
        options[2] = "email";
        options[3] = "data de nascimento";
        options[4] = "senha";
        // creates an string of the options availiable as defined on the object
        for (final Object option : options) 
        {
            optionsPrompt += "\n     *" + (iteration + 1) + " -> " + option;
            // check if it's not the last item then add a comma
            if(objectSize > (iteration + 1)){
                optionsPrompt += ", ";
            }
            iteration++;
        }
        return Teclado.leInt(optionsPrompt + " \n ]");
    }
    /*
     * Seletor que permite a verificação de alteração de dados de acordo com os atributos da classe estudante e dá a opção de alterá-los
    */
    public void alteraDadosEstudante(){
        // Nova linha para clareza no console.
        System.out.println();
        boolean altDadosEst = Teclado.leBoolean("Alterar dados do estudante? [true: sim, false: não]");
        // Caso positivo, verificar quais dados serão alterados
        if(altDadosEst) {
            //
            System.out.println("\n");
            System.out.println("~~ Alteração de dados de estudante ~~");
            // collect input and act accordingly 
            switch(this.alteraDadosEstudantesOptPrompt()) 
            {
                // 
                case 1: //[0] = "código do estudante"
                    String codEstPrompt    = "Digite um inteiro para o código do estudante: ";
                    this.setCodigo(Teclado.leInt(codEstPrompt));
                    break;
                case 2: //[1] = "nome"
                    String nomEstPrompt    = "Digite o nome: ";
                    this.setNome(Teclado.leString(nomEstPrompt));
                    break;
                case 3: //[2] = "email"
                    String emailEstPrompt  = "Digite o email: ";
                    this.setEmail(Teclado.leString(emailEstPrompt));
                    break;
                case 4: //[3] = "data de nascimento";
                    String dtnascEstPrompt = "Digite a data de nascimento: ";
                    this.setDataDeNascimento(Teclado.leString(dtnascEstPrompt));
                    break;
                case 5: //[4] = "senha" 
                    this.resetPassword(this);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente...");
                    this.alteraDadosEstudante();
                    break;
            }
            // Exibe dados e verifica se mais alterações são necessárias
            this.exibeDados();
        }
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
        System.out.println("\n");
        System.out.println("~~ Alteração de Senha ~~");
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
        System.out.println("\n");
        System.out.println("** Dados Pessoais *");
        // Exibir todos os dados da classe
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senha);
        System.out.println("Data de Nascimento: " + dataDeNascimento);
        System.out.println("Cidade: " + cidade.getDescricao());
        System.out.println("UF: " + cidade.getUf());
        // perguntar se precisa alterar dados
        this.alteraDadosEstudante();
    }
}
