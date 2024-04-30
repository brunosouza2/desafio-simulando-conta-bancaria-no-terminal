package br.com.brunosouza2.banco;

import br.com.brunosouza2.banco.exception.ContaBancariaException;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta {

    private int numero;
    private String agencia;
    private BigDecimal saldo;
    private Cliente cliente;

    public Conta(int numero, String agencia, BigDecimal saldo, Cliente cliente) {
        setNumero(numero);
        setAgencia(agencia);
        setSaldo(saldo);
        setCliente(cliente);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) throw new ContaBancariaException("O número da conta não pode ser igual a 0 ou negativo.");
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        Objects.requireNonNull(agencia);
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        Objects.requireNonNull(saldo);
        if (saldo.compareTo(new BigDecimal("0.0")) < 1) throw new ContaBancariaException("Saldo inválido.");
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Objects.requireNonNull(cliente);
        this.cliente = cliente;
    }
}