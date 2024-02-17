# Declarative Swing

This is an experimental wrapper around Swing that provides declarative GUI building. This library is inspired heavily by Flutter.

# Usage

## Simple

A barebones application would look like this:

```java
import fl.newswing.*;

class MyApp extends Application {
  
  public MyApp() {
    super(
        "Window Title",
        new Text("Hello, world!")
    );
  }

  public static void main(String[] args) {
    new MyApp().run();
  }
}
```

## Routing
Routes are created with the following syntax:

```java
new Router(
    "routeIndex",
    new Route("routeIndex", new Text("index"))
);
```

Navigation can be done by passing a `Navigation` object to the router:

```java
final var navigation = new Navigation();

new Router(
  "page1",
  
  naviagation, // <-- Router listens to navigation

  new Route(
    "page1",
    new Button(
      "Page 1 - Click here!",
      () -> navigation.goTo("page2")
    )
  ),

  new Route(
    "page2",
    new Text("Page 2")
  )
);
```

The above example will display a button at the `page1` route that when you click, goes to `page2` -- a page that says "Page 2".