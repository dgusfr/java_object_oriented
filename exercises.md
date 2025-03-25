# Introdução à Programação Orientada a Objetos

### Exercício 1 – Cadastro de Funcionários do Banco J

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

### Exercício 2 – Teste da classe Funcionário

Utilizando a classe `Funcionario` criada no exercício anterior, implemente uma classe `Main` que tenha o método `main`. Essa classe deverá criar dois funcionários distintos com dados fornecidos diretamente no código (hardcoded). 

Após isso, imprima as informações de cada funcionário para verificar se os dados foram corretamente armazenados. Utilize o método de impressão apropriado para exibir os dados de forma organizada e clara.

**Use a mesma estrutura sugerida no exercício anterior.**

---

### Exercício 3 – Método para Exibir Informações dos Funcionários

Melhore a classe `Funcionario` implementando um método chamado `mostra()` que imprima automaticamente todos os atributos do funcionário de forma clara e organizada. Dessa maneira, você evitará repetições de comandos `System.out.println()` cada vez que precisar exibir as informações do funcionário. Teste este método criando um objeto funcionário na classe `Main` e chamando `mostra()` logo em seguida.

**Utilize a mesma estrutura das pastas dos exercícios anteriores.**

---

### Exercício 4 – Comparação de Referências de Objetos

Crie dois objetos diferentes do tipo `Funcionario` com os mesmos valores em todos os atributos e compare-os utilizando o operador `==`. Faça outra comparação, dessa vez criando duas variáveis que apontem para o mesmo objeto criado anteriormente. Observe os resultados e explique por que eles são diferentes ou iguais. Documente suas conclusões em comentários na própria classe `Main`.

---

### Exercício 5 – Melhorando a Data de Entrada do Funcionário

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

### Exercício 6 – Controle de Acesso aos Atributos

Suponha que temos uma classe chamada `Conta` com um atributo saldo. Avalie se faz sentido acessar diretamente atributos ou métodos desta classe como se fossem estáticos, da seguinte forma:  
```java
Conta.saldo = 1234;
Conta.saca(50);
```
Crie uma classe simples `Conta` contendo atributos e métodos mínimos necessários para representar essa situação. Teste o código acima na classe `Main` e explique em comentários o motivo pelo qual faz sentido ou não, e como corrigir se houver algum erro.

---

### Exercício 7 – Fibonacci Recursivo

Crie uma classe `Fibonacci` que contenha um método recursivo chamado `calculaFibonacci(int n)`. Este método deverá retornar o n-ésimo termo da sequência de Fibonacci utilizando exclusivamente recursão (sem loops). Por exemplo, se você chamar o método com o valor `5`, ele deverá retornar `8`, que é o sexto número da sequência (considerando que começa com 1). Teste o método através de uma classe `Main` que imprima o resultado na tela.

---

### Exercício 8 – Avaliação de Desempenho: Recursão vs Iteração

Usando a classe criada no exercício anterior, crie também um método iterativo `calculaFibonacciIterativo(int n)`. Utilize a classe `Main` para medir e comparar o tempo gasto pela execução do método recursivo e do método iterativo para calcular o mesmo número da sequência de Fibonacci. Explique em comentários por que o método recursivo é mais lento que o iterativo.

---

### Exercício 9 – Método Recursivo com Operador Ternário

Reescreva o método recursivo da classe `Fibonacci` criado anteriormente, utilizando o operador condicional ternário. O objetivo é implementar o método em uma única linha de código. Teste a solução na classe `Main` para garantir que o resultado ainda esteja correto.

---

### Exercício 10 – Validação de Dados do Funcionário

Considerando que o banco precisa garantir que nenhum funcionário seja cadastrado com salário negativo ou vazio no nome, implemente a validação dos atributos da classe `Funcionario`. Se houver tentativas de inserir salários negativos ou nomes inválidos (String vazia ou somente espaços), imprima uma mensagem de erro e não altere os atributos. Realize testes na classe `Main` para verificar o funcionamento correto dessas validações.

___

<br>
<br>

---

