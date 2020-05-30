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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.ResponseStatus;

/**
 *
 * @author student1
 */


public class Controller {

    private static Controller instance;
    private final Map<String, Object> map; 
    private final Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;

    private Controller() throws IOException {
        map = new HashMap<>();
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

    public void pronadjiRadnika(String username, String password) throws IOException, ClassNotFoundException, Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_LOGIN);
        Map<String, String> radnikMap = new HashMap<>();
        radnikMap.put("username", username);
        radnikMap.put("password", password);
        requestObject.setData(radnikMap);

        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();

        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        ResponseStatus status = responseObject.getStatus();
        if (status == ResponseStatus.SUCCESS) {
            map.put("radnik", responseObject.getData());
        } else {
            throw new Exception(responseObject.getErrorMessage());
        }
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
        //waiting response
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

    public ArrayList<Primerak> pronadjiPrimerke(String pretraga) throws IOException, Exception {
        RequestObject requestObject = new RequestObject(Operation.OPERATION_PRETRAGA_KNJIGA, pretraga);
        objectOutputStream.writeObject(requestObject);
        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            throw new Exception(responseObject.getErrorMessage());
        }
       return  (ArrayList<Primerak>) responseObject.getData();
    }

    
     
}
