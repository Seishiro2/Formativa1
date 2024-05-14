import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class jogosSorteadosUser extends JFrame {
    private JPanel painelSorteados;
    private JTable tabelaJogos;

    public jogosSorteadosUser(){

        setSize(900,600);
        setContentPane(painelSorteados);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        int[][] tabelinha = new int[1][1];

        tabelaJogos.createDefaultColumnsFromModel();

    }

    public static void main(String[] args) {
        //roda de fato a tela
        jogosSorteadosUser j = new jogosSorteadosUser();

    }

}
