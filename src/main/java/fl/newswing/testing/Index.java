package fl.newswing.testing;

import fl.newswing.Button;
import fl.newswing.Navigation;
import fl.newswing.Route;
import fl.newswing.Text;
import fl.newswing.Vbox;

public class Index extends Route {
  public Index(Navigation navigation) {
    super(
        "index",
        new Vbox(
            new Text("Hello!"),
            new Text("How's it going?"),
            new Button(
                "Click me",
                () -> navigation.goTo(OtherScreen.path)
            )
        )
    );
  }
}
