package service;

import model.Bootcamp;
import model.Dev;
import model.conteudo.Conteudo;

import java.util.Optional;

/**
 * Serviço para gerenciar inscrições e progresso dos devs nos bootcamps.
 */
public class DevService {

    /**
     * Inscreve um dev em um bootcamp.
     *
     * @param dev       desenvolvedor a ser inscrito
     * @param bootcamp  bootcamp no qual o dev será inscrito
     */
    public void inscreverBootcamp(Dev dev, Bootcamp bootcamp) {
        bootcamp.getDevs().add(dev);
        dev.getConteudosIncritos().addAll(bootcamp.getConteudos());
    }

    /**
     * Marca o próximo conteúdo inscrito como concluído e adiciona XP ao dev.
     *
     * @param dev desenvolvedor que está progredindo
     */
    public void progredir(Dev dev) {
        Optional<Conteudo> conteudoOptional = dev.getConteudosIncritos().stream().findFirst();

        if (conteudoOptional.isPresent()) {
            Conteudo conteudo = conteudoOptional.get();
            dev.getConteudosConcluidos().add(conteudo);
            dev.getConteudosIncritos().remove(conteudo);
            dev.adicionaXp(conteudo.calcularXp());
        } else {
            System.out.println("Você não está matriculado em nunnhum conteúdo.");
        }
    }
}
