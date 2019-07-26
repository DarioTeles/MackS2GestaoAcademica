
package lp1v1;

import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Dário Teles de Oliveira                  TIA 41582391
 * 
 * Define a classe que incorpora as entidades.
 */
public class GestaoAcademicaApp1 {
    
    public static void main (String[] args) throws IOException{
         
        int op, d, e;
         
        Universidade universidade1 = new Universidade();
        universidade1.carregarDados("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        Scanner entrada = new Scanner (System.in);
         
        System.out.println("Bem-vindo");
        do{    
            
            System.out.println("");
            System.out.println("O que deseja fazer?");
            System.out.println("");
            System.out.println("1. Listar números e nomes de todos os estudantes.");
            System.out.println("2. Listar códigos de todas as disciplinas.");
            System.out.println("3. Listar todas as informações dos estudantes matriculados em uma determinada disciplina.");
            System.out.println("4. Listar todas as informações das disciplinas em que um determinado estudante está matriculado.");
            System.out.println("0. Sair");
            System.out.println("");
            System.out.println("Opção:");
            
            op = entrada.nextInt();
            System.out.println();
         
            switch (op) {
                case 1:
                    System.out.println("Cod" + ":" + "Nome");
                    for (int i=0; i<universidade1.getEstudantes().size(); i++){
                        
                        if(universidade1.getEstudantes().get(i) instanceof EstudanteGrad){
                            EstudanteGrad estudante1 = (EstudanteGrad) universidade1.getEstudantes().get(i);
                            System.out.println("Id: " + estudante1.getId() + "   Nome: " + estudante1.getNome() + "   Total de Creditos: " + estudante1.getTotalCreditos() + "   Atividades Complementares: " + estudante1.getHorasAtividades());
                        } else {
                            EstudantePos estudante1 = (EstudantePos) universidade1.getEstudantes().get(i);
                            System.out.println("Id: " + estudante1.getId() + "   Nome: " + estudante1.getNome() + "   Total de Creditos: " + estudante1.getTotalCreditos() + "   Tema: " + estudante1.getTema() + "   Orientador: " + estudante1.getOrientador());
                        }
                    }
                break;
                
                case 2:
                    System.out.println("Cod");
                    for (int i=0; i<universidade1.getDisciplinas().size(); i++){
                        System.out.println(universidade1.getDisciplinas().get(i).getCodigo());
                    }
                break;
                case 3:
                    
                    do {
                        System.out.println("Digite o código da disciplina desejada:");
                        d = entrada.nextInt();
                    }while (d < 1);
                    
                    int soma = 0;
                    
                    System.out.println("Disciplina: " + universidade1.getDisciplinas().get(d-1).getCodigo());
                    System.out.println();
                    for (int i=0; i<universidade1.getDisciplinas().get(d-1).getEstudantesMatriculados().size(); i++){
                        System.out.print("Id: " + universidade1.getDisciplinas().get(d-1).getEstudantesMatriculados().get(i).getId() + "  ");
                        System.out.print("Nome: " + universidade1.getDisciplinas().get(d-1).getEstudantesMatriculados().get(i).getNome() + "  ");
                        System.out.print("E-mail: " + universidade1.getDisciplinas().get(d-1).getEstudantesMatriculados().get(i).getEmail() + "  ");
                        System.out.print("Número de Creditos: " + universidade1.getDisciplinas().get(d-1).getEstudantesMatriculados().get(i).getTotalCreditos() + "  ");
                    
                        if(universidade1.getEstudantes().get(d-1) instanceof EstudanteGrad){
                            EstudanteGrad estudante1 = (EstudanteGrad) universidade1.getEstudantes().get(d-1);
                            System.out.println("Atividades Complementares: " + estudante1.getHorasAtividades());
                        } else {
                            EstudantePos estudante1 = (EstudantePos) universidade1.getEstudantes().get(d-1);
                            System.out.println("Tema: " + estudante1.getTema() + "  " + "Orientador: " + estudante1.getOrientador());
                        }
                        soma += 1;
                    }
                    
                    System.out.print("Número total de matriculados: " + soma);
                    
                break;
                case 4:
                    
                    do {
                        System.out.println("Digite o código do estudante desejado:");
                        d = entrada.nextInt();
                    }while(d < 1);
                    
                    System.out.println("Nome do Estudante:" + universidade1.getEstudantes().get(d-1).getNome());
                    System.out.println();
                    System.out.println("Código  Crédito");
                    for (int i=0; i<universidade1.getEstudantes().get(d-1).getDisciplinasMatriculadas().size(); i++){
                        System.out.print(universidade1.getEstudantes().get(d-1).getDisciplinasMatriculadas().get(i).getCodigo() + "     ");
                        System.out.println(universidade1.getEstudantes().get(d-1).getDisciplinasMatriculadas().get(i).getCreditos());
                    }
                    System.out.println();
                    System.out.println("Total de créditos: " + universidade1.getEstudantes().get(d-1).getTotalCreditos());
                    
                break;
                
                case 0:
                    System.out.println("Fechando programa.");
                    System.exit(0);
                break;
            }
            
        } while (op != 0);
    }
}
