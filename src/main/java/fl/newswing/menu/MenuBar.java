package fl.newswing.menu;

import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * Wrapper for {@link JMenuBar}.
 */
public class MenuBar {

  private final List<Menu> menus;

  public MenuBar(Menu ... menus) {
    this.menus = Arrays.asList(menus);
  }

  public void addToJFrame(JFrame jFrame) {
    final var menuBar = new JMenuBar();

    this.menus.stream()
        .map(Menu::buildJMenu)
        .forEach(menuBar::add);

    jFrame.setJMenuBar(menuBar);
  }

}
