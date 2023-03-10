package project;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("|--------------------------------------------------|");
        System.out.println("|----------* Bem vindos a nossa Agência *----------|");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|-----* Selecione uma operação para continuar *----|");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                Opção 1 - Criar conta             |");
        System.out.println("|                Opção 2 - Depósitar               |");
        System.out.println("|                Opção 3 - Sacar                   |");
        System.out.println("|                Opção 4 - Transferir              |");
        System.out.println("|                Opção 5 - Listar                  |");
        System.out.println("|                Opção 6 - Cancelar                |");
        System.out.println("|                Opção 7 - Sair                    |");
        System.out.println("|--------------------------------------------------|");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1 -> criarConta();
            case 2 -> depositar();
            case 3 -> sacar();
            case 4 -> transferir();
            case 5 -> listarContas();
            case 6 -> cancelar();
            case 7 -> {
                System.out.println("Obrigado por utilizar nossa Agência!");
                System.exit(0);
            }
            default -> {
                System.out.println("Opção inválida!");
                operacoes();
            }
        }
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nSobrenome: ");
        String sobrenome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, sobrenome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for (Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depósitar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depósitado com sucesso!");
        }else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void sacar() {

        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
//            System.out.println("Valor retirado com sucesso!");
        }else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void transferir() {

        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }else {
                System.out.println("A conta para depósito não foi encontrada!");
                System.out.println("\n");
            }
        }else {
            System.out.println("Conta para transferência não encontrada!");
            System.out.println("\n");
        }
        operacoes();
    }

    public static void cancelar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Deseja realmente cancelar a conta?");
            System.out.println("Digite 1 para SIM e 2 para NÃO");
            int confirmar = input.nextInt();

            if (confirmar == 1) {
                contasBancarias.remove(conta);
                System.out.println("Conta cancelada com sucesso!");
            }else {
                System.out.println("Operação cancelada!");
            }

        }else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }
}
