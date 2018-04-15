package io.cong.chen.coffeescriptcompiler;

import org.junit.Test;

public class CoffeeScriptCompilerTest {
  @Test
  public void test() throws Exception {
    CoffeeScriptCompiler coffeeScriptCompiler = new CoffeeScriptCompiler();
    String coffeeScriptCode =
        "UPON \"sent\", ->\n" +
            "  DO \"forward\"\n" +
            "  return true\n";
    String javascriptCode =
        "UPON(\"sent\", function() {\n" +
        "  DO(\"forward\");\n" +
        "  return true;\n" +
        "});\n";
    assert(coffeeScriptCompiler.compile(coffeeScriptCode)
        .equals(javascriptCode));
  }
}
