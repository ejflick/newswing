package fl.newswing.testing;

import fl.newswing.widgets.Button;
import fl.newswing.Navigation;
import fl.newswing.widgets.TextBox;
import fl.newswing.widgets.routing.Route;
import fl.newswing.widgets.Text;
import fl.newswing.widgets.Vbox;

public class HomeScreen extends Route {
  public HomeScreen(Navigation navigation) {
    super(
        "index",
        new Vbox(
            new Text("Hello!"),
            new Text("How's it going?"),
            new Button(
                "Click me",
                () -> navigation.push(OtherScreen.path)
            ),
            new TextBox("this is a textbox")
        )
    );
  }
}
