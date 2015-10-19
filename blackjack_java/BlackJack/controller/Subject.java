package BlackJack.controller;

/**
 * Created by johanrovala on 19/10/15.
 */
public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();
}
