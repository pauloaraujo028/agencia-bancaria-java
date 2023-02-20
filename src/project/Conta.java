package project;

import utilitarios.Utils;

public class Conta {

    private static int idDeContas = 1;
    private static int numeroDeContas = 1001;

    private int idContas;
    private long numeroConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.idContas = idDeContas;
        this.numeroConta = numeroDeContas;
        this.cliente = cliente;
        numeroDeContas += 1;
        idDeContas += 1;
    }

    public int getIdContas() {
        return idContas;
    }

    public void setIdContas(int idContas) {
        this.idContas = idContas;
    }

    public int getNumeroConta() {
        return (int) numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nID da conta: " + this.getIdContas() +
                "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.cliente.getNome() + " " + cliente.getSobrenome() +
                "\nCPF: " + this.cliente.getCPF() +
                "\nEmail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a transferencia!");
        }
    }
}
