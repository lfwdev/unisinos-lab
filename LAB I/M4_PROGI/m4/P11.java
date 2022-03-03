public class P11
{
    public P11()
    {
        geraMultiplosDeTres(10,90);
        geraMultiplosDeTres1(10,90);
        geraMultiplosDeTres2(10,90);
    }
    public void geraMultiplosDeTres(int a, int b){
        String result = "";
        if(a<b){
            while(a<=b){
                if(a%3==0)
                    result += a + " ";
                a++;
            }
        } else {
            while(b<=a){
                if(b%3==0)
                    result += b + " ";
                b++;
            }
        }
        System.out.println(result);
    }
    
    public void geraMultiplosDeTres1(int a, int b){
        String result = "";
     if ( a < b){
       for (int i = a; i<= b; i++) {
          if (i % 3 == 0)
             result += i + " ";
       }//fim for
      }else{
        for (int i = b; i<= a; i++) {
           if (i% 3 == 0)
               result += i + " ";
         }//fim for
       }
       System.out.println(result);
     }
    //
     public void geraMultiplosDeTres2(int a, int b) {
         String result = "";
         if ( a > b) {
            int guarda = a;
            a = b;
            b = guarda;
          }
          for (int i = a; i <= b; i++) {
              if (i % 3 == 0)
               result += i + " ";
          }
          System.out.println(result);
    }
}
