package fl.newswing.widgets;

import fl.newswing.Widget;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Vbox extends Widget {

  public Vbox(Widget ... children) {
    this.children = List.of(children);
  }

  @Override
  public void render(JComponent container) {
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
