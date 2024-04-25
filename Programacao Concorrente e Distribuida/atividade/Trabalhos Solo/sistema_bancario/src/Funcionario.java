public class Funcionario extends Thread {
    private Double salario = 1400.00;
    private String id;
    private String idInvestimento;
    private Conta conta;
    private Conta contaInvestimento;
    private Banco banco;

    // Construtor da classe Funcionario
    public Funcionario(String id, Banco banco) {
        // Inicializa as variáveis do funcionário, incluindo suas contas e o banco
        this.id = "Funcionario" + id;
        this.idInvestimento = id + "Investimento";
        try {
            // Inicializa a conta corrente do funcionário
            this.conta = new Conta(0.00, id);
        } catch (Exception e) {
            // Lança uma exceção em caso de erro na criação da conta corrente
            throw new RuntimeException(e);
        }
        try {
            // Inicializa a conta de investimento do funcionário
            this.contaInvestimento = new Conta(0.00, idInvestimento);
        } catch (Exception e) {
            // Lança uma exceção em caso de erro na criação da conta de investimento
            throw new RuntimeException(e);
        }
        // Inicializa o banco
        this.banco = banco;
    }

    // Método para obter o ID do funcionário
    @Override
    public long getId() {
        return Long.parseLong(id);
    }

    // Método para obter a conta corrente do funcionário
    public Conta getConta() {
        return conta;
    }

    // Método para obter a conta de investimento do funcionário
    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    // Método para realizar o investimento de uma parte do salário do funcionário
    public void investir() {
        // Calcula o valor do investimento como 20% do salário
        double valorInvestimento = salario * 0.2;
        // Transfere o valor do investimento da conta corrente do funcionário para sua conta de investimento
        banco.transferir(conta, contaInvestimento, valorInvestimento);
    }
}
