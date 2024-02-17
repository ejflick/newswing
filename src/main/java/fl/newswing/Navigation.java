package fl.newswing;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

  private final List<NavigationListenable> listenables = new ArrayList<>();

  public void listen(NavigationListenable subscriber) {
    this.listenables.add(subscriber);
  }

  public void pop() {
    this.listenables.forEach(NavigationListenable::pop);
  }

  public void push(String path) {
    this.listenables.forEach(listenable -> listenable.push(path));
  }

  public void pushReplacement(String path) {
    this.listenables.forEach(listenable -> listenable.pushReplacement(path));
  }

  public interface NavigationListenable {
    void pop();
    void push(String path);
    void pushReplacement(String path);
  }
}
