package teste;

import data.Arquivos;
import view.Terminal;
import view.Visualizacao;
import terminal.Menu;

public class ArchiLocali {
	
	public static void main(String[] args) {
		Visualizacao terminal = new Terminal();
		String alunoPath = "C://Users//Cliente//Desktop//Java//APS//src//files//Alunos.csv";
		String cursoPath = "C://Users//Cliente//Desktop//Java//APS//src//files//Curso.csv";
		String relacaoPath = "C://Users//Cliente//Desktop//Java//APS//src//files//Relacao.csv";
		String rendimentoPath = "C://Users//Cliente//Desktop//Java//APS//src//files//Rendimento.csv";
		Arquivos data = new Arquivos(alunoPath, cursoPath, relacaoPath, rendimentoPath);
		new Menu(terminal, data).init();
	}
}