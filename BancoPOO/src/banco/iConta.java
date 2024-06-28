package banco;

public interface iConta {
	
	public double sacar(double valor, boolean imprimirMensagem) throws SaldoInsuficienteException;

	public void depositar(double valor);
	
	public void transferir(double valor, Conta contadestino) throws SaldoInsuficienteException;
	
}
