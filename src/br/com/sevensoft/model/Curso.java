package br.com.sevensoft.model;

public class Curso extends Conteudo {

	private int cargaHoraria;

	public Curso(String titulo, String descricao, int cargaHoraria) {
		setTitulo(titulo);
		setDescricao(descricao);
		this.cargaHoraria = cargaHoraria;
	}

	  @Override
	    public double calcularXp() {
	        return xp_padrao += 15;
	    }

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		return "\nCurso -> " + getTitulo() + "\nDescrição: " + getDescricao() + "\nCarga horária: " + cargaHoraria;
	}
}
