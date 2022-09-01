package br.com.jdev.aplicacao;

import javax.swing.JOptionPane;

/**
 * 
 * @author Igor Santos
 *
 *Curso jdev treinamentos, m�dulo de Thread e programa��o paralela ou concorrente
 */
public class AulaThread {
	
	public static void main(String[] args) throws InterruptedException {
		
//		Thread processando em paralelo do envio do e-mail
		new Thread() {
			
//			run executa o que nos queremos
			public void run() {
				
//		C�digo da rotina que eu quero executar em paralelo
				for(int pos = 0; pos <= 10; pos++) {
					System.out.println("Executando alguma rotina, por exemplo envio de e-mail");

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		
//		start liga a thread que fica processando paralelamente
		}.start();
		
		Thread.sleep(10000);
		
//		Segunda thread de processamento em paralelo
		new Thread() {
			
			public void run() {
				for(int pos = 0; pos < 10; pos ++) {
					System.out.println("Gerando rel�t�rios");
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}.start();
		
		
//		C�digo do sistema do usu�rio continua o fluxo de trabalho
		System.out.println("CHEGOU AO FIM DO C�DIGO DE TESTE DE THREAD");
		
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usu�rio");
	}
}
