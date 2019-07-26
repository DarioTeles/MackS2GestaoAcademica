package lp1v1;

import java.util.ArrayList;
/**
 * @author Dário Teles de Oliveira TIA 41582391
 * 
 * Define uma disciplina.
 */
public class Disciplina 
{
    
    //Atributos
    private String codigo;
    private int creditos;
    private ArrayList<Matricula> matriculas  = new ArrayList<Matricula>();
    
    //Método construtor sem parâmetros
    public Disciplina() {}
    
    //Método construtor com parâmetros
    public Disciplina(String codigo, int creditos)
    {
        this.codigo = codigo;
        this.creditos = creditos;
    }
    
    /**
     * Retorna o cógigo.
     * @return codigo
     */
    public String getCodigo()
    {
        return codigo;
    }
    
    /**
     * Retorna a quatidade de crédito referente a disciplina.
     * @return 
     */
    public int getCreditos()
    {
        return creditos;
    }
    
    /**
     * Retorna a lista de matrículas da disciplina.
     * @return lista matriculas
     */
    public ArrayList<Matricula> getMatriculas() 
    {
        return matriculas;
    }
    
    /**
     * Adiciona uma matricula na disciplina.
     * @param matricula  
     */
    public void addMatricula(Matricula matricula)
    {
        if (matricula != null)
        {
            this.matriculas.add(matricula);
        }
    }
    
    /**
     * Retorna a lista de estudantes matriculados na disciplina.
     * @return lista de estudantes matriculados
     */
    public ArrayList<Estudante> getEstudantesMatriculados() 
    {
        ArrayList<Estudante> estudantesMatriculados = new ArrayList();
        
        for (int i=0; i<matriculas.size(); i++)
        {
            String indice = matriculas.get(i).getDisciplina().getCodigo();
            
            if (indice.equals(this.codigo))
            {
                estudantesMatriculados.add(matriculas.get(i).getEstudante());
            }
        }
        
        return estudantesMatriculados;
    }
}
