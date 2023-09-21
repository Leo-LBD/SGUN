package terminal;

import java.util.Map;
import java.util.TreeMap;

import data.Arquivos;
import entidades.Aluno;
import entidades.Curso;
import entidades.Relacao;
import entidades.Rendimento;
import view.Visualizacao;

public class Menu {
	private Visualizacao terminal;
	private Arquivos data;
	private Relacao registro;
	public static Map<Integer, Opcao> opc = new TreeMap<>();
{

	for(Opcao o: Opcao.values()) {
	opc.put(o.codigo, o);
	}
}

	public Menu(Visualizacao terminal, Arquivos data) {
		this.terminal = terminal;
		this.data = data;
	}

	public void init(){
		registro = data.getRegistro();
		int x;
	
	Opcao codigo = null;
		while(codigo != Opcao.SAIR) {
		codigo = terminal.menu();
		x = 1;
	
	switch(codigo) {
	
			case LISTA_ALUNOS:
				while(x != 2) {
					if(x == 1) {
						listarAlunos();
					}
					x = subMenu();
				}
				break;
				
			case LISTA_CURSOS:
				while(x != 2) {
					if(x == 1) {
						listarCursos();
					}
					x = subMenu();
				}
				break;
				
			case LISTA_ALUNOS_DE_CURSO:
				while(x != 2) {
					if(x == 1) {
						listaAlunosPorCurso();
					}
					x = subMenu();
				}
				break;
				
			case LISTA_CURSOS_DE_ALUNO:
				while(x != 2) {
					if(x == 1) {
						listaCursosPorAluno();
					}
					x = subMenu();
				}
				break;
		
			case ADICIONA_ALUNO:
				while(x != 2) {
					if(x == 1) {
						adicionarAluno();
					}
					x = subMenu();
				}
				break;
				
			case ADICIONA_CURSO:
				while(x != 2) {
					if(x == 1) {
						adicionarCurso();
					}
					x = subMenu();
				}
				break;
				
			case ADICIONAR_RENDIMENTO:
				while(x != 2) {
					if(x == 1) {
						adicionarRendimento();
					}
					x = subMenu();
				}
				break;
				
			case CONSULTAR_RENDIMENTO:
				while(x != 2) {
					if(x == 1) {
						consultarRendimento();
					}
					x = subMenu();
				}
				break;
				
			case ADICIONA_RELACAO:
				while(x != 2) {
					if(x == 1) {
						adicionarRelacao();
					}
					x = subMenu();
				}
				break;
				
			case REMOVER_ALUNO:
				while(x != 2) {
					if(x == 1) {
						removerAluno();
					}
					x = subMenu();
				}
			break;
			
			case REMOVER_CURSO:		
				while(x != 2) {		
					if(x == 1) {		
						removerCurso();		
					}		
					x = subMenu();	
				}
				break;
				
			case REMOVER_RELACAO:
				while(x != 2) {
					if(x == 1) {
						removerRelacao();
					}
					x = subMenu();
				}
				break;
				
			case SAIR:
				terminar();
				break;
			default:
				throw new IllegalArgumentException("Valor Desconhecido:	" + opc);
		}
		
	}
}
	
	private void listarAlunos() {
		terminal.listarAlunos(registro);
	}
	
	private void listarCursos() {
		terminal.listarCursos(registro);
	}

	private void adicionarAluno() {
		Aluno aluno = terminal.addAluno();
		this.registro.addAluno(aluno);
	}
	
	private void removerAluno() {
		Aluno aluno = terminal.delAluno();
		this.registro.delAluno(aluno);
	}

	private void adicionarCurso() {
		Curso curso = terminal.addCurso();
		this.registro.addCurso(curso);
	}
	
	private void adicionarRendimento() {
		Rendimento rendimento = terminal.addRendimento();
		this.registro.addRendimento(rendimento);
	}
	
	private void consultarRendimento() {
		terminal.consultarRendimento(registro);
	}

	private void removerCurso() {
		Curso curso = terminal.delCurso();
		this.registro.delCurso(curso);
	}

	private void listaAlunosPorCurso() {
		Curso curso = terminal.getCursoPorLista(registro);
		if(curso==null) return;
		terminal.listarAlunosPorCurso(registro, curso);
	}

	private void listaCursosPorAluno() {
		Aluno aluno = terminal.getAlunoPorLista(registro);
		if(aluno==null) return;
		terminal.listarCursosPorAluno(registro, aluno);
	}

	private void adicionarRelacao() {
		Aluno aluno = terminal.getAlunoPorLista(registro);
		if(aluno==null) return;
		Curso curso = terminal.getCursoPorLista(registro);
		if(curso==null) return;
		registro.addRelacaoAlunoCurso(aluno, curso);
	}

	private void removerRelacao() {
		Aluno aluno = terminal.getAlunoPorLista(registro);
		if(aluno==null) return;
		Curso curso = terminal.getCursoPorLista(registro);
		if(curso==null) return;
		registro.delRelacaoAlunoCurso(aluno, curso);
	}

	private int subMenu() {
		return terminal.subMenu();
	}

	private void terminar() {
		data.saveRegistro(registro);
	}

}