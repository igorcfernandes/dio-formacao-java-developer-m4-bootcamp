package model;

import exception.DevException;
import model.conteudo.Conteudo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Representa um desenvolvedor participante do Bootcamp.
 */
public class Dev {

    private String nome;

    /** Conteúdos nos quais o dev está inscrito */
    private final Set<Conteudo> conteudosIncritos = new LinkedHashSet<>();

    /** Conteúdos já concluídos pelo dev */
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    /** XP total acumulado */
    private double totalXp = 0.0;

    /**
     * Construtor do dev.
     *
     * @param nome nome do desenvolvedor
     * @throws DevException se o nome for nulo ou vazio
     */
    public Dev(String nome) {
        setNome(nome);
    }

    /**
     * Define o nome do dev.
     *
     * @param nome nome do desenvolvedor
     * @throws DevException se o nome for nulo ou vazio
     */
    private void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new DevException("O nome não pode ser vazio.");
        }

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosIncritos() {
        return conteudosIncritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public double getTotalXp() {
        return totalXp;
    }

    /**
     * Adiciona XP ao dev.
     *
     * @param xp quantidade de XP a adicionar
     */
    public void adicionaXp(double xp) {
        this.totalXp += xp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Double.compare(totalXp, dev.totalXp) == 0 &&
                Objects.equals(nome, dev.nome) &&
                Objects.equals(conteudosIncritos, dev.conteudosIncritos) &&
                Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosIncritos, conteudosConcluidos, totalXp);
    }
}
