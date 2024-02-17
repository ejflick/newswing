package fl.newswing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Application {

  private final String title;
  private final Widget widget;

  public Application(String title, Widget widget) {
    // The following line reduces lag on Ubuntu.
    System.setProperty("sun.java2d.opengl", "True");

    this.title = title;
    this.widget = widget;
  }

  public void run() {
    SwingUtilities.invokeLater(() -> {
      final var frame = new JFrame(title);
      final var contentPane = new JPanel();
      frame.setSize(800, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);

      widget.render(contentPane);
      frame.setContentPane(contentPane);
      frame.setVisible(true);
    });
  }

}
