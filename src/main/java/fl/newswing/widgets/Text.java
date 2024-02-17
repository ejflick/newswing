package fl.newswing.widgets;

import static java.awt.Font.PLAIN;

import fl.newswing.Widget;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Text extends Widget {

  private final String text;

  public Text(String text) {
    this.text = text;
  }

  @Override
  public void render(JComponent container) {
    final var label = new JLabel(this.text);
    final var font = label.getFont();

    label.setFont(new Font(font.getName(), PLAIN, 24));

    container.add(
        new JLabel(
            this.text
        )
    );
  }

  @Override
  public void destroy() {

  }
}
