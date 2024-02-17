package fl.newswing.menu;

import fl.newswing.EventCallable;
import javax.swing.JMenuItem;

public class MenuItem {

  private final String label;
  private final EventCallable eventcallable;

  public MenuItem(String label, EventCallable eventCallable) {
    this.label = label;
    this.eventcallable = eventCallable;
  }

  public JMenuItem toJMenuItem() {
    final var jMenuItem = new JMenuItem(this.label);

    jMenuItem.addActionListener((actionEvent) -> eventcallable.onEvent());

    return jMenuItem;
  }

}
