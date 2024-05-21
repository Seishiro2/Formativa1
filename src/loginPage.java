import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class loginPage extends JFrame{
    private JTextField caixaUsuario;
    private JButton loginButton;
    private JButton registrarButton;
    private JLabel senhaLabel;
    private JPanel loginPainel;
    private JLabel userLabel;
    private JTextField caixaSenha;
    private JLabel labelDoErro;
    private JButton cancelarButton;

    public boolean verificarUser(){

        try {
            BufferedReader leitor =
                    new BufferedReader(new FileReader("logins.txt"));
            String linha;
            do {
                linha = leitor.readLine();
                if(linha!= null)
                {
                    String[] u = linha.split(";");
                    if(u[0].equals(caixaUsuario.getText()) && u[1].equals(caixaSenha.getText())){

                        return true;

                    }
                }
            }while(linha != null);
            leitor.close();
        } catch (Exception e) {

        }
        return false;
    }

    public loginPage(){

        setSize(700,400);
        setContentPane(loginPainel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if((caixaUsuario.getText().equals("") && caixaSenha.getText().equals("")) ||
                        (caixaUsuario.getText().equals("") || caixaSenha.getText().equals(""))){

                    labelDoErro.setText("PREENCHA OS CAMPOS CORRETAMENTE");

                }else if(verificarUser()) {

                    new paginaPrincipal();
                    dispose();

                }

            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new registerPage();
                dispose();

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });

    }

    public static void main(String[] args) {

        loginPage lpg = new loginPage();

    }

}
