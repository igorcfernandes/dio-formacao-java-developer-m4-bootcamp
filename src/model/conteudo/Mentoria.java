package model.conteudo;


import exception.ConteudoException;

import java.time.LocalDate;

/**
 * Representa uma mentoria dentro do Bootcamp.
 * Cada mentoria possui tículo, descrição e uma data de realiazação
 */
public class Mentoria extends Conteudo {

    /** Data em que a mentoria será realizada */
    private LocalDate data;

    /**
     * Construtor da mentoria
     *
     * @param titulo    título da mentoria
     * @param descricao descrição da mentoria
     * @param data      data da mentoria
     * @throws ConteudoException se data for inválida
     */
    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        setData(data);
    }

    /**
     * Define a data da mentoria
     *
     * @param data data da mentoria
     * @throws ConteudoException se a data for nula ou anterior à data atual
     */
    private void setData(LocalDate data) {
        if (data == null || data.isBefore(LocalDate.now())) {
            throw new ConteudoException("A data da mentoria deve ser hoje ou futura.");
        }

        this.data = data;
    }

    /**
     * Calcula o XP obtido ao concluir a mentoria
     *
     * @return XP fixo da mentoria
     */
    @Override
    public double calcularXp() {
        return XP_PADRAO * 3;
    }
}
