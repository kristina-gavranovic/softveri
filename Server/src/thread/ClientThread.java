package thread;

import controller.Controller;
import database.connection.ConnectionFactory;
import domain.Clan;
import domain.Knjiga;
import domain.Radnik;
import domain.Zaduzenje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.ResponseStatus;

public class ClientThread extends Thread {

    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (!socket.isClosed() && socket.isConnected()) {
            try {
                RequestObject requestObject = (RequestObject) objectInputStream.readObject();
                ResponseObject responseObject = handleRequest(requestObject);

                objectOutputStream.writeObject(responseObject);

            } catch (SocketException ex) {
                try {
                    socket.close();
                } catch (IOException ex1) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                ResponseObject responseObject = new ResponseObject();
                responseObject.setStatus(ResponseStatus.ERROR);
                responseObject.setErrorMessage(ex.getMessage());

                try {
                    objectOutputStream.writeObject(responseObject);
                } catch (IOException ex1) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private ResponseObject handleRequest(RequestObject requestObject) throws SQLException, Exception {
        try {
            Operation operation = requestObject.getOperation();
            Object data = null;
            String msg = null;
            switch (operation) {
                case OPERATION_LOGIN:
                    data = Controller.getInstance().prijaviRadnika((Radnik) requestObject.getData());
                    msg = "Uspesno ulogovan radnik";
                    break;

                case OPERATION_SVI_AUTORI:
                    data = Controller.getInstance().vratiSveAutore();
                    break;

                case OPERATION_SACUVAJ_RADNIKA:
                    data = Controller.getInstance().sacuvajRadnika((Radnik) requestObject.getData());
                    msg = "Uspesno sacuvan radnik";
                    break;

                case OPERATION_SACUVAJ_KNJIGU:
                    data = Controller.getInstance().sacuvajKnjigu((Knjiga) requestObject.getData());
                    break;
                case OPERATION_SACUVAJ_CLANA:
                    data = Controller.getInstance().sacuvajClana((Clan) requestObject.getData());
                    msg = "Uspesno sacuvan clan";
                    break;

                case OPERATION_PRETRAGA_KNJIGA:
                    data = Controller.getInstance().pronadjiPrimerke((String) requestObject.getData());
                    break;

                case OPERATION_SVI_CLANOVI:
                    data = Controller.getInstance().vratiSveClanove();
                    break;

                case OPERATION_SACUVAJ_ZADUZENJE:
                    data = Controller.getInstance().sacuvajZaduzenje((Zaduzenje) requestObject.getData());
                    msg = "Uspesno sacuvano zaduzenje";
                    break;

                case OPERATION_SVA_ZADUZENJA:
                    data = Controller.getInstance().vratiZaduzenja((int)requestObject.getData());
                    msg = "Uspesno nasao zaduzenje";
                    break;
                case OPERATION_VRATI_KNJIGU:
                    data = Controller.getInstance().vratiKnjigu((Zaduzenje) requestObject.getData());
                    msg = "Uspesno vratio zaduzenje";
                    break;
                case OPERATION_SVE_KNJIGE:
                    data = Controller.getInstance().vratiSveKnjige();
                    break;
                case BRISANJE_KNJIGE:
                    data=Controller.getInstance().brisanjeKnjige((Knjiga)requestObject.getData());
                    break;

            }
            return new ResponseObject(ResponseStatus.SUCCESS, data, msg);
        } catch (Exception ex) {
            ConnectionFactory.getInstance().getConnection().rollback();
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseObject(ResponseStatus.ERROR, null, ex.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
