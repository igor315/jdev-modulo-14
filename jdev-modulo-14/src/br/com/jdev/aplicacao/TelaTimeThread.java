package br.com.jdev.aplicacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class TelaTimeThread extends JDialog {
	
//	Painel de componentes
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
	private JLabel descricaoHora = new JLabel("Time da thread1");
	private JTextField mostraTempo = new JTextField(); 
	
	private JLabel descricaoHora2 = new JLabel("Time da thread2");
	private JTextField mostraTempo2 = new JTextField();
	
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
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(mostraTempo, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(mostraTempo2, gridBagConstraints);
		
		add(jPanel, BorderLayout.WEST);
//		Sempre sera o ultimo comando a ser executado.
		setVisible(true);
	}

}