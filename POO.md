# POO com Java

## Sumário

1. [Conceitos Iniciais](#1-conceitos-iniciais)  
   1.1 [Classes e Objetos](#11-classes-e-objetos)  
   1.2 [Projeto de Classes com UML](#12-projeto-de-classes-com-uml)  
2. [Definindo Classes](#2-definindo-classes)  
   2.1 [Atributos](#21-atributos)  
   2.2 [Criando Objetos](#22-criando-objetos)  
   2.3 [Acessando e Modificando Atributos](#23-acessando-e-modificando-atributos)  
3. [Membros Estáticos](#3-membros-estáticos)  
   3.1 [Atributos e Métodos Estáticos](#31-atributos-e-métodos-estáticos)  
   3.2 [Comparação com Membros Não Estáticos](#32-comparação-com-membros-não-estáticos)  
   3.3 [Melhores Práticas](#33-melhores-práticas)  
4. [Métodos](#4-métodos)  
   4.1 [Definindo Métodos](#41-definindo-métodos)  
   4.2 [Métodos com Retorno](#42-métodos-com-retorno)  
   4.3 [O Método transfere](#43-o-método-transfere)  
5. [Referências em Java](#5-referências-em-java)  
   5.1 [Como Referências Funcionam](#51-como-referências-funcionam)  
   5.2 [Comparando Objetos com ==](#52-comparando-objetos-com--)  
6. [Exemplos de Código](#6-exemplos-de-código)  
   6.1 [Classe Conta](#61-classe-conta)  
   6.2 [Teste de Métodos](#62-teste-de-métodos)  
7. [Atributos](#7-atributos)  
   7.1 [Valores Padrão](#71-valores-padrão)  
   7.2 [Composição de Classes](#72-composição-de-classes)  
   7.3 [Referências e null](#73-referências-e-null)  
8. [Palavra-chave this](#8-palavra-chave-this)  
   8.1 [Diferenciando Atributos de Variáveis Locais](#81-diferenciando-atributos-de-variáveis-locais)  
   8.2 [Passando o Próprio Objeto como Argumento](#82-passando-o-próprio-objeto-como-argumento)  
9. [Controlando o Acesso](#9-controlando-o-acesso)  
   9.1 [Problemas com Acesso Direto a Atributos](#91-problemas-com-acesso-direto-a-atributos)  
   9.2 [Encapsulamento para Proteger os Dados](#92-encapsulamento-para-proteger-os-dados)  
10. [Encapsulamento e Modificadores de Acesso](#10-encapsulamento-e-modificadores-de-acesso)  
   10.1 [Benefícios do Encapsulamento](#101-benefícios-do-encapsulamento)  
   10.2 [Interface vs. Implementação](#102-interface-vs-implementação)  
11. [Exemplo Prático: Validação de CPF](#11-exemplo-prático-validação-de-cpf)  
12. [Getters e Setters](#12-getters-e-setters)  
   12.1 [Problema do Acesso Direto](#121-problema-do-acesso-direto)  
   12.2 [O Papel dos Getters e Setters](#122-o-papel-dos-getters-e-setters)  
   12.3 [Boas Práticas com Getters e Setters](#123-boas-práticas-com-getters-e-setters)  
13. [Construtores](#13-construtores)  
   13.1 [O Que é um Construtor?](#131-o-que-é-um-construtor)  
   13.2 [Construtor Default](#132-construtor-default)  
   13.3 [Construtores com Argumentos](#133-construtores-com-argumentos)  
   13.4 [Sobrecarga de Construtores](#134-sobrecarga-de-construtores)  
   13.5 [Chamando Outro Construtor com this()](#135-chamando-outro-construtor-com-this)  
14. [Resumo e Benefícios](#14-resumo-e-benefícios)  
15. [Introdução aos Atributos de Classe](#15-introdução-aos-atributos-de-classe)  
16. [Atributos Estáticos com static](#16-atributos-estáticos-com-static)  
   16.1 [Definição de Atributos Estáticos](#161-definição-de-atributos-estáticos)  
   16.2 [Acesso e Uso de Atributos Estáticos](#162-acesso-e-uso-de-atributos-estáticos)  
17. [Métodos Estáticos](#17-métodos-estáticos)  
   17.1 [Características dos Métodos Estáticos](#171-características-dos-métodos-estáticos)  
   17.2 [Comparação: Métodos Estáticos vs. Métodos de Instância](#172-comparação-métodos-estáticos-vs-métodos-de-instância)  
18. [Exemplo Prático: Controle de Contas Bancárias](#18-exemplo-prático-controle-de-contas-bancárias)  
19. [Resumo e Benefícios](#19-resumo-e-benefícios)  

---

## 1. Conceitos Iniciais
### 1.1 Classes e Objetos

- **Classe:** Define a estrutura e o comportamento de um objeto; pode ser vista como uma “planta”.  
- **Objeto:** É uma instância da classe, criada em tempo de execução.

### 1.2 Projeto de Classes com UML

UML (*Unified Modeling Language*) é uma linguagem visual para modelar sistemas de software. Permite representar classes, objetos, interações e relacionamentos, facilitando o design antes da implementação.

Exemplo de Classe **Conta** em UML:  
- **Atributos**:  
  - numero  
  - dono  
  - saldo  
  - limite  
- **Visibilidade**:  
  - `-` (privado)  
  - `+` (público)

---

## 2. Definindo Classes
### 2.1 Atributos

```java
class Conta {
    int numero;
    String dono;
    double saldo;
    double limite;
}
```
Esse código declara a classe `Conta` com quatro atributos públicos, definindo as características básicas de uma conta.

### 2.2 Criando Objetos

```java
Conta minhaConta = new Conta();
```
Esse código cria um novo objeto da classe `Conta` e o atribui à variável `minhaConta`.

### 2.3 Acessando e Modificando Atributos

```java
minhaConta.dono = "Duke";
minhaConta.saldo = 1000.0;
System.out.println(minhaConta.saldo);
```
Aqui, atribuimos valores aos atributos `dono` e `saldo` de `minhaConta`, exibindo o saldo ao final.

---

## 3. Membros Estáticos
### 3.1 Atributos e Métodos Estáticos

```java
public static final double PI = 3.14159;
```
Este código mostra um atributo estático que pode ser usado como constante em toda a aplicação.

```java
public static double circunference(double radius) {
    return 2.0 * PI * radius;
}
```
Este método estático realiza o cálculo de circunferência de um círculo, utilizando o atributo estático `PI`.

```java
double circ = Calculator.circunference(3.0);
```
Aqui, o método estático `circunference` é chamado diretamente a partir do nome da classe `Calculator`.

### 3.2 Comparação com Membros Não Estáticos

Membros não estáticos pertencem a cada instância, enquanto membros estáticos pertencem à classe e podem ser acessados sem a criação de objetos.

### 3.3 Melhores Práticas

- Use membros estáticos para constantes e métodos utilitários.  
- Evite redundância criando membros não estáticos para valores que não variam.

---

## 4. Métodos
### 4.1 Definindo Métodos

```java
void saca(double quantidade) {
    this.saldo -= quantidade;
}
```
Este método reduz o atributo `saldo` de uma conta ao sacar uma quantia informada.

### 4.2 Métodos com Retorno

```java
boolean saca(double valor) {
    if (this.saldo < valor) {
        return false;
    }
    this.saldo -= valor;
    return true;
}
```
Este método verifica se há saldo suficiente antes de efetuar o saque e retorna um valor booleano indicando sucesso ou falha.

### 4.3 O Método transfere

```java
boolean transfere(Conta destino, double valor) {
    if (this.saca(valor)) {
        destino.deposita(valor);
        return true;
    }
    return false;
}
```
Este método utiliza o `saca` internamente para verificar se há saldo e, se bem-sucedido, faz o depósito na conta de destino.

---

## 5. Referências em Java
### 5.1 Como Referências Funcionam

```java
Conta c1 = new Conta();
Conta c2 = c1;
```
As variáveis `c1` e `c2` passam a apontar para o mesmo objeto em memória. 

### 5.2 Comparando Objetos com ==

```java
Conta c1 = new Conta();
Conta c2 = new Conta();
System.out.println(c1 == c2);
```
O operador `==` verifica se as duas variáveis referem-se ao mesmo objeto, não se têm atributos equivalentes.

---

## 6. Exemplos de Código
### 6.1 Classe Conta

```java
class Conta {
    int numero;
    String dono;
    double saldo;
    double limite;

    void saca(double quantidade) {
        this.saldo -= quantidade;
    }

    void deposita(double quantidade) {
        this.saldo += quantidade;
    }

    boolean transfere(Conta destino, double valor) {
        if (this.saca(valor)) {
            destino.deposita(valor);
            return true;
        }
        return false;
    }
}
```
Essa classe `Conta` contém atributos básicos e métodos para saque, depósito e transferência de valores entre contas.

### 6.2 Teste de Métodos

```java
public class TestaMetodos {
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        minhaConta.dono = "Duke";
        minhaConta.saldo = 1000;

        minhaConta.saca(200);
        minhaConta.deposita(500);

        Conta outraConta = new Conta();
        outraConta.dono = "John";
        minhaConta.transfere(outraConta, 300);

        System.out.println("Saldo de " + minhaConta.dono + ": " + minhaConta.saldo);
        System.out.println("Saldo de " + outraConta.dono + ": " + outraConta.saldo);
    }
}
```
Este programa cria duas contas, realiza operações de saque, depósito e transferência, e exibe os saldos resultantes.

---

## 7. Atributos
### 7.1 Valores Padrão

Em Java, atributos de tipos numéricos são inicializados como 0, booleanos como `false` e referências como `null` se não houver atribuição explícita.

```java
class Conta {
    int numero = 1234;
    String titular = "Duke";
    double saldo = 1000.0;
}
```
Aqui, definimos valores padrão diretamente na declaração dos atributos.

### 7.2 Composição de Classes

```java
class Cliente {
    String nome;
    String sobrenome;
    String cpf;
}

class Conta {
    int numero;
    double saldo;
    Cliente titular;
}
```
Essas classes demonstram a composição, onde `Conta` possui um atributo do tipo `Cliente`.

```java
Conta minhaConta = new Conta();
Cliente cliente = new Cliente();
minhaConta.titular = cliente;
minhaConta.titular.nome = "Duke";
```
Instanciamos as duas classes separadamente e atribuimos um objeto `Cliente` à conta.

### 7.3 Referências e null

Se um atributo não é inicializado, ele permanece `null` e seu uso indevido gera exceções em tempo de execução.

```java
class Conta {
    Cliente titular = new Cliente();
}
```
Neste exemplo, cada `Conta` já inicia com um objeto `Cliente` associado, evitando `NullPointerException` ao acessar `titular`.

---

## 8. Palavra-chave this
### 8.1 Diferenciando Atributos de Variáveis Locais

```java
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
```
O `this` diferencia os atributos da classe dos parâmetros do construtor que possuem o mesmo nome.

### 8.2 Passando o Próprio Objeto como Argumento

```java
public class ChessMatch {
    public void startMatch() {
        placeNewPiece('e', 1, new King(this));
    }
}
```
Ao criar o objeto `King`, passamos a própria instância de `ChessMatch` para que a peça conheça o contexto da partida.

---

## 9. Controlando o Acesso
### 9.1 Problemas com Acesso Direto a Atributos

Quando os atributos são públicos, pode-se inserir valores inválidos ou inconsistentes:

```java
class Conta {
    String titular;
    int numero;
    double saldo;

    void saca(double valor) {
        this.saldo = this.saldo - valor;
    }
}
```
Sem validações adequadas, é possível obter saldos negativos ou outras inconsistências.

### 9.2 Encapsulamento para Proteger os Dados

```java
class Conta {
    private double saldo;

    public void saca(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo -= valor;
        }
    }

    public void deposita(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
```
Ao tornar `saldo` privado, garantimos que apenas métodos específicos podem alterá-lo, evitando alterações indevidas.

---

## 10. Encapsulamento e Modificadores de Acesso
### 10.1 Benefícios do Encapsulamento

1. **Controle de Acesso**: Apenas métodos da própria classe alteram seus atributos.  
2. **Facilidade de Manutenção**: Regras de negócio ficam centralizadas nos métodos.  
3. **Segurança**: Impede atribuições inválidas.  
4. **Baixo Acoplamento**: Reduz dependências entre classes.

### 10.2 Interface vs. Implementação

- **Interface**: Define o que a classe oferece (métodos públicos).  
- **Implementação**: Detalhes internos (atributos privados, lógica dos métodos).

---

## 11. Exemplo Prático: Validação de CPF

```java
class Cliente {
    private String nome;
    private String endereco;
    private String cpf;

    public void mudaCPF(String cpf) {
        validaCPF(cpf);
        this.cpf = cpf;
    }

    private void validaCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido!");
        }
    }
}
```
A classe `Cliente` valida internamente o CPF para evitar valores nulos ou com tamanho incorreto.

```java
class TestaCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.mudaCPF("12345678901");
    }
}
```
Ao chamar `mudaCPF`, a validação acontece dentro da classe e protege o estado do objeto.

---

## 12. Getters e Setters
### 12.1 Problema do Acesso Direto

```java
class Conta {
    private double saldo;
    private String titular;
}
```
Atributos privados não podem ser acessados diretamente de fora da classe.

### 12.2 O Papel dos Getters e Setters

```java
class Conta {
    private String titular;
    private double saldo;

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
```
Métodos *getter* e *setter* controlam o acesso aos atributos privados, permitindo validações e lógicas adicionais.

### 12.3 Boas Práticas com Getters e Setters

- Criar *setters* apenas quando for necessário alterar o valor do atributo.  
- Realizar validações nos *setters* para manter a integridade dos dados.  
- *Getters* podem formatar ou processar as informações antes de retorná-las.

---

## 13. Construtores
### 13.1 O Que é um Construtor?

Bloco especial executado quando o objeto é criado com `new`. Não tem tipo de retorno (nem `void`).

```java
class Conta {
    Conta() {
        System.out.println("Nova conta criada!");
    }
}
```
Ao instanciar `new Conta()`, a mensagem é exibida.

### 13.2 Construtor Default

Se não declararmos nenhum construtor, o Java fornece um construtor sem parâmetros que inicializa os atributos com valores padrão.

### 13.3 Construtores com Argumentos

```java
class Conta {
    private String titular;

    Conta(String titular) {
        this.titular = titular;
    }
}
```
Podemos receber parâmetros no construtor para inicializar atributos obrigatórios.

### 13.4 Sobrecarga de Construtores

```java
class Conta {
    private String titular;
    private double saldo;

    Conta() {}

    Conta(String titular) {
        this.titular = titular;
    }

    Conta(String titular, double saldo) {
        this(titular);
        this.saldo = saldo;
    }
}
```
Permite criar várias versões do construtor, cada uma aceitando parâmetros diferentes.

### 13.5 Chamando Outro Construtor com this()

```java
class Conta {
    private String titular;
    private int numero;

    Conta(String titular) {
        this.titular = titular;
    }

    Conta(String titular, int numero) {
        this(titular);
        this.numero = numero;
    }
}
```
`this()` reutiliza a lógica de outro construtor, reduzindo duplicação de código.

---

## 14. Resumo e Benefícios

- **Encapsulamento**: Protege dados, centraliza validações e facilita manutenção.  
- **Getters e Setters**: Controlam acesso a atributos privados, mantendo a classe coesa.  
- **Construtores**: Garantem que o objeto seja criado em estado consistente, podendo aceitar diferentes parâmetros por meio de sobrecarga.  

---

## 15. Introdução aos Atributos de Classe

Atributos de classe (ou *variáveis de classe*) são compartilhados por todas as instâncias, ao contrário dos atributos de instância, que são próprios de cada objeto.

---

## 16. Atributos Estáticos com static
### 16.1 Definição de Atributos Estáticos

```java
class Conta {
    private static int totalDeContas = 0;

    Conta() {
        Conta.totalDeContas += 1;
    }
}
```
`totalDeContas` pertence à classe `Conta`. Cada vez que um objeto é criado, incrementa-se esse valor.

### 16.2 Acesso e Uso de Atributos Estáticos

```java
public static int getTotalDeContas() {
    return Conta.totalDeContas;
}
```
O acesso pode ser feito diretamente pelo nome da classe, sem instanciar um objeto.

---

## 17. Métodos Estáticos
### 17.1 Características dos Métodos Estáticos

- Não dependem de atributos de instância.  
- São chamados usando o nome da classe.  
- Ideais para operações gerais (por exemplo, métodos utilitários de cálculo).

```java
class Calculadora {
    public static double soma(double a, double b) {
        return a + b;
    }
}
```
Após compilar, `Calculadora.soma(3, 5)` pode ser usado em qualquer parte do código.

### 17.2 Comparação: Métodos Estáticos vs. Métodos de Instância

- **Métodos Estáticos**: Não possuem `this` e não acessam atributos de instância.  
- **Métodos de Instância**: Podem manipular dados específicos daquele objeto.

---

## 18. Exemplo Prático: Controle de Contas Bancárias

```java
class Conta {
    private static int totalDeContas = 0;
    private String titular;
    private double saldo;

    Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
        Conta.totalDeContas += 1;
    }

    public static int getTotalDeContas() {
        return Conta.totalDeContas;
    }

    public void deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
}
```
A classe acima mantém um atributo estático `totalDeContas` para contar quantas contas foram criadas, além de métodos para depósito e acesso ao saldo.

```java
public class ProgramaPrincipal {
    public static void main(String[] args) {
        Conta conta1 = new Conta("Duke");
        conta1.deposita(1000);

        Conta conta2 = new Conta("Maria");
        conta2.deposita(500);

        System.out.println("Saldo da conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da conta 2: " + conta2.getSaldo());
        System.out.println("Total de contas: " + Conta.getTotalDeContas());
    }
}
```
Este programa cria duas contas, deposita valores e exibe a contagem total de contas criadas, demonstrando o uso de atributo e método estáticos.

---

## 19. Resumo e Benefícios

- **Atributos Estáticos**: Compartilhados por todas as instâncias, ideais para contadores ou constantes.  
- **Métodos Estáticos**: Executam funções sem depender do estado de um objeto.  
- **Facilitam Operações Genéricas**: Como cálculos e utilitários.  
- **Melhor Organização**: Métodos que não precisam de instância podem ficar em uma classe separada, agrupando funcionalidades afins.

---
