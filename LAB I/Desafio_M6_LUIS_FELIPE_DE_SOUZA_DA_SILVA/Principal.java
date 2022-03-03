/**
 * @author Luís Felipe de Souza
 * @version 2021-06-14
 */
public class Principal
{
    /**
     * MAIN
     */
    public Principal()
    {
        /* 
         * Crie um array de Universidade com o número 
         * de posições indicadas pelo usuário via teclado. 
         *
         * Em cada posição deste array, crie Universidades Públicas 
         * ou Privadas, de acordo com a vontade do usuário (ou seja, 
         * pergunte ao usuário via teclado que tipo de Universidade 
         * ele deseja inserir em cada posição).
        */
        Object[] uni = cadUni();
        /* 
         * Utilizando um objeto do tipo MEC, imprima as informações 
         * de todas as Universidades do array.
        */
        MEC.imprimeUniversidades(uni);
        /* 
         * Utilizando um objeto do tipo MEC, imprima as informações 
         * da Universidade Privada mais cara do array
        */
        MEC.maisCara(uni);
        /* 
         * Utilizando um objeto do tipo MEC, imprima as informações 
         * de todas as Universidades Públicas da região Sul do Brasil
        */
        MEC.universidadesDoSul(uni);
    }
    /**
     * cadUniObj
     * Permite ao usuário informar o número de universidades a serem cadastradas.
     */
    private Object[] cadUniObj()
    {
        String msg_caduni = "Informe o número de universidades que deseja cadastrar: \n";
        // recebe um int com o número de universidades a serem cadastradas
        int len = Teclado.leInt(msg_caduni);
        // cria um novo objeto de tamanho definido pelo valor informado e o retorna
        Object[] uni = new Object[len]; 
        return uni;
    }
    /**
     * cadUni
     * Permite ao usuário cadastrar múltiplas universidades.
     */
    public Object[] cadUni() {
        // limpa o console
        System.out.print('\u000C');
        Object[] uni = cadUniObj();
        // Verifica o comprimento da array tal como definido no método cadUniObj
        for(int i = 0; uni.length > i; i++){
            // Permite ao usuário criar um novo objeto do tipo MEC para cada universidade chamando ao método cadSingleUni
            uni[i] = cadSingleUni();
        }
        // retorna um objeto contendo todos objetos do tipo mec criados
        return uni;
    }
    /**
     * cadUniNome
     * Coleta nome de instituição
     */
    private String cadUniNome(){
        String msg_nome = "Informe o nome da instituição: \n";
        return Teclado.leString(msg_nome);
    }
    /**
     * cadUniQA
     * Coleta quantidade de alunos da instituição
     */
    private int cadUniQA(){
        String msg_qA = "Informe a quantidade de alunos: \n";
        return Teclado.leInt(msg_qA);
    }
    /**
     * cadUniQP
     * Coleta quantidade de professores da instituição
     */
    private int cadUniQP(){
        String msg_qP     =  "Informe a quantidade de professores: \n";
        return Teclado.leInt(msg_qP);
    }
    /**
     * cadSingleUni
     * Permite ao usuário cadastrar uma universidade publica ou privada e armazena esta em um objeto do tipo MEC.
     */
    private MEC cadSingleUni()
    {
        System.out.print('\u000C');
        System.out.println("\n" + "CADASTRAR NOVA UNIVERSIDADE" + "\n");
        // coleta o tipo de universidade via teclado
        String msg_tipo   = "Digite [0] para universidade pública e [1] para privada: \n";
        int tipo = Teclado.leInt(msg_tipo);
        // declara novo objeto do tipo MEC
        MEC uni;
        // verifica se o tipo informado é publica ou privada e passa a responsabilidade de criação para os devidos métodos (cadSinglePublicUni, cadSinglePrivateUni)
        // caso seja informada uma opção incorreta é refeita a chamada ao método, após isso retorna o objeto do tipo MEC
        if(tipo == 0)    
            uni = new MEC(cadSinglePublicUni(),0);
        else if(tipo == 1)
            uni = new MEC(cadSinglePrivateUni(),1);
        else
            uni = cadSingleUni();
        return uni;
    }
    /**
     * cadSinglePrivateUni
     * Permite ao usuário cadastrar uma universidade Privada.
     */
    private Privada cadSinglePrivateUni()
    {
        // coleta os valores relacionados a objetos do tipo privada
        double custo = Teclado.leDouble("Informe o valor da mensalidade: \n");
        // cria novo objeto do tipo privada e o retorna 
        Privada uni  = new Privada(cadUniNome(),cadUniQA(),cadUniQP(),custo);
        return uni;
    }
    /**
     * cadSinglePublicUni
     * Permite ao usuário cadastrar uma universidade Pública.
     */
    private Publica cadSinglePublicUni()
    {
        // coleta os valores relacionados a objetos do tipo publica
        String estado = Teclado.leString("Informe UF da instituição: \n");
        String cidade = Teclado.leString("Informe Município da instituição: \n");
        // cria novo objeto do tipo publica e o retorna 
        Publica uni   = new Publica(cadUniNome(),cadUniQA(),cadUniQP(),estado,cidade);
        return uni;
    }
}
