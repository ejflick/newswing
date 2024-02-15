# Declarative Swing

This is an experimental wrapper around Swing that provides declarative GUI building. This library is inspired heavily by Flutter.

# Usage

A barebones application would look like this:
```java
import fl.newswing.*;

class MyApp {
  public static void main(String [] args) {
    new App(
        "Window Title",
        new Router(
            "index",
            new Route(
                "index",
                new VBox(
                    new Text("Hello..."),
                    new Text("...world!")
                )
            )
        )
    ).run();
  }
}
```

Every _App_ contains a _Router_. Each _Router_ will contain multiple _Routes_ which are associated with a path that points to a _Widget_. In this example, both `VBox` and `Text` are _Widgets_.