package banco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int agencia, int numConta, Cliente cliente) {
		super(agencia, numConta, cliente);
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato da Conta Poupança === ");
		super.imprimirInfosComuns();
	}

}
