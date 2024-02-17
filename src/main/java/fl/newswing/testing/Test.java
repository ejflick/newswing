package fl.newswing.testing;

import fl.newswing.Application;
import fl.newswing.Navigation;
import fl.newswing.Router;

public class Test extends Application {

  public Test(Navigation navigation) {
    super(
        "Test App",
        new Router(
            "index",
            navigation,
            new Index(navigation),
            new OtherScreen()
        )
    );
  }

  public static void main(String[] args) {
    final var navigation = new Navigation();

    new Test(navigation)
        .run();
  }

}
