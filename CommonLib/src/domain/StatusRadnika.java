package domain;


public enum StatusRadnika {
    aktivan(1),
    neaktivan(2);
    
     private final int id;
    
    private StatusRadnika(int id) {
        this.id = id;
    }
        
    public int getId(){
        return this.id;
    }

    public static StatusRadnika getById(int id) {
        for (StatusRadnika e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
