public class P10
{
    public P10()
    {
       exibeLetrasMinusculasDezAtea( );
    }
    
    public void exibeLetrasMinusculasDezAtea( ){
     for (char letra = 'z'; letra >= 'a'; letra--) {
          System.out.println(letra);
     }
    }
}