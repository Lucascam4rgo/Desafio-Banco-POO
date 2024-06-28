package banco;

public class ContaCorrente extends Conta {

	public ContaCorrente(int agencia, int numConta, Cliente cliente) {
		super(agencia, numConta, cliente);
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato da Conta Corrente === ");
		super.imprimirInfosComuns();
	}

}
