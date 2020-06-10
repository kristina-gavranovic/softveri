/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Autor;
import domain.Clan;
import domain.Knjiga;
import domain.Primerak;

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
import util.ResponseStatus;

/**
 *
 * @author Kristina
 */
public class Controller {

    private static Controller instance;
    private final Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;

    private Controller() throws IOException {
        socket = new Socket("localhost", 9000);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public static Controller getInstance() throws IOException {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Radnik pronadjiRadnika(String username, String password) throws IOException, ClassNotFoundException, Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_LOGIN);
        Radnik radnik = new Radnik();
        radnik.setUsername(username);
        radnik.setPassword(password);

        requestObject.setData(radnik);

        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();

        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
            return (Radnik) responseObject.getData();
        }
        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            //System.out.println("bacio excp u controlleru na klijetu");
            throw new Exception(responseObject.getErrorMessage() + "");
        }
        return null;
    }

    public Radnik sacuvajRadnika(Radnik noviRadnik) throws Exception {
        RequestObject requestObject = new RequestObject(Operation.OPERATION_SACUVAJ_RADNIKA, noviRadnik);
        objectOutputStream.writeObject(requestObject);
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
        if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
            return (Radnik) responseObject.getData();
        }
        throw new Exception(responseObject.getErrorMessage());
    }

    public List<Autor> vratiSveAutore() throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_SVI_AUTORI);

        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        ResponseStatus status = responseObject.getStatus();
        if (status == ResponseStatus.SUCCESS) {
            return (List<Autor>) responseObject.getData();
        } else {
            throw new Exception(responseObject.getErrorMessage());
        }

    }

    public void sacuvajKnjigu(Knjiga knjiga) throws Exception {

        RequestObject requestObject = new RequestObject(Operation.OPERATION_SACUVAJ_KNJIGU, knjiga);
        objectOutputStream.writeObject(requestObject);
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            throw new Exception(responseObject.getErrorMessage());
        }

    }

    public void sacuvajClana(Clan clan) throws Exception {
        RequestObject requestObject = new RequestObject(Operation.OPERATION_SACUVAJ_CLANA, clan);
        objectOutputStream.writeObject(requestObject);
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            throw new Exception(responseObject.getErrorMessage());
        }

    }

    public ArrayList<Knjiga> pronadjiKnjige(String pretraga) throws IOException, Exception {
        RequestObject requestObject = new RequestObject(Operation.OPERATION_PRETRAGA_KNJIGA, pretraga);
        objectOutputStream.writeObject(requestObject);
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            throw new Exception(responseObject.getErrorMessage());
        }

        ArrayList<Knjiga> list = (ArrayList<Knjiga>) responseObject.getData();
        ArrayList<Knjiga> listZadovoljavaUslov = new ArrayList<>();

        for (Knjiga knjiga : list) {
            if (knjiga.getNaslov().toLowerCase().contains(pretraga.toLowerCase())) {
                listZadovoljavaUslov.add(knjiga);
            }

        }

        return listZadovoljavaUslov;
    }

    public ArrayList<Clan> vratiSveClanove() throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_SVI_CLANOVI);

        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        ResponseStatus status = responseObject.getStatus();
        if (status == ResponseStatus.SUCCESS) {
            return (ArrayList<Clan>) responseObject.getData();
        } else {
            throw new Exception(responseObject.getErrorMessage());
        }

    }

    public void sacuvajZaduzenje(Zaduzenje zaduzenje) throws Exception {
        RequestObject requestObject = new RequestObject(Operation.OPERATION_SACUVAJ_ZADUZENJE, zaduzenje);
        objectOutputStream.writeObject(requestObject);
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            throw new Exception(responseObject.getErrorMessage());
        }

    }

    public ArrayList<Zaduzenje> vratiZaduzenjaClana(Integer clanID) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_SVA_ZADUZENJA);

        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        ResponseStatus status = responseObject.getStatus();
        if (status == ResponseStatus.SUCCESS) {
            ArrayList<Zaduzenje> lista = (ArrayList<Zaduzenje>) responseObject.getData();
            if (clanID != -1) {
                List<Zaduzenje> searchResults = new ArrayList<>();

                for (Zaduzenje zaduzenje : lista) {
                    if (zaduzenje.getClan().getId() == clanID) {
                        searchResults.add(zaduzenje);
                    }
                }
                return (ArrayList<Zaduzenje>) searchResults;
            }

            return lista;
        } else {
            throw new Exception(responseObject.getErrorMessage());
        }
    }

    public void vratiKnjigu(Zaduzenje zaduzenje) throws Exception {
          RequestObject requestObject = new RequestObject(Operation.OPERATION_VRATI_KNJIGU, zaduzenje);
        objectOutputStream.writeObject(requestObject);
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            throw new Exception(responseObject.getErrorMessage());
        }
    }

    public ArrayList<Knjiga> vratiSveKnjige() throws Exception {
    RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_SVE_KNJIGE);

        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        ResponseStatus status = responseObject.getStatus();
        if (status == ResponseStatus.SUCCESS) {
            return (ArrayList<Knjiga>) responseObject.getData();
        } else {
            throw new Exception(responseObject.getErrorMessage());
        }    }

}
