package prekid2;

import prekid1.*;


/*
  GlavnaNitStanje2:
  Problem: Nit se nalazi u stanju blokade  i zeli se
  prekinuti rad te niti (koristi se logicka promenljiva).
*/
class NitStanje extends Thread{
	boolean izvrsavaSe;
	NitStanje(){
		izvrsavaSe=true;
	}
	public void run(){
		try{
			int i =0;
			while (izvrsavaSe==true){
				i++;
				System.out.println(i+". put se izvrsavam...");
				sleep(10000);
			}
			System.out.println("NitStanje zavrsila rad - XXX");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void prekiniIzvrsenjeNiti(){
		izvrsavaSe=false;
	}
}

class GlavnaNitStanje2{
	public static void main(String[] args)throws Exception{
		NitStanje objNit = new NitStanje();
		objNit.start();
		Thread.sleep(2000);
		objNit.prekiniIzvrsenjeNiti();
		System.out.println("Glavna programska nit zavrsila rad - XXX");

	}
}