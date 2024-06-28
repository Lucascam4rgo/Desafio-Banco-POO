package banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}
	
	public void adicionarContaCorrente(int agencia, int numConta, Cliente cliente) {
		contas.add(new ContaCorrente(agencia, numConta, cliente));
	}
	
	public void adicionarContaPoupanca(int agencia, int numConta, Cliente cliente) {
		contas.add(new ContaPoupanca(agencia, numConta, cliente));
	}
	
	public void removerConta(int numConta) {
		contas.removeIf(c -> c.getNumConta() == numConta);
		
	}
	
	public Conta buscarConta(int numConta) {
		for (Conta conta : contas) {
			if(conta.getNumConta() == numConta) {
				return conta;
			}
		}
		System.out.println("Essa conta não existe!");
		return null;
	}
	

	public String getNome() {
		return nome;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
}
