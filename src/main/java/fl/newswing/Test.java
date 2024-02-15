package fl.newswing;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Test {

  public static void main(String[] args) {
    new App(
        "Test App",
        new Router(
            "index",
            new Route(
                "index",
                new Vbox(
                    new Text("Hello!"),
                    new Text("How's it going?"),
                    new Button(
                        "Click me",
                        event -> {
                          final var dialog = new JDialog();
                          dialog.add(new JLabel("Hello"));
                          dialog.pack();
                          dialog.setVisible(true);
                          dialog.setLocationRelativeTo(null);
                        }
                    )
                )
            )
        )
    ).run();
  }

}
