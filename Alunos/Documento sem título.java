import java.util.ArrayList;

// Classe Vendedor  
class Vendedor {  
    private String nome;  
    private int idade;  
    private String loja;  
    private String cidade;  
    private String bairro;  
    private String rua;  
    private double salarioBase;  
    private ArrayList\<Double\> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {  
        this.nome \= nome;  
        this.idade \= idade;  
        this.loja \= loja;  
        this.cidade \= cidade;  
        this.bairro \= bairro;  
        this.rua \= rua;  
        this.salarioBase \= salarioBase;  
        this.salarioRecebido \= new ArrayList\<\>();  
    }

    public void adicionarSalario(double salario) {  
        if (salarioRecebido.size() \< 3\) {  
            salarioRecebido.add(salario);  
        } else {  
            System.out.println("Já existem 3 registros de salário recebidos.");  
        }  
    }

    public void apresentarse() {  
        System.out.println("Nome: " \+ nome \+ ", Idade: " \+ idade \+ ", Loja: " \+ loja);  
    }

    public double calcularMedia() {  
        if (salarioRecebido.isEmpty()) {  
            return 0;  
        }  
        double soma \= 0;  
        for (double salario : salarioRecebido) {  
            soma \+= salario;  
        }  
        return soma / salarioRecebido.size();  
    }

    public double calcularBonus() {  
        return salarioBase \* 0.2;  
    }  
}

// Classe Cliente  
class Cliente {  
    private String nome;  
    private int idade;  
    private String cidade;  
    private String bairro;  
    private String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {  
        this.nome \= nome;  
        this.idade \= idade;  
        this.cidade \= cidade;  
        this.bairro \= bairro;  
        this.rua \= rua;  
    }

    public void apresentarse() {  
        System.out.println("Nome: " \+ nome \+ ", Idade: " \+ idade);  
    }  
}

// Classe Loja  
class Loja {  
    private String nomeFantasia;  
    private String razaoSocial;  
    private String cnpj;  
    private String cidade;  
    private String bairro;  
    private String rua;  
    private ArrayList\<Vendedor\> vendedores;  
    private ArrayList\<Cliente\> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {  
        this.nomeFantasia \= nomeFantasia;  
        this.razaoSocial \= razaoSocial;  
        this.cnpj \= cnpj;  
        this.cidade \= cidade;  
        this.bairro \= bairro;  
        this.rua \= rua;  
        this.vendedores \= new ArrayList\<\>();  
        this.clientes \= new ArrayList\<\>();  
    }

    public int contarClientes() {  
        return clientes.size();  
    }

    public int contarVendedores() {  
        return vendedores.size();  
    }

    public void apresentarse() {  
        System.out.println("Nome Fantasia: " \+ nomeFantasia \+ ", CNPJ: " \+ cnpj \+ ", Endereço: " \+ rua \+ ", " \+ bairro \+ ", " \+ cidade);  
    }

    public void adicionarVendedor(Vendedor vendedor) {  
        vendedores.add(vendedor);  
    }

    public void adicionarCliente(Cliente cliente) {  
        clientes.add(cliente);  
    }  
}

public class Main {  
    public static void main(String\[\] args) {  
        // Criando a loja  
        Loja loja \= new Loja("My Plant", "My Plant Ltda", "12.345.678/0001-90", "São Paulo", "Centro", "Rua das Flores, 100");

        // Criando vendedores  
        Vendedor vendedor1 \= new Vendedor("Carlos Silva", 30, loja.getNomeFantasia(), "São Paulo", "Centro", "Rua das Flores", 2500);  
        Vendedor vendedor2 \= new Vendedor("Fernanda Souza", 25, loja.getNomeFantasia(), "São Paulo", "Centro", "Rua das Flores", 2200);

        // Adicionando salários  
        vendedor1.adicionarSalario(2500);  
        vendedor1.adicionarSalario(2600);  
        vendedor1.adicionarSalario(2550);

        vendedor2.adicionarSalario(2200);  
        vendedor2.adicionarSalario(2300);  
        vendedor2.adicionarSalario(2400);

        // Criando clientes  
        Cliente cliente1 \= new Cliente("João Pereira", 40, "São Paulo", "Centro", "Rua das Flores");  
        Cliente cliente2 \= new Cliente("Maria Oliveira", 35, "São Paulo", "Centro", "Rua das Flores");

        // Adicionando vendedores e clientes à loja  
        loja.adicionarVendedor(vendedor1);  
        loja.adicionarVendedor(vendedor2);  
        loja.adicionarCliente(cliente1);  
        loja.adicionarCliente(cliente2);

        // Exibindo informações da loja  
        loja.apresentarse();  
        System.out.println("Quantidade de Vendedores: " \+ loja.contarVendedores());  
        System.out.println("Quantidade de Clientes: " \+ loja.contarClientes());

        System.out.println("\\nVendedores:");  
        for (Vendedor vendedor : loja.vendedores) {  
            vendedor.apresentarse();  
            System.out.println("Média de Salários: " \+ vendedor.calcularMedia());  
            System.out.println("Bônus: " \+ vendedor.calcularBonus() \+ "\\n");  
        }

        System.out.println("Clientes:");  
        for (Cliente cliente : loja.clientes) {  
            cliente.apresentarse();  
        }  
    }  
}

