import java.time.LocalDate;

class Carro {
    private int ano;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;

    public Carro(int ano, String marca, String modelo, String cor, String placa) {
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }

    public void exibirDetalhes() {
        System.out.println("Detalhes do Carro:");
        System.out.println("Ano: " + ano);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Placa: " + placa);
    }

    public void atualizarCor(String novaCor) {
        this.cor = novaCor;
        System.out.println("Cor do carro atualizada para: " + novaCor);
    }
}

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void exibirInformacoes() {
        System.out.println("Informações do Cliente:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }
}

class Seguro {
    private Carro carro;
    private Cliente cliente;
    private double valor;
    private LocalDate vigencia;

    public Seguro(Carro carro, Cliente cliente, LocalDate vigencia) {
        this.carro = carro;
        this.cliente = cliente;
        this.vigencia = vigencia;
    }

    public void calcularValor(double baseValor, double taxa) {
        this.valor = baseValor * (1 + taxa / 100);
        System.out.println("Valor calculado do seguro: R$ " + valor);
    }

    public boolean verificarVigencia() {
        LocalDate hoje = LocalDate.now();
        boolean valido = !hoje.isAfter(vigencia);
        System.out.println("O seguro está válido? " + valido);
        return valido;
    }

    public void exibirDetalhesSeguro() {
        System.out.println("Detalhes do Seguro:");
        carro.exibirDetalhes();
        cliente.exibirInformacoes();
        System.out.println("Valor do Seguro: R$ " + valor);
        System.out.println("Vigência até: " + vigencia);
    }
}

public class SistemaSeguros {
    public static void main(String[] args) {
        // Criando instâncias
        Carro carro = new Carro(2020, "Toyota", "Corolla", "Prata", "ABC-1234");
        Cliente cliente = new Cliente("João Silva", "123.456.789-00");
        Seguro seguro = new Seguro(carro, cliente, LocalDate.of(2025, 12, 31));

        // Exibindo detalhes do seguro
        seguro.exibirDetalhesSeguro();

        // Atualizando a cor do carro
        carro.atualizarCor("Preto");

        // Calculando o valor do seguro
        seguro.calcularValor(1000, 10);

        // Verificando a vigência
        seguro.verificarVigencia();
    }
}