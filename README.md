# EcoGame

O **EcoGame** é um jogo educacional desenvolvido em Java com o objetivo de abordar conceitos relacionados à educação ambiental por meio da classificação de resíduos.

O projeto foi desenvolvido como parte das **Atividades Práticas Supervisionadas (APS)** do curso de **Ciência da Computação**, com aplicação de conceitos da disciplina de **Programação Orientada a Objetos**.

---

## Sobre o projeto

No EcoGame, diferentes tipos de resíduos aparecem na tela e se deslocam em direção à parte inferior da área de jogo.

O jogador deve identificar corretamente o tipo de resíduo apresentado e utilizar a tecla correspondente à lixeira adequada.

O jogo possui sistema de pontuação, controle de vidas, tela de fim de jogo, possibilidade de reinício da partida e armazenamento das melhores pontuações em um banco de dados SQLite local.

---

## Objetivo

O objetivo do EcoGame é relacionar uma mecânica simples de jogo com o tema da separação de resíduos.

Durante a partida, o jogador precisa reconhecer diferentes categorias de materiais e associá-las às respectivas lixeiras.

O projeto também foi utilizado para aplicar conceitos estudados durante o curso, incluindo:

- Programação Orientada a Objetos;
- desenvolvimento de interfaces gráficas;
- tratamento de eventos;
- organização do código em pacotes;
- persistência de dados;
- acesso a banco de dados;
- gerenciamento de dependências com Maven.

---

## Tipos de resíduos

O EcoGame trabalha com quatro categorias de resíduos:

| Tipo | Descrição |
|---|---|
| Papel | Resíduos classificados como papel |
| Vidro | Resíduos classificados como vidro |
| Plástico | Resíduos classificados como plástico |
| Orgânico | Resíduos classificados como matéria orgânica |

---

## Controles

O jogador utiliza o teclado para selecionar a categoria correspondente ao item exibido na tela.

| Tecla | Tipo de resíduo |
|---|---|
| `A` | Papel |
| `S` | Vidro |
| `D` | Plástico |
| `F` | Orgânico |

---

## Sistema de pontuação

Quando o jogador realiza uma classificação correta, são adicionados pontos à pontuação da partida.

Cada acerto corresponde a:

```text
+10 pontos
```

Quando ocorre um erro, o jogador perde uma vida.

Quando não há mais vidas disponíveis, a partida é encerrada e a tela de fim de jogo é apresentada.

---

## Ranking

Ao finalizar uma partida, o jogador pode informar seu nome.

A pontuação obtida é armazenada em um banco de dados SQLite local.

Após o registro, o jogo consulta as melhores pontuações e apresenta o ranking na tela de fim de jogo.

Atualmente, são exibidas até:

```text
5 melhores pontuações
```

O ranking é ordenado da maior para a menor pontuação.

---

## Tecnologias utilizadas

O projeto utiliza as seguintes tecnologias:

- Java 17;
- Java Swing;
- Java AWT;
- Graphics2D;
- Maven;
- JDBC;
- SQLite;
- SQLite JDBC 3.46.1.3;
- Maven Compiler Plugin;
- Maven Shade Plugin;
- Git;
- GitHub.

---

## Estrutura do projeto

A estrutura principal do código-fonte está organizada da seguinte forma:

```text
EcoGame/
├── pom.xml
├── README.md
│
└── src/
    └── main/
        └── java/
            └── com/
                └── ecogame/
                    ├── Main.java
                    │
                    ├── controller/
                    │   └── Pontuacao.java
                    │
                    ├── dao/
                    │   ├── ConexaoBanco.java
                    │   └── RankingDAO.java
                    │
                    ├── model/
                    │   ├── ItemLixo.java
                    │   ├── Lixeira.java
                    │   └── TipoLixo.java
                    │
                    └── view/
                        ├── JanelaJogo.java
                        └── PainelJogo.java
```

---

## Organização das classes

### `Main.java`

Classe responsável pelo ponto de entrada da aplicação.

A partir dela é iniciada a interface gráfica do EcoGame.

---

### `controller/Pontuacao.java`

Responsável pelo gerenciamento da pontuação e das vidas do jogador.

