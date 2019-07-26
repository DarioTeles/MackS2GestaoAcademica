
package lp1v1;

/**
 *
 * @author Dário Teles de Oliveira TIA 41582391
 * 
 * Define uma matricula.
 */
public class Matricula 
{
    
    //Atributos
    private Estudante estudante;
    private Disciplina disciplina;
    
    //Método construtor sem parâmetros
    public Matricula (){}
    
    //Método construtor com parâmetros
    public Matricula (Estudante estudante, Disciplina disciplina)
    {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }

    /**
     * Retorna o estudante relacionado a matricula.
     * @return estudante
     */
    public Estudante getEstudante() 
    {
        return estudante;
    }
    
    /**
     * Retorna a disciplina relacionada a matricula.
     * @return disciplina
     */
    public Disciplina getDisciplina() 
    {
        return disciplina;
    }
    
}
