package fl.newswing;

import java.awt.Container;
import java.util.Arrays;

public class Router {

  private final String index;

  private final Route[] routes;

  /**
   * Routing mechanism for the application.
   *
   * @param index The default route to navigate to when the application loads.
   * @param routes The routes in your application.
   */
  public Router(String index, Route ... routes) {
    this.index = index;
    this.routes = routes;
  }

  /**
   * Get a {@link Navigator} to navigate to different routes in the application.
   */
  public Navigator navigator() {
    return new Navigator();
  }

  void goToIndex(Container container) {
    indexComponent(container);
  }

  private void indexComponent(Container container) {
    Arrays.asList(routes)
        .stream()
        .filter(route -> route.route().equals(index))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Can not route to index: " + index))
        .topLevelWidget()
        .render(container);
  }

  void setCurrent(String path) {

  }

  public class Navigator {
    private Navigator() {

    }

    void goTo(String path) {
      setCurrent(path);
    }
  }

}
