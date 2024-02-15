package fl.newswing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

  private final String title;
  private final Router router;

  public App(String title, Router router) {
    System.setProperty("sun.java2d.opengl", "True");
    this.title = title;
    this.router = router;
  }

  public void run() {
    SwingUtilities.invokeLater(() -> {
      final var frame = new JFrame(title);

      frame.setSize(800, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      router.goToIndex(frame);
    });
  }

}
