package io.cong.chen.coffeescriptcompiler;

import org.mozilla.javascript.*;

public class CoffeeScriptCompiler {
  public String compile(String coffeeScriptCode) {
    Context context = Context.enter();
    try {
      Scriptable scope  = context.initStandardObjects();

      Script script = (Script) new CoffeeScript();
      script.exec(context, scope);

      NativeObject coffeeScriptNativeObject =
          (NativeObject) scope.get("CoffeeScript", scope);

      Function compileFunction =
          (Function) coffeeScriptNativeObject.get("compile", scope);

      return (String) compileFunction.call(
          context, scope, coffeeScriptNativeObject, new Object[] {
              coffeeScriptCode,
              context.evaluateString(scope, "({bare: true})", null, 1, null)});

    } catch (JavaScriptException e) {

      Scriptable location = (Scriptable) ScriptableObject.getProperty(
          (Scriptable) e.getValue(), "location");

      throw new IllegalArgumentException("CoffeeScript syntax error " +
          ((Double) ScriptableObject.getProperty(location, "first_line"))
              .intValue() + ":" +
          ((Double) ScriptableObject.getProperty(location, "first_column"))
              .intValue());

    } finally {
      Context.exit();
    }
  }
}
