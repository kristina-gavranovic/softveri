package transfer;

import java.io.Serializable;
import util.Operation;

public class RequestObject implements Serializable {

    private Operation operation;
    private Object data;

    public RequestObject() {
    }

    public RequestObject(Operation operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
