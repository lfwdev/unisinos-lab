/**
 * @author Luís Felipe de Souza da Silva
 * @version 2021-04-19
 */
/*
    2: Crie a classe: Cidade com os seguintes atributos:
        Código = tipo de dados número inteiro
        Descrição = tipo de dados texto
        UF = tipo de dados texto;
        Quantidade de estudantes = tipo de dados número inteiro.
    
    3: Crie os seguintes métodos na classe Cidade:
        Construtor que receba como parâmetro os valores dos atributos:
            Código, Descrição e UF
        Métodos de acesso (GET) para os atributos:
            Código, Descrição e UF
        Métodos de configuração (SET) para os atributos:
            Descrição e UF
        Método adicionaNovoEstudante que deverá somar +1 estudante no 
        atributo que representa a quantidade de estudantes, toda vez 
        que o método for executado.
        Método exibeDados para apresentar os dados da classe.
*/
import java.util.*;
public class Cidade
{
    /*
     * Atributos
    */
    private int codigo;
    private String descricao;
    private String uf;
    private int qtdEstudantes;
    /*
     * Construtor
    */
    public Cidade(
        int codigo,
        String descricao,
        String uf
    )
    {
        this.setCodigo(codigo);
        this.setDescricao(descricao);
        this.setUf(uf);
    }
    /*
     * codigo setters and getters
    */
    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }
    public int getCodigo() 
    {
        return this.codigo;    
    }
    /*
     * descricao setters and getters
    */
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }
    public String getDescricao() 
    {
        return this.descricao;    
    }
    /*
     * uf setters and getters
    */
    public void setUf(String uf) 
    {
        this.uf = uf;
    }
    public String getUf() 
    {
        return this.uf;    
    }
    /*
     * adicionaNovoEstudante 
    */
    public void adicionaNovoEstudante()
    {
        this.qtdEstudantes = this.qtdEstudantes + 1;
    }
    /*
     * exibeDados - método que exibe os dados do Estudante no console
    */
    public void exibeDados()
    {
        // Nova linha para melhor clareza dos dados exibidos
        System.out.println();
        System.out.println("* Dados da Cidade *");
        // Exibir todos os dados da classe
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("UF: " + uf);
        System.out.println("Quantidade de Estudantes: " + qtdEstudantes);
    }
}