package br.com.jdev.aplicacao;
/**
 * 
 * @author Igor Santos
 *
 *Curso jdev treinamentos, módulo de Thread e programação paralela ou concorrente
 */
public class AulaThread {
	
	public static void main(String[] args) throws InterruptedException {
		
//		Quero executar esse envio com um tempo de parada, ou com tempo determinado
		for(int pos = 0; pos <= 10; pos++) {
//			thread.sleep define o tempo que ele executara essa rotina de enviar o email
			Thread.sleep(2000);
			System.out.println("Executando alguma rotina, por exemplo envio de e-mail");
		}
		
		System.out.println("CHEGOU AO FIM DO CÓDIGO DE TESTE DE THREAD");
	}
}
