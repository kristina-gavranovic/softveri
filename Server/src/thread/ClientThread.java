package thread;

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
import java.util.List;
import java.util.Map;

import service.ServiceRadnik;
import service.impl.ServiceAutorImpl;

import service.impl.ServiceRadnikImpl;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.ResponseStatus;
import service.ServiceAutor;
import service.ServiceClan;
import service.ServiceKnjiga;
import service.ServicePrimerak;
import service.impl.ServiceClanImpl;
import service.impl.ServiceKnjigaImpl;
import service.impl.ServicePrimerakImpl;

/**
 *
 * @author Dusan
 */
public class ClientThread extends Thread {

    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    private final ServiceRadnik serviceRadnik;
    private final ServiceAutor serviceAutor;
    private final ServiceKnjiga serviceKnjiga;
    private final ServiceClan serviceClan;
    private final ServicePrimerak servicePrimerak;

    private Radnik ulogovaniRadnik;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        serviceRadnik = new ServiceRadnikImpl();
        serviceAutor = new ServiceAutorImpl();
        serviceKnjiga = new ServiceKnjigaImpl();
        serviceClan = new ServiceClanImpl();
        servicePrimerak = new ServicePrimerakImpl();

    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                RequestObject requestObject = (RequestObject) objectInputStream.readObject();
                ResponseObject responseObject = handleRequest(requestObject);
                objectOutputStream.writeObject(responseObject);
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private ResponseObject handleRequest(RequestObject requestObject) {
        int operation = requestObject.getOperation();
        switch (operation) {
            case Operation.OPERATION_LOGIN:
                return pronadjiRadnika((Map) requestObject.getData());
            case Operation.OPERATION_SVI_AUTORI:
                return vratiSveAutore();
            case Operation.OPERATION_SACUVAJ_RADNIKA:
                return sacuvajRadnika((Radnik) requestObject.getData());
            case Operation.OPERATION_SACUVAJ_KNJIGU:
                return sacuvajKnjigu((Knjiga) requestObject.getData());
            case Operation.OPERATION_SACUVAJ_CLANA:
                return sacuvajClana((Clan) requestObject.getData());
            case Operation.OPERATION_PRETRAGA_KNJIGA:
                return pronadjiPrimerke((String) requestObject.getData());

        }
        return null;
    }

    private ResponseObject pronadjiRadnika(Map data) {
        String username = (String) data.get("username");
        String password = (String) data.get("password");
        ResponseObject responseObject = new ResponseObject();
        try {
            Radnik radnik = serviceRadnik.pronadjiRadnika(username, password);
            this.ulogovaniRadnik = radnik;
            responseObject.setData(radnik);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }

        return responseObject;
    }

    public Socket getSocket() {
        return socket;
    }

    private ResponseObject sacuvajRadnika(Radnik radnik) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Radnik sacuvanRadnik = serviceRadnik.sacuvaj(radnik);
            responseObject.setData(sacuvanRadnik);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    public Radnik getLoginUser() {
        return ulogovaniRadnik;
    }

    private ResponseObject vratiSveAutore() {
        ResponseObject responseObject = new ResponseObject();
        try {
            List<Autor> autori = serviceAutor.vratiSve();
            responseObject.setData(autori);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }

        return responseObject;

    }

    private ResponseObject sacuvajKnjigu(Knjiga knjiga) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Knjiga k = serviceKnjiga.sacuvaj(knjiga);
            responseObject.setData(k);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;

    }

    private ResponseObject sacuvajClana(Clan clan) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Clan sacuvanClan = serviceClan.sacuvaj(clan);
            responseObject.setData(sacuvanClan);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;

    }

    private ResponseObject pronadjiPrimerke(String pretraga) {
        ResponseObject responseObject = new ResponseObject();

        try {
            ArrayList<Primerak> primerci = servicePrimerak.pronadjiPrimerke(pretraga);
            responseObject.setData(primerci);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());

        }
        return responseObject;
    }

}
