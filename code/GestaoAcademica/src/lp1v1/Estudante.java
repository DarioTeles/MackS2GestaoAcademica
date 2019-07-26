
package lp1v1;

import java.util.ArrayList;
/**
 *
 * @author Dário Teles de Oliveira                  TIA 41582391
 * 
 * Define um estudante abstrato.
 */
public abstract class Estudante 
{
    
    //Atributos
    protected long id;
    protected String nome;
    protected String email;
    protected ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
    
    //Método construtor sem parâmetros
    public Estudante() {}
    
    //Método construtor com parâmetros
    public Estudante(long id, String nome, String email) 
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    /**
     * Retorna o ID do estudante.
     * @return id
     */
    public long getId() 
    {
        return id;
    }
    
    /**
     * Retorna o nome do estudante.
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }
    
    /**
     * Retorna o e-mail do estudante.
     * @return email
     */
    public String getEmail() 
    {
        return email;
    }
    
    /**
     * Retorna as matrículas relacionadas ao estudante.
     * @return lista de matriculas
     */
    public ArrayList<Matricula> getMatriculas() 
    {
        return matriculas;
    }
    
    /**
     * Adiciona uma nova matrícula ao estudante.
     * @param matricula 
     */
    public void addMatricula(Matricula matricula) 
    {
        if (matricula != null){
            this.matriculas.add(matricula);
        }
    }
    
    /**
     * Retorna a lista das disciplinas que o estudante está matriculado.
     * @return lista de disciplinas
     */
    public ArrayList<Disciplina> getDisciplinasMatriculadas() 
    {
        ArrayList<Disciplina> disciplinasMatriculadas = new ArrayList();
        
        for (int i=0; i<matriculas.size(); i++)
        {
            long indice = matriculas.get(i).getEstudante().getId();
            
            if (indice == this.id)
            {
                disciplinasMatriculadas.add(matriculas.get(i).getDisciplina());
            }
        }
        
        return disciplinasMatriculadas;
    }
    
    abstract int getTotalCreditos();
}
