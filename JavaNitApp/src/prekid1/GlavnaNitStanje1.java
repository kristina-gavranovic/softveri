package prekid1;


/*
  Primer GlavnaNitStanje1:
  Nit se nalazi u stanju izvrsava se i zeli se
  prekinuti rad te niti (koristi se logicka promenljiva).
*/
class NitStanje extends Thread{
	boolean izvrsavaSe;
	NitStanje(){
		izvrsavaSe=true;
	}
	public void run(){
		int i =0;
		while (izvrsavaSe==true){
			i++;
			System.out.println(i+". put se izvrsavam...");
		}
		System.out.println("NitStanje zavrsila rad - XXX");
	}
	public void prekiniIzvrsenjeNiti(){
		System.out.println("Pozvana metoda prekiniIzvrsenjeNiti()");
		izvrsavaSe=false;
	}
}

class GlavnaNitStanje1{
	public static void main(String[] args)throws Exception{
		NitStanje objNit = new NitStanje();
		objNit.start();
		Thread.sleep(5000);
		objNit.prekiniIzvrsenjeNiti();
		System.out.println("Glavna programska nit zavrsila rad - XXX");

	}
}