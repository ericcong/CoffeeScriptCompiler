# CoffeeScriptCompiler
CoffeeScriptCompiler for JVM.

## Build
This project uses Bazel for building.

To build:

`bazel build src/main/java/src/main/java/io/cong/chen/coffeescriptcompiler:coffee_script_compiler`

## Usage

```
String coffeeScriptCode = "someCoffeeScriptCode";
CoffeeScriptCompiler coffeeScriptCompiler = new CoffeeScriptCompiler();
String javaScriptCode = coffeeScriptCompiler.compile(coffeeScriptCode);
```
