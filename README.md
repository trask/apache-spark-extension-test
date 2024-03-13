
```
mvn package

export APPLICATIONINSIGHTS_CONNECTION_STRING=...
export APPLICATIONINSIGHTS_SELF_DIAGNOSTICS_LEVEL=TRACE

java -javaagent:applicationinsights-agent-3.5.1.jar -Dotel.javaagent.extensions=opentelemetry-spark-0.11.0-SNAPSHOT.jar -Dotel.instrumentation.apache-spark.enabled=true -Dotel.javaagent.debug=true -jar target/apache-spark-example-1.0-SNAPSHOT.jar
```

and look in the logs for something like

```
before
2024-03-13 13:47:56.659-07:00 DEBUG i.o.j.e.i.InstrumentationModule - Applying instrumentation: apache-spark [class io.opentelemetry.javaagent.instrumentation.spark.ApacheSparkInstrumentationModule] on jdk.internal.loader.ClassLoaders$AppClassLoader@511d50c0
2024-03-13 13:47:56.659-07:00 DEBUG i.o.javaagent.tooling.HelperInjector - Injecting classes onto class loader jdk.internal.loader.ClassLoaders$AppClassLoader@511d50c0 -> [io.opentelemetry.javaagent.instrumentation.spark.SparkEventListener, io.opentelemetry.javaagent.instrumentation.spark.ApacheSparkSingletons, io.opentelemetry.javaagent.instrumentation.spark.SparkEventLogger, io.opentelemetry.javaagent.instrumentation.spark.JsonProtocol, io.opentelemetry.javaagent.instrumentation.spark.EventTimeAccessor, io.opentelemetry.javaagent.instrumentation.spark.ApacheSparkSingletons$1, io.opentelemetry.javaagent.instrumentation.spark.PropertiesTextMapAccessor]
2024-03-13 13:47:56.663-07:00 DEBUG i.o.j.t.AgentInstaller$TransformLoggingListener - Transformed org.apache.spark.scheduler.LiveListenerBus -- jdk.internal.loader.ClassLoaders$AppClassLoader@511d50c0
after
```
