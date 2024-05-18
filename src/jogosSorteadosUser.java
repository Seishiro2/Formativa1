import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class jogosSorteadosUser extends JFrame {
    private JPanel painelSorteados;
    private JTable tabelaJogos;
    private JButton botãoDeCriarJogoUser;
    private JButton voltarButton;

    public jogosSorteadosUser(){

        setSize(900,600);
        setContentPane(painelSorteados);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        DefaultTableModel tblModel = (DefaultTableModel) tabelaJogos.getModel();
        //criando coluna
        tblModel.addColumn("SEUS JOGOS!");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new paginaPrincipal();
                dispose();

            }
        });

        //botão que cria os jogos do user

        botãoDeCriarJogoUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //a string q vai salvar novos jogos
                String[] salvarJogosUser = new String[6];
                salvarJogosUser = new String[]{Arrays.toString(jogoSorteadoMega.geradorMegasena())};


                //vai escrever os jogos gerados em um arquivo
                try {
                    FileWriter escritor = new FileWriter("jogosUsuario.txt",true);
                    escritor.write(Arrays.toString(salvarJogosUser) + "\n");
                    escritor.close();
                } catch (IOException p) {
                    throw new RuntimeException(p);
                }

                //escreve os jogos na tabela
                tblModel.addRow(salvarJogosUser);

            }
        });

        //le os jogos do arquivo
        try {
            BufferedReader leitor =
                    new BufferedReader(new FileReader("jogosUsuario.txt"));
            String linha;
            do {
                linha = leitor.readLine();
                if(linha!= null)
                {
                    tblModel.addRow(new String[]{linha});
                }
            }while(linha != null);
            leitor.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        //roda de fato a tela
        jogosSorteadosUser j = new jogosSorteadosUser();

    }

}
