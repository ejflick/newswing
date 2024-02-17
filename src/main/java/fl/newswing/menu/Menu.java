package fl.newswing.menu;

import java.util.Arrays;
import java.util.List;
import javax.swing.JMenu;

public class Menu {

  private final String label;
  private final List<MenuItem> menuItems;

  public Menu(String label, MenuItem ... menuItems) {
    this.label = label;
    this.menuItems = Arrays.asList(menuItems);
  }

  public JMenu buildJMenu() {
    final var menu = new JMenu(this.label);
    menuItems.stream()
        .map(MenuItem::toJMenuItem)
        .forEach(menu::add);
    return menu;
  }
}
