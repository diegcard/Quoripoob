package Quoripoob.src.domain;

/**
 * This class is an abstract class that represents a box in the board
 *
 * @author Diego Cardenas
 * @author Sebastian Cardona
 * @version 1.0
 */
public abstract class Box {

    private boolean isOcupate;
    public Box() {

    }

    public void setOcupate(boolean isOcupate){
        this.isOcupate = isOcupate;
    }

    public boolean getOcupate(){
        return isOcupate;
    }


}
