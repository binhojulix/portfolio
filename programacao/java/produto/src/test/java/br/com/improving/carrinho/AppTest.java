/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.improving.carrinho;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

/**
 *
 * @author binho
 */

class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void valorTotalItem() {
        Produto produto1 = new Produto(1l, "sabonete");
        Item item = new Item(produto1, BigDecimal.valueOf(2), 2);
        assertEquals(BigDecimal.valueOf(4), item.getValorTotal());
    }

    @Test
    void testaValorTotal() {
        Produto produto1 = new Produto(1l, "sabonete");
        Produto produto2 = new Produto(2l, "escova de dente");
        Produto produto3 = new Produto(3l, "cerveja");
        CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
        CarrinhoCompras carrinhoCompras = carrinhoComprasFactory.criar("fabio");
        carrinhoCompras.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto3, BigDecimal.valueOf(3), 2);
        assertEquals(BigDecimal.valueOf(14), carrinhoCompras.getValorTotal());
    }
    @Test
    void  testaRemoveItemPorProduto() {
        Produto produto1 = new Produto(1l, "sabonete");
        Produto produto2 = new Produto(2l, "escova de dente");
        Produto produto3 = new Produto(3l, "cerveja");
        CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
        CarrinhoCompras carrinhoCompras = carrinhoComprasFactory.criar("fabio");
        carrinhoCompras.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto3, BigDecimal.valueOf(3), 2);
        assertEquals(true, carrinhoCompras.removerItem(produto1));
    }

    @Test
    void testaRemoveItemPorId() {
        Produto produto1 = new Produto(1l, "sabonete");
        Produto produto2 = new Produto(2l, "escova de dente");
        Produto produto3 = new Produto(3l, "cerveja");
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        carrinhoCompras.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto3, BigDecimal.valueOf(3), 2);
        assertEquals(true, carrinhoCompras.removerItem(1));
    }

    @Test
    void invalidarCarrinhoComprasFactory(){
        Produto produto1 = new Produto(1l, "sabonete");
        Produto produto2 = new Produto(2l, "escova de dente");
        Produto produto3 = new Produto(3l, "cerveja");
        CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
        CarrinhoCompras carrinhoCompras = carrinhoComprasFactory.criar("fabio");
        carrinhoCompras.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto3, BigDecimal.valueOf(3), 2);
        CarrinhoCompras carrinhoCompras2 = carrinhoComprasFactory.criar("fabio");
        carrinhoCompras2.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras2.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras2.adicionarItem(produto3, BigDecimal.valueOf(3), 2);

        assertEquals(true, carrinhoComprasFactory.invalidar("fabio"));
    }

    @Test
    void getValorTicketMedioCarrinhoComprasFactory(){
        Produto produto1 = new Produto(1l, "sabonete");
        Produto produto2 = new Produto(2l, "escova de dente");
        Produto produto3 = new Produto(3l, "cerveja");
        CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
        CarrinhoCompras carrinhoCompras = carrinhoComprasFactory.criar("fabio");
        carrinhoCompras.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto3, BigDecimal.valueOf(3), 2);
        CarrinhoCompras carrinhoCompras2 = carrinhoComprasFactory.criar("fabio");
        carrinhoCompras2.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras2.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras2.adicionarItem(produto3, BigDecimal.valueOf(3), 2);
        BigDecimal total =  BigDecimal.ZERO;
        total = total.add(carrinhoCompras.getValorTotal());
        total = total.add(carrinhoCompras.getValorTotal());
        total = total.divide(BigDecimal.valueOf(2));
        assertEquals(total, carrinhoComprasFactory.getValorTicketMedio());

    }
  
  






  
}
