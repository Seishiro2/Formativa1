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
    private JButton voltarButton;

    public static int[] geradorMegasena(){

        Random r = new Random();

        int desposableNum = 0;
        int[] megasenaAleatoria = new int[6];

        for(int i = 0; i <= 5; i++){

            //variavel descartavel
            desposableNum = r.nextInt(1, 60);
            //váriavel que diz caso a lista ja tenha X valor
            boolean contains;
            if (Arrays.asList(megasenaAleatoria).contains(i)) contains = true;
            else contains = false;

            if(contains){
                //caso tenha o item já, n adiciona ele e volta o loop até não repetir
                i--;
            } else{
                //ganha o numero novo
                megasenaAleatoria[i] = desposableNum;
            }

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

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new paginaPrincipal();
                dispose();

            }
        });

    }

    public static void main(String[] args) {
        //faz o programa executar normal
        jogoSorteadoMega jm = new jogoSorteadoMega();

    }

}
