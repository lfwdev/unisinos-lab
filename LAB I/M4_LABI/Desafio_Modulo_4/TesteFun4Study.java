/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-05-02
 */
/*
 * Instruções no README
*/
import java.lang.*;
public class TesteFun4Study
{
    /*
     * Construtor
    */
    public TesteFun4Study()
    {
        Estudante.cc();
        System.out.println(":: TESTE ::");
        //
        int repeatAddEstudante = 1;
        //Cria nova cidade
        do {
            // Cidade x
            Cidade cX = novaCidade();
            cX.exibeDados();
            int nEstudantes = 0;
            // Cria novo estudante 
            do {
                System.out.println("\n");
                // Verifica se o usuário decidiu não continuar a adicionar estudantes porém a cidade ainda não contém o mínimo requerido
                if(repeatAddEstudante == 0 && nEstudantes < 4)
                    System.out.printf("Quantidade de estudantes abaixo do mínimo. (%s/4)",nEstudantes);
                // Estudante x
                novoEstudante(cX);
                nEstudantes++;
                // Pergunta ao usuário se deseja continuar a adicionar estudantes a esta cidade
                repeatAddEstudante = this.redoPrompt("adicionando estudantes");
            } while((repeatAddEstudante != 0) || (nEstudantes < 4));
        } while(this.redoPrompt("adicionando cidades") != 0);
        //
        System.out.println(":: FIM ::");
    }
    /*
     * Pergunta se deve continuar a execução ou interromper.
    */
    public int redoPrompt(String name) {
        String redoPrompt = "Coninuar " + name + "? Digite [1: Sim, 0: Não].";
        return Teclado.leInt(redoPrompt);
    }
    /*
     * Cria um estudante de acordo com a entrada do usuário  
    */
    public Estudante novoEstudante(Cidade cidade)
    {
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println("\n");
        System.out.println("++ Adiciona Novo Estudante ++");
        // Define os prompts
        String codEstPrompt    = "Digite um inteiro para o código do estudante: ";
        String nomEstPrompt    = "Digite o nome: ";
        String emailEstPrompt  = "Digite o email: ";
        String senhaEstPrompt  = "Digite a senha: ";
        String dtnascEstPrompt = "Digite a data de nascimento: ";
        // solicita os dados via classe teclado e retorna novo objeto do tipo estudante
        Estudante eX = new Estudante(
            Teclado.leInt(codEstPrompt),
            Teclado.leString(nomEstPrompt),
            Teclado.leString(emailEstPrompt),
            Teclado.leString(senhaEstPrompt),
            Teclado.leString(dtnascEstPrompt),
            cidade           
        );
        // Exibe dados do objeto criado
        eX.exibeDados();
        //
        return eX;
    }
    /*
     * Cria uma cidade de acordo com a entrada do usuário  
    */
    public Cidade novaCidade()
    {
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println("\n");
        System.out.println("++ Adiciona Nova Cidade ++");
        // Define os prompts
        String codCidPrompt = "Digite um inteiro para o código da cidade: ";
        String desCidPrompt = "Digite o nome da cidade: ";
        String ufCidPrompt  = "Digite o estado onde a cidade está localizada: ";
        // solicita os dados via classe teclado e retorna novo objeto do tipo cidade
        return new Cidade(
            Teclado.leInt(codCidPrompt),
            Teclado.leString(desCidPrompt),
            Teclado.leString(ufCidPrompt));
    }
}