package fl.newswing.widgets;

import fl.newswing.Widget;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextBox extends Widget {

  private final String text;

  public TextBox() {
    this("");
  }

  public TextBox(String text) {
    this.text = text;
  }

  @Override
  public void render(JComponent container) {
    container.add(new JTextField(this.text));
  }
}
