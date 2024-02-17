package fl.newswing.widgets.routing;

import fl.newswing.Renderable;
import fl.newswing.Widget;
import javax.swing.JComponent;

public class Route extends Widget {

  private final String path;
  private final Widget topLevelWidget;

  public Route(String path, Widget topLevelWidget) {
    this.path = path;
    this.topLevelWidget = topLevelWidget;
  }

  public String path() {
    return path;
  }

  @Override
  public void render(JComponent container) {
    topLevelWidget.render(container);
  }

  @Override
  public void destroy() {
    this.children.forEach(Renderable::destroy);
  }
}
