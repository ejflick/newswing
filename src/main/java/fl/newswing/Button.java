package fl.newswing;

import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class Button implements Widget {

  private final String buttonText;
  private final ActionListener actionListener;

  public Button(String buttonText) {
    this.buttonText = buttonText;
    this.actionListener = new NoopActionListener();
  }

  public Button(String buttonText, ActionListener actionListener) {
    this.buttonText = buttonText;
    this.actionListener = actionListener;
  }

  @Override
  public void render(Container container) {
    final var button = new JButton(this.buttonText);
    button.addActionListener(this.actionListener);

    container.add(button);
  }

  @Override
  public void destroy() {

  }
}
