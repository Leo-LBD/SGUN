package terminal;

public enum Opcao {
	LISTA_ALUNOS(1, "Listar todos os alunos"), 
	LISTA_CURSOS(2, "Listar todos os cursos"), 
	
	LISTA_ALUNOS_DE_CURSO(3, "Listar todos os alunos de um curso"), 
	LISTA_CURSOS_DE_ALUNO(4, "Listar todos os cursos de um aluno"),
	
	ADICIONA_ALUNO(5, "Cadastrar um novo aluno"),
	ADICIONA_CURSO(6, "Cadastrar um novo curso"),
	ADICIONA_RELACAO(7, "Adicionar relacao aluno-curso"),
	
	ADICIONAR_RENDIMENTO(8, "Adicionar rendimento"),
	CONSULTAR_RENDIMENTO(9, "Consultar rendimento"),
	
	REMOVER_ALUNO(10, "Remover um aluno"),
	REMOVER_CURSO(11, "Remover um curso"),
	REMOVER_RELACAO(12, "Remover uma relacao entre aluno e curso"),
	
	SAIR(0, "Sair do programa e salvar os dados");
	
	public String descricao;
	public int codigo;
	
	private Opcao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
}
