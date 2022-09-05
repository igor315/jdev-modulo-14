package br.com.jdev.aplicacao;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread{
	
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}
	
	@Override
	public void run() {
		

		Iterator iteracao = pilha_fila.iterator();
		
//		Bloquear o acesso a esta lista por outros processos
		synchronized (iteracao) {
			
//		Enquanto conter dados na lista irá processar
			while(iteracao.hasNext()) {
				ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
				
//			Processar 10 mil notas fiscais
//			Gerar uma lista ernome de PDF
//			Gerar um envio em massa de email
				
				System.out.println("-------------------------");
				
				System.out.println(processar.getEmail());
				System.out.println(processar.getNome());
				
//			processa o que quiser remove e parte para o proximo objeto
				iteracao.remove();
				
				try {
//				Dar um tempo para descarga de memoria
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		try {
//			Processou toda a lista, dar um tempo para limpeza de mémoria
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
