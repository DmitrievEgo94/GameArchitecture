import java.awt.*;

public interface Movable {

    /*
        returns time, that unitGroup spent to change location
     */
    long changePosition(Point newPosition);
}
