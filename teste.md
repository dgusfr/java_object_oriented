Explique melhor os tópicos a baixo, mantendo as orientações dos chats anteriores
"

16.1 Herança
Como toda empresa, nosso Banco possui funcionários. Vamos modelar a classe
Funcionario:
class Funcionario {
String nome;
String cpf;
double salario;
// métodos devem vir aqui
}
Além de um funcionário comum, há também outros cargos, como os gerentes.
Os gerentes guardam a mesma informação que um funcionário comum, mas
possuem outras informações, além de ter funcionalidades um pouco diferentes. Um
gerente no nosso banco possui também uma senha numérica que permite o acesso
ao sistema interno do banco:
class Gerente {
String nome;
String cpf;
double salario;
int senha;
public boolean autentica(int senha) {
if (this.senha == senha) {
System.out.println(“Acesso Permitido!”);
return true;
} else {
System.out.println(“Acesso Negado!”);
return false;
}
}
// outros métodos
}



HERANÇA

EXTENDS

PROTECTED
SUPER E SUB
CLASSES
Caelum – http://www.caelum.com.br - Java e Orientação a Objetos

Precisamos mesmo de outra classe?
Poderíamos ter deixado a classe Funcionario mais genérica, mantendo nela senha de
acesso. Caso o funcionário não fosse um gerente, deixaríamos este atributo vazio.
Essa é uma possibilidade. Mas e em relação aos métodos? A classe Gerente tem o
método autentica, que não faz sentido ser acionado em um funcionário que não é
gerente.

Se tivéssemos um outro tipo de funcionário, que tem características diferentes
do funcionário comum, precisaríamos criar uma outra classe, e copiar o código
novamente!
Além disso, se um dia precisarmos adicionar uma nova informação para todos
os funcionários, precisaríamos passar por todas as classes de funcionário e adicionar
esse atributo. O problema acontece novamente por não centralizar as informações
principais do funcionário em um único lugar!
Existe uma maneira, em Java, de relacionarmos uma classe de tal maneira que
uma delas herda tudo que a outra tem. Isto é uma relação de classe mãe e classe
filha. No nosso caso, gostaríamos de fazer com que o Gerente tivesse tudo que um
Funcionario tem, gostaríamos que ela fosse uma extensão de Funcionario.
Fazemos isto através da palavra chave extends.
class Gerente extends Funcionario {
int senha;
public boolean autentica(int senha) {
if (this.senha == senha) {
System.out.println(“Acesso Permitido!”);
return true;
} else {
System.out.println(“Acesso Negado!”);
return false;
}
}
}
Todo momento que criarmos um objeto do tipo Gerente, este objeto possuirá
também os atributos definidos na classe Funcionario, pois agora um Gerente é um
Funcionario:
Gerente gerente = new Gerente();
gerente.nome = “João da Silva”;
gerente.senha = “4231”;

Dizemos que a classe Gerente herda todos os atributos e métodos da classe
mãe, no nosso caso, a Funcionario. Para ser mais preciso, ela também herda os
atributos e métodos privados, porém não consegue acessa-los diretamente.
Super e Sub classe
A nomenclatura mais encontrada é que Funcionario é a superclasse de Gerente, e
Gerente é a subclasse de Funcionario. Dizemos também que todo Gerente é um
Funcionário.

E se precisamos acessar os atributos que herdamos? Não gostaríamos de
deixar os atributos de Funcionario public, pois dessa maneira qualquer um

poderia alterar os atributos dos objetos deste tipo. Existe um outro modificador de
acesso, o protected, que fica entre o private e o public. Um atributo protected
só pode ser acessado (visível) pela própria classe ou suas subclasses.
class Funcionario {
protected String nome;
protected String cpf;
protected double salario;
// métodos devem vir aqui
}
Sempre usar protected?
Então porque usar private? Depois de um tempo programando orientado a objetos,
você vai começar a sentir que nem sempre é uma boa idéia deixar que a classe filha
acesse os atributos da classe mãe, pois isto quebra um pouco a idéia de que só aquela
classe deveria manipular seus atributos. Essa é uma discussão um pouco mais
avançada.
Além disso, não só as subclasses podem acessar os atributos protected, como outras
classes, que veremos mais a frente (mesmo pacote).
16.2 - Reescrita de método

Todo fim de ano, os funcionários do nosso banco recebem uma bonificação. Os
funcionários comuns recebem 10% do valor do salário e os gerentes, 15%.
Vamos ver como fica a classe Funcionario:

class Funcionario {
protected String nome;
protected String cpf;
protected double salario;
public double getBonificacao() {
return this.salario * 0.10;
}
// métodos
}

Se deixarmos a classe Gerente como ela está, ela vai herdar o método
getBonificacao.
Gerente gerente = new Gerente();
gerente.setSalario(5000.0);
System.out.printoln(gerente.getBonificacao());

O resultado aqui será 500. Não queremos essa resposta, não queremos este
método que foi escrito na classe mãe, eu quero reescrever (sobrescrever, override)
este método:
class Gerente extends Funcionario {
int senha;
public double getBonificacao() {
return this.salario * 0.15;
}
// ...



POLIMORFISMO

}
Agora sim o método está correto para o Gerente. Refaça o teste e veja que,
agora, o valor impresso é o correto (750):
Gerente gerente = new Gerente();
gerente.setSalario(5000.0);
System.out.printoln(gerente.getBonificacao());
16.3 - Polimorfismo

O que guarda uma variável do tipo Funcionario? Uma referência para um
Funcionario.
Na herança, vimos que Gerente é um Funcionario, pois é uma extensão
deste. Eu posso me referenciar a um Gerente como sendo um Funcionario. Se
alguém precisa falar com um Funcionario do banco, pode falar com um Gerente!
Por que? Pois Gerente é um Funcionario. Essa é a semântica da herança.
Funcionario funcionario = new Gerente();
funcionario.salario = 5000.0;

