package br.com.brunosouza2.banco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ClienteTest {

    @Test
    void getNomeDeveRetornarNome(){
        // Arrange
        String nomeEsperado = "Luis";

        // Act
        Cliente cliente = new Cliente("Luis");
        String nomeAtual = cliente.getNome();

        // Assert
        assertEquals(nomeEsperado, nomeAtual);
    }

    @Test
    void getNomeDeveRetornarExceptionSeNulo(){
        // Arrange e Act
        assertThrows(NullPointerException.class, () -> new Cliente(null));
    }

}