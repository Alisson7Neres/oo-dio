package br.com.sevensoft.main;

import br.com.sevensoft.model.Aluno;
import br.com.sevensoft.model.Bootcamp;
import br.com.sevensoft.model.Curso;

public class Main {

	public static void main(String[] args) {

		// Cursos pertencentes ao Bootcamp
		Curso javaSE = new Curso("Java", "Java SE", 20);
		Curso javaOO = new Curso("Java", "Java OO", 40);
		Curso javaEE = new Curso("Java", "Java EE", 60);
		
		// Adicionando os cursos no Bootcamp Java Developer
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(javaSE);
		bootcamp.getConteudos().add(javaOO);
		bootcamp.getConteudos().add(javaEE);
		
		// Inscrevendo o aluno
		Aluno aluno1 = new Aluno("Álisson Neres");
		aluno1.inscreverBootcamp(bootcamp);
		
		// Se progredir o curso será removido
			aluno1.progredir();
		  	aluno1.progredir();
		  	/*
		  	aluno1.progredir();
		  	 */
		
		// A cada progressão irá somar xp += 15
		  	aluno1.calcularTotalXp();
			aluno1.calcularTotalXp();
			/*
			aluno1.calcularTotalXp();
			 */
		
		System.out.println("-Aluno: " + aluno1.getNome() + "\nLevel: " + aluno1.getLevel() + " \n-Inscrito no bootcamp: " + aluno1.getConteudosInscritos());

		System.out.println(	"\nData da inscrição: " + bootcamp.getDataInicial() + "\nTermino do curso: " + bootcamp.getDataFinal() +
					"\nTempo restante: " + bootcamp.diasRestantes() + " dias");
	}

}
