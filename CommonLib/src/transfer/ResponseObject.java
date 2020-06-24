
package transfer;

import java.io.Serializable;
import util.ResponseStatus;


public class ResponseObject implements Serializable {

    private static final long serialVersionUID = 1209201909480000l;
    private ResponseStatus status;
    private Object data;
    private String errorMessage;

    public ResponseObject() {
    }

    public ResponseObject(ResponseStatus status, Object data, String errorMessage) {
        this.status = status;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
