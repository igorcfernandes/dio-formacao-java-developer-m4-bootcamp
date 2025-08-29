package model;

import exception.BootcampException;
import model.conteudo.Conteudo;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Representa um Bootcamp.
 * Cada Bootcamp possui nome, descrição, data de início, data de fim, conteúdos e desenvolvedores inscritos.
 */
public class Bootcamp {

    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    /** Conteúdos disponíveis no bootcamp */
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    /** Devs inscritos no bootcamp */
    private Set<Dev> devs = new LinkedHashSet<>();

    /**
     * Construtor do bootcamp.
     * Inicializa datas padrão: início = hoje, fim = +45 dias.
     *
     * @param nome      nome do bootcamp
     * @param descricao descrição do bootcamp
     * @throws BootcampException se nome, descrição ou datas de início e fim forem inválidas
     */
    public Bootcamp(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
        setDatas(LocalDate.now(), LocalDate.now().plusDays(45));
    }

    /** Valida e define o nome do bootcamp */
    private void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new BootcampException("O nome do bootcamp não pode ser vazio.");
        }

        this.nome = nome;
    }

    /** Valida e define a descrição do bootcamp */
    private void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new BootcampException("A descrição do bootcamp não pode ser vazia.");
        }

        this.descricao = descricao;
    }

    /**
     * Define as datas do bootcamp.
     *
     * @param inicio data de início (não pode ser anterior a hoje)
     * @param fim    data de fim (deve ser posterior ao início)
     * @throws BootcampException se datas forem inválidas
     */
    private void setDatas(LocalDate inicio, LocalDate fim) {
        if (inicio == null || fim == null) {
            throw new BootcampException("As datas de início e fim não podem ser nulas.");
        }

        if (inicio.isBefore(LocalDate.now())) {
            throw new BootcampException("A data de início deve ser hoje ou futura.");
        }

        if (!fim.isAfter(inicio)) {
            throw new BootcampException("A data de fim deve ser posterior à data de início.");
        }

        this.dataInicio = inicio;
        this.dataFim = fim;
    }

    /**
     * Adiciona um conteúdo ao bootcamp.
     *
     * @param conteudo conteúdo a ser adicionado ao bootcamp
     * @throws BootcampException se o conteúdo já estiver presente
     */
    public void adicionarConteudo(Conteudo conteudo) {
        if (!this.conteudos.add(conteudo)) {
            throw new BootcampException("Este conteúdo já foi adicionado ao bootcamp.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public Set<Dev> getDevs() {
        return devs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) &&
                Objects.equals(descricao, bootcamp.descricao) &&
                Objects.equals(dataInicio, bootcamp.dataInicio) &&
                Objects.equals(dataFim, bootcamp.dataFim) &&
                Objects.equals(conteudos, bootcamp.conteudos) &&
                Objects.equals(devs, bootcamp.devs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicio, dataFim, conteudos, devs);
    }
}
