package fl.newswing.testing;

import fl.newswing.widgets.routing.Route;
import fl.newswing.widgets.Text;

public class OtherScreen extends Route {

  public static final String path = "otherScreen";

  public OtherScreen() {
    super(path, new Text("*sigh*"));
  }
}
