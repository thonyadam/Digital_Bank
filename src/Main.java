
public class Main {

	public static void main(String[] args) {
		/*Cliente cliente = new Cliente();
		cliente.setNome("Cliente 1");

		Cliente cliente2 = new Cliente();
		cliente.setNome("Cliente 2");
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente2);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();*/

		Cliente cliente = new Cliente();
		cliente.setNome("Anthony");

		Conta conta = new ContaCorrente(cliente);

		conta.depositar(100);

		conta.imprimirExtrato();

		System.out.println(conta.analisarEmprestimo());
		System.out.println(conta.solicitarEmprestimo(500));

		conta.imprimirExtrato();
	}

}
