package br.com.sevensoft.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Aluno {

	public Aluno(String nome) {
		this.nome = nome;
	}

	private String nome;
	private String level;
	private int xp = 0;
	@SuppressWarnings("unused")
	private Optional<Conteudo> concluido;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			concluido = this.conteudosInscritos.stream().findFirst();
			System.err.println("CURSO CONCLUÍDO " + conteudo + "\n");
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		} else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
	}

	public double calcularTotalXp() {
		Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
		double soma = 0;
		while (iterator.hasNext()) {
			double next = iterator.next().calcularXp();
			soma += next;
		}
		this.getXp(soma);
		return soma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLevel() {
		if (level == null) this.level = "Iniciante";
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getXp(double xp) {
		String level;
		level = this.level;
		if (xp >= 0 && xp <= 30) {
			level = "Iniciante";
		} else if (xp > 30 && xp <= 60) {
			level = "Intermediário";
		} else if (xp > 60 && xp <= 90) {
			level = "Avançado";
		}
		this.level = level;
		return level;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	@Override
	public String toString() {
		return "Aluno: " + nome + "\nLevel: " + "\nxp: " + xp;
	}
}