Entre suas responsabilidades estão:

- registrar acertos;
- registrar erros;
- controlar a quantidade de pontos;
- controlar as vidas;
- verificar o fim da partida;
- reiniciar os valores para uma nova partida.

---

### `model/ItemLixo.java`

Representa os itens de lixo utilizados durante a partida.

Cada item possui informações relacionadas à sua posição, velocidade de deslocamento e tipo de resíduo.

---

### `model/Lixeira.java`

Representa as lixeiras existentes no jogo.

Cada lixeira está associada a um determinado tipo de resíduo.

---

### `model/TipoLixo.java`

Enumeração responsável pela definição dos tipos de resíduos utilizados pelo EcoGame:

```java
PAPEL
VIDRO
PLASTICO
ORGANICO
```

---

### `view/JanelaJogo.java`

Representa a janela principal da aplicação.

É responsável por configurar e exibir a interface que contém o painel do jogo.

---

### `view/PainelJogo.java`

É a principal classe responsável pela interface e pelo funcionamento visual da partida.

Entre suas responsabilidades estão:

- desenhar os elementos gráficos;
- gerar os itens de lixo;
- atualizar o estado da partida;
- controlar os temporizadores;
- receber comandos do teclado;
- verificar as classificações realizadas pelo jogador;
- apresentar pontuação e vidas;
- detectar o fim da partida;
- apresentar o ranking;
- disponibilizar o botão de reinício.

---

### `dao/ConexaoBanco.java`

Responsável pela conexão com o banco de dados SQLite.

Também cria automaticamente a tabela necessária para armazenar o ranking caso ela ainda não exista.

---

### `dao/RankingDAO.java`

Responsável pelas operações relacionadas ao ranking.

A classe realiza operações como:

- salvar o nome e a pontuação do jogador;
- consultar as melhores pontuações;
- ordenar os resultados para apresentação no jogo.

---

## Banco de dados

O EcoGame utiliza um banco de dados SQLite local.

O arquivo é criado durante a execução da aplicação com o nome:

```text
ranking.db
```

A conexão utilizada pela aplicação é:

```text
jdbc:sqlite:ranking.db
```

A tabela utilizada para armazenar os resultados é denominada:

```text
ranking
```

Sua estrutura contém os seguintes dados:

```text
id
jogador
pontos
data_hora
```

O arquivo `ranking.db` não é enviado ao repositório GitHub, pois cada execução pode possuir seu próprio banco de dados local.

Ele está incluído no arquivo `.gitignore`.

---

## Interface gráfica

A interface gráfica foi desenvolvida utilizando **Java Swing**.

Os elementos personalizados do jogo são desenhados utilizando recursos do **AWT** e da classe **Graphics2D**.

A tela apresenta elementos como:

- itens de resíduos;
- lixeiras;
- identificação das teclas;
- pontuação;
- vidas;
- tela de fim de jogo;
- ranking;
- botão de reinício.

---

## Programação Orientada a Objetos

O projeto utiliza diferentes recursos relacionados à Programação Orientada a Objetos.

### Encapsulamento

Os atributos das classes são mantidos internamente e acessados por meio dos métodos definidos em cada classe.

### Herança

A interface utiliza classes da biblioteca Swing por meio de herança.

Por exemplo:

```java
JanelaJogo extends JFrame
```

e:

```java
PainelJogo extends JPanel
```

### Composição e associação

As diferentes classes do projeto trabalham de forma conjunta.

O painel do jogo utiliza objetos como:

```text
Pontuacao
ItemLixo
Lixeira
RankingDAO
```

para realizar diferentes partes do funcionamento da aplicação.

### Enumeração

A enumeração `TipoLixo` foi utilizada para representar de forma organizada os diferentes tipos de resíduos existentes no jogo.

### Separação de responsabilidades

O código foi dividido em pacotes conforme suas principais responsabilidades:

```text
model
view
controller
dao
```

A organização possui características semelhantes ao padrão MVC, embora a classe `PainelJogo` concentre tanto responsabilidades relacionadas à interface quanto parte da lógica da partida.

---

## Requisitos

Para compilar e executar o projeto é recomendado possuir:

