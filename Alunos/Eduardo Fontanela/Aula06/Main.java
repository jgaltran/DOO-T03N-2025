public class Main {
    public static void main(String[] args) {
        // Criando um vendedor
        Vendedor v = new Vendedor();
        v.nome = "Carlos";
        v.idade = 30;
        v.loja = "My Plant - Centro";
        v.cidade = "São Paulo";
        v.bairro = "Centro";
        v.rua = "Rua das Flores";
        v.salarioBase = 2000.00;

        // Criando um cliente
        Cliente c = new Cliente();
        c.nome = "Fernanda";
        c.idade = 28;
        c.cidade = "São Paulo";
        c.bairro = "Vila Mariana";
        c.rua = "Rua Verde";

        // Criando uma loja
        Loja loja = new Loja();
        loja.nomeFantasia = "My Plant";
        loja.razaoSocial = "My Plant Comércio de Plantas LTDA";
        loja.cnpj = "12.345.678/0001-99";
        loja.cidade = "São Paulo";
        loja.bairro = "Centro";
        loja.rua = "Rua das Palmeiras";

        // Adicionando vendedor e cliente à loja
        loja.vendedores.add(v);
        loja.clientes.add(c);

        // Exibindo informações
        v.apresentarse();
        System.out.println("Média Salarial: " + v.calcularMedia());
        System.out.println("Bônus: " + v.calcularBonus());
        System.out.println();

        c.apresentarse();
        System.out.println();

        loja.apresentarse();
        loja.contarClientes();
        loja.contarVendedores();
    }
}
