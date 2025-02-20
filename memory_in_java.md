# Alocação Dinâmica de Memória em Java

## Sumário

1. [Introdução](#1-introdução)
2. [Tipos de Dados e Memória](#2-tipos-de-dados-e-memória)
   - [2.1 Tipos Referência](#21-tipos-referência)
   - [2.2 Valor `null`](#22-valor-null)
   - [2.3 Tipos Primitivos](#23-tipos-primitivos)
   - [2.4 Comparação: Tipos Referência vs. Tipos Valor](#24-comparação-tipos-referência-vs-tipos-valor)
3. [Gerenciamento de Memória](#3-gerenciamento-de-memória)
   - [3.1 Garbage Collector](#31-garbage-collector)
   - [3.2 Escopo e Desalocação](#32-escopo-e-desalocação)
4. [Desafios e Exemplos](#4-desafios-e-exemplos)
5. [Conclusão](#5-conclusão)

---

<br>

## **1. Introdução**

Em Java, a alocação de memória é gerenciada automaticamente pela **JVM (Java Virtual Machine)**, diferenciando-se de linguagens que exigem controle manual. A memória utilizada é dividida principalmente em:

- **Stack:** Armazena variáveis locais e referências para objetos.
- **Heap:** Armazena objetos criados dinamicamente via `new`.
- **Garbage Collector:** Remove objetos sem referências para evitar vazamento de memória.

Compreender essa estrutura é essencial para evitar falhas como `NullPointerException` e melhorar a eficiência do código.

---

<br>

## **2. Tipos de Dados e Memória**

### **2.1 Tipos Referência**

Variáveis do tipo referência armazenam endereços de memória que apontam para objetos na **Heap**. Quando uma variável de referência é atribuída a outra, ambas passam a apontar para o mesmo objeto.

#### **Exemplo:**
```java
class Product {
    String name;
    double price;
    
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class TesteReferencia {
    public static void main(String[] args) {
        Product p1 = new Product("TV", 900.00);
        Product p2 = p1; // p2 aponta para o mesmo objeto que p1
        p2.name = "Radio";
        
        System.out.println(p1.name); // Imprime: Radio
    }
}
```

🔹 **Explicação:**
- `p1` e `p2` referenciam o mesmo objeto na **Heap**.
- Alterações feitas por `p2` afetam `p1`, pois ambos compartilham a mesma referência.

### **2.2 Valor `null`**

Variáveis de referência podem ser inicializadas como `null`, indicando que não apontam para nenhum objeto.

```java
Product p1 = null;
System.out.println(p1.name); // Erro: NullPointerException
```

**Importante:** A tentativa de acessar atributos ou métodos de uma variável `null` resulta em um erro de execução.

### **2.3 Tipos Primitivos**

Os tipos primitivos (`int`, `double`, `boolean`, etc.) armazenam valores diretamente na **Stack**, sem referências externas.

```java
int x = 10;
int y = x;
y = 20;
System.out.println(x); // 10 (não foi alterado)
System.out.println(y); // 20
```

🔹 **Explicação:** `y` recebe uma cópia do valor de `x`, portanto, modificações em `y` não afetam `x`.

### **2.4 Comparação: Tipos Referência vs. Tipos Valor**

| Característica            | Tipo Referência (Objetos) | Tipo Primitivo  |
|---------------------------|--------------------------|-----------------|
| **Armazenamento**        | Heap                     | Stack          |
| **Atribuição (=)**       | Copia referência         | Copia valor    |
| **Aceita `null`**        | Sim                      | Não            |
| **Modificação**          | Reflete nas variáveis apontando para o objeto | Independente |
| **Liberação de Memória** | Garbage Collector        | Automática     |

---

<br>

## **3. Gerenciamento de Memória**

### **3.1 Garbage Collector**

O **Garbage Collector (GC)** da JVM remove automaticamente objetos sem referências na **Heap**, liberando espaço de memória.

#### **Exemplo:**
```java
Product p1 = new Product("TV", 900.00);
Product p2 = new Product("Mouse", 30.00);
p1 = p2; // O objeto "TV" se torna inacessível e será coletado pelo GC
```

**Antes:**
```
Stack        Heap
p1 ------> "TV    900.00"
p2 ------> "Mouse 30.00"
```
**Depois:**
```
Stack        Heap
p1 ------> "Mouse 30.00"
p2 ------> "Mouse 30.00"
"TV" é coletado pelo GC
```

### **3.2 Escopo e Desalocação**

Variáveis locais são desalocadas automaticamente ao final do escopo da função.

```java
void metodo() {
    int x = 10;
    if (x > 5) {
        int y = 20;
    }
    System.out.println(x); // OK
    // System.out.println(y); // Erro: variável fora de escopo
}
```

**Regras:**
- Variáveis declaradas dentro de um bloco `{}` são removidas ao sair do bloco.
- Objetos na **Heap** são removidos apenas quando não há mais referências a eles.

---

<br>

## **4. Desafios e Exemplos**

### **Desafio 1: Código Inválido**
```java
class Teste {
    int x = 37;
    public static void main(String[] args) {
        System.out.println(x);
    }
}
```
❌ **Erro:** `x` é uma variável de instância e não pode ser acessada de um método estático.

✅ **Correção:**
```java
class Teste {
    static int x = 37;
    public static void main(String[] args) {
        System.out.println(x);
    }
}
```

### **Desafio 2: Implementando Singleton**
Garanta que apenas uma instância de `FabricaDeCarro` seja criada.

```java
class FabricaDeCarro {
    private static FabricaDeCarro instancia;
    
    private FabricaDeCarro() {}
    
    public static FabricaDeCarro getInstance() {
        if (instancia == null) {
            instancia = new FabricaDeCarro();
        }
        return instancia;
    }
}
```

🔹 **Explicação:**
- Construtor privado impede a criação de novos objetos.
- O método `getInstance()` cria um único objeto e o reutiliza.

---

## **5. Conclusão**

A alocação de memória em Java ocorre automaticamente, mas entender como **Stack, Heap e Garbage Collector** interagem é fundamental para escrever código eficiente. Algumas regras importantes:

✅ **Objetos vivem na Heap, enquanto referências e variáveis primitivas estão na Stack.**  
✅ **O Garbage Collector remove objetos inacessíveis, prevenindo vazamentos de memória.**  
✅ **Tipos primitivos armazenam valores diretamente e são mais performáticos que objetos.**  
✅ **O escopo das variáveis determina quando a memória será liberada automaticamente.**

Ao compreender esses conceitos, você pode evitar problemas de desempenho e otimizar sua aplicação em Java! 🚀

