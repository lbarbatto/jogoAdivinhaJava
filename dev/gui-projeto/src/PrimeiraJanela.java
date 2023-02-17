import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import javax.swing.JFormattedTextField;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Label;

public class PrimeiraJanela {

	private static int numeroCerto;
	private JFrame frame;
	private JFormattedTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraJanela window = new PrimeiraJanela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//		Instancia a classe que sorteia o número certo.
		
		SorteiaNumero sorteio = new SorteiaNumero();
		numeroCerto = sorteio.getNumero();

//		System.out.println(numeroCerto);
	}

	/**
	 * Create the application.
	 */
	public PrimeiraJanela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Jogo da Adivinhação");
		lblTitulo.setBounds(0, 11, 444, 23);
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(lblTitulo);

		JLabel lblRodape = new JLabel("Leopoldo Barbato - Alura T4 - ONE Oracle Next Education");
		lblRodape.setBounds(0, 325, 444, 15);
		lblRodape.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblRodape.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRodape.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRodape.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblRodape);

		txtInput = new JFormattedTextField();
		txtInput.setBounds(36, 152, 200, 75);
		txtInput.setHorizontalAlignment(SwingConstants.CENTER);
		txtInput.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtInput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtInput.setText("Digite um número de 1 a 100.");
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);

		JLabel lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImagem.setIcon(new ImageIcon("C:\\Users\\leopo\\Desktop\\java_alura\\gui-projeto\\src\\02.png"));
		lblImagem.setBounds(294, 45, 140, 269);
		frame.getContentPane().add(lblImagem);

		JFormattedTextField txtMensagens = new JFormattedTextField();
		txtMensagens.setBorder(null);
		txtMensagens.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMensagens.setFont(new Font("Verdana", Font.BOLD, 14));
		txtMensagens.setEditable(false);
		txtMensagens.setText("Qual NÚMERO eu escolhi?");
		txtMensagens.setBounds(36, 64, 277, 66);
		frame.getContentPane().add(txtMensagens);

		Label lblResultado = new Label("Total de Tentativas");
		lblResultado.setVisible(false);
		lblResultado.setFont(new Font("Verdana", Font.BOLD, 14));
		lblResultado.setAlignment(Label.CENTER);
		lblResultado.setBounds(36, 152, 200, 22);
		frame.getContentPane().add(lblResultado);

		Label lblTentativas = new Label("");
		lblTentativas.setAlignment(Label.CENTER);
		lblTentativas.setVisible(false);
		lblTentativas.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTentativas.setBounds(36, 180, 200, 47);
		frame.getContentPane().add(lblTentativas);

		JButton btnCompara = new JButton("CHUTAR");
		btnCompara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValidaEntrada validador = new ValidaEntrada();

				if (!validador.valida(txtInput.getText())) {
					txtInput.setText("Apenas números entre 1 e 100.");
				}

				int chute = Integer.parseInt(txtInput.getText());

				ComparaResposta comparador = new ComparaResposta();
				String mensagemResultado = comparador.compara(chute, numeroCerto);

				if (mensagemResultado == "Parabéns! Você acertou!") {
					txtMensagens.setFont(new Font("Verdana", Font.BOLD, 14));
					txtMensagens.setText(mensagemResultado);
					lblImagem.setIcon(new ImageIcon("C:\\Users\\leopo\\Desktop\\java_alura\\gui-projeto\\src\\01.png"));
					txtInput.setVisible(false);
					btnCompara.setVisible(false);
					lblResultado.setVisible(true);
					lblTentativas.setVisible(true);
					String result = String.valueOf(comparador.getTotalTentativas());
					lblTentativas.setText(result);

				} else {
					txtMensagens.setFont(new Font("Verdana", Font.PLAIN, 12));
					txtMensagens.setText(mensagemResultado);
				}

			}
		});
		btnCompara.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCompara.setBounds(90, 238, 88, 23);
		frame.getContentPane().add(btnCompara);

	}
}
