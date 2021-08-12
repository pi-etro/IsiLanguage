# IsiLanguage
Compilador da IsiLanguage, projeto da disciplina de Compiladores da UFABC.

| Nome            | RA        |
|-----------------|-----------|
|Gabriel Fernandes|11048816   |
|Pedro Machado    |11201721325|
|Pietro Gregorio  |11038416   |

## Requisitos

### Itens Obrigatórios
 - [ ] Possuir 2 tipos de variáveis (pelo menos 1 deles String)
 - [ ] Possuir a instrução  if-else
 - [ ] Pelo menos 1 estrutura de repetição
 - [ ] Verificar atribuição de variáveis (erro semântico) - compatibilidade de tipos
 - [ ] Possui operações de Entrada e Saída
 - [ ] Aceitar números decimais
 - [ ] Verificar se variável foi ou não declarada
 - [ ] Verificar se variável declarada foi ou não utilizada
 - [ ] Linguagem Destino (C/Java/Python)

### Itens Opcionais
 - [ ] .
 - [ ] .
 - [ ] .
 - [ ] .
 - [ ] .

## Utilização

```
java -cp .:antlr-4.9.2-complete.jar org.antlr.v4.Tool IsiLang.g4 -package br.com.professorisidro.isilanguage -o ./src/br/com/professorisidro/isilanguage/parser/
```
