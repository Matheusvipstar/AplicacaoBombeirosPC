/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaobombeirospc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class ControleDeArquivo {
    public static String Read(String caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha + "\r\n";
                    linha = lerArq.readLine();
                }
                Write(caminho, conteudo);
                arq.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return conteudo;
    }
    
    public static boolean Write(String caminho, String texto){
        try{
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean addLocal(String caminho, Local local){
        try {
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravaArq = new PrintWriter(arq);
            String conteudo = Read(caminho);
            conteudo += "\r\n" +local.getEndereço() +"\r\n" +local.getUrl();
            gravaArq.println(conteudo);
            gravaArq.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Local procurarLocal(String caminho, String local){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha!=null) {                    
                    if(linha==local){
                        linha = lerArq.readLine();
                        return new Local(local, linha);
                    }
                }
                arq.close();
                lerArq.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Local> lerTodosLocais(String caminho){
        List<Local> locais = new ArrayList<>();
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    String endereco = linha;
                    System.out.println(endereco);
                    linha = lerArq.readLine();
                    String url = linha;
                    System.out.println(url);
                    locais.add(new Local(endereco, url));
                    linha = lerArq.readLine();
                }
                arq.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return locais;
    }
}
