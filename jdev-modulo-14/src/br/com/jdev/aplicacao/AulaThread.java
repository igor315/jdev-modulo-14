package br.com.jdev.aplicacao;

import javax.swing.JOptionPane;

/**
 * 
 * @author Igor Santos
 *
 *         Curso jdev treinamentos, módulo de Thread e programação paralela ou
 *         concorrente
 */
public class AulaThread {

	public static void main(String[] args) throws InterruptedException {

//		Thread processando em paralelo do envio do e-mail
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();

		Thread.sleep(10000);

//		Segunda thread de processamento em paralelo
		Thread threadRelatorio = new Thread(thread2);
		threadRelatorio.start();
		
//		Código do sistema do usuário continua o fluxo de trabalho
		System.out.println("CHEGOU AO FIM DO CÓDIGO DE TESTE DE THREAD");

		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	private static Runnable thread1 = new Runnable() {
		@Override
		public void run() {
//			Código da rotina que eu quero executar em paralelo
			for (int pos = 0; pos <= 10; pos++) {
				System.out.println("Executando alguma rotina, por exemplo envio de e-mail");

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	private static Runnable thread2 = new Runnable() {
		@Override
		public void run() {
			for (int pos = 0; pos < 10; pos++) {
				System.out.println("Gerando relátórios");

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	};
	
}
