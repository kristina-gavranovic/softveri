/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import util.Operation;

public class RequestObject implements Serializable {

    //private static final long serialVersionUID = 1209201909470000l;
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
