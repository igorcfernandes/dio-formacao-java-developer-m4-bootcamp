package util;

import model.Dev;
import model.conteudo.Conteudo;

import java.util.Set;

/**
 * Classe utilitária para imprimir informações de Devs e seus conteúdos.
 */
public class DevPrinter {

    /**
     * Imprime informações completas do Dev: nome, conteúdos e XP.
     *
     * @param dev Dev a ser impresso
     */
    public static void imprimir(Dev dev) {
        System.out.println(dev.getNome());
        imprimirConteudo("Conteúdos inscritos", dev.getConteudosIncritos());
        imprimirConteudo("Conteúdos concluídos", dev.getConteudosConcluidos());
        System.out.println("\tTotal XP: " + dev.getTotalXp());
    }

    /**
     * Imprime um conjunto de conteúdos com título e tipo.
     *
     * @param titulo    título da lista
     * @param conteudos conjunto de conteúdos
     */
    private static void imprimirConteudo(String titulo, Set<Conteudo> conteudos) {
        System.out.println("\t" + titulo + ":");

        for (Conteudo conteudo : conteudos) {
            System.out.println("\t\t- " + conteudo.getTitulo() + " (" + conteudo.getClass().getSimpleName() + ")");
        }
    }
}
