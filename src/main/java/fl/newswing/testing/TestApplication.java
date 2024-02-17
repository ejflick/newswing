package fl.newswing.testing;

import fl.newswing.Application;
import fl.newswing.Navigation;
import fl.newswing.NoopEventCallable;
import fl.newswing.widgets.routing.Router;
import fl.newswing.menu.Menu;
import fl.newswing.menu.MenuBar;
import fl.newswing.menu.MenuItem;

public class TestApplication extends Application {

  public TestApplication(Navigation navigation) {
    super(
        "Test App",
        new MenuBar(
            new Menu(
                "File",
                new MenuItem("Pop", navigation::pop),
                new MenuItem("Save", new NoopEventCallable())
            )
        ),
        new Router(
            "index",
            navigation,
            new HomeScreen(navigation),
            new OtherScreen()
        )
    );
  }

  public static void main(String[] args) {
    final var navigation = new Navigation();

    new TestApplication(navigation)
        .run();
  }

}
