package prekid6;


class NitStanje extends Thread{
	public void run(){
		int i =0;
			while (!isInterrupted()){
				try{
					i++;
					System.out.println(i+". put se izvrsavam...");
					sleep(10000);// generise izuzetak
				}catch(InterruptedException ie){
					/* stanje = false */
					interrupt(); /* set: stanje = true*/
					System.out.println("view stanje: "+isInterrupted());

				}
			}
			System.out.println("NitStanje zavrsila rad - XXX");
	}
}

class GlavnaNitStanje6{
	public static void main(String[] args)throws Exception{
		NitStanje objNit = new NitStanje();
		objNit.start();
		Thread.currentThread().sleep(2000);
		objNit.interrupt();
		System.out.println("Probudila se glavna nit");
		System.out.println("Glavna programska nit zavrsila rad - XXX");
	}
}