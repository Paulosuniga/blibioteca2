package com.biblioteca;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class VendaTest {

    @Test
    public void testConstrutorComParametros() {
        String nomeCliente = "Cliente1";
        String formaPagamento = "Cartão";
        double valorDado = 100.0;

        LivroEstoque livroEstoque1 = new LivroEstoque();
        LivroVenda livroVenda1 = new LivroVenda(livroEstoque1, 2);

        LivroEstoque livroEstoque2 = new LivroEstoque();
        LivroVenda livroVenda2 = new LivroVenda(livroEstoque2, 1);

        List<LivroVenda> livros = new ArrayList<>();
        livros.add(livroVenda1);
        livros.add(livroVenda2);

        Venda venda = new Venda(nomeCliente, formaPagamento, valorDado, livros);

        assertEquals(nomeCliente, venda.nomeCliente);
        assertEquals(formaPagamento, venda.formaPagamento);
        assertEquals(valorDado, venda.valorDado, 0.001); // Comparação de double com margem de erro
        assertEquals(livros, venda.livros);
    }

    @Test
    public void testConstrutorSemParametros() {
        Venda venda = new Venda();

        assertNull(venda.nomeCliente);
        assertNull(venda.formaPagamento);
        assertEquals(0.0, venda.valorDado, 0.001);
        assertNull(venda.livros);
    }
}
