# CoffeeScriptCompiler
CoffeeScript Compiler for JVM.

This project pre-compiled the official CoffeeScript compiler written in JavaScript into a class called `CoffeeScriptCompiler`,
so developers can directly use it to efficiently compile CoffeeScript codes to JavaScript in their JVM code.

# Usage
First download the jar, and include it in classpath.

Then in your Java code, do something like this:

```
import io.cong.chen.coffeescriptcompiler.CoffeeScriptCompiler;

...
String coffeeScriptCode = "some_offee_script_code";
CoffeeScriptCompiler coffeeScriptCompiler = new CoffeeScriptCompiler();
String javaScriptCode = coffeeScriptCompiler(coffeeScriptCode);
...
```

# Build
This project uses Bazel for building, to build it, do this in the project root:

`bazel build src/main/java/io/cong/chen/coffeescriptcompiler:coffee_script_compiler_bin_deploy.jar`

then

`cp bazel-bin/src/main/java/io/cong/chen/coffeescriptcompiler/coffee_script_compiler_bin_deploy.jar coffee-script-compiler.jar`.
