package fl.newswing;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Vbox implements Widget {

  private final Widget[] children;

  public Vbox(Widget ... children) {
    this.children = children;
  }

  @Override
  public void render(Container container) {
    final var vBox = new JPanel();
    vBox.setLayout(new BoxLayout(vBox, BoxLayout.PAGE_AXIS));

    for (Widget child : children) {
      child.render(vBox);
    }

    container.add(vBox);
  }

  @Override
  public void destroy() {

  }
}
