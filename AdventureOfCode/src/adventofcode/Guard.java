package adventofcode;

import java.util.ArrayList;

public class Guard {

    private ArrayList<Integer> duerme;
    private String idGuard;

    /**
     *
     */
    public Guard() {
    }

    /**
     * @return the duerme
     */
    public ArrayList<Integer> getDuerme() {
        return duerme;
    }

    /**
     * @param duerme the duerme to set
     */
    public void setDuerme(ArrayList<Integer> duerme) {
        this.duerme = duerme;
    }

    /**
     * @return the idGuard
     */
    public String getIdGuard() {
        return idGuard;
    }

    /**
     * @param idGuard the idGuard to set
     */
    public void setIdGuard(String idGuard) {
        this.idGuard = idGuard;
    }
}
