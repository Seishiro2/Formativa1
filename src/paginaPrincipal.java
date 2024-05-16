import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paginaPrincipal extends JFrame {

    private JLabel TituloPrincipal;
    private JButton JogoDaMegaButton;
    private JButton JogosUserButton;
    private JPanel painelPrincipal;

    public paginaPrincipal() {

        setSize(900, 600);
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JogoDaMegaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new jogoSorteadoMega();
                dispose();

            }
        });

    }

    public static void main(String[] args) {

        paginaPrincipal pg = new paginaPrincipal();

    }
}
