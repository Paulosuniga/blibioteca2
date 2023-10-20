package com.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class LivroVendaTest {

    @Test
    public void testConstrutorSemParametros() {
        LivroVenda livroVenda = new LivroVenda();
        assertNotNull(livroVenda); // Garante que o objeto foi instanciado corretamente
        assertNull(livroVenda.livroDoEstoque); // Garante que o atributo livroDoEstoque é nulo
        assertEquals(0, livroVenda.quantidade); // Garante que o atributo quantidade é 0
    }

    @Test
    public void testConstrutorComParametros() {
        LivroEstoque livroEstoque = new LivroEstoque();
        int quantidade = 5;

        LivroVenda livroVenda = new LivroVenda(livroEstoque, quantidade);

        assertNotNull(livroVenda); // Garante que o objeto foi instanciado corretamente
        assertEquals(livroEstoque, livroVenda.livroDoEstoque); // Garante que o atributo livroDoEstoque é o esperado
        assertEquals(quantidade, livroVenda.quantidade); // Garante que o atributo quantidade é o esperado
    }    
    
    @Test
    public void testDecrementarQuantidadeQuandoZero() {
        LivroEstoque livroEstoque = new LivroEstoque();
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);

        assertFalse(livroVenda.DecrementarQuantidade());
    }

    @Test
    public void testIncrementarQuantidade() {
        LivroEstoque livroEstoque = new LivroEstoque();
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);

        livroVenda.IncrementarQuantidade();

        assertEquals(1, livroVenda.quantidade);
    }

    @Test
    public void testIncrementarQuantidadeComValor() {
        LivroEstoque livroEstoque = new LivroEstoque();
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 0);

        livroVenda.IncrementarQuantidade(5);

        assertEquals(5, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidade() {
        LivroEstoque livroEstoque = new LivroEstoque();
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 5);

        assertTrue(livroVenda.DecrementarQuantidade());
        assertEquals(4, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeComValor() {
        LivroEstoque livroEstoque = new LivroEstoque();
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 5);

        assertTrue(livroVenda.DecrementarQuantidade(3));
        assertEquals(2, livroVenda.quantidade);
    }

    @Test
    public void testDecrementarQuantidadeComValorExcedeQuantidade() {
        LivroEstoque livroEstoque = new LivroEstoque();
        LivroVenda livroVenda = new LivroVenda(livroEstoque, 2);

        assertFalse(livroVenda.DecrementarQuantidade(5));
        assertEquals(2, livroVenda.quantidade);
    }
}
