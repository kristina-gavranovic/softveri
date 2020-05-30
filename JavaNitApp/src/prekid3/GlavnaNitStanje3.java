package prekid3;

import prekid1.*;


/*
  Primer GlavnaNitStanje3:
  Nit se nalazi u stanju izvrsava se i zeli se prekinuti rad te niti
  - koristi se metoda interrupt() -
*/
class NitStanje extends Thread{
	public void run(){
		int i =0;
		/* vrati stanje */
		while (!isInterrupted()){
			i++;
			System.out.println(i+". put se izvrsavam...");
		}
		/* stanje = true */
		System.out.println("1.isInterupted() "+isInterrupted()); //t
                System.out.println("2.isInterupted() "+isInterrupted()); //t
		System.out.println("3.interupted() "+interrupted()); //t
		System.out.println("4.isInterupted() "+isInterrupted());//f

                System.out.println("5.interupted() "+interrupted()); //f
		System.out.println("6.isInterupted() "+isInterrupted());//f
                interrupt();
                System.out.println("7.isInterupted() "+isInterrupted());//t
                
                
		System.out.println("NitStanje zavrsila rad - XXX");
	}
}

class GlavnaNitStanje3{
	public static void main(String[] args)throws Exception{
		NitStanje objNit = new NitStanje();
		objNit.start();
		Thread.sleep(2000);
		objNit.interrupt();
		System.out.println("Glavna programska nit zavrsila rad - XXX");
	}
}