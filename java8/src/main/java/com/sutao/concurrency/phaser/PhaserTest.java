package com.sutao.concurrency.phaser;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Phaser;

public class PhaserTest {

	public static void main(String[] args) {

		List<Worker> workers = new LinkedList<Worker>();
		Phaser p = new MyPhaser(workers);

		// register main
		p.register();

		for(int j=0; j<5; j++){
			// register 3 workers
			p.bulkRegister(3);
			for(int i=0; i<3; i++){
				Worker w = new Worker(p);
				workers.add(w);
				w.start();
			}

			System.out.println(threadName()+" current arrived: "+p.getArrivedParties());
			int arriveIndex = p.arriveAndAwaitAdvance();
			System.out.println(threadName()+" arrivate index: "+arriveIndex);
			System.out.println("workers size="+workers.size());
		}
	}

	public static String threadName(){
		return Thread.currentThread().getName();
	}

	static class Worker extends Thread {

		private static int WOKER_ID = 0;

		private Phaser p;

		public Worker(Phaser p){
			this.p = p;
			setName("Worker-"+(WOKER_ID++));
		}

		public void run(){
			if(!p.isTerminated()){
				System.out.println(threadName()+" current arrived: "+p.getArrivedParties());
				int phaseNum = p.arriveAndDeregister();
				System.out.println(threadName()+" arrivate index is: "+phaseNum);
			}else{
				System.out.println("phaser has terminated");
			}
		}
	}

	static class MyPhaser extends Phaser {

		private List<Worker> workers;

		public MyPhaser(List<Worker> workers){
			this.workers = workers;
		}

		@Override
		protected boolean onAdvance(int phase, int registeredParties) {
			System.out.println("========= current phase ["+this.getPhase()+"], p:"+phase+", r: "+registeredParties+" =========");

			System.out.println("arrived parties: "+this.getArrivedParties()+", unarrived parties: "+this.getUnarrivedParties()+", registered: "+this.getRegisteredParties());
			workers.clear();

			return true;
		}
	}

}
