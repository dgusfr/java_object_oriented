# POO com Java

## Sumário
1. [Conceitos Iniciais](#1-conceitos-iniciais)
    - [Classes e Objetos](#11-classes-e-objetos)
    - [Projeto de Classes com UML](#12-projeto-de-classes-com-uml)
2. [Definindo Classes](#2-definindo-classes)
    - [Atributos](#21-atributos)
    - [Criando Objetos](#22-criando-objetos)
    - [Acessando e Modificando Atributos](#23-acessando-e-modificando-atributos)
3. [Membros Estáticos](#3-membros-estáticos)
    - [Atributos e Métodos Estáticos](#31-atributos-e-métodos-estáticos)
    - [Comparação com Membros Não Estáticos](#32-comparação-com-membros-não-estáticos)
    - [Melhores Práticas](#33-melhores-práticas)
4. [Métodos](#4-métodos)
    - [Definindo Métodos](#41-definindo-métodos)
    - [Métodos com Retorno](#42-métodos-com-retorno)
    - [O Método `transfere`](#43-o-método-transfere)
5. [Referências em Java](#5-referências-em-java)
    - [Como Referências Funcionam](#51-como-referências-funcionam)
    - [Comparando Objetos com `==`](#52-comparando-objetos-com-)
6. [Exemplos de Código](#6-exemplos-de-código)
    - [Classe `Conta`](#61-classe-conta)
    - [Teste de Métodos](#62-teste-de-métodos)

---

## 1. Conceitos Iniciais

### 1.1 Classes e Objetos

- **Classe:** Define a estrutura e o comportamento de um objeto. Pode ser considerada como uma "planta" ou modelo.
- **Objeto:** É uma instância da classe, criada em tempo de execução.

---

### 1.2 Projeto de Classes com UML

UML (*Unified Modeling Language*) é uma linguagem visual para modelar sistemas de software. Permite representar classes, objetos, interações e relacionamentos, facilitando o design antes da implementação.

#### Exemplo de Classe `Conta`
- **Atributos:**
  - `numero`: Número da conta.
  - `dono`: Nome do titular.
  - `saldo`: Saldo atual.
  - `limite`: Limite de crédito.
- **Visibilidade:**
  - `-` (privado): Restringe o acesso.
  - `+` (público): Permite acesso externo.

---

## 2. Definindo Classes

### 2.1 Atributos

Os atributos definem as características de uma classe. Por exemplo:

```java
class Conta {
    int numero;
    String dono;
    double saldo;
    double limite;
}
```

---

### 2.2 Criando Objetos

Objetos são criados usando o operador `new`:

```java
Conta minhaConta = new Conta();
```

---

### 2.3 Acessando e Modificando Atributos

Podemos acessar e modificar atributos com o operador ponto (`.`):

```java
minhaConta.dono = "Duke";
minhaConta.saldo = 1000.0;
System.out.println(minhaConta.saldo);
```

---

## 3. Membros Estáticos

### 3.1 Atributos e Métodos Estáticos

Membros estáticos pertencem à classe, não às instâncias. Exemplos:

- **Atributo Estático:**
  ```java
  public static final double PI = 3.14159;
  ```

- **Método Estático:**
  ```java
  public static double circunference(double radius) {
      return 2.0 * PI * radius;
  }
  ```

**Uso:**
```java
double circ = Calculator.circunference(3.0);
```

---

### 3.2 Comparação com Membros Não Estáticos

Membros não estáticos pertencem a cada instância da classe e precisam de um objeto para serem acessados.

---

### 3.3 Melhores Práticas

- Use membros estáticos para constantes e métodos utilitários.
- Evite redundância criando atributos e métodos não estáticos para valores invariáveis.

---

## 4. Métodos

### 4.1 Definindo Métodos

Os métodos representam comportamentos de um objeto. Por exemplo:

```java
void saca(double quantidade) {
    this.saldo -= quantidade;
}
```

---

### 4.2 Métodos com Retorno

Métodos podem retornar valores. Exemplo de um método `saca` que verifica o saldo antes de realizar a operação:

```java
boolean saca(double valor) {
    if (this.saldo < valor) {
        return false;
    }
    this.saldo -= valor;
    return true;
}
```

---

### 4.3 O Método `transfere`

O método `transfere` permite transferir valores entre contas. Exemplo com validação:

```java
boolean transfere(Conta destino, double valor) {
    if (this.saca(valor)) {
        destino.deposita(valor);
        return true;
    }
    return false;
}
```

---

## 5. Referências em Java

### 5.1 Como Referências Funcionam

- As variáveis armazenam referências, não os objetos em si.
- Exemplo:
  ```java
  Conta c1 = new Conta();
  Conta c2 = c1;
  ```

Ambas `c1` e `c2` apontam para o mesmo objeto.

---

### 5.2 Comparando Objetos com `==`

O operador `==` verifica se duas referências apontam para o mesmo objeto, não se possuem o mesmo conteúdo.

```java
Conta c1 = new Conta();
Conta c2 = new Conta();
System.out.println(c1 == c2); // false
```

---

## 6. Exemplos de Código

### 6.1 Classe `Conta`

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

---

### 6.2 Teste de Métodos

```java
public class TestaMetodos {
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        minhaConta.dono = "Duke";
        minhaConta.saldo = 1000;

        // Saque
        minhaConta.saca(200);

        // Depósito
        minhaConta.deposita(500);

        // Transferência
        Conta outraConta = new Conta();
        outraConta.dono = "John";
        minhaConta.transfere(outraConta, 300);

        // Exibe saldo
        System.out.println("Saldo de " + minhaConta.dono + ": " + minhaConta.saldo);
        System.out.println("Saldo de " + outraConta.dono + ": " + outraConta.saldo);
    }
}
```

Saída esperada:

```
Saldo de Duke: 1000.0
Saldo de John: 300.0
```

---
