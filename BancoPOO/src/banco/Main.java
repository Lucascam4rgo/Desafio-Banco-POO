package banco;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException {
		Banco banco = new Banco("Meu banco");
		
		Cliente lucas = new Cliente();
		lucas.setNome("Lucas");
		
		banco.adicionarContaCorrente(1, 1001, lucas);
		banco.adicionarContaPoupanca(1, 1002, lucas);
		
		ContaCorrente cc = (ContaCorrente) banco.buscarConta(1001);
		ContaPoupanca poupanca = (ContaPoupanca) banco.buscarConta(1002);
		
		 if (cc != null) {
	            cc.depositar(100);

	            try {
	                cc.transferir(100, poupanca);
	            } catch (SaldoInsuficienteException e) {
	                System.out.println(e.getMessage());
	            }

	            try {
	                cc.sacar(150, false);
	            } catch (SaldoInsuficienteException e) {
	                System.out.println(e.getMessage());
	            }

	            cc.imprimirExtrato();
	        }

	        if (poupanca != null) {
	            poupanca.imprimirExtrato();
	        }

	}

}
