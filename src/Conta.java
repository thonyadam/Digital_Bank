
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double emprestimo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public String analisarEmprestimo() {
		//analisa se a pessoa já tem um emprestimo em aberto
		String analise = "";

		if (this.emprestimo > 0){
			analise = "Você tem um emprestimo não quitado";
		}else if (this.saldo <= 0) {
			analise = "Você não tem direito ao emprestimo";
		}
		else{
			analise = String.format("Você tem direito a um emprestimo de até: %.2f, com juros de 10%%", this.valorEmprestimo());
		}

		return analise;
	}

	@Override
	public double valorEmprestimo(){
		//gera o emprestimo com um valor ficticio de 10 vezes o que a pessoa tem de saldo
		double emprestimo = this.saldo * 10;

		return emprestimo;
	}

	@Override
	public String solicitarEmprestimo(double valor){
		String solicitacao = "";

		if (valor <= 0 ){
			solicitacao = "Valor não pode ser menor que 0";
		}else {
			double divida = valor * 1.1;
			this.emprestimo = divida;
			this.saldo = this.saldo + valor;

			solicitacao = String.format("Emprestimo aprovado no valor de %.2f !", valor);
		}


		return solicitacao;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Emprestimo: %.2f", this.emprestimo));
	}
}
