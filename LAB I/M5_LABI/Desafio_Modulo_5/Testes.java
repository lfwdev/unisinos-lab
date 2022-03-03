/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-05-26
 */
public class Testes
{
    /**
     * Constructor for objects of class Testes
     */
    public Testes()
    {
        this.cc();
        this.novoArtista();
    }
    /**
     * 
    */
    public void novoArtista(){
        int opt = this.cadastroOptPrompt();
        if(opt == 1){
            // Pintor
            Pintor.cadastro(true);
            // recursion
            this.novoArtista();
        } else if (opt == 2){ 
            // Músico
            Musico.cadastro(true);
            // recursion
            this.novoArtista();
        } else{
            // Cancelar
        }
    }
    // Limpa o console
    public static void cc(){
        System.out.print('\u000C');
    }
    /**
     * Monta String de opções de mudança de atributo dos estudantes e solicita via Teclado qual opção a ser alterada
    */
    public int cadastroOptPrompt(){
        // definições de variáveis
        int objectSize = 3;
        int iteration  = 0;
        String optionsPrompt = "Qual tipo de artista deseja cadastrar? \n [Digite:";
        Object[] options = new Object[objectSize];
        options[0] = "Pintor";
        options[1] = "Musico";
        options[2] = "Cancelar";
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
}