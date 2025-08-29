package model.conteudo;

import exception.ConteudoException;

/**
 * Representa um curso dentro do Bootcamp.
 * Cada curso possui título, descrição e carga horária em horas.
 */
public class Curso extends Conteudo {

    /** Carga horária do curso em horas */
    private int cargaHoraria;

    /**
     * Construtor do curso
     *
     * @param titulo       título do curso
     * @param descricao    descrição do curso
     * @param cargaHoraria carga horária do curso (maior que 0)
     * @throws ConteudoException se a carga horária for inválida
     */
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        setCargaHoraria(cargaHoraria);
    }

    /**
     * Define a carga horária do curso
     *
     * @param cargaHoraria carga horária do curso
     * @throws ConteudoException se a carga horária for menor que 0
     */
    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new ConteudoException("A carga horária deve ser maior que zero.");
        }

        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * Calcula a quantidade de XP obtida ao concluir o curso
     *
     * @return XP do curso
     */
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }
}
