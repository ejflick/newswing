package fl.newswing.widgets;

import fl.newswing.EventCallable;
import fl.newswing.NoopEventCallable;
import fl.newswing.Widget;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Button extends Widget {

  private final String buttonText;
  private final EventCallable actionCallable;

  public Button(String buttonText) {
    this.buttonText = buttonText;
    this.actionCallable = new NoopEventCallable();
  }

  public Button(String buttonText, EventCallable actionCallable) {
    this.buttonText = buttonText;
    this.actionCallable = actionCallable;
  }

  @Override
  public void render(JComponent container) {
    final var button = new JButton(this.buttonText);
    button.addActionListener((actionEvent) -> actionCallable.onEvent());

    container.add(button);
  }

  @Override
  public void destroy() {

  }
}
