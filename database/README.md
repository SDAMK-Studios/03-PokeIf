# 🗄️ Banco de Dados ( database/ )

## 📌 Introdução

A pasta `database/` abriga todo o ecossistema de **persistência e modelagem de dados** do projeto **pokeIF**.

Para suportar as mecânicas de um jogo retrô 2D ambientado no **IFCE Campus Maranguape**, a aplicação necessita de um banco de dados **MySQL** robusto e confiável. Este diretório centraliza desde a modelagem conceitual e lógica do banco de dados até os scripts SQL responsáveis pelo armazenamento de contas de utilizadores, dados do jogador, registos da agenda integrada, histórico de duelos e inventário.

---

## 📁 Estrutura de Diretórios

```text
database/
├── README.md                   # Documentação do diretório de banco de dados
├── DER/                        # Diagrama Entidade-Relacionamento (Modelo Conceitual)
├── DL/                         # Diagrama Lógico de Dados (Modelo Lógico)
└── scripts/                    # Scripts SQL para criação das tabelas (DDL) e população inicial (DML)