Polimorfismo é a capacidade de um objeto poder ser referenciado de várias
formas. (cuidado, polimorfismo nao quer dizer que o objeto fica se transformando,
muito pelo contrario, um objeto nasce de um tipo e morre daquele tipo, o que muda
e a maneira como nos referenciamos a ele).
Até aqui tudo bem, mas e se eu tentar:

funcionario.getBonificacao();

Qual é o retorno desse método? 500 ou 750? No Java, a chamada de método
sempre vai ser decidida em tempo de execução. O Java vai procurar o objeto na
memória e ai sim decidir qual método deve ser chamado, sempre relacionando com
sua classe de verdade, e não a que estamos usando para referencia-lo. Apesar de
estarmos nos referenciando a esse Gerente como sendo um Funcionario, o método
executado é o do Gerente. O retorno é 750.
Parece estranho criar um gerente e referenciá-lo como apenas um funcionário.
Porque faria isso? Na verdade, a situação que costuma aparecer é a que temos um
método que recebe um argumento do tipo Funcionario:
class ControleDeBonificacoes {
private double totalDeBonificacoes = 0;
public void bonifica(Funcionario funcionario) {
this.totalDeBonificacoes += funcionario.getBonificacao();
}
public double getTotalDeBonificacoes() {
return this.totalDeBonificacoes;
}
}

E, em algum lugar da minha aplicação (ou no main se for apenas para testes):

ControleDeBonificacoes controle = new ControleDeBonificacoes();
Gerente funcionario1 = new Gerente();
funcionario1.setSalario(5000.0);
controle.bonifica(funcionario1);


Funcionario funcionario2 = new Funcionario();
funcionario2.setSalario(1000.0);
controle.bonifica(funcionario2);
System.out.println(controle.getTotalDeBonificacoes());

Repare que conseguimos passar um Gerente para um método que recebe um
Funcionario como argumento.
Qual será o valor resultante?
O dia que criarmos uma classe Secretaria, por exemplo, que é filha de
Funcionario, precisaremos mudar a classe de ControleDeBonificacoes? Não.
Basta a classe Secretario reescrever os métodos que lhe parecer necessário. É
exatamente esse o poder do polimorfismo juntamente com a herança e reescrita de
método: diminuir acoplamento entre as classes, para que evitar que novos códigos
resultem em modificações em inúmeros lugares.
Repare que quem criou ControleDeBonificacoes pode nunca ter imaginado a
criação da classe Secretario ou Engenheiro. Isto tras um reaproveitamente
enorme de código.
16.4 - Um exemplo mais completo

Imagine que vamos modelar um sistema para a faculdade, que controle as
despesas com funcionários e professores. Nosso funcionário fica assim:
class EmpregadoDaFaculdade {
private String nome;
private double salario;
double getGastos() {
return this.salario;
}
String getInfo() {
return “nome: ” + this.nome + “ com salário ” + this.salario;
}
// métodos de get, set e outros
}
O gasto que temos com o professor não é apenas seu salário. Temos de somar
um bônus de 10 reais por hora/aula. O que fazemos então? Reescrevemos o método.
Assim como o getGastos é diferente, o getInfo também será, pois temos de
mostrar as horas aula também.
class ProfessorDaFaculdade extends EmpregadoDaFaculdade {
private int horasDeAula;
double getGastos() {
return this.getSalario() + this.horasDeAula * 10;
}
String getInfo() {
String informacaoBasica = super.getInfo();
String informacao = informacaoBasica + “ horas de aula: ” +

this.horasDeAula;

return informacao;
}
// métodos de get, set e outros
}



COMPOSIÇÃO


A novidade aqui é a palavra chave super. Apesar do método ter sido reescrito,
gostaríamos de acessar o método da classe mãe, para não ter de copiar e colocar o
conteúdo desse método e depois concatenar com a informação das horas de aula.
Como tiramos proveito do polimorfismo? Imagine que temos uma classe de
relatório:
class GeradorDeRelatorio {
public void adiciona(FuncionarioDaFaculdade f) {
System.out.println(f.getInfo());
System.out.println(f.getGatos());
}
}

Podemos passar para nossa classe qualquer FuncionarioDaFaculdade! Vai
funcionar tanto para professor, quanto para funcionário comum.
Um certo dia, muito depois de terminar essa classe de relatório, resolvemos
aumentar nosso sistema, e colocar uma classe nova, que representa o Reitor. Como
ele também é um FuncionarioDaFaculdade, será que vamos precisar alterar
alguma coisa na nossa classe de Relatorio? Não. essa é a idéia. Quem programou a
classe GeradorDeRelatorio nunca imaginou que existiria uma classe Reitor, e
mesmo assim o sistema funciona.
class Reitor extends ProfessorDaFaculdade {
// informações extras
String getInfo() {
return super.getInfo() + “ e ele é um reitor”;
}
// não sobreescrevemos o getGastos!!!
}
16.5 - Um pouco mais...

1-) Se não houvesse herança em Java, como você poderia reaproveitar o
código de outra classe?
2-) Uma discussão muito atual é sobre o abuso no uso da herança. Algumas
pessoas usam herança apenas para reaproveitar o código, quando poderia ter feito
uma composição. Procure sobre herança versus composição.
3-) Mesmo depois de reescrever um método da classe mãe, a classe filha ainda
pode acessar o método antigo. Isto é feito através da palavra chave
super.método(). Algo parecido ocorre entre os construtores das classes, o que?