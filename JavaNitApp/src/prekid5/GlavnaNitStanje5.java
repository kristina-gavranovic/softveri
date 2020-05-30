package prekid5;


/*
  Primer GlavnaNitStanje5:
  Nit se nalazi u stanju blokade i zeli se prekinuti rad te niti
*/
class NitStanje extends Thread{
	public void run(){
		int i =0;
		try{
			while (true){
				i++;
				System.out.println(i+". put se izvrsavam...");
				sleep(100000);// generise izuzetak
			}
	    }catch(InterruptedException ie){
			System.out.println("NitStanje zavrsila rad - XXX");
		}
	}
}

class GlavnaNitStanje5{
	public static void main(String[] args)throws Exception{
		NitStanje objNit = new NitStanje();
		objNit.start();
		Thread.currentThread().sleep(2000);
		objNit.interrupt();
		System.out.println("Probudila se glavna nit");
		System.out.println("Glavna programska nit zavrsila rad - XXX");
	}
}