```text
JDK 17
Apache Maven
```

O projeto foi configurado para compilação utilizando Java 17.

Versões mais recentes do Java também podem executar a aplicação, porém podem apresentar avisos relacionados ao carregamento da biblioteca nativa utilizada pelo SQLite JDBC.

---

## Compilação

Abra um terminal na pasta raiz do projeto.

Execute:

```bash
mvn clean package
```

O Maven irá:

1. baixar as dependências necessárias;
2. compilar o código-fonte;
3. executar a etapa de empacotamento;
4. gerar um JAR executável contendo as dependências necessárias.

Após uma compilação bem-sucedida, deverá ser apresentada a mensagem:

```text
BUILD SUCCESS
```

O arquivo executável será criado em:

```text
target/ecogame.jar
```

---

## Maven Shade Plugin

O projeto utiliza o **Maven Shade Plugin** para gerar um único arquivo JAR contendo tanto as classes do EcoGame quanto as dependências necessárias para sua execução.

Isso inclui o driver JDBC utilizado pelo SQLite.

Dessa forma, o arquivo:

```text
target/ecogame.jar
```

pode ser executado diretamente sem a necessidade de informar manualmente o caminho das dependências.

---

## Como executar

Após a compilação, execute:

```bash
java -jar target/ecogame.jar
```

A janela principal do EcoGame será aberta.

---

## Execução em versões recentes do Java

Em versões mais recentes do Java, como Java 26, o SQLite JDBC pode apresentar avisos relacionados ao acesso a bibliotecas nativas.

Exemplo:

```text
WARNING: A restricted method in java.lang.System has been called
```

Esse aviso não impede a execução do jogo.

Caso seja necessário permitir explicitamente o acesso nativo, a aplicação pode ser iniciada com:

```bash
java --enable-native-access=ALL-UNNAMED -jar target/ecogame.jar
```

Para o ambiente originalmente configurado pelo projeto, recomenda-se a utilização do **Java 17**.

---

## Funcionamento da partida

Durante a execução:

1. itens de resíduos são gerados na parte superior da tela;
2. os itens se deslocam em direção à parte inferior;
3. o jogador identifica o tipo de material;
4. uma das teclas `A`, `S`, `D` ou `F` é pressionada;
5. o jogo verifica a classificação selecionada;
6. um acerto adiciona pontos;
7. um erro reduz a quantidade de vidas;
8. quando as vidas terminam, a partida é encerrada;
9. o jogador informa seu nome;
10. a pontuação é armazenada no SQLite;
11. as melhores pontuações são apresentadas;
12. o jogador pode iniciar uma nova partida utilizando o botão **Reiniciar**.

---

## Arquivos ignorados pelo Git

Arquivos gerados localmente e ferramentas auxiliares utilizadas durante o desenvolvimento não são enviados para o repositório.

Entre eles estão:

```text
target/
ranking.db
analise/
documentacao/
__pycache__/
*.pyc
```

Também são ignorados arquivos específicos de IDEs e arquivos compilados.

---

## Repositório

O código-fonte do projeto está disponível no GitHub:

https://github.com/Rodrigo-Stt/EcoGame

---

## Contexto acadêmico

Projeto desenvolvido para fins acadêmicos como parte das **Atividades Práticas Supervisionadas (APS)** do curso de **Ciência da Computação**.

Tema do trabalho:

> **Desenvolvimento de um jogo com utilização de interface gráfica**

O projeto utiliza a temática de educação ambiental e separação de resíduos, associando o desenvolvimento da aplicação aos conteúdos de Programação Orientada a Objetos.

---

## Status do projeto

O projeto possui atualmente:

- interface gráfica funcional;
- geração de resíduos;
- quatro categorias de materiais;
- controles por teclado;
- sistema de pontuação;
- sistema de vidas;
- tela de fim de jogo;
- reinício da partida;
- banco de dados SQLite;
- armazenamento de pontuações;
- ranking com as melhores pontuações;
- geração de JAR executável com dependências.

---

## Autor

Projeto acadêmico desenvolvido para o curso de **Ciência da Computação**.

**EcoGame — 2026**