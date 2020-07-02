package controller;

import domain.Autor;
import domain.Clan;
import domain.Knjiga;
import domain.Radnik;
import domain.Zaduzenje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.PropertyReader;
import util.ResponseStatus;

public class Controller {

    private static Controller instance;
    private final Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;

    private Controller() throws IOException {
        socket = new Socket("localhost", Integer.valueOf(PropertyReader.getInstance().getProperty("port")));
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public static Controller getInstance() throws IOException {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Object request(Operation op, Object data) throws Exception {
        RequestObject requestObject = new RequestObject(op, data);
        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        if (responseObject.getStatus().equals(ResponseStatus.ERROR)) {
            throw new Exception(responseObject.getErrorMessage());
        }
        return responseObject.getData();
    }

    public Radnik prijaviRadnika(Radnik radnik) throws IOException, ClassNotFoundException, Exception {
        return (Radnik) request(Operation.OPERATION_LOGIN, radnik);
    }

    public Radnik sacuvajRadnika(Radnik noviRadnik) throws Exception {
        return (Radnik) request(Operation.OPERATION_SACUVAJ_RADNIKA, noviRadnik);
    }

    public List<Autor> vratiSveAutore() throws Exception {
        return (List<Autor>) request(Operation.OPERATION_SVI_AUTORI, null);
    }

    public void sacuvajKnjigu(Knjiga knjiga) throws Exception {
        request(Operation.OPERATION_SACUVAJ_KNJIGU, knjiga);
    }

    public void sacuvajClana(Clan clan) throws Exception {
        request(Operation.OPERATION_SACUVAJ_CLANA, clan);
    }

    public ArrayList<Knjiga> pronadjiKnjige(String pretraga) throws IOException, Exception {
        return (ArrayList<Knjiga>) request(Operation.OPERATION_PRETRAGA_KNJIGA, pretraga);
    }

    public ArrayList<Clan> vratiSveClanove() throws Exception {
        return (ArrayList<Clan>) request(Operation.OPERATION_SVI_CLANOVI, null);
    }

    public void sacuvajZaduzenje(Zaduzenje zaduzenje) throws Exception {
        request(Operation.OPERATION_SACUVAJ_ZADUZENJE, zaduzenje);
    }

    public ArrayList<Zaduzenje> vratiZaduzenjaClana(Integer clanID) throws Exception {
        return (ArrayList<Zaduzenje>) request(Operation.OPERATION_SVA_ZADUZENJA, clanID);
    }

    public void izmeniZaduzenje(Zaduzenje zaduzenje) throws Exception {
        request(Operation.OPERATION_VRATI_KNJIGU, zaduzenje);
    }

    public ArrayList<Knjiga> vratiSveKnjige() throws Exception {
        return (ArrayList<Knjiga>) request(Operation.OPERATION_SVE_KNJIGE, null);
    }

    public boolean obrisiKnjigu(Knjiga knjiga) throws Exception {
        return (boolean) request(Operation.BRISANJE_KNJIGE, knjiga);

    }

}
