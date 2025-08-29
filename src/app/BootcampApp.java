package app;

import model.Bootcamp;
import model.Dev;
import model.conteudo.Curso;
import model.conteudo.Mentoria;
import service.DevService;
import util.DevPrinter;

import java.time.LocalDate;

/**
 * Classe principal para simular o fluxo de um Bootcamp.
 */
public class BootcampApp {

    public static void main(String[] args) {

        // Criando cursos e mentoria
        Curso cursoJava = new Curso("Estruturas condicionais em Java", "Aprenda estruturas condicionais básicas", 10);
        Curso cursoSpring = new Curso("Introdução ao Spring Boot", "Aprenda a criar aplicações Spring Boot", 5);
        Mentoria mentoriaJava = new Mentoria("POO em Java", "Mentoria sobre Programação Orientada a Objetos", LocalDate.now().plusDays(1));

        // Criando bootcamp e adicionando conteúdos
        Bootcamp bootcamp = new Bootcamp("Java Developer", "Bootcamp para desenvolvedores Java");
        bootcamp.adicionarConteudo(cursoJava);
        bootcamp.adicionarConteudo(cursoSpring);
        bootcamp.adicionarConteudo(mentoriaJava);

        // Criando desenvolvedores
        Dev devJoao = new Dev("João das Tantas");
        Dev devMaria = new Dev("Maria de Jesus");

        // Criando serviço para gerenciar devs
        DevService devService = new DevService();

        // Inscrevendo devs no bootcamp
        devService.inscreverBootcamp(devJoao, bootcamp);
        devService.inscreverBootcamp(devMaria, bootcamp);

        // Simulando progresso dos devs
        devService.progredir(devJoao);
        devService.progredir(devJoao); // João conclui dois conteúdos
        devService.progredir(devMaria); // Maria conclui um conteúdo

        // Imprimindo status dos devs
        bootcamp.getDevs().forEach(DevPrinter::imprimir);
    }
}
