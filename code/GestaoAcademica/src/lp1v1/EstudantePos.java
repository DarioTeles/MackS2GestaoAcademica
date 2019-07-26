
package lp1v1;

/**
 *
 * @author Dário Teles de Oliveira                  TIA 41582391
 * 
 * Define um estudante de pós-graduação.
 */
public class EstudantePos extends Estudante
{
    
    //Métodos
    private String tema;
    private String orientador;
    
    //Método construtor sem parâmetros
    public EstudantePos(){}
    
    //Método construtor com parâmetros
    public EstudantePos(long id, String nome, String email, String tema, String orientador) 
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tema = tema;
        this.orientador = orientador;
    }
    
    /**
     * Retorna o tema do projeto de pós graduação.
     * @return tema
     */
    public String getTema() 
    {
        return tema;
    }
    
    /**
     * Retorna o nome do orientador do projeto de pós graduação.
     * @return orientador
     */
    public String getOrientador() 
    {
        return orientador;
    }
    
    /**
     * Retorna a quantidade total de créditos.
     * @return quantidade de créditos utilizados
     */
    public int getTotalCreditos() 
    {
        int soma = 0;
        
        for (int i=0; i<this.getDisciplinasMatriculadas().size(); i++){
            soma += this.getDisciplinasMatriculadas().get(i).getCreditos();
        }
        
        return soma;
    }
}
