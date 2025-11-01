
package Teste1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaAutenticacao extends JFrame implements ActionListener {
	
    private JLabel lbUser, lbSenha;
    private JTextField tfUser;
    private JPasswordField pfSenha;
    private JButton btEntrar;

    public TelaAutenticacao() {
        this.setTitle(" **|Tela de Autenticação do utilizador|**");
        this.setSize(400, 200);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2, 5, 5));

        lbUser = new JLabel("Usuário:");
        lbSenha = new JLabel("Senha:");
        tfUser = new JTextField(15);
        pfSenha = new JPasswordField(15);
        btEntrar = new JButton("Entrar");
        btEntrar.addActionListener(this);

        this.add(lbUser);
        this.add(tfUser);
        this.add(lbSenha);
        this.add(pfSenha);
        this.add(new JLabel(""));
        this.add(btEntrar);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = tfUser.getText();
        String senha = new String(pfSenha.getPassword());

        if (user.equals("admin") && senha.equals("0000")) {
            String nome = JOptionPane.showInputDialog("Digite o seu nome:");
            double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Valor inicial da conta:"));

            Conta conta = new Conta(nome, saldoInicial);

            this.setVisible(false);
            new Menu(conta);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciais inválidas!");
        }      
    }
    
}



