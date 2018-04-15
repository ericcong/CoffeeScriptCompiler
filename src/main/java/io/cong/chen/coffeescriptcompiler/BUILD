package(default_visibility = ["//visibility:public"])

java_library(
    name = "coffee_script_compiler",
    srcs = [
        "CoffeeScript.java",
        "CoffeeScriptCompiler.java"
    ],
    deps = [
        "@rhino//jar",
    ],
    resources = [
        "//src/main/resources:coffee_script_class",
    ],
)

java_binary(
    name = "coffee_script_compiler_bin",
    runtime_deps = [
        ":coffee_script_compiler",
    ],
)
