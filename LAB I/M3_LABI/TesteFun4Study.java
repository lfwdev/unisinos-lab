/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-04-19
 */
/*
    6: Crie uma classe de Teste chamada: TesteFun4Study
      * A classe de teste deve criar 2 cidades e 2 estudantes para cada cidade criada.
         Utilize a classe Teclado para solicitar os dados do teclado.
      * Para cada estudante criado, atualize a senha. 
         Utilize a classe Teclado para solicitar os dados do teclado. 
      * Para atualizar a senha, o usuário deve digitar (nesta ordem):
            senha anterior (cadastrada na criação do objeto)
            nova senha
            repetir a nova senha
    * A senha deve ser atualizada apenas se o usuário digitar corretamente a senha 
    anterior e digitar duas vezes a nova senha. Informe com uma mensagem o sucesso 
    ou não da alteração da senha.
    * Depois da criação das cidades e seus estudantes, o sistema deverá exibir os 
    dados destes objetos na tela.
*/
import java.lang.*;
public class TesteFun4Study
{
    /*
     * Construtor
    */
    public TesteFun4Study()
    {
        // Limpa os dados do console
        System.out.print('\u000C');
        //this.populate();
        // Delimita o fim e dá início a outra etapa
        System.out.print("*********************");
        System.out.print("+ NOVO TESTE ¬      +");
        System.out.print("*********************");
        // Cidade 1
        Cidade c1    = novaCidade();
        // Estudante 1
        Estudante e1 = novoEstudante(c1);
        Estudante.resetPassword(e1);
        // Estudante 2
        Estudante e2 = novoEstudante(c1);
        Estudante.resetPassword(e2);
        // exibe dados cidade 1 e respectivos estudantes
        System.out.print("*********************");
        System.out.print("~ DADOS INSERIDOS ¬ ~");
        System.out.print("*********************");
        c1.exibeDados();
        e1.exibeDados();
        e2.exibeDados();
        // Delimita o fim e dá início a outra etapa
        System.out.print("*********************");
        System.out.print("+  NOVO TESTE ¬     +");
        System.out.print("*********************");
        // Cidade 2
        Cidade c2    = novaCidade();
        // Estudante 3
        Estudante e3 = novoEstudante(c2);
        Estudante.resetPassword(e3);
        // Estudante 4
        Estudante e4 = novoEstudante(c2);
        Estudante.resetPassword(e4);
        // exibe dados cidade 2 e respectivos estudantes
        System.out.print("*********************");
        System.out.print("~ DADOS INSERIDOS ¬ ~");
        System.out.print("*********************");
        c2.exibeDados();
        e3.exibeDados();
        e4.exibeDados();
    }
    /*
     * Cria duas cidades e quatro estudantes sem requerer 
     * entrada do usuário para a finalidade de testes   
    */
    public void populate()
    {
        // Cidade 1
        Cidade c1 = new Cidade(1,"Porto Alegre","RS");
        Estudante e1 = new Estudante(1,"Pedro","pedro@edu.unisinos.br","123456789","13/12/1983",c1);
        //Estudante.resetPassword(e1);
        Estudante e2 = new Estudante(2,"João","Joao@edu.unisinos.br","123456789","14/11/1991",c1);
        //Estudante.resetPassword(e2);
        // Cidade 2
        Cidade c2 = new Cidade(2,"São Leopoldo","RS");
        Estudante e3 = new Estudante(3,"Alexandre","alex@edu.unisinos.br","123456789","15/10/1990",c2);
        //Estudante.resetPassword(e3);
        Estudante e4 = new Estudante(4,"Marcos","marcos@edu.unisinos.br","123456789","16/09/1999",c2);
        //Estudante.resetPassword(e4);
        // exibe dados cidade 1 e respectivos estudantes
        c1.exibeDados();
        e1.exibeDados();
        e2.exibeDados();
        // exibe dados cidade 2 e respectivos estudantes
        c2.exibeDados();
        e3.exibeDados();
        e4.exibeDados();
    }
    
    /*
     * Cria uma cidade de acordo com a entrada do usuário  
    */
    public Cidade novaCidade()
    {
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println();
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
    /*
     * Cria um estudante de acordo com a entrada do usuário  
    */
    public Estudante novoEstudante(Cidade cidade)
    {
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println();
        // Define os prompts
        String codEstPrompt    = "Digite um inteiro para o código do estudante: ";
        String nomEstPrompt    = "Digite o nome: ";
        String emailEstPrompt  = "Digite o email: ";
        String senhaEstPrompt  = "Digite a senha: ";
        String dtnascEstPrompt = "Digite a data de nascimento: ";
        // solicita os dados via classe teclado e retorna novo objeto do tipo estudante
        return new Estudante(
            Teclado.leInt(codEstPrompt),
            Teclado.leString(nomEstPrompt),
            Teclado.leString(emailEstPrompt),
            Teclado.leString(senhaEstPrompt),
            Teclado.leString(dtnascEstPrompt),
            cidade           
        );
    }
}