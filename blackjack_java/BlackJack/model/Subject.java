package BlackJack.model;

/**
 * Created by Ludde on 2015-10-20.
 */
public interface Subject {

    void register(Observer o);
    void notifyObserver();
}
