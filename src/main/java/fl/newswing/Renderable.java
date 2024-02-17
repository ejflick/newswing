package fl.newswing;

import javax.swing.JComponent;

public interface Renderable {

  void render(JComponent container);

  void destroy();

}
