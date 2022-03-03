import java.util.Arrays;
public class prova
{    
    public prova()
    {
        /**
         * Questão 1
        
        System.out.println("\n Questão 1 \n");
        System.out.println(q1(3));
        /**
         * Questão 2
    
        System.out.println("\n Questão 2 \n");
        q2();
        /**
         * Questão 3
        
        System.out.println("\n Questão 3 \n");
        System.out.println(q3(25,32,50));
        System.out.println(q3B(25,32,50));
        /**
         * Questão 4
        
        System.out.println("\n Questão 4 \n");
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println(q4(a,b));
       
        /**
         * Questão 5
        
       
        System.out.println("\n Questão 5 \n");
        System.out.println(q5());
        
        /**
         * Questão 6
        
        int[] c = {25, 103, 2, 3, 53};
        System.out.println(q6(c));
        
        /**
         * Questão 7
        
       
        System.out.println("\n Questão 7 \n");
        int[] d = {23, 7, 3};
        int[] e = {141, 45, 86};
        System.out.println(Arrays.toString(q7(d,e)));
        */
        imprimePar();
        /**
         * FIM
        */
       
    }
    
    /**
       Crie um método que não recebe parâmetros. 
       O método deve pedir para o usuário digitar 
       2 valores inteiros via Teclado (val1 e val2). 
       Se nenhum dos valores for negativo, escreva 
       os números pares entre o menor (inclusive) e 
       o maior (inclusive) valor, em ordem crescente.
    */
    public void imprimePar(){
        
        int x = Teclado.leInt("Digite o primeiro número:");
        int y = Teclado.leInt("Digite o segundo número:");
        
        if (x >= 0 && y >= 0)
        {
            int par = 0;
            for(int i = (x<y?x:y); i <= (x>y?x:y); i++)
            {
                if(i % 2 == 0)
                {
                    System.out.println(i);
                }  
            } 
        }        
    }
    
    /**
      Questão 1
        Crie um método que recebe um inteiro X por parâmetro 
        e retorne a soma dos valores de 0 até X (inclusive).
     */
    public int q1(int x)
    {
        int r = 0;
        for (int i = 0; i <= x ; i++){
            r = r + i;
        }
        return r;
    }
    /**
      Questão 2
        Crie um método que não recebe parâmetros. 
        O método deve imprimir a soma dos valores pares e a soma dos valores ímpares 
        entre dois números quaisquer digitados pelo usuário. 
        Seu método deve garantir que os valores digitados serão maiores do que 0. 
        Além disso, você também deve garantir que o primeiro valor digitado é menor que o segundo. 
        Ou seja: você deve solicitar os valores novamente sempre que um dos valores digitados 
        for negativo ou zero, e também quando o primeiro valor digitado for maior ou igual ao 
        segundo valor digitado.
     */
    public void q2()
    {
        int x = Teclado.leInt("Digite o primeiro número:");
        int y = Teclado.leInt("Digite o segundo número:");
        if((x > 0 && y > 0) && (x < y))
        {
            int par   = 0;
            int impar = 0;
            for(int i = x; i <= y; i++)
            {
                if(i % 2 == 0)
                    par = par + i;
                else 
                    impar = impar + i;
            } 
            System.out.println("Soma dos valores pares: " + par);
            System.out.println("Soma dos valores ímpares: " + impar);
        }
        else {
            System.out.println("Ambos os números devem ser maiores que zero e o primeiro número menor que o segundo");
            q2();
        }
    }
    /**

      Questão 3
        Crie um método que recebe três valores inteiros por parâmetro e retorna o menor deles.
     */
    public int q3(int x,int y,int z)
    {
        int r = (x < y) ? x : y;
        return ((r < z) ? r : z);
    }
    //
    public int q3B(int x,int y,int z)
    {
        return ((x<y)?((x<z)?x:((z<y)?z:y)):(y<z)?y:z);
    }
    /**
      Questão 4
        Faça um método que recebe dois arrays de inteiros por parâmetro e retorna verdadeiro 
        caso eles sejam iguais (ou seja, mesma quantidade de elementos e todos eles no mesmo índice) 
        e falso caso sejam diferentes.    
     */
    public boolean q4(int[] a, int[] b)
    {
        //Uso da livraria java.util.Arrays para função Arrays.equals().
        if (Arrays.equals(a,b))
            return true;
        else
            return false;
    }
    /**
      Questão 5
        Crie um método que não recebe parâmetros. O método deve pedir para o usuário digitar
        números com ponto flutuante positivos via Teclado. Quando o usuário digitar um número
        negativo, o método deve retornar a média de todos os números que ele informou, ou -1 caso
        não tenha informado valor algum.
    */
    public double q5()
    {
        double newNum = 0;
        double res = 0; 
        int rep = 0;
        //
        do {
            newNum = Teclado.leDouble("Digite um novo número positivo(Float) ou negativo para encerrar a execução:");
            if(newNum > 0) {
                res = res + newNum;
                rep++;
            }
        } while(newNum > 0);
        //
        return (rep > 0) ? res/rep : -1;
    }
    /**
     Faça um método que recebe um array de 
     inteiros por parâmetro e retorna o maior elemento do array.  
    */
    public int q6(int[] x)
    {
        int maior = 0;
        for(int i = 0; i < x.length; i++)
        {
            if(x[i] > maior)
                maior = x[i];
        }
        return maior;
    }
    /**
    Faça um método que recebe dois arrays de inteiros por parâmetro, 
    e retorna um terceiro array contendo todos os elementos dos 
    dois arrays.   
    */
    public int[] q7(int[] a, int[] b)
    {
        int[] c = new int[(a.length + b.length)];
        int pointer = 0;
        for(int i = 0; i < a.length; i++)
        {
            c[pointer] = a[i];
            pointer++;
        }
        for(int i = 0; i < b.length; i++)
        {
            c[pointer] = b[i];
            pointer++;
        }
        return c;
    }
}
