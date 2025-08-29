## Desafio Bootcamp

O objetivo deste projeto prático hands-on é reforçar o conhecimento em **Programação Orientada a Objetos (POO)** em Java, através da implementação de um sistema que simula um **bootcamp de desenvolvimento**.
Serão trabalhados, na prática, os quatro pilares da POO:

- Abstração
- Encapsulamento
- Herança
- Polimorfismo

<br>

### Descrição

Este repositório contém um projeto de referência desenvolvido em **Java**, modelando um **bootcamp**, com os seguintes recursos:

- Criação de **cursos** e **mentorias**, ambos herdando de uma **classe abstrata Conteudo**.
- Cada curso possui **carga horária**, e cada mentoria possui uma **data**.
- **Classe Bootcamp** para gerenciar conteúdos e devs inscritos.
- **Classe Dev** para representar desenvolvedores, com controle de conteúdos inscritos, conteúdos concluídos e XP acumulado.
- **Serviço DevService** para inscrição em bootcamp, progresso nos conteúdos e cálculo de XP.
- **Classe utilitária DevPrinter** para exibir informações de devs e seus conteúdos.
- **Validações robustas** com **Exceptions personalizadas**, incluindo:
    - `ConteudoException`
    - `BootcampException`
    - `DevException`

Este projeto serve como referência para aprendizado de:

- **Programação Orientada a Objetos (POO)** em Java
- **Herança e classes abstratas**
- **Tratamento de exceções**
- **Validação de dados**
- Boas práticas de **design de código** e organização de projetos

<br>

### Diagrama UML

```mermaid
classDiagram
direction TB
    class Conteudo {
        - String titulo
        - String descricao
        + calcularXp() double
    }

    class Curso {
        - int cargaHoraria
        + getCargaHoraria() int
        + setCargaHoraria(int cargaHoraria)
        + calcularXp() double
    }

    class Mentoria {
        - LocalDate data
        + getData() LocalDate
        + setData(LocalDate data)
        + calcularXp() double
    }

    class Bootcamp {
        - String nome
        - String descricao
        - LocalDate dataInicio
        - LocalDate dataFim
        - Set~Conteudo~ conteudos
        - Set~Dev~ devs
        + adicionarConteudo(Conteudo conteudo)
        + getConteudos() Set~Conteudo~
        + getDevs() Set~Dev~
    }

    class Dev {
        - String nome
        - Set~Conteudo~ conteudosInscritos
        - Set~Conteudo~ conteudosConcluidos
        - double totalXp
        + adicionarXp(double xp)
        + getTotalXp() double
    }

    class DevService {
        + inscreverBootcamp(Dev dev, Bootcamp bootcamp)
        + progredir(Dev dev)
    }

    class DevPrinter {
        + imprimir(Dev dev)
        + imprimirConteudo(String titulo, Set~Conteudo~ conteudos)
    }

    Conteudo <|-- Curso
    Conteudo <|-- Mentoria
    Bootcamp --> Conteudo : contém
    Bootcamp --> Dev : possui
    DevService --> Dev : gerencia
    DevService --> Bootcamp : gerencia
    DevPrinter --> Dev : imprime

