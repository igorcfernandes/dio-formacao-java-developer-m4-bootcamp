package model.conteudo;

import exception.ConteudoException;

/**
 * Classe abstrata que representa um conteúdo do Bootcamp.
 * Serve como base para Cursos e Mentorias.
 */
public abstract class Conteudo {

    /** XP padrão atribuído a cada conteúdo */
    protected static final double XP_PADRAO = 10.0;

    private String titulo;
    private String descricao;

    /**
     * Construtor do conteúdo, exige título e descrição válidos.
     *
     * @param titulo título do conteúdo
     * @param descricao descrição do conteúdo
     * @throws ConteudoException se título ou descrição forem inválidos
     */
    public Conteudo(String titulo, String descricao) {
        setTitulo(titulo);
        setDescricao(descricao);
    }

    /** Valida e define o título do conteúdo */
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ConteudoException("O título do conteúdo não pode ser vazio.");
        }

        this.titulo = titulo;
    }

    /** Valida e define a descrição do conteúdo */
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new ConteudoException("A descrição do conteúdo não pode ser vazia.");
        }

        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Calcula a quantidade de XP obtida ao concluir este conteúdo.
     *
     * @return XP do conteúdo
     */
    public abstract double calcularXp();
}
