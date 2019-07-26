
package lp1v1;

/**
 *
 * @author Dário Teles de Oliveira                  TIA 41582391
 * 
 * Define um estudante de graduação.
 */
public class EstudanteGrad extends Estudante
{
    //Atributos
    private int horasAtividades;
    
    //Método construtor sem parâmetros
    public EstudanteGrad() {}
    
    //Método construtor com parâmetros
    public EstudanteGrad(long id, String nome, String email, int horasAtividades) 
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.horasAtividades = horasAtividades;
    }
    
    /**
     * Retorna as horas de atividades.
     * @return horasAtividades
     */
    public int getHorasAtividades() 
    {
        return horasAtividades;
    }
    
    /**
     * Retorna a quantidade total de créditos.
     * @return quantidade de créditos utilizados
     */
    public int getTotalCreditos() 
    {
        int soma = 0;
        
        for (int i=0; i<this.getDisciplinasMatriculadas().size(); i++)
        {
            soma += this.getDisciplinasMatriculadas().get(i).getCreditos();
        }
        
        soma += this.getHorasAtividades();
        return soma;
    }
}
