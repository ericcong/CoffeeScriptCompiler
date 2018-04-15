package(default_visibility = ["//visibility:public"])

filegroup(
    name = "coffee_script_js",
    srcs = [
        "coffee-script.js",
    ],
)

genrule(
    name = "coffee_script_class",
    srcs = [
        ":coffee_script_js",
        "@rhino//jar",
    ],
    outs = ["io/cong/chen/coffeescriptcompiler/CoffeeScript.class"],
    cmd = "java -cp .:$(location @rhino//jar) " +
          "org.mozilla.javascript.tools.jsc.Main " +
          "-opt 9 -nosource -o CoffeeScript " +
          "-package io.cong.chen.coffeescriptcompiler " +
          "$(location :coffee_script_js); " +
          "mv src/main/resources/io/cong/chen/coffeescriptcompiler/CoffeeScript.class $@"
)
