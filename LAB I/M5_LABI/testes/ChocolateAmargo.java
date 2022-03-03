public class ChocolateAmargo extends Chocolate
{
    private int teorCacau;

    public ChocolateAmargo(String marca, int peso, int calorias, int teorCacau){
        super (marca, peso, calorias);
        this.teorCacau = teorCacau;
    }

    public int getTeorCacau(){
        return teorCacau;
    }
    
    public void setTeorCacau(int novoTeorCacau){
        teorCacau = novoTeorCacau;
    }
    
    public void exibeDados(){
    super.exibeDados();
    if (teorCacau >= 70)
        System.out.println("Esse chocolate é amargo!");
    else
    System.out.println("Esse chocolate não é amargo!");
    }
}