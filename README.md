# 🎮 pokeIF

<p align="center">
  <!-- INSIRA A LOGO DO JOGO ABAIXO -->
  <img src="resources/images/logo_SDAMK _STUDIOS.png" alt="Logo do pokeIF" width="320"/>
</p>

<p align="center">
  <b>Projeto Livre da disciplina de Programação Orientada a Objetos (POO)</b><br/>
  <i>Desenvolvido por: SDAMK Studios — IFCE Campus Maranguape</i>
</p>

---

## 📝 Descrição

O **pokeIF** é um jogo retrô em perspectiva 2D que combina nostalgia com a rotina e o cotidiano dos estudantes do **IFCE Campus Maranguape**.

A narrativa acompanha um estudante (o protagonista) que chega ao campus para assistir às suas aulas, mas é barrado na entrada por estar **sem o devido fardamento escolar**. Para conquistar o direito de entrar na escola, o jogador precisa encarar uma jornada dividida em **4 fases**, duelando contra 4 personagens diferentes — culminando em um confronto contra o grande **chefão final**.

Inspirado em mecânicas clássicas e trazendo elementos visuais do *Pokémon GO* (presente inclusive na identidade visual e na logo), o **pokeIF** conta ainda com uma funcionalidade utilitária integrada: uma **agenda de contatos**.

---

## 🎯 Objetivos

* **Acessibilidade:** Desenvolver um jogo interativo, leve, de baixo tamanho e 100% jogável de forma offline, garantindo compatibilidade com a maioria dos dispositivos.
* **Aplicação Prática de POO:** Demonstrar a importância real dos conceitos da disciplina de Programação Orientada a Objetos na formação de desenvolvedores de software, especialmente voltada para a criação de games e sistemas de gestão.
* **Representatividade Acadêmica:** Homenagear o ecossistema do IFCE Campus Maranguape de forma lúdica e descontraída.

---

## 🛠 Tecnologias Utilizadas

> ⚠️ *O projeto encontra-se atualmente em fase de **planejamento e desenvolvimento teórico**.*

* **Java / JavaFX:** Linguagem principal e biblioteca gráfica para construção do ambiente 2D e das interfaces.
* **MySQL:** Banco de dados relacional planejado para persistência de dados (como informações do jogador e a agenda de contatos).
* **Git & GitHub:** Controle de versão e organização em equipe.

---

## 🚀 Como Executar o Projeto

De acordo com o planejamento de implantação do projeto:

1. Baixe o pacote comprimido (`.zip`) do projeto ou realize o download da versão mais recente nas *Releases*.
2. Extraia os arquivos na pasta de sua preferência no seu computador.
3. Execute o arquivo do jogo.
4. **Pronto para uso!** Não é necessária nenhuma conexão com a internet.

---

## 📸 Capturas de Tela e Mídias

* **Logo do Jogo:** Guardada no caminho `resources/images/logo_pokeif.png`
* **Foto da Equipe:** Guardada no caminho `resources/images/IMG_20260929_121014.jpg`

---

## 📁 Estrutura do Diretório

A organização do repositório segue uma estrutura padronizada para separar código-fonte, recursos visuais, documentação técnica e materiais de suporte:

```text
PokeIf/
├── .gitignore             # Arquivos e pastas ignorados pelo Git
├── LICENSE                # Licença de uso do projeto (MIT License)
├── README.md              # Documentação principal do repositório
│
├── database/              # Modelagem e scripts de Banco de Dados
│   ├── DER/               # Diagrama Entidade-Relacionamento (Modelo Conceitual)
│   ├── DL/                # Diagrama Lógico (Modelo Lógico)
│   └── scripts/           # Scripts SQL (Criação de tabelas e inserção de dados)
│
├── docs/                  # Documentação técnica e visual do sistema
│   ├── diagrams/          # Diagramas explicativos do fluxo do jogo
│   ├── presentations/     # Apresentações e slides do projeto
│   ├── ui-ux/             # Protótipos e design da interface do usuário
│   │   ├── mockups/       # Designs de alta fidelidade das telas
│   │   ├── prototypes/    # Protótipos interativos
│   │   └── wireframes/    # Esboços e estruturas de tela
│   └── uml/               # Diagramas UML (Classes, Casos de Uso, Sequência, etc.)
│
├── resources/             # Recursos estáticos e visuais da interface
│   ├── icons/             # Ícones utilizados na UI
│   └── images/            # Imagens, logos e fotos da equipe
│
├── src/                   # Código-fonte da aplicação em Java / JavaFX
│
└── support/               # Materiais complementares e de apoio
    ├── documents/         # Documentos de apoio e especificações
    ├── references/        # Referências bibliográficas e links úteis
    ├── tutorials/         # Guias e tutoriais de utilização e execução
    └── videos/            # Recursos audiovisuais usados no desenvolvimento
