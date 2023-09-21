package entidades;

import java.util.Objects;

public class Rendimento implements Comparable<Rendimento>{

	
	
	private double np1;
	private double np2;
	private double sub;
	private double exame;
	private String aluno;
	private boolean aprovado;
	private double media;
	private double mediaGrad = 7;
	private double mediaPGrad = 5;

	
	private int ano;
	private String curso;
	private String nivel;
	
	public Rendimento(String aAluno, double aNp1, double aNp2, double aSub, double aExame, int aAno, String aCurso, String aNivel) {
		
		this.np1 = aNp1;
		this.np2 = aNp2;
		this.sub = aSub;
		this.exame = aExame;
		this.aluno = aAluno;
		this.ano = aAno;
		this.curso = aCurso;
		this.nivel = aNivel;
	}
		
	public double getNp1() {
		return this.np1;
	}
	
	 public void setNp1(double np1) {
		 this.np1 = np1;
	}

	public double getNp2() {
		return np2;
	}

	public void setNp2(double np2) {
		this.np2 = np2;
	}

	public double getSub() {
		return sub;
	}

	public void setSub(double sub) {
		this.sub = sub;
	}

	public double getExame() {
		return exame;
	}

	public void setExame(double exame) {
		this.exame = exame;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	
	
	/*-------Métodos--------*/
	
	public boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	/*-----------------------*/
	
		public int getAno() {
			return ano;
		}
	
		public void setAno(int ano) {
			this.ano = ano;
		}
	
		public String getCurso() {
			return curso;
		}
	
		public void setCurso(String curso) {
			this.curso = curso;
		}
	
		public String getNivel() {
			return nivel;
		}
	
		public void setNivel(String nivel) {
			this.nivel = nivel;
		}
		
	
		public void CalcMediaInicial() {	
			
			if (this.sub > this.np1) {
				this.media = (this.sub + this.np2)/2;
			} 
			
			else if(this.sub > this.np2) {
				this.media = (this.sub + this.np1)/2;
			}
			
			else {
				this.media = (this.np1 + this.np2)/2;
			}
		}
	
		

		public void CalcMediaFinal() {
			if (this.media >= this.mediaGrad) {
				this.aprovado = true;
			}
			else if(this.media < this.mediaGrad) {
				this.media = (this.media + this.exame)/2;
				
				if(this.media < this.mediaPGrad) {
					this.aprovado = false;
				} else {
					this.aprovado = true;
				}
			}
		}
		
		public void CalcMediaPos() {	
			
			if (this.media >= this.mediaPGrad) {
				this.aprovado = true;
			}
			else if(this.media < this.mediaPGrad) {
				this.media = (this.media + this.exame)/2;
				
				if(this.media < this.mediaPGrad) {
					this.aprovado = false;
				} else {
					this.aprovado = true;
				}
			}
		}
		
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		Rendimento oRendimento = (Rendimento)o;
		return Objects.equals(this.aluno, oRendimento.aluno);
	}
	
	@Override
	public int compareTo(Rendimento o) { /*As informações só serão iguais se tiverem os mesmos parâmetros*/
		if(!this.curso.equals(o.curso)) {
			return this.curso.compareTo(o.curso);
		}
		
		if(!this.nivel.equals(o.nivel)) {
			return this.nivel.compareTo(o.nivel);
		}
		
		if(!this.aluno.equals(o.aluno)) {
			return this.aluno.compareTo(o.aluno);
		}
		
		return Integer.compare(this.ano, o.ano);
		
	}

	
	@Override
	public String toString() {
		String res = "";
		
		res += "Id: " + this.aluno + "\n";
		res += "Np1: " + this.np1 + "\n";
		res += "Np2: " + this.np2 + "\n";
		res += "Substituitiva: " + this.sub + "\n";
		res += "Exame: " + this.exame + "\n";
		res += "Media: " + this.media + "\n";
		res += "Situação: " + this.aprovado;
		return res;
	}
	 
}
