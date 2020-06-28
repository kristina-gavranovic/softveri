
package util;

//TODO obrisi metode koje ne koristis nigde

import domain.Radnik;
import domain.StatusRadnika;

public abstract class AbstractValidation {
    protected static void notEmpty(String msg, String txt) throws Exception{
        if(txt.isEmpty())
            throw new Exception(msg);
    }
    
    protected static void notNull(String msg, Object obj) throws Exception{
        if(obj == null)
            throw new Exception(msg);
    }
    
    protected static void notEquals(String msg, String expected, String actual) throws Exception {
        if(!expected.equals(actual))
            throw new Exception(msg);
    }
    protected static void isActive(String msg,Object obj) throws Exception{
        if(((Radnik)obj).getStatus()==StatusRadnika.neaktivan)
            throw new Exception(msg);
    
    }
}
