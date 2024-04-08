//package meuapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;


public class lotofacil extends JFrame {

    //atributos
    private JPanel painel = new JPanel();
    private JLabel jLabelMensagem1 = new JLabel("☛ LOTO FACIL ☚");
    private JLabel jLabelMensagem = new JLabel("Escolha qual aposta deseja fazer: ");
    private JButton jButtonApostar = new JButton("✅ Apostar");
    private JLabel jLabel1 = new JLabel("Digite sua Aposta:");
    private JTextField jTextField1 = new JTextField("" , 20);
    private JComboBox<String> jComboBox1 = new JComboBox<>(new String[]{"Aposta de 0 a 100", "Apostar A à Z", "Apostar PAR ou ÍMPAR"}); // Adicionando opções ao JComboBox


    //construtor
    public lotofacil(){
        this.setTitle("Lotofácil");
        this.setSize(400,400);
        configurarComponentes();
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setVisible(true); // Exibir janela
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/android-chrome-192x192.png"));
        setIconImage(icon);
    }

    private void configurarComponentes() {
        jButtonApostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNovaJanela();
            }
        });
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        jTextField1.setFont(new Font("Arial", Font.PLAIN,16));
        painel.add(jLabelMensagem1);
        painel.add(jLabelMensagem);


        painel.add(jComboBox1);
        painel.add(jLabel1);
        painel.add(jTextField1);
        painel.add(jButtonApostar);
        this.getContentPane().add(painel);

    }
    private void abrirNovaJanela() {
        String opcaoSelecionada = (String) jComboBox1.getSelectedItem();
        // Criando uma nova janela
        JFrame novaJanela = new JFrame("Nova Janela");
        novaJanela.setSize(300, 200);

        if (opcaoSelecionada.equals("Aposta de 0 a 100")) {
            SecureRandom random = new SecureRandom();
            int rand = random.nextInt(101);
            try {
                int value = Integer.parseInt(jTextField1.getText());
                if (value >= 0 && value <= 100) {
                    if (value == rand) {
                        novaJanela.add(new JLabel("Parabéns! Seu número foi sorteado. Você ganhou R$ 1.000,00 reais! \uD83D\uDE04" ));
                    } else
                        novaJanela.add(new JLabel("Seu número não foi sorteado. Número sorteado: " +rand+ " \uD83D\uDE41"));
                }else
                    novaJanela.add(new JLabel("Digite Apenas número de 0 à 100"));
            }catch(Exception e){
                novaJanela.add(new JLabel("Digite apenas Números 0 à 100"));
            }
        } else if (opcaoSelecionada.equals("Apostar A à Z")) {
            try {
                char bet = jTextField1.getText().charAt(0);
                char let = 'M';
                if(Character.isLetter(bet)){
                    bet = Character.toUpperCase(bet);
                    if (bet == let){
                        novaJanela.add(new JLabel("Parabéns a letra sorteada foi: "+ let+ " \uD83D\uDE04"));
                    }else
                        novaJanela.add(new JLabel("Desculpe a letra escolhida foi: "+ bet +" A letra premiada é: "+let));

                }else
                    novaJanela.add(new JLabel("Digite apenas UMA letra!"));
            } catch (IndexOutOfBoundsException ex) {
                novaJanela.add(new JLabel("Erro: Insira uma letra."));
            }
        } else if (opcaoSelecionada.equals("Apostar PAR ou ÍMPAR")) {
            int value = Integer.parseInt(jTextField1.getText());
            if (value %2 == 0){
                novaJanela.add(new JLabel("Parabéns o número sorteado foi par "+ value + " \uD83D\uDE04"));
            }else
                novaJanela.add(new JLabel("Desculpe o sorteio foi para numeros pares e não impares"));
        }

        // Configurando a nova janela
        novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas a janela atual ao fechar
        novaJanela.setLocationRelativeTo(null);
        novaJanela.setVisible(true);
        novaJanela.setTitle("LotoFácil");// Exibir a nova janela
        novaJanela.setSize(400,260);
        novaJanela.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/android-chrome-192x192.png"));
        setIconImage(icon);
    }
    public static void main(String[] args) {
        new lotofacil();
    }
}
