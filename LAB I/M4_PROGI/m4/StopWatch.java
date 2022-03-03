import java.util.Scanner;
public class StopWatch
{
    public StopWatch() {
        // Limpa os dados do console
        System.out.print('\u000C');
        String welcomePrompt = "Digite a quantidade de tempo em minutos para iniciar o cronômetro.";
        // collect input e executa
        Scanner scan = new Scanner(System.in);
        System.out.println(welcomePrompt);
        stopwatch(scan.nextDouble());
    }
    //
    public void stopwatch(double n) {
        try
        {
            // transforma minutos em segundos
            n = n * 60;
            // declara variavéis a serem utilizadas dentro do loop
            int elapsedseconds = 0;
            int elapsedminutes = 0;
            // executa enquanto i for menor ou igual a n
            for (int i = 0;i <= n;i++){
                // verifica se muda o valor do minuto após 60 iterações
                if(elapsedseconds >= 60){
                    elapsedminutes++;
                    elapsedseconds = 0;
                }
                // pausa por 1 segundo
                Thread.sleep(1000);
                // Limpa os dados do console
                System.out.print('\u000C');
                // Imprime cronometro
                System.out.println(elapsedminutes + "." + elapsedseconds);
                // incrementa o contador de segundos
                elapsedseconds++;
            }
        }
        catch (java.lang.InterruptedException ie)
        {
            ie.printStackTrace();
        }        
    }
}