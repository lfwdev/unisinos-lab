public class P08
{
    public P08()
    {
        exibe(5);
    }
    //
    public void exibe(int n){
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++)
            System.out.print("*-");
        System.out.println();
        }
    }
}
