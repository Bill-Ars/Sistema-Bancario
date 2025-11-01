package Teste1;

public class Conta {
    private static int contadorContas = 1; // gera número de conta automático
    private int numeroConta;
    private String nome;
    private double saldo;
    private int numeroLevantamentos;
    
    

    public Conta(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
        this.numeroConta = contadorContas++;
        this.numeroLevantamentos = 0;
    }
    
    
  
    
  
    public String getNome() {
        return nome;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroLevantamentos() {
        return numeroLevantamentos;
    }

    public void depositar(double valor) {     
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean levantar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            numeroLevantamentos++;
            return true;
        }
        return false;
    }
}
