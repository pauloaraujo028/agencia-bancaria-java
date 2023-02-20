package project;

public class Cliente {

    private static int count = 1;

    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;

    public Cliente(String nome, String sobrenome, String cpf, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        count += 1;
    }

    public Cliente(String nome, String sobrenome) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "\nNome: " + this.getNome() +
                "\nSobrenome: " + this.getSobrenome() +
                "\nCPF: " + this.getCPF() +
                "\nEmail: " + this.getEmail();
    }
}
