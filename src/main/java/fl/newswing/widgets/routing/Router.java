package fl.newswing.widgets.routing;

import fl.newswing.Navigation;
import fl.newswing.Navigation.NavigationListenable;
import fl.newswing.Widget;
import fl.newswing.widgets.Text;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import javax.swing.JComponent;

public class Router extends Widget implements NavigationListenable {

  private final Stack<Widget> screenStack = new Stack<>();
  private final String indexPath;
  private final List<Route> routes;

  private JComponent container;
  private boolean firstTimeRendered = true;

  /**
   * Routing mechanism for the application.
   *
   * @param indexPath The default route to navigate to when the application loads.
   * @param routes The routes in your application.
   */
  public Router(String indexPath, Route ... routes) {
    this.indexPath = indexPath;
    this.routes = Arrays.asList(routes);

    screenStack.push(new BlankRoute());
  }

  /**
   * Routing mechanism for the application.
   *
   * @param indexPath The default route to navigate to when the application loads.
   * @param routes The routes in your application.
   */
  public Router(String indexPath, Navigation navigation, Route ... routes) {
    this(indexPath, routes);
    navigation.listen(this);
  }

  void goToIndex() {
    pushReplacement(indexPath);
  }

  private Route matchRouteToPath(String path) {
    return routes.stream()
        .filter(route -> route.path().equals(path))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Can not route to path: " + indexPath));
  }

  @Override
  public void pop() {
    if (screenStack.empty()) {
      return;
    }

    screenStack.pop();

    container.removeAll();
    screenStack.peek().render(this.container);
    container.repaint();
    container.validate();
  }

  @Override
  public void push(String path) {
    final var replacementRoute = matchRouteToPath(path);

    container.removeAll();
    screenStack.push(replacementRoute);
    replacementRoute.render(this.container);
    container.repaint();
    container.validate();
  }

  @Override
  public void pushReplacement(String path) {
    final var replacementRoute = matchRouteToPath(path);

    // The following call invalidates component hierarchy...hence the call to validate below.
    container.removeAll();
    screenStack.pop();
    replacementRoute.render(this.container);
    screenStack.push(replacementRoute);
    container.repaint();
    container.validate();
  }

  @Override
  public void render(JComponent container) {
    if (!firstTimeRendered) {
      screenStack.peek().render(container);
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

  private static class BlankRoute extends Route {
    public BlankRoute() {
      super("", new Text(""));
    }
  }
}
