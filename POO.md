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
7. [Atributos](#1-atributos)
   - [Valores Padrão](#11-valores-padrão)
   - [Composição de Classes](#12-composição-de-classes)
   - [Referências e `null`](#13-referências-e-null)
8. [Palavra-chave `this`](#2-palavra-chave-this)
   - [Diferenciando Atributos de Variáveis Locais](#21-diferenciando-atributos-de-variáveis-locais)
   - [Passando o Próprio Objeto como Argumento](#22-passando-o-próprio-objeto-como-argumento)
9. [Controlando o Acesso](#3-controlando-o-acesso)
   - [Problemas com Acesso Direto a Atributos](#31-problemas-com-acesso-direto-a-atributos)
   - [Encapsulamento para Proteger os Dados](#32-encapsulamento-para-proteger-os-dados)
10. [Problemas com Acesso Direto a Atributos](#1-problemas-com-acesso-direto-a-atributos)
2. [Encapsulamento e Modificadores de Acesso](1#2-encapsulamento-e-modificadores-de-acesso)
   - [Benefícios do Encapsulamento](#21-benefícios-do-encapsulamento)
   - [Interface vs. Implementação](#22-interface-vs-implementação)
13. [Exemplo Prático: Validação de CPF](#3-exemplo-prático-validação-de-cpf)
14. [Getters e Setters](#1-getters-e-setters)  
   1.1 [Problema do Acesso Direto](#11-problema-do-acesso-direto)  
   1.2 [O Papel dos Getters e Setters](#12-o-papel-dos-getters-e-setters)  
   1.3 [Boas Práticas com Getters e Setters](#13-boas-práticas-com-getters-e-setters)  
15. [Construtores](#2-construtores)  
   2.1 [O Que é um Construtor?](#21-o-que-é-um-construtor)  
   2.2 [Construtor Default](#22-construtor-default)  
   2.3 [Construtores com Argumentos](#23-construtores-com-argumentos)  
   2.4 [Sobrecarga de Construtores](#24-sobrecarga-de-construtores)  
   2.5 [Chamando Outro Construtor com `this()`](#25-chamando-outro-construtor-com-this)  
16. [Resumo e Benefícios](#3-resumo-e-benefícios)
17. [Introdução aos Atributos de Classe](#1-introdução-aos-atributos-de-classe)  
18. [Atributos Estáticos com `static`](#2-atributos-estáticos-com-static)  
   2.1 [Definição de Atributos Estáticos](#21-definição-de-atributos-estáticos)  
   2.2 [Acesso e Uso de Atributos Estáticos](#22-acesso-e-uso-de-atributos-estáticos)  
19. [Métodos Estáticos](#3-métodos-estáticos)  
   3.1 [Características dos Métodos Estáticos](#31-características-dos-métodos-estáticos)  
   3.2 [Comparação: Métodos Estáticos vs. Métodos de Instância](#32-comparação-métodos-estáticos-vs-métodos-de-instância)  
20. [Exemplo Prático: Controle de Contas Bancárias](#4-exemplo-prático-controle-de-contas-bancárias)  
21. [Resumo e Benefícios](#5-resumo-e-benefícios)  

---

## 1 Conceitos Iniciais

### 1.1 Classes e Objetos

- **Classe:** Define a estrutura e o comportamento de um objeto. Pode ser considerada como uma "planta" ou modelo.
  
- **Objeto:** É uma instância da classe, criada em tempo de execução.

---

### 1.2 Projeto de Classes com UML

UML (*Unified Modeling Language*) é uma linguagem visual para modelar sistemas de software. Permite representar classes, objetos, interações e relacionamentos, facilitando o design antes da implementação.

<img src="images/UML.png" alt="uml" width="500">

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

<img src="images/ref.png" alt="Java" width="200">

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

## 1. Atributos

### 1.1 Valores Padrão

Os atributos em Java recebem valores padrão:

- **Números:** `0`
- **Booleanos:** `false`
- **Referências a Objetos:** `null`

Você também pode definir valores padrão explicitamente:

```java
class Conta {
    int numero = 1234;
    String titular = "Duke";
    double saldo = 1000.0;
}
```

---

### 1.2 Composição de Classes

Uma classe pode conter outra classe como atributo, representando uma composição. Exemplo com `Conta` e `Cliente`:

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

No `main`:

```java
Conta minhaConta = new Conta();
Cliente cliente = new Cliente();
minhaConta.titular = cliente;
minhaConta.titular.nome = "Duke";
```

Composição permite delegar responsabilidades entre classes, promovendo maior organização.

---

### 1.3 Referências e `null`

Por padrão, referências a objetos são inicializadas com `null`. Caso uma referência não seja inicializada, acessar seus atributos ou métodos resultará em uma exceção `NullPointerException`.

Exemplo de erro:

```java
Conta minhaConta = new Conta();
minhaConta.titular.nome = "Manoel"; // Erro: titular é null!
```

Solução:

```java
class Conta {
    Cliente titular = new Cliente();
}
```

Nesse caso, toda nova `Conta` criada terá automaticamente um `Cliente` associado. Decidir instanciar um objeto por padrão depende das regras de negócio.

---

## 2. Palavra-chave `this`

### 2.1 Diferenciando Atributos de Variáveis Locais

Quando os parâmetros de um método possuem o mesmo nome dos atributos da classe, utilizamos `this` para diferenciar os dois:

```java
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome; // Atributo da classe
        this.preco = preco; // Parâmetro do método
    }
}
```

---

### 2.2 Passando o Próprio Objeto como Argumento

`this` pode ser usado para passar a referência do objeto atual para outro método ou classe:

```java
public class ChessMatch {
    public void startMatch() {
        placeNewPiece('e', 1, new King(this));
    }
}
```

No exemplo, o objeto atual da classe `ChessMatch` é passado para o construtor do `King`, permitindo que a peça interaja diretamente com o tabuleiro e as regras da partida.

---

## 3. Controlando o Acesso

### 3.1 Problemas com Acesso Direto a Atributos

Sem encapsulamento, atributos podem ser acessados e modificados diretamente, o que pode gerar inconsistências:

```java
Conta minhaConta = new Conta();
minhaConta.saldo = -200; // Saldo negativo
```

---

### 3.2 Encapsulamento para Proteger os Dados

O encapsulamento permite proteger os atributos, tornando-os privados e acessíveis apenas por métodos controlados:

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

No exemplo acima, o saldo só pode ser alterado usando os métodos `saca` e `deposita`, garantindo maior segurança.

---

## 1. Problemas com Acesso Direto a Atributos

No início, atributos podem ser acessados diretamente, o que permite que dados inconsistentes sejam atribuídos:

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

Problemas:
1. Saques não validados:
   ```java
   Conta minhaConta = new Conta();
   minhaConta.saldo = 1000.0;
   minhaConta.saca(50000); // saldo só tinha 1000!
   ```

2. Acessos indevidos:
   ```java
   minhaConta.saldo = -200; // saldo negativo sem validação.
   ```

---

## 2. Encapsulamento e Modificadores de Acesso

O encapsulamento é a prática de restringir o acesso direto aos atributos e métodos de uma classe. Isso é feito usando **modificadores de acesso** como `private` e expondo métodos públicos para interação controlada.

### Tornando os Atributos Privados

Os atributos são protegidos usando o modificador `private`:

```java
class Conta {
    private double saldo;
    private String titular;
    private int numero;

    public void saca(double valor) {
        if (valor > this.saldo) { 
            System.out.println("Não posso sacar um valor maior do que o saldo!");
        } else {
            this.saldo -= valor;
        }
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
```

Tentativas de acesso direto agora resultam em erro de compilação:

```java
class TestaAcessoDireto {
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        minhaConta.saldo = 1000; // Erro: saldo has private access in Conta
    }
}
```

---

### 2.1 Benefícios do Encapsulamento

1. **Controle de Acesso**: Atributos são acessados apenas por métodos específicos da classe.
2. **Facilidade de Manutenção**: Validações e regras de negócio centralizadas nos métodos.
3. **Segurança**: Evita inconsistências, como saldo negativo ou dados inválidos.
4. **Baixo Acoplamento**: Reduz dependências entre classes.

---

### 2.2 Interface vs. Implementação

A interface de uma classe (métodos públicos) define **o que fazer**, enquanto a implementação (código interno) define **como fazer**. A separação entre os dois promove flexibilidade e manutenção.

#### Analogia:
- **Carro**: Você usa os pedais e o volante (*interface*) sem se preocupar com o funcionamento interno do motor (*implementação*).
- **Celulares**: Realizam ligações (*interface*), independentemente do sistema operacional (*implementação*).

---

## 3. Exemplo Prático: Validação de CPF

O encapsulamento é útil para aplicar regras específicas, como validação de CPF:

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

#### Uso no Programa Principal:

```java
class TestaCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.mudaCPF("12345678901"); // Valida e altera o CPF.
    }
}
```

Se quisermos aplicar regras adicionais, como restringir a alteração de CPF para clientes com mais de 60 anos:

```java
public void mudaCPF(String cpf) {
    if (this.idade <= 60) {
        validaCPF(cpf);
        this.cpf = cpf;
    } else {
        System.out.println("Clientes com mais de 60 anos não podem alterar o CPF.");
    }
}
```

---

## Conclusão

- **Encapsulamento**: Centraliza e protege dados, expondo apenas o necessário.
- **Modificadores de Acesso**:
  - `private`: Restringe o acesso à própria classe.
  - `public`: Permite acesso livre a métodos ou atributos.
- **Interface vs. Implementação**: Concentra-se no que um método faz, não em como ele é implementado.
- **Benefícios**:
  - **Maior Segurança**: Protege atributos contra manipulações indevidas.
  - **Melhor Organização**: Centraliza regras e validações.
  - **Facilidade de Manutenção**: Permite alterações internas sem impacto na interface pública.

Pratique o uso de encapsulamento para criar sistemas robustos e flexíveis, garantindo a integridade dos dados e facilitando futuras manutenções e melhorias.


### **Getters, Setters e Construtores em Java**

## **1. Getters e Setters**

Os **getters** e **setters** são métodos usados para acessar e modificar atributos privados de uma classe, garantindo controle sobre a manipulação de dados.

---

### **1.1 Problema do Acesso Direto**

Se declararmos os atributos de uma classe como `private`, acessá-los diretamente de fora da classe não é possível:

```java
class Conta {
    private double saldo;
    private String titular;
}
```

Exemplo de erro ao tentar acessar diretamente:

```java
Conta minhaConta = new Conta();
minhaConta.saldo = 1000; // Erro: saldo tem acesso privado em Conta
```

---

### **1.2 O Papel dos Getters e Setters**

Getters e setters solucionam esse problema permitindo acesso indireto e controlado aos atributos.

#### **Exemplo de Getters e Setters**

```java
class Conta {
    private String titular;
    private double saldo;

    // Getter para saldo
    public double getSaldo() {
        return this.saldo;
    }

    // Setter para titular
    public void setTitular(String titular) {
        this.titular = titular;
    }
}
```

**Uso no programa principal:**

```java
Conta minhaConta = new Conta();
minhaConta.setTitular("Duke");
System.out.println("Titular: " + minhaConta.getTitular());
```

---

### **1.3 Boas Práticas com Getters e Setters**

1. **Evite Setters Desnecessários:** 
   - Para atributos como `saldo`, é melhor usar métodos como `deposita()` e `saca()` para evitar inconsistências.

2. **Personalize Getters:**
   - Retorne dados formatados ou acrescente lógica:
     ```java
     public double getSaldoComLimite() {
         return this.saldo + this.limite;
     }
     ```

3. **Crie Apenas Quando Necessário:** 
   - Evite gerar getters e setters automáticos para todos os atributos. Avalie a necessidade real de acesso.

---

## **2. Construtores**

Os construtores são usados para inicializar objetos de forma consistente no momento de sua criação.

---

### **2.1 O Que é um Construtor?**

- Bloco especial que **não possui tipo de retorno** (nem mesmo `void`).  
- Executado automaticamente quando `new` é chamado.  

#### **Exemplo:**

```java
class Conta {
    private String titular;

    // Construtor
    Conta() {
        System.out.println("Nova conta criada!");
    }
}
```

---

### **2.2 Construtor Default**

Quando nenhum construtor é declarado, o Java cria automaticamente um **construtor default**, que:
- Não recebe parâmetros.
- Inicializa os atributos com valores padrão (0, `null`, ou `false`).

#### **Exemplo:**

```java
class Conta {
    private String titular;
    private double saldo;
}
```

O código abaixo funciona porque o Java cria um construtor default:

```java
Conta minhaConta = new Conta();
```

---

### **2.3 Construtores com Argumentos**

Construtores podem receber argumentos para inicializar atributos diretamente:

```java
class Conta {
    private String titular;

    // Construtor com argumento
    Conta(String titular) {
        this.titular = titular;
    }
}
```

**Uso no programa principal:**

```java
Conta minhaConta = new Conta("Duke");
System.out.println(minhaConta.getTitular());
```

---

### **2.4 Sobrecarga de Construtores**

Uma classe pode ter vários construtores, desde que tenham assinaturas diferentes (número e/ou tipo de parâmetros).

#### **Exemplo:**

```java
class Conta {
    private String titular;
    private double saldo;

    // Construtor padrão
    Conta() {}

    // Construtor com um argumento
    Conta(String titular) {
        this.titular = titular;
    }

    // Construtor com dois argumentos
    Conta(String titular, double saldo) {
        this(titular); // Chama o construtor que recebe o titular
        this.saldo = saldo;
    }
}
```

---

### **2.5 Chamando Outro Construtor com `this()`**

Use `this()` para reutilizar a lógica de outro construtor:

```java
class Conta {
    private String titular;
    private int numero;

    Conta(String titular) {
        this.titular = titular;
    }

    Conta(String titular, int numero) {
        this(titular); // Reutiliza o construtor que recebe o titular
        this.numero = numero;
    }
}
```

**Uso:**

```java
Conta conta = new Conta("Duke", 1234);
```

---

## **3. Resumo e Benefícios**

### **Encapsulamento com Getters e Setters**
- **Proteção dos Dados:** Evita modificações indevidas.
- **Centralização de Lógica:** Validações e regras de negócio em um único lugar.
- **Flexibilidade:** Permite mudar a implementação sem afetar o resto do código.

### **Construtores**
- **Inicialização Obrigatória:** Forçam que certos valores sejam definidos no momento da criação.
- **Flexibilidade com Sobrecarga:** Permitem múltiplas formas de criar objetos.
- **Consistência:** Garante que o objeto comece em um estado válido.

### **Melhores Práticas**
- Use `private` para atributos e exponha métodos públicos apenas quando necessário.
- Prefira inicializar atributos obrigatórios em construtores em vez de setters.
- Evite duplicação de código reutilizando construtores com `this()`.

Ao dominar esses conceitos, você garante a criação de classes robustas, seguras e fáceis de manter, seguindo os pilares da Programação Orientada a Objetos.

---

### **Atributos de Classe e Métodos Estáticos**

## **1. Introdução aos Atributos de Classe**

Os **atributos de classe** são variáveis que pertencem à classe como um todo, e não a instâncias específicas. Isso significa que todas as instâncias compartilham o mesmo valor do atributo.

Exemplo de problema:  
```java
class Conta {
    private int totalDeContas; // Não funciona como esperado
    Conta() {
        this.totalDeContas += 1;
    }
}
```
Cada objeto `Conta` teria seu próprio `totalDeContas`, resultando em inconsistências.

---

## **2. Atributos Estáticos com `static`**

### **2.1 Definição de Atributos Estáticos**

Os atributos `static` pertencem à classe, não a objetos individuais. Eles têm as seguintes características:
- São compartilhados por todas as instâncias.
- Mantêm o mesmo valor para todas as instâncias.
- Podem ser acessados sem criar uma instância da classe.

**Exemplo:**
```java
class Conta {
    private static int totalDeContas = 0;
    
    Conta() {
        Conta.totalDeContas += 1; // Incrementa ao criar uma conta
    }
}
```

---

### **2.2 Acesso e Uso de Atributos Estáticos**

#### **Acesso pelo Nome da Classe**
Para acessar um atributo estático, usamos o nome da classe:
```java
Conta.totalDeContas;
```

#### **Uso com Getter Estático**
Podemos criar um getter estático para expor o valor do atributo de forma controlada:
```java
class Conta {
    private static int totalDeContas = 0;

    Conta() {
        Conta.totalDeContas += 1;
    }

    public static int getTotalDeContas() {
        return Conta.totalDeContas;
    }
}
```

#### **Uso no Programa Principal**
```java
public class ProgramaPrincipal {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        Conta c2 = new Conta();
        System.out.println("Total de contas: " + Conta.getTotalDeContas()); // Exibe: 2
    }
}
```

---

## **3. Métodos Estáticos**

### **3.1 Características dos Métodos Estáticos**
- **Pertencem à classe:** Não dependem de instâncias.
- **Acesso direto:** Podem ser chamados usando o nome da classe.
- **Não acessam membros de instância diretamente:** Como não possuem referência `this`, não podem acessar atributos ou métodos de instância.

**Exemplo de Método Estático:**
```java
class Calculadora {
    public static double soma(double a, double b) {
        return a + b;
    }
}
```
**Uso:**
```java
double resultado = Calculadora.soma(3, 5); // Saída: 8
```

---

### **3.2 Comparação: Métodos Estáticos vs. Métodos de Instância**

| **Método Estático**         | **Método de Instância**         |
|-----------------------------|---------------------------------|
| Pertence à classe.          | Pertence à instância do objeto.|
| Não acessa atributos de instância. | Pode acessar e modificar atributos de instância. |
| Usado para funcionalidades gerais. | Representa o comportamento de um objeto específico. |

**Exemplo:**
```java
class Conta {
    private double saldo;

    public static void mostrarMensagem() {
        System.out.println("Bem-vindo ao Banco!");
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }
}
```

---

## **4. Exemplo Prático: Controle de Contas Bancárias**

#### **Classe Conta**
```java
class Conta {
    private static int totalDeContas = 0;
    private String titular;
    private double saldo;

    // Construtor
    Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
        Conta.totalDeContas += 1;
    }

    // Getter estático para totalDeContas
    public static int getTotalDeContas() {
        return Conta.totalDeContas;
    }

    // Método de instância para depositar
    public void deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    // Método de instância para obter o saldo
    public double getSaldo() {
        return this.saldo;
    }
}
```

#### **Programa Principal**
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
**Saída:**
```
Saldo da conta 1: 1000.0
Saldo da conta 2: 500.0
Total de contas: 2
```

---

## **5. Resumo e Benefícios**

### **Atributos Estáticos**
- **Uso:** Representam informações compartilhadas por todas as instâncias.
- **Exemplo:** Número total de contas criadas.

### **Métodos Estáticos**
- **Uso:** Funcionalidades gerais que não dependem de atributos ou estados de instância.
- **Exemplo:** Calculadoras, validações ou operações matemáticas.

### **Benefícios**
1. **Centralização de Lógica:** Reduz duplicação de código.
2. **Manutenção Simplificada:** Alterações no comportamento afetam todas as instâncias de forma consistente.
3. **Eficiência:** Reduz uso de memória ao compartilhar dados e métodos entre instâncias.

A aplicação correta de atributos e métodos estáticos melhora a organização e o desempenho do código, promovendo boas práticas em Programação Orientada a Objetos.

