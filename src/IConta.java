
public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);

	double analisarEmprestimo();

	String solicitarEmprestimo(double valor);
	
	void imprimirExtrato();
}
