# Exercício 1 – Cadastro de Funcionários do Banco J

Você está desenvolvendo um sistema de gerenciamento de funcionários para o Banco J. Cada funcionário deve ter as seguintes informações armazenadas: nome completo, departamento, salário, data de entrada no banco (inicialmente como uma String), RG (String) e um indicador booleano para informar se o funcionário está atualmente ativo na empresa ou não. 

O sistema precisa fornecer funcionalidades para aplicar uma bonificação ao salário, recebendo um valor numérico como argumento, além de permitir demitir o funcionário, alterando seu status para "inativo". Não se esqueça de utilizar a convenção Java ao nomear classes, métodos e variáveis.

**Estrutura sugerida de pastas:**

```
src/
 ├── application/
 │   └── Main.java (classe contendo o método main)
 └── entities/
     └── Funcionario.java
```

---

# Exercício 2 – Teste da classe Funcionário

Utilizando a classe `Funcionario` criada no exercício anterior, implemente uma classe `Main` que tenha o método `main`. Essa classe deverá criar dois funcionários distintos com dados fornecidos diretamente no código (hardcoded). 

Após isso, imprima as informações de cada funcionário para verificar se os dados foram corretamente armazenados. Utilize o método de impressão apropriado para exibir os dados de forma organizada e clara.

**Use a mesma estrutura sugerida no exercício anterior.**

---

# Exercício 3 – Método para Exibir Informações dos Funcionários

Melhore a classe `Funcionario` implementando um método chamado `mostra()` que imprima automaticamente todos os atributos do funcionário de forma clara e organizada. Dessa maneira, você evitará repetições de comandos `System.out.println()` cada vez que precisar exibir as informações do funcionário. Teste este método criando um objeto funcionário na classe `Main` e chamando `mostra()` logo em seguida.

**Utilize a mesma estrutura das pastas dos exercícios anteriores.**

---

# Exercício 4 – Comparação de Referências de Objetos

Crie dois objetos diferentes do tipo `Funcionario` com os mesmos valores em todos os atributos e compare-os utilizando o operador `==`. Faça outra comparação, dessa vez criando duas variáveis que apontem para o mesmo objeto criado anteriormente. Observe os resultados e explique por que eles são diferentes ou iguais. Documente suas conclusões em comentários na própria classe `Main`.

---

# Exercício 5 – Melhorando a Data de Entrada do Funcionário

Substitua a representação atual da data (que é uma String) por uma nova classe chamada `Data`. Essa nova classe deverá conter três atributos inteiros (dia, mês e ano). Altere a classe `Funcionario` para que a data de entrada seja um objeto da classe `Data`. No método `mostra()` da classe `Funcionario`, exiba a data no formato "dia/mês/ano". Crie instâncias de funcionários para testar as mudanças na classe `Main`.

**Nova estrutura sugerida:**

```
src/
 ├── application/
 │   └── Main.java
 └── entities/
     ├── Funcionario.java
     └── Data.java
```

---

# Exercício 6 – Controle de Acesso aos Atributos

Suponha que temos uma classe chamada `Conta` com um atributo saldo. Avalie se faz sentido acessar diretamente atributos ou métodos desta classe como se fossem estáticos, da seguinte forma:  
```java
Conta.saldo = 1234;
Conta.saca(50);
```
Crie uma classe simples `Conta` contendo atributos e métodos mínimos necessários para representar essa situação. Teste o código acima na classe `Main` e explique em comentários o motivo pelo qual faz sentido ou não, e como corrigir se houver algum erro.

---

# Exercício 7 – Fibonacci Recursivo

Crie uma classe `Fibonacci` que contenha um método recursivo chamado `calculaFibonacci(int n)`. Este método deverá retornar o n-ésimo termo da sequência de Fibonacci utilizando exclusivamente recursão (sem loops). Por exemplo, se você chamar o método com o valor `5`, ele deverá retornar `8`, que é o sexto número da sequência (considerando que começa com 1). Teste o método através de uma classe `Main` que imprima o resultado na tela.

---

# Exercício 8 – Avaliação de Desempenho: Recursão vs Iteração

Usando a classe criada no exercício anterior, crie também um método iterativo `calculaFibonacciIterativo(int n)`. Utilize a classe `Main` para medir e comparar o tempo gasto pela execução do método recursivo e do método iterativo para calcular o mesmo número da sequência de Fibonacci. Explique em comentários por que o método recursivo é mais lento que o iterativo.

---

# Exercício 9 – Método Recursivo com Operador Ternário

Reescreva o método recursivo da classe `Fibonacci` criado anteriormente, utilizando o operador condicional ternário. O objetivo é implementar o método em uma única linha de código. Teste a solução na classe `Main` para garantir que o resultado ainda esteja correto.

---

# Exercício 10 – Validação de Dados do Funcionário

Considerando que o banco precisa garantir que nenhum funcionário seja cadastrado com salário negativo ou vazio no nome, implemente a validação dos atributos da classe `Funcionario`. Se houver tentativas de inserir salários negativos ou nomes inválidos (String vazia ou somente espaços), imprima uma mensagem de erro e não altere os atributos. Realize testes na classe `Main` para verificar o funcionamento correto dessas validações.
