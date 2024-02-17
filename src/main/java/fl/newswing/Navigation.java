package fl.newswing;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

  private final List<NavigationListenable> listenables = new ArrayList<>();

  public void listen(NavigationListenable subscriber) {
    this.listenables.add(subscriber);
  }

  public void goTo(String path) {
    this.listenables.forEach(listenable -> listenable.navigation(path));
  }

  @FunctionalInterface
  public interface NavigationListenable {
    void navigation(String path);
  }
}
