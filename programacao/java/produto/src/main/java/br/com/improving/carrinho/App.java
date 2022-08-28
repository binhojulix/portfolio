package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Produto produto1 = new Produto(1l, "sabonete");
        Produto produto2 = new Produto(2l, "escova de dente");
        Produto produto3 = new Produto(3l, "cerveja");
        CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
        carrinhoCompras.adicionarItem(produto1, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto2, BigDecimal.valueOf(2), 2);
        carrinhoCompras.adicionarItem(produto3, BigDecimal.valueOf(3), 2);
       // System.out.println(carrinhoCompras.removerItem(1));
        System.out.println(carrinhoCompras.removerItem(produto1));
        for(Item i : carrinhoCompras.getItens()){
            System.out.println(i.getProduto());
        }
        System.out.println(carrinhoCompras.getValorTotal());
        
    }
}
