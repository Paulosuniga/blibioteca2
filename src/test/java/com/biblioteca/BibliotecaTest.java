package com.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void testAdicionarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("Nome Autor", "Sobrenome Autor");
        Editora editora = new Editora("Minha Editora");
        Livro livro = new Livro(autor, editora, "123456789", "Meu Livro", 200);

        biblioteca.AdicionarLivro(livro);

        assertTrue(biblioteca.livros.contains(livro));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarLivroExistente() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("Nome Autor", "Sobrenome Autor");
        Editora editora = new Editora("Minha Editora");
        Livro livro1 = new Livro(autor, editora, "123456789", "Meu Livro", 200);
        Livro livro2 = new Livro(autor, editora, "123456789", "Outro Livro", 150);

        biblioteca.AdicionarLivro(livro1);
        biblioteca.AdicionarLivro(livro2);  // Deve lançar uma exceção
    }

    @Test
    public void testRemoverLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("Nome Autor", "Sobrenome Autor");
        Editora editora = new Editora("Minha Editora");
        Livro livro = new Livro(autor, editora, "123456789", "Meu Livro", 200);

        biblioteca.AdicionarLivro(livro);
        biblioteca.RemoverLivro(livro);

        assertFalse(biblioteca.livros.contains(livro));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverLivroInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("Nome Autor", "Sobrenome Autor");
        Editora editora = new Editora("Minha Editora");
        Livro livro = new Livro(autor, editora, "123456789", "Meu Livro", 200);

        biblioteca.RemoverLivro(livro);  // Deve lançar uma exceção
    }

    @Test
    public void testAdicionarEstoque() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro(new Autor(), new Editora(), "ISBN123", "Livro 1", 100);
        LivroEstoque livroEstoque1 = new LivroEstoque(livro1, 5, 10.0);

        biblioteca.AdicionarEstoque(livroEstoque1);

        assertEquals(1, biblioteca.estoque.size());
        assertSame(livroEstoque1, biblioteca.estoque.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarEstoqueComLivroExistente() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro(new Autor(), new Editora(), "ISBN123", "Livro 1", 100);
        LivroEstoque livroEstoque1 = new LivroEstoque(livro1, 5, 10.0);
        LivroEstoque livroEstoque2 = new LivroEstoque(livro1, 3, 8.0);

        biblioteca.AdicionarEstoque(livroEstoque1);
        biblioteca.AdicionarEstoque(livroEstoque2); // Deve lançar uma exceção
    }

    @Test
    public void testRemoverEstoque() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro(new Autor(), new Editora(), "ISBN123", "Livro 1", 100);
        LivroEstoque livroEstoque1 = new LivroEstoque(livro1, 5, 10.0);

        biblioteca.AdicionarEstoque(livroEstoque1);
        biblioteca.RemoverEstoque(livroEstoque1);

        assertEquals(0, biblioteca.estoque.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverEstoqueComLivroInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro(new Autor(), new Editora(), "ISBN123", "Livro 1", 100);
        LivroEstoque livroEstoque1 = new LivroEstoque(livro1, 5, 10.0);

        biblioteca.RemoverEstoque(livroEstoque1); // Deve lançar uma exceção
    }

    @Test
    public void testAdicionarAutor() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("Nome Autor", "Sobrenome Autor");

        biblioteca.AdicionarAutor(autor);

        assertTrue(biblioteca.autores.contains(autor));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarAutorExistente() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor1 = new Autor("Nome Autor", "Sobrenome Autor");
        Autor autor2 = new Autor("Nome Autor", "Sobrenome Autor");

        biblioteca.AdicionarAutor(autor1);
        biblioteca.AdicionarAutor(autor2); // Deve lançar uma exceção
    }

    @Test
    public void testRemoverAutor() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("Nome Autor", "Sobrenome Autor");

        biblioteca.AdicionarAutor(autor);
        biblioteca.RemoverAutor(autor);

        assertFalse(biblioteca.autores.contains(autor));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverAutorInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor("Nome Autor", "Sobrenome Autor");

        biblioteca.RemoverAutor(autor); // Deve lançar uma exceção
    }

    @Test
    public void testAdicionarEditora() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora("Minha Editora");

        biblioteca.AdicionarEditora(editora);

        assertTrue(biblioteca.editoras.contains(editora));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarEditoraExistente() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora1 = new Editora("Minha Editora");
        Editora editora2 = new Editora("Minha Editora");

        biblioteca.AdicionarEditora(editora1);
        biblioteca.AdicionarEditora(editora2); // Deve lançar uma exceção
    }

    @Test
    public void testRemoverEditora() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora("Minha Editora");

        biblioteca.AdicionarEditora(editora);
        biblioteca.RemoverEditora(editora);

        assertFalse(biblioteca.editoras.contains(editora));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverEditoraInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        Editora editora = new Editora("Minha Editora");

        biblioteca.RemoverEditora(editora); // Deve lançar uma exceção
    }
}
