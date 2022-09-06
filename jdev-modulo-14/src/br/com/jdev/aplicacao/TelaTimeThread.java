package br.com.jdev.aplicacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class TelaTimeThread extends JDialog {
	
//	Painel de componentes
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
	private JLabel descricaoNome = new JLabel("Nome");
	private JTextField mostraNome = new JTextField(); 
	
	private JLabel descricaoEmail = new JLabel("Email");
	private JTextField mostraEmail = new JTextField();
	
	private JButton jButtonAddLista = new JButton("Add Lista");
	private JButton jButtonStop = new JButton("Stop");
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();
	
	public TelaTimeThread() {
//		Configuracoes iniciais
		setTitle("Tela de Time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		
//		Segunda parte GribagConstraints Controlador de posicionamento de componentes
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = gridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		
		descricaoNome.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoNome, gridBagConstraints);
		
		mostraNome.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		mostraNome.setEditable(true);
		jPanel.add(mostraNome, gridBagConstraints);
		
		descricaoEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoEmail, gridBagConstraints);
		
		mostraEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		mostraEmail.setEditable(true);
		jPanel.add(mostraEmail, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		jButtonAddLista.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButtonAddLista, gridBagConstraints);
		
		jButtonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++;
		jPanel.add(jButtonStop, gridBagConstraints);
		
//		Executa o clique no botão start
		jButtonAddLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
//				Se a fila for igual null inicia um novo objeto.
				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				
//				Enviando um email 100x 
				for(int qtd = 0; qtd < 100; qtd++) {
					
					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraNome.getText());
					filaThread.setEmail(mostraEmail.getText() + " - " + qtd);
					
					fila.add(filaThread);
				}
			}
		});
		
		jButtonStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fila.stop();
				fila = null;
				JOptionPane.showMessageDialog(null, "Você interrompeu o processo!");
			}
		});
		
		fila.start();
		
		add(jPanel, BorderLayout.WEST);
//		Sempre sera o ultimo comando a ser executado.
		setVisible(true);
	}

}
