package br.com.jdev.aplicacao;

import java.awt.Dimension;

import javax.swing.JDialog;


public class TelaTimeThread extends JDialog {
	
	public TelaTimeThread() {
//		Configura��es iniciais
		setTitle("Tela de Time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		
		
//		Sempre ser� o �ltimo comando a ser executado.
		setVisible(true);
	}

}
