package banco;

import java.util.Objects;

public abstract class Conta implements iConta {

	protected int agencia;
	protected int numConta;
	protected double saldo;
	protected Cliente cliente;

	public Conta(int agencia, int numConta, Cliente cliente) {
		this.agencia = agencia;
		this.numConta = numConta;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumConta() {
		return numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return numConta == other.numConta;
	}

	public double sacar(double valor, boolean imprimirMensagem) throws SaldoInsuficienteException {
		if (valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque ou transferência.");
		} else {
			saldo -= valor;
			if (imprimirMensagem) {
				System.out.println("Saque realizado - Saldo atual: " + saldo);
			}
			return saldo;
		}

	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void transferir(double valor, Conta contadestino) throws SaldoInsuficienteException {
		this.sacar(valor, false);
		contadestino.depositar(valor);
		System.out.println("Transferência realizada - Saldo atual: " + saldo);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", cliente.getNome()));
		System.out.println(String.format("Agência: %d", agencia));
		System.out.println(String.format("Número da Conta: %d", numConta));
		System.out.println(String.format("Saldo: %.2f", saldo));
	}
	
	 public double consultarSaldo() {
	        return saldo;
	    }

}
