
package lp1v1;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Dário Teles de Oliveira                  TIA 41582391
 * 
 * Define uma universidade.
 */
public class Universidade 
{
    
    //Atributos
    private String nome;
    private ArrayList<Estudante> estudantes = new ArrayList<Estudante>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    
    //Método construtor sem parâmetros
    public Universidade() {}
    
    //Método construtor com parâmetros
    public Universidade(String nome) 
    {
        this.nome = nome;
    }
    
    //Métodos
    
    /**Método para carregamento de dados dos arquivo .txt:
    *   Ele realiza a leitura de cada linha do arquivo .txt (objeto) e armazena na String linha;
    *   Separa a String linha conforme o separador (linha.split) e armazena no vetor vetString;
    *   Com os atributos separados, criamos um objeto anônimo e armazenamos o objeto na ArrayList;
    *   Isso ocorre para os arquivos arquivoDisciplinas e arquivoEstudantes.
    */
    public void carregarDados(String arquivoDisciplinas, String arquivoEstudantes, String arquivoMatriculas) throws IOException
    {
        
        //Leitura do arquivoDisciplinas e armazenamento na ArrayList disciplinas
        FileReader arquivoDisciplinasFile = new FileReader(arquivoDisciplinas);
        BufferedReader entrada = new BufferedReader(arquivoDisciplinasFile); 
        String linha;
        
        do 
        {
            linha = entrada.readLine();
            if (linha != null)
            {
                String vetString[] = linha.split(":");
                
                this.disciplinas.add(new Disciplina (vetString[0], Integer.parseInt(vetString[1])));
                
            }
            
        } while(linha != null);
        
        arquivoDisciplinasFile.close();
        
        //Leitura do arquivoEstudantes e armazenamento na ArrayList estudantes
        FileReader arquivoEstudantesFile = new FileReader(arquivoEstudantes);
        entrada = new BufferedReader(arquivoEstudantesFile); 
        
        do 
        {
            linha = entrada.readLine();
            if (linha != null)
            {
                String vetString[] = linha.split(":");
                if (vetString[3].equals("GRAD"))
                {
                    this.estudantes.add(new EstudanteGrad (Long.parseLong(vetString[0]), vetString[1], vetString[2],  Integer.parseInt(vetString[4])));
                }else
                {
                    this.estudantes.add(new EstudantePos (Long.parseLong(vetString[0]), vetString[1], vetString[2], vetString[4], vetString[5]));
                }
            }
            
        } while(linha != null);
        
        arquivoEstudantesFile.close();
        
         //Leitura do arquivoMatriculas e armazenamento na ArrayList matriculas
        FileReader arquivoMatriculasFile = new FileReader(arquivoMatriculas);
        entrada = new BufferedReader(arquivoMatriculasFile); 
        Estudante estudanteRef = null;
        Disciplina disciplinaRef = null;
        
        
        do 
        {
            linha = entrada.readLine();
            
            if (linha != null)
            {
                String vetString[] = linha.split(":");
                
                for (int i=0; i<estudantes.size(); i++)
                {
                    long indice = estudantes.get(i).getId();
                    long estCod = Long.parseLong(vetString[0]);
                    
                    if(estCod == indice)
                    {
                        estudanteRef = estudantes.get(i);
                    }
                }
            
                for (int i=0; i<disciplinas.size(); i++)
                {
                    String discCod = disciplinas.get(i).getCodigo();
                    
                    if(discCod.equals(vetString[1]))
                    {
                        disciplinaRef = disciplinas.get(i);
                    }
                }
                
                if (estudanteRef != null && disciplinaRef != null) 
                {
                    estudanteRef.addMatricula(new Matricula(estudanteRef, disciplinaRef));
                    disciplinaRef.addMatricula(new Matricula(estudanteRef, disciplinaRef));
                } 
            }
            
        } while(linha != null);
        
        arquivoEstudantesFile.close();
    }
    
    /**
     * Retorna o nome da universidade.
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }
    
    /**
     * Retorna a lista de estudantes da universidade.
     * @return lista de estudantes
     */
    public ArrayList<Estudante> getEstudantes() 
    {
        return estudantes;
    }
    
    /** 
     * Retorna a lista de disciplinas da universidade.
     * @return lista de estudantes
     */
    public ArrayList<Disciplina> getDisciplinas() 
    {
        return disciplinas;
    }
    
}
