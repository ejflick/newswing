package fl.newswing;

import fl.newswing.menu.MenuBar;
import fl.newswing.menu.NoMenuBar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Application {

  private final String title;
  private final Widget widget;
  private MenuBar menuBar;

  public Application(String title, Widget widget) {
    // The following line reduces lag on Ubuntu.
    System.setProperty("sun.java2d.opengl", "True");

    this.title = title;
    this.widget = widget;
    this.menuBar = new NoMenuBar();
  }

  public Application(String title, MenuBar menuBar, Widget widget) {
    this(title, widget);
    this.menuBar = menuBar;
  }

  public void run() {
    SwingUtilities.invokeLater(() -> {
      final var frame = new JFrame(title);
      final var contentPane = new JPanel();
      frame.setSize(800, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationByPlatform(true);

      menuBar.addToJFrame(frame);
      widget.render(contentPane);
      frame.setContentPane(contentPane);
      frame.setVisible(true);
    });
  }

}
