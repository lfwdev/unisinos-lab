/**
 * @author Luís Felipe de Souza
 * @version 2021-06-14
 */
public class MEC
{
    private Object uni;
    private int tipo;
    /**
     * MAIN
     */
    public MEC(Object uni,int tipo)
    {
       this.setTipo(tipo);
       this.setUni(uni);
    }
    /**
     * Setters and getters
     */
    public int getTipo() {
        return this.tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public Object getUni() {
        return this.uni;
    }
    public void setUni(Object uni) {
        this.uni = uni;
    }
    /**
     * imprimeUniversidades(obj)
     * Recebe um objeto e imprime as informações de 
     * todas as Universidades, indicando na impressão o tipo da 
     * Universidade (Publica ou Privada).
    */
    public static void imprimeUniversidades(Object[] obj)
    {
        System.out.println("\n UNIVERSIDADES \n");
        // É feito um loop utilizando o objeto imutável singleton derivado do objeto obj que contém objetos do tipo MEC, Publica e Privada
        for (final Object singleton : obj) 
        {
            // é feita a conversão do singleton para um objeto do tipo MEC
            MEC mec   = (MEC)singleton;
            // é definido o tipo da universidade armazenada no singleton 
            int tipo  = mec.getTipo();
            // verifica se a universidade é publica ou privada
            if(tipo == 0)  {
                System.out.println("\n INSTITUIÇÃO PUBLICA: \n");
                // converte o objeto para o tipo Publica
                Publica uni = (Publica)mec.getUni();
                // imprime as informações 
                uni.imprimeInfo();
            }
            else if(tipo == 1) {
                System.out.println("\n INSTITUIÇÃO PRIVADA: \n");
                // converte o objeto para o tipo Privada
                Privada uni = (Privada)mec.getUni();
                // imprime as informações 
                uni.imprimeInfo();
            }
        }
    }
    /**
     * maisCara
     * recebe um objeto e imprime as informações 
     * da Universidade Privada mais cara do array
     */
    public static void maisCara(Object[] obj)
    {
        System.out.println("\n UNIVERSIDADES MAIS CARA \n");
        // São definidas as variáveis Double valor para armazenar o valor e a variável maisCara que armazenará um objeto do tipo Privada.
        Double valor = 0.0;
        Privada maisCara = null;
        // É feito um loop utilizando o objeto obj que contém objetos do tipo MEC, Publica e Privada
        for (final Object singleton : obj) 
        {
            // é feita a conversão do singleton para um objeto do tipo MEC
            MEC mec   = (MEC)singleton;
            // é definido o tipo da universidade armazenada no singleton 
            int tipo  = mec.getTipo();
            // verifica se a universidade é privada
            if(tipo == 1) {
                // é feita a conversão do objeto para o tipo Privada
                Privada uni = (Privada)mec.getUni();
                // compara o valor da mensalidade com o valor armazenado na variável valor, 
                // caso seja maior sobrescreve o mesmo com o novo valor 
                // e atribui a variável mais cara um objeto do tipo Privada
                if(uni.getValorMensalidade() > valor) {
                    valor    = uni.getValorMensalidade();
                    maisCara = uni;
                }
            }
        }
        // verifica se foi informada uma universidade privada
        if(maisCara != null)
        {
            // Chama o método imprimeInfo() da classe Privada.
            maisCara.imprimeInfo();
        }
    }
    /**
     * universidadesDoSul
     * recebe um array de Universidade e imprime as informações das 
     * Universidades Públicas do Sul do Brasil (ou seja, RS, SC e PR)
     */
    public static void universidadesDoSul(Object[] obj)
    {
        System.out.println("\n UNIVERSIDADES DO SUL \n");
        // É feito um loop utilizando o objeto obj que contém objetos do tipo MEC, Publica e Privada
        for (final Object singleton : obj) 
        {
            // é feita a conversão do singleton para um objeto do tipo MEC
            MEC mec   = (MEC)singleton;
            // é definido o tipo da universidade armazenada no singleton 
            int tipo  = mec.getTipo();
            // verifica se a universidade é pública
            if(tipo == 0)  {
                // é feita a conversão do objeto para o tipo Publica
                Publica uni   = (Publica)mec.getUni();
                // utiliza o método getEstado da classe Publica para verificar utilizando o SWITCH 
                // se o estado informado é um estado do sul do brasil, caso positivo, imprime as informações.
                switch(uni.getEstado()){
                    case "RS":
                    case "Rio Grande do Sul":
                    case "PR":
                    case "Paraná":
                    case "SC":
                    case "Santa Catarina":
                            uni.imprimeInfo();
                        break;
                }
            }
        }
    }
}
