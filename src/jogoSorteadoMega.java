import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class jogoSorteadoMega extends JFrame {

    private JLabel Introdução;
    private JButton ResultadoMegaButton;
    private JLabel resultadoNaTela;
    private JPanel painelSorteioMega;

    public static int[] geradorMegasena(){

        Random r = new Random();

        int[] megasenaAleatoria = new int[6];

        for(int i = 0; i <= 5; i++){

            megasenaAleatoria[i] = r.nextInt(1, 60);

        }

        return megasenaAleatoria;
    }

    public jogoSorteadoMega(){

        setSize(900,600);
        setContentPane(painelSorteioMega);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //função para caso seja apertado o botão
        ResultadoMegaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //coloca na tela o resultado
                resultadoNaTela.setText(Arrays.toString(geradorMegasena()));


            }
        });

    }

    public static void main(String[] args) {
        //faz o programa executar normal
        jogoSorteadoMega jm = new jogoSorteadoMega();

    }

}
