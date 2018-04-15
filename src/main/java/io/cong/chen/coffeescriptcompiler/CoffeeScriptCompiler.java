package io.cong.chen.coffeescriptcompiler;

import org.mozilla.javascript.*;

public class CoffeeScriptCompiler {
  public String compile(String coffeeScriptCode) {
    Context ctx = Context.enter();
    try {
      Scriptable scope  = ctx.initStandardObjects();
      Script script = (Script) new CoffeeScript();
      script.exec(ctx, scope);
      NativeObject obj = (NativeObject) scope.get("CoffeeScript", scope);
      Function fun = (Function) obj.get("compile", scope);
      Object opts = ctx.evaluateString(scope, "({bare: true})", null, 1, null);
      return (String) fun.call(
          ctx, scope, obj, new Object[] {coffeeScriptCode, opts});
    } catch (JavaScriptException e) {
      Scriptable location = (Scriptable) ScriptableObject.getProperty(
          (Scriptable) e.getValue(), "location");
      throw new IllegalArgumentException("CoffeeScript syntax error " +
          ScriptableObject.getProperty(location, "first_line").toString() +
          ScriptableObject.getProperty(location, "first_column").toString());
    } finally {
      Context.exit();
    }
  }
}
