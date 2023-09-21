package entidades;

import java.util.Objects;

public class Aluno implements Comparable<Aluno>{

		private String id;
		private String nome;
		
	public Aluno(String aId, String aNome) {
		this.id = aId;
		this.nome = aNome;
	}
		
	public String getId() {
		return this.id;
	}
	
	 public void setId(String id) {
		 this.id = id;
	}
	 
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		 this.nome = nome;
	}
	 
	@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null)
				return false;
			if (this.getClass() != o.getClass())
				return false;
			Aluno oAluno = (Aluno)o;
			return Objects.equals(this.id, oAluno.id);
		}
	
	@Override
		public int compareTo(Aluno o) {
			return this.id.compareTo(o.id);
		}
	
	@Override
		public String toString() {
			String res = "";
			res += "\nId: " + this.id +"\n";
			res += "Nome do aluno: " + this.nome;
			return res;
	}

}
