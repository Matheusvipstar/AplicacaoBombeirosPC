/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaobombeirospc;

/**
 *
 * @author mathe
 */
public class TesteControleArquivo {
    public static void main(String[] args) {
        String arq = "locais e urls.txt";
        
        String texto = ControleDeArquivo.Read(arq);
        if(texto.isEmpty())
            System.out.println("Erro ao ler do arquivo");
        else
            System.out.println(texto);
        System.out.println("Leitura 1");
        
        
    }
}
