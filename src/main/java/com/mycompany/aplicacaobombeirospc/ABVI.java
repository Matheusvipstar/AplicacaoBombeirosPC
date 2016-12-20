/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaobombeirospc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Matheus Henrique
 */
public class ABVI extends JFrame{
    
    protected JTextArea notificacoes;
    private List<Local> locais;
    
    public ABVI() {
        super("ABVI");
        Container firstContainer = getContentPane();
        firstContainer.setLayout(new BorderLayout());
        
        Container secondContainer = new JPanel();
        secondContainer.setLayout(new GridLayout(1,4));
        secondContainer.add(new JButton("Adicionar local"));
        secondContainer.add(new JButton("Pesquisar local"));
        secondContainer.add(new JButton("Alterar local"));
        secondContainer.add(new JButton("Deletar local"));
        
        notificacoes = new JTextArea("Aqui vai as notificações");
        JScrollPane scroll = new JScrollPane(notificacoes);
        notificacoes.setForeground(Color.BLUE);
        
        firstContainer.add(BorderLayout.CENTER, scroll);
        firstContainer.add(BorderLayout.NORTH, secondContainer);
        
        setSize(500,500);
        getContentPane().setBackground(Color.red);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        locais = ControleDeArquivo.lerTodosLocais("locais e urls.txt");
        ProtocoloDeEnvio PDE = new ProtocoloDeEnvio(locais);
        PDE.start();
    }
    
    public static void main(String[] args){
        new ABVI();
        
    }

    public void addNotificacao(String notificacao){
        notificacoes.append(notificacao +"\n");
    }
    
}
