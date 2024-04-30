package br.com.brunosouza2.banco;

import br.com.brunosouza2.banco.exception.ContaBancariaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    private Conta conta;

    @BeforeEach
    void setUp(){
        conta = new Conta(1234, "1234-AB", BigDecimal.ZERO, new Cliente("Lucas"));
    }

    @Test
    void getNumeroDeveRetornarNumeroDaConta(){
        // Arrange
        int numeroEsperado = 1234;

        // Act & Assert
        assertEquals(numeroEsperado, conta.getNumero());
    }

    @Test
    void setNumeroDeveInserirNovoNumero(){
        // Arrange
        int numeroEsperado = 2444;

        // Act
        conta.setNumero(2444);

        //Assert
        assertEquals(numeroEsperado, conta.getNumero());
    }

    @Test
    void setNumeroNaoPodeInserirNumeroNegativo(){
        // Arrange
        Class<ContaBancariaException> exception = ContaBancariaException.class;

        //Act e Assert
        assertThrows(exception, () -> conta.setNumero(-1));
    }

    @Test
    void getAgenciaDeveRetornarUmaAgencia(){
        // Arrange
        String agenciaEsperada = "1234-AB";

        // Act e Assert
        assertEquals(agenciaEsperada, conta.getAgencia());
    }

    @Test
    void setAgenciaDeveInserirNovaAgencia(){
        // Arrange
        String agenciaEsperada = "4444-C";

        //Act
        conta.setAgencia("4444-C");

        // Assert
        assertEquals(agenciaEsperada, conta.getAgencia());
    }

    @Test
    void setAgenciaNaoPodeInserirAgenciaNula(){
        // Arrange
        Class<NullPointerException> exceptionEsperada = NullPointerException.class;

        // Act e Assert
        assertThrows(exceptionEsperada, () -> conta.setAgencia(null));
    }

    @Test
    void getSaldoDeveRetornarSaldoAtual(){
        // Arrange
        BigDecimal saldoEsperado = BigDecimal.ZERO;

        // Assert
        assertEquals(saldoEsperado, conta.getSaldo());
    }

    @Test
    void setSaldoDeveInserirNovoSaldo(){
        // Arrange
        BigDecimal saldoEsperado = BigDecimal.TEN;

        // Act
        conta.setSaldo(BigDecimal.TEN);

        // Assert
        assertEquals(saldoEsperado, conta.getSaldo());
    }

    @Test
    void setSaldoNaoPodeInserirValorNegativo(){
        // Arrange
        Class<ContaBancariaException> exceptionEsperada = ContaBancariaException.class;

        //Act e Assert
        assertThrows(exceptionEsperada, () -> conta.setSaldo(new BigDecimal("-1.0")),
                "O saldo não pode ser negativo");
    }

    @Test
    void getClienteDeveRetornarCliente(){
        // Arrange
        Cliente clienteEsperado = new Cliente("Lucas");

        // Assert
        assertEquals(clienteEsperado, conta.getCliente());
    }

    @Test
    void setClienteDeveInserirNovoCliente(){
        // Arrange
        Cliente clienteEsperado = new Cliente("Bruno");

        // Act
        conta.setCliente(new Cliente("Bruno"));

        // Assert
        assertEquals(clienteEsperado, conta.getCliente());
    }

    @Test
    void setClienteNaoPodeInserirClienteNulo(){
        // Arrange
        Class<NullPointerException> exceptionEsperada = NullPointerException.class;

        // Act e Assert
        assertThrows(exceptionEsperada, () -> conta.setCliente(null));
    }





}