package view;

import java.util.InputMismatchException;
import terminal.Menu;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import entidades.Relacao;
import entidades.Rendimento;
import terminal.Opcao;
import entidades.Curso;
import entidades.Aluno;

public class Terminal implements Visualizacao{

	public Opcao menu() {

		while(true) {
			try{
				System.out.println("Escolha uma das opcoes:");
				for(Opcao o: Opcao.values()) {
					System.out.println("" + o.codigo + " - " + o.descricao);
				}
				
				Scanner scan = new Scanner(System.in);
				try {
					String entrada = scan.nextLine();
					int opcaoCodigo = Integer.parseInt(entrada);
					if(!Menu.opc.keySet().contains(opcaoCodigo)) {
						throw new InputMismatchException("Nao existe essa opcao");
					}
					return Menu.opc.get(opcaoCodigo);
				}catch(NumberFormatException e) {
					throw new InputMismatchException("Caracter Invalido");
				}
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
}
	

	@Override
	public void listarAlunos(Relacao teste) {
		System.out.println("Todos os alunos:");
		for(Aluno a: teste.getAlunos()) {
			System.out.println(a);
		}
	}

	@Override
	public void listarCursos(Relacao registro) {
		System.out.println("Todos os Cursos");
		for(Curso c: registro.getCursos()) {
			System.out.println("\n--------------------------\n");
			System.out.println(c);
			
		}
	}

	@Override
	public void listarAlunosPorCurso(Relacao registro, Curso curso) {
		System.out.println("\nTodos os alunos do curso \n" + curso);
		double mediaGeral = 0;
		int cont = 0;
		for(Aluno a: registro.getAlunosPorCurso(curso)) {
			System.out.println("-------------------------");
			System.out.println(a);
						
			System.out.println("\nRendimento do aluno: \n");
			for(Rendimento r: registro.getRendimentos()) {
				
				Curso rCurso = new Curso(r.getCurso(),r.getNivel(),r.getAno());
				
				if (rCurso.equals(curso)) { //Criando um objeto que se os valores forem os mesmos conseguimos selecionar apenas o curso que queremos
					
					if (r.getAluno().equals(a.getId())) {
						r.CalcMediaInicial();
						
						if(curso.getNivel().equals("Graduação") ) {
							r.CalcMediaFinal();	
						} else if (curso.getNivel().equals("Pós-Graduação")) {
							r.CalcMediaPos();
						}
						cont +=1;
						mediaGeral = mediaGeral+r.getMedia();
						System.out.println(r);
					
					}
				}
				
			}
		}
		System.out.println("-------------------------");
		System.out.println("\nMédia geral do curso de " + curso.getNome() + " "+ mediaGeral/cont);
	}
	
	@Override
	public void listarCursosPorAluno(Relacao registro, Aluno aluno) {
		System.out.println("\nTodos os cursos do aluno " + aluno.getNome() + "\n");

		for(Curso c: registro.getCursosPorAluno(aluno.getId())) {
			System.out.println("-------------------------");
			System.out.println(c);
			
			System.out.println("\nRendimento do aluno: \n");
			for(Rendimento a: registro.getRendimentos()) {
				
				Curso aCurso = new Curso(a.getCurso(),a.getNivel(),a.getAno());
				
				if (aCurso.equals(c)) {
					if (a.getAluno().equals(aluno.getId())) {
						a.CalcMediaInicial();
						
						if(c.getNivel().equals("Graduação") ) {
							a.CalcMediaFinal();	
							
						} else if (c.getNivel().equals("Pós-Graduação")) {
							a.CalcMediaPos();
						}
						
						System.out.println(a);
						
					}
				}
			}
		}
		
		
	}
	
	@Override
	public Curso addCurso() {
		return getNewCurso();
	}
	
	@Override
	public Aluno addAluno() {
		return getNewAluno();
	}
	
	@Override
	public Curso delCurso() {
		return getNewCurso();
	}

	@Override
	public Aluno delAluno() {
		return getNewAluno();
	}

	@Override
	public Curso getCursoPorLista(Relacao registro) {
		System.out.println("\nEscolha um curso\n");
		Curso curso = selecioneCurso(registro);
		if(!registro.getCursos().contains(curso)) {
			System.out.println("Nao existe esse curso");
			return null;
		}
		return curso;
	}
	
	@Override
	public Aluno getAlunoPorLista(Relacao registro) {
		listarAlunos(registro);
		System.out.println("\nEntre com o id do aluno");
		String id = getString();
		Aluno aluno = registro.getAlunosPorId(id);
		if(aluno==null) {
			System.out.println("Nao existe o id deste aluno");
		}
		return aluno;
	}
	
	public Aluno getNewAluno() {
		System.out.println("Entre com os dados do aluno");
		String id = getIdAluno();
		String nome = getNomeAluno();
		return new Aluno(id, nome);
	}
	
	public String getIdAluno() {
		System.out.println("Entre com o id do aluno");
		return getString();
	}
	
	public String getNomeAluno() {
		System.out.println("Entre com o nome do aluno");
		return getString();
	}
	
	public Curso getNewCurso() {
		System.out.println("Entre com os dados do curso");
		String nome = getNomeCurso();
		String nivel = getNivelCurso();
		int ano = getAnoCurso();
		return new Curso(nome, nivel, ano);
	}
	
	public String getNomeCurso() {
		System.out.println("\nEntre com o nome do curso");
		return getString();
	}
	
	public String getNivelCurso() {
		System.out.println("Entre com o nivel do curso");
		return getString();
	}
	
	public int getAnoCurso() {
		System.out.println("\nEntre com o ano do curso");
		return getInt();
	}
	
	private Curso selecioneCurso(Relacao registro) {
		String nome = selecioneNomesCurso(registro);
		String nivel = selecioneNivelCurso(registro);
		int ano = selecioneAnoCurso(registro);
		return new Curso(nome, nivel, ano);
	}
	
	private String selecioneNivelCurso(Relacao registro) {
		Set<String> niveis = new TreeSet<>();
		for(Curso c: registro.getCursos()) {
			niveis.add(c.getNivel());
		}
		
		System.out.println("\nEscolha um dos niveis");
		for(String nivel: niveis) {
			System.out.println(nivel+"\n");
		}
		
		System.out.println("Entre com o nivel escolhido (Graduação ou Pós-Graduação):");
		return getString();
	}
	
	private String selecioneNomesCurso(Relacao registro) {
		Set<String> nomes = new TreeSet<>();
		for(Curso c: registro.getCursos()) {
			nomes.add(c.getNome());
		}
		
		System.out.println("Escolha um dos nomes");
		for(String nome: nomes) {
			System.out.println(nome);
		}
		
		System.out.println("\nEntre com o nome escolhido:");
		return getString();
	}
	
	private int selecioneAnoCurso(Relacao registro) {
		Set<Integer> anos = new TreeSet<>();
		for(Curso c: registro.getCursos()) {
			anos.add(c.getAno());
		}
		System.out.println("\nEscolha um dos anos");
		for(int ano: anos) {
			System.out.println(ano);
		}
		System.out.println("\nEntre com o ano escolhido:");
		return getInt();
	}
	
	@Override
	public int subMenu() {
		System.out.println("\n\n1 Continuar\n2 voltar");
		int x;
		x = getInt();
		if(!(x == 1 || x == 2 )) {
			System.out.println("Nao existe essa opcao");
		}
		return x;
	}
	
	public String getString() {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		return str.trim();
	}
	
	public int getInt() {
		int num;
		num = 0;
		try {
			Scanner in = new Scanner(System.in);
			num = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Caracter Invalido");
		}return num;
	}
	
	public double getDouble() {
		double num;
		num = 0;
		try {
			Scanner in = new Scanner(System.in);
			num = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Caracter Invalido");
		}return num;
	}


	@Override
	public Rendimento addRendimento() {
		return getNewRendimento();
	}
	
	public double getNp1Rendimento() {
		System.out.println("Entre com a np1 do aluno: ");
		return getDouble();
	}
	
	public double getNp2Rendimento() {
		System.out.println("Entre com a np2 do aluno: ");
		return getDouble();
	}
	
	public double getSubRendimento() {
		System.out.println("Entre com a sub do aluno: ");
		return getDouble();
	}
	
	public double getExameRendimento() {
		System.out.println("Entre com a exame do aluno: ");
		return getDouble();
	}
	
	public Rendimento getNewRendimento() {
		System.out.println("Entre com os rendimentos");
		String aluno = getIdAluno();
		double np1 = getNp1Rendimento();
		double np2 = getNp2Rendimento();
		double sub = getSubRendimento();
		double exame = getExameRendimento();
		int ano = getAnoCurso();
		String curso = getNomeCurso();
		String nivel = getNivelCurso();
		return new Rendimento(aluno, np1, np2, sub, exame, ano, curso, nivel);
	}

	@Override
	public void consultarRendimento(Relacao registro) {
		System.out.println("Todos os rendimentos:");
		for(Rendimento a: registro.getRendimentos()) {
			
			String nivel = getNivelCurso();
			a.CalcMediaInicial();
			
			if(nivel == "Graduação") {
				a.CalcMediaFinal();	
			} else if (nivel == "Pós-Graduação") {
				a.CalcMediaPos();
			}
			
			System.out.println(a);
			
		}
		
	}

	@Override
	public Rendimento getRendimento(Relacao registro) {
		// TODO Auto-generated method stub
		return null;
	}

}