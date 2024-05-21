import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class registerPage extends JFrame{
    private JLabel userLabel;
    private JTextField newUserBox;
    private JLabel senhaLabel;
    private JTextField newSenhaBox;
    private JButton RegistrarSe;
    private JPanel painelRegistro;
    private JLabel vazioBoxes;

    public registerPage(){

        setSize(700,400);
        setContentPane(painelRegistro);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        RegistrarSe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if((newSenhaBox.getText().equals("")) || (newUserBox.getText().equals(""))){

                    vazioBoxes.setText("PREENCHA OS CAMPOS");

                }else {

                    //escreve o user no arquivo
                    try {
                        FileWriter escritor = new FileWriter("logins.txt",true);
                        escritor.write(newUserBox.getText() + ";" + newSenhaBox.getText() + "\n");
                        escritor.close();
                    } catch (IOException p) {
                        throw new RuntimeException(p);
                    }

                    new loginPage();
                    dispose();

                }

            }
        });

    }

}
