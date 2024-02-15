package fl.newswing;

public class Route {

  private final String route;
  private final Widget topLevelWidget;

  public Route(String route, Widget topLevelWidget) {
    this.route = route;
    this.topLevelWidget = topLevelWidget;
  }

  public String route() {
    return route;
  }

  public Widget topLevelWidget() {
    return topLevelWidget;
  }
}
