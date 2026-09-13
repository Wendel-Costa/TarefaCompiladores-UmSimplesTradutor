Aluno: Wendel Davi Reis Costa


# Trabalho 1 — Tradutor de Aquecimento (expressões aritméticas → notação pós-fixa)

**Disciplina:** Compiladores
**Tipo:** Individual
**Baseado em:** Unidade 1, Capítulo 2 — Aquecimento: um simples tradutor

## Objetivo

Implementar, passo a passo, o tradutor de expressões aritméticas descrito no Capítulo 2 do livro-texto da disciplina. O objetivo não é o tradutor em si, mas praticar as técnicas que serão usadas nos capítulos seguintes para construir o tokenizador e o parser da linguagem Jack: análise léxica, análise sintática descendente recursiva e tradução dirigida pela sintaxe.

<aside>
💡

Usem como base o tutorial https://profsergiocosta.notion.site/Tradu-o-dirigida-por-sintaxe-bc590c67d8234f81bee5cfdb505f2dd1?pvs=74 que está mais completo do que o do e-book.

</aside>

## O que deve ser entregue

Seguindo o tutorial do link acima, o aluno deve implementar **todos os 8 passos** descritos no capítulo, chegando a um programa funcional que:

1. Recebe uma expressão como `let a = 42 + 5; print a + 6;` e a traduz para uma sequência de comandos em notação pós-fixa (`push`, `pop`, `add`, `sub`, `print`).
2. Possui um **Scanner** (analisador léxico) que reconhece números de múltiplos dígitos, identificadores, a palavra reservada `let`, a palavra `print` e os símbolos `+`, , `=`, `;`, ignorando espaços em branco.
3. Possui um **Parser** descendente recursivo (um método por não-terminal) que consome os tokens do Scanner e emite a tradução.
4. Possui um pequeno **Interpretador** que executa a saída do parser sobre uma pilha e um mapa de variáveis, imprimindo o resultado dos comandos `print`.

## Linguagem

O trabalho deve ser feito **preferencialmente em Java**, pois o tutorial apresenta o código pronto nessa linguagem e basta segui-lo. Alunos que desejarem podem implementar em outra linguagem de sua escolha, desde que mantenham a mesma estrutura (Scanner / Parser / Interpretador) e o mesmo comportamento descrito no tutorial.

## Extensões obrigatórias

Além de seguir os 8 passos, o aluno deve estender o tradutor para suportar os operadores `*` e `/` (multiplicação e divisão), conforme sugerido como exercício no final do Passo 1 do tutorial. Isso exige ajustar a gramática, o Scanner e o Parser de forma consistente com o padrão já usado para `+` e `-`.

## Como entregar

1. Criar um repositório no GitHub com o código do trabalho.
2. Baixar o repositório como `.zip` (botão *Code → Download ZIP* do GitHub).
3. Enviar o arquivo `.zip` no SIGAA.
4. No campo de comentários da entrega, colar o link do repositório no GitHub.

## Critérios de avaliação

- Corretude da tradução para expressões com múltiplos dígitos, identificadores e espaços em branco.
- Corretude dos comandos `let` e `print`.
- Suporte funcional a  e `/`.
- Organização do código em Scanner / Parser / Interpretador, seguindo a separação de responsabilidades discutida no tutorial.
- Repositório no GitHub com histórico de commits que reflita o desenvolvimento incremental (não um único commit final).