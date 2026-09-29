# Sistema de Login em Java - v0.0.0 (Design Inicial)

Este repositório contém a especificação e o protótipo conceitual da **versão 0.0.0** da interface de um Sistema de Login desenvolvido em Java. Esta versão inicial documenta a arquitetura de telas e o fluxo de interface do usuário (UI/UX) desenhados manualmente.

---

## 📌 Visão Geral do Protótipo (v0.0.0)

O layout inicial estabelece a divisão estrutural dos componentes visuais da aplicação, englobando a área de autenticação de credenciais e os módulos navegáveis do sistema.

## 🧩 Componentes do Layout

Com base no esboço conceitual, a interface divide-se nas seguintes seções:

1. **Painel de Autenticação (Direita):**
   * **Campo Usuário:** Input para inserção do nome de usuário/e-mail.
   * **Campo Senha:** Input para credencial de acesso segura.

2. **Painel de Conexão e Identidade (Esquerda):**
   * **Módulo BD:** Indicador/Status de conexão com o banco de dados.
   * **Módulo Logo:** Espaço reservado para o logotipo principal do sistema.

3. **Navegação e Estrutura Superior/Inferior:**
   * **Cabeçalho / Header:** Área para título do sistema ou navegação primária.
   * **Rodapé / Footer:** Painel inferior para informações de status, versão ou links auxiliares.

---

## 🛠️ Tecnologias Previstas

* **Linguagem:** Java (JDK 17+)
* **Interface Gráfica (GUI):** JavaFX ou Swing
* **Banco de Dados:** MySQL / PostgreSQL

---
# Sistema de Login e Navegação em Java - v1.0.0

Este repositório contém a especificação e a documentação de interface do usuário (UI/UX) para a **versão 1.0.0** da aplicação Java. Nesta versão, o esboço conceitual inicial foi refinado e transformado em um design moderno, limpo e intuitivo com fluxo de telas completo.

---

## 📌 Visão Geral da Versão (v1.0.0)

A v1.0.0 traz a evolução do protótipo desenhado à mão para uma interface digital moderna, estabelecendo um fluxo claro entre autenticação, menu principal e os módulos da aplicação.

### 🔄 Fluxo de Navegação do Usuário

 [ Tela de Login ] ──( Autenticar )──> [ Menu Principal ]
                                            │
                                            ├──> [ Agenda de Contatos ]
                                            └──> [ Nosso Jogo ]

---

## 🖥️ Módulos e Telas do Sistema

### 1. Tela de Login (`v1.0.0`)
* **Design Moderno:** Layout vertical limpo, estilo *mobile/responsive*, com paleta de cores azul e cantos arredondados.
* **Formulário de Entrada:**
  * **Usuário:** Campo de texto com ícone indicativo e placeholder ("Digite seu usuário").
  * **Senha:** Campo de senha com ícone de cadeado e alternador de visibilidade (exibir/ocultar senha).
* **Ação:** Botão de destaque "Entrar".

### 2. Menu Principal
* **Cabeçalho:** Barra azul com botão de voltar (`←`) e título "Menu Principal".
* **Mensagem de Boas-Vindas:** "Bem-vindo! Escolha uma opção abaixo."
* **Opções de Navegação (Cards Clicáveis):**
  * **Agenda de Contatos:** Redireciona para o gerenciamento de contatos (Ícone de agenda).
  * **Nosso Jogo:** Redireciona para a área de entretenimento (Ícone de controle/gamepad).

### 3. Agenda de Contatos
* **Interface:** Visualização simplificada da lista/gerenciador de contatos.
* **Descrição:** "Sua Agenda - Aqui você pode visualizar e gerenciar seus contatos."
* **Ação Principal:** Botão em destaque "+ Adicionar Contato".

### 4. Módulo "Nosso Jogo"
* **Interface:** Tela com elementos gráficos lúdicos.
* **Descrição:** "Vamos Jogar! Escolha suas habilidades e divirta-se com o nosso jogo."
* **Ação Principal:** Botão de início rápido "► Iniciar Jogo" (Verde).

---

# Sistema de Login e Navegação em Java - v1.1.0

Este repositório contém a especificação e a documentação de interface do usuário (UI/UX) para a **versão 1.1.0** da aplicação Java. Nesta versão, a interface foi aprimorada com novos ícones temáticos, atualização visual dos botões do menu e integração do mapa do jogo.

---

## 📌 Visão Geral da Versão (v1.1.0)

A versão v1.1.0 traz uma atualização significativa nos elementos visuais do Menu Principal e das telas integradas:
* **Ícone do Jogo:** Atualizado para o estilo Pokébola.
* **Tela do Jogo:** Exibição do mapa estilo Pokémon (visão top-down em pixel art).
* **Agenda de Contatos:** Representada por um ícone de Banco de Dados SQL estilizado.

### 🔄 Fluxo de Navegação do Usuário

 [ Tela de Login ] ──( Autenticar )──> [ Menu Principal ]
                                            │
                                            ├──> [ Agenda de Contatos (SQL) ]
                                            └──> [ Jogo (Mapa Pokémon) ]

---

## 🖥️ Módulos e Telas do Sistema

### 1. Tela de Login (`v1.1.0`)
* **Design:** Layout vertical em tons de azul e branco com bordas arredondadas.
* **Campos:**
  * **Usuário:** Campo de texto com ícone de perfil e texto explicativo ("Digite seu usuário").
  * **Senha:** Campo de senha com ícone de cadeado e botão para alternar visibilidade.
* **Ação:** Botão principal "Entrar" que redireciona o usuário para o Menu Principal.

### 2. Menu Principal (`v1.1.0`)
* **Cabeçalho:** Barra superior azul com botão de voltar (`←`) e título "Menu Principal".
* **Atalhos e Ícones Reorganizados:**
  * **Agenda de Contatos:** Card com ícone de agenda roxa.
  * **Jogo:** Card com ícone de Pokébola clássica em estilo 3D.

### 3. Agenda de Contatos (`v1.1.0` - Banco de Dados SQL)
* **Cabeçalho:** Barra de navegação "Agenda de Contatos" com botão de voltar (`←`).
* **Visual Ilustrativo:** Ícone centralizado de banco de dados 3D em tons de azul com a etiqueta **SQL**.
* **Descrição:** "Aqui você pode visualizar e gerenciar seus contatos."

### 4. Tela do Jogo (`v1.1.0` - Mapa Pokémon)
* **Cabeçalho:** Barra de navegação "Jogo" com botão de voltar (`←`).
* **Ambiente de Jogo:** Renderização do mapa do jogo em pixel art (estilo clássico Pokémon), com estradas, casas, áreas aquáticas e árvores.

---

