public class P09
{
    public P09()
    {
        int n = 3;
        System.out.println();
        double media1 = geraExibeNumerosSomaImparesC (n);
        System.out.println("media1 " + media1);
        int media2 = geraExibeNumerosSomaImparesD (n);
        System.out.println("media2 " + media2);
    }
    
    public double geraExibeNumerosSomaImparesC (int n){
      int somaImpares = 0;
      int contImpares = 0;
      double media = 0;
      int num;
      for(int i=1; i<=n; i++){
          num = 10 + (int)(Math.random()*40);
          System.out.print(num +" ");
          if (num % 2 == 1){
              somaImpares = somaImpares +num;
              contImpares++;
          }
       }
       if (contImpares>0)
          media = (double) somaImpares / contImpares;
       return media;
    } //fim método

    public int geraExibeNumerosSomaImparesD (int n){
      int somaImpares = 0;
      int contImpares = 0;
      int media = 0;
      int num;
      for(int i=1; i<=n; i++){
          num = 10 + (int)(Math.random()*40);
          System.out.print(num +" ");
          if (num % 2 == 1){
              somaImpares = somaImpares +num;
              contImpares++;
          }
       }
      if (contImpares>0)
          media = somaImpares / contImpares;
      return media;
    } //fim método
}
