package view;

import entidades.Aluno;
import entidades.Curso;
import entidades.Relacao;
import entidades.Rendimento;
import terminal.Opcao;

public interface Visualizacao {
	Opcao menu();
	
	void listarAlunos(Relacao registro);
	void listarCursos(Relacao registro);
	void listarAlunosPorCurso(Relacao registro, Curso curso);
	void consultarRendimento(Relacao registro);
	void listarCursosPorAluno(Relacao registro, Aluno aluno);

	Curso addCurso();
	Aluno addAluno();
	Rendimento addRendimento();
	
	Curso delCurso();
	Aluno delAluno();
	Curso getCursoPorLista(Relacao registro);
	Aluno getAlunoPorLista(Relacao registro);
	Rendimento getRendimento(Relacao registro);
	
	int subMenu();
}