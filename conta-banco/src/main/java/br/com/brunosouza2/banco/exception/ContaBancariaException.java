package br.com.brunosouza2.banco.exception;

public class ContaBancariaException extends RuntimeException {

    public ContaBancariaException() {
    }

    public ContaBancariaException(String message) {
        super(message);
    }
}
