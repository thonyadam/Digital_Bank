
public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);

	String analisarEmprestimo();

	double valorEmprestimo();

	String solicitarEmprestimo(double valor);
	
	void imprimirExtrato();
}