### Controle de Acesso e Encapsulamento

### Exercício 1  
Analise as classes `Funcionario` e `Empresa` que você criou. Agora, observe a visibilidade dos **atributos** e **métodos** dessas classes: eles estão realmente protegidos contra acesso direto? Sua tarefa é aplicar os **modificadores de visibilidade adequados** (`private` ou `public`) para cada um desses membros. Após isso, experimente, dentro do método `main`, instanciar um objeto do tipo `Funcionario` e tentar **acessar diretamente** um de seus atributos que agora está privado. Observe o comportamento do compilador. O que é exibido? O que isso te diz sobre o encapsulamento em Java?

---

### Exercício 2  
Com os atributos agora encapsulados, é hora de permitir o **acesso controlado** a eles. Implemente os **getters e setters** na classe `Funcionario` e, se necessário, na classe `Empresa`. No entanto, reflita: todos os atributos realmente precisam de ambos os métodos? Há situações em que faz mais sentido **não expor** um atributo diretamente, mas sim oferecer uma interface que represente uma **ação mais clara** da classe. Por exemplo, considere a array de funcionários em `Empresa`: é mesmo interessante permitir acesso direto à array completa ou modificá-la livremente? Talvez algo como:

```java
Funcionario getFuncionario(int posicao) {
    return this.funcionarios[posicao];
}
```

possa cumprir melhor essa função.

---

### Exercício 3  
Você precisa garantir que cada `Funcionario` tenha um **identificador numérico único**, crescente conforme novas instâncias são criadas. Para isso, crie um **atributo `int identificador`** dentro da classe. O primeiro funcionário instanciado deve receber o valor `1`, o segundo `2` e assim por diante, **automaticamente**. Nenhum código externo deve ser responsável por atribuir esse número. Dica: considere usar um **atributo estático auxiliar** que armazene a **quantidade de funcionários criados até agora**. Implemente também um **getter para o identificador**. Reflita se devemos ou não permitir a existência de um `setter` para ele. Faz sentido alterar esse valor depois que foi atribuído?

---

### Exercício 4 *(Opcional)*  
Até agora, sua classe `Empresa` provavelmente define a **array de funcionários com tamanho fixo** dentro do próprio código. Reestruture isso: altere o **construtor da classe** para receber como **parâmetro o tamanho desejado** da array de `Funcionario`. Isso traz mais flexibilidade para o programa. Com isso feito, tente instanciar uma `Empresa` sem passar argumento nenhum: `new Empresa()`. O que acontece? O compilador reclama? Por quê? Use esse erro como ponto de reflexão sobre **sobrecarga de construtores**.

---

### Exercício 5 *(Opcional)*  
Suponha que exista uma classe `Data` com atributos como dia, mês e ano. Como você garantiria que **datas inválidas** — como `31/2/2005` — não fossem aceitas na criação de objetos dessa classe? Pense em formas de validar esses valores já no momento da construção do objeto. É possível usar **condições** no construtor? Ou talvez um **método de validação interno**? Avalie.

---

### Exercício 6 *(Opcional)*  
Implemente uma nova classe chamada `PessoaFisica`, com um atributo `cpf`. Este atributo é **obrigatório**: não deve ser possível criar uma `PessoaFisica` sem CPF válido. Embora você **não precise implementar a lógica de validação completa**, crie um método `valida(String cpf)` que simule essa verificação. Certifique-se de que ele seja chamado sempre que uma nova instância for criada. Como você estruturaria o construtor para garantir isso? Qual modificador seria ideal para o atributo `cpf`?

---

### Exercício 7 *(Opcional)*  
Observe o trecho de código abaixo e tente entender por que ele **não compila**:

```java
class Teste {
    int x = 37;
    public static void main(String[] args) {
        System.out.println(x);
    }
}
```

O compilador aponta erro ao tentar acessar `x`. Mas por quê? Lembre-se da **diferença entre métodos estáticos e atributos de instância**. Qual é o contexto do método `main`? O que seria necessário fazer para acessar corretamente a variável `x`?

---

