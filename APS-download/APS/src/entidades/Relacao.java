package entidades;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relacao {
	
	Map<Aluno, Set<Curso>> alunos = new TreeMap<>();
	Map<Curso, Set<Aluno>> cursos = new TreeMap<>();
	Map<Rendimento, Set<Curso>> rendimentos = new TreeMap();

	Map<String, Aluno> alunosId = new TreeMap<>();

	public Aluno getAlunosPorId(String id) {
		return alunosId.get(id);
	}
	
	public Set<Aluno> getAlunos() {
		return alunos.keySet();
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.put(aluno, new TreeSet<>());
		this.alunosId.put(aluno.getId(), aluno);
	}
	
	public void addRendimento(Rendimento rendimento) {
		this.rendimentos.put(rendimento, new TreeSet<>());

	}
	
	public void delAluno(Aluno aluno) {
		this.alunos.remove(aluno, new TreeSet<>());
		this.alunosId.remove(aluno.getId(), aluno);
	}
	
	public Set<Curso> getCursos() {
		return cursos.keySet();
	}
	
	public Set<Rendimento> getRendimentos() {
		return rendimentos.keySet();
	}
	
	public void addCurso(Curso curso) {
		this.cursos.put(curso, new TreeSet<>());
	}

	public void delCurso(Curso curso) {
		this.cursos.remove(curso, new TreeSet<>());
	}

	public Set<Curso> getCursosPorAluno(String id) {
		return alunos.get(new Aluno(id, ""));
	}
	
	public Set<Aluno> getAlunosPorCurso(Curso curso) {
		return cursos.get(curso);
	}
	
	public void addRelacaoAlunoCurso(Aluno aluno, Curso curso) {
		this.cursos.get(curso).add(aluno);
		this.alunos.get(aluno).add(curso);
	}

	public void delRelacaoAlunoCurso(Aluno aluno, Curso curso) {
		this.cursos.get(curso).remove(aluno);
		this.alunos.get(aluno).remove(curso);
	}
}