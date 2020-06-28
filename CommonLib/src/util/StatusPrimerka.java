package util;

public enum StatusPrimerka {
    slobodna(1),
    izdata(2);

    private final int id;

    private StatusPrimerka(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static StatusPrimerka getById(int id) {
        for (StatusPrimerka e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

}
