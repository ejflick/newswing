package fl.newswing;

import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;

public class Router extends Widget {

  private final String indexPath;

  private final List<Route> routes;
  private JComponent container;
  private boolean firstTimeRendered = true;
  private Route current;

  /**
   * Routing mechanism for the application.
   *
   * @param indexPath The default route to navigate to when the application loads.
   * @param routes The routes in your application.
   */
  public Router(String indexPath, Route ... routes) {
    this.indexPath = indexPath;
    this.routes = Arrays.asList(routes);
  }

  /**
   * Routing mechanism for the application.
   *
   * @param indexPath The default route to navigate to when the application loads.
   * @param routes The routes in your application.
   */
  public Router(String indexPath, Navigation navigation, Route ... routes) {
    this.indexPath = indexPath;
    this.routes = Arrays.asList(routes);

    navigation.listen(this::setCurrent);
  }

  void goToIndex() {
    setCurrent(indexPath);
  }

  void setCurrent(String path) {
    Route rootRoute = routes.stream()
        .filter(route -> route.path().equals(path))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Can not route to path: " + indexPath));

    // The following call invalidates component hierarchy...hence the call to validate below.
    container.removeAll();
    rootRoute.render(this.container);
    container.repaint();
    container.validate();

    current = rootRoute;
  }

  @Override
  public void render(JComponent container) {
    if (!firstTimeRendered) {
      current.render(container);
      return;
    }

    firstTimeRendered = false;
    this.container = container;
    goToIndex();
  }

  @Override
  public void destroy() {
    routes.forEach(Route::destroy);
  }
}
