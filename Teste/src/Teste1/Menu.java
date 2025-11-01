package Teste1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu MenuOper, ficheiro;
    private JMenuItem extrato, levanta, deposita, sair;

    private Conta conta;

    public Menu(Conta conta) {
        this.conta = conta;

        this.setTitle("Menu Principal");
        this.setSize(500, 400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        MenuOper = new JMenu("Operações");
        ficheiro = new JMenu("Ficheiro");

        extrato = new JMenuItem("Extrato");
        levanta = new JMenuItem("Levantar");
        deposita = new JMenuItem("Depositar");
        sair = new JMenuItem("Sair");

        extrato.addActionListener(this);
        levanta.addActionListener(this);
        deposita.addActionListener(this);
        sair.addActionListener(this);

        MenuOper.add(extrato);
        MenuOper.add(levanta);
        MenuOper.add(deposita);
        ficheiro.add(sair);

        menuBar.add(MenuOper);
        menuBar.add(ficheiro);
        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == extrato) {
            JOptionPane.showMessageDialog(this,
                    "Nome: " + conta.getNome() +
                    "  |  Número da Conta: " + conta.getNumeroConta() +
                    "  |  Saldo: " + conta.getSaldo() +
                    "  |  Numero de levantamentos: " + conta.getNumeroLevantamentos());
        } 
        else if (e.getSource() == levanta) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a levantar:"));
            if (conta.levantar(valor)) {
                JOptionPane.showMessageDialog(this, "Levantamento efetuado!");
            } else {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente!");    
            }
        } 
        else if (e.getSource() == deposita) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a depositar:"));
            conta.depositar(valor);
            JOptionPane.showMessageDialog(this, "Depósito efetuado!");
        } 
        else if (e.getSource() == sair) {
            System.exit(0);
        }
    }
}


