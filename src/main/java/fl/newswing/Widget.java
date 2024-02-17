package fl.newswing;

import java.util.List;

public abstract class Widget implements Renderable {

  protected List<Widget> children;

  public Widget() {
    this.children = List.of();
  }

  @Override
  public void destroy() {
    this.children.forEach(Widget::destroy);
  }
}
