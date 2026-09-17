# EcoGame

O **EcoGame** é um jogo educacional desenvolvido em Java com o objetivo de trabalhar conceitos de educação ambiental por meio da classificação correta de resíduos.

O projeto foi desenvolvido como parte das Atividades Práticas Supervisionadas (APS) do curso de Ciência da Computação.

## Objetivo

O jogo apresenta itens de resíduos que caem pela tela. O jogador deve identificar o tipo do resíduo e selecionar a lixeira correspondente utilizando o teclado.

O sistema utiliza pontuação, vidas e um ranking local para registrar os melhores resultados obtidos durante as partidas.

## Tipos de resíduos

O EcoGame trabalha com quatro categorias:

- Papel
- Vidro
- Plástico
- Orgânico

## Controles

| Tecla | Tipo de resíduo |
|---|---|
| A | Papel |
| S | Vidro |
| D | Plástico |
| F | Orgânico |

## Tecnologias utilizadas

- Java 17
- Java Swing
- AWT / Graphics2D
- Maven
- SQLite
- JDBC
- SQLite JDBC 3.46.1.3

## Estrutura do projeto

```text
src/main/java/com/ecogame/
├── Main.java
├── controller/
│   └── Pontuacao.java
├── dao/
│   ├── ConexaoBanco.java
│   └── RankingDAO.java
├── model/
│   ├── ItemLixo.java
│   ├── Lixeira.java
│   └── TipoLixo.java
└── view/
    ├── JanelaJogo.java
    └── PainelJogo.java