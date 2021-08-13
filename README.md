# Java instrumentation
Dependencies https://github.com/brutusin/instrumentation

Change dir

`cd src/main/java/testinstrumentation`

Compile classes

`javac -cp "<local-path-to-javaassist>;<local-path-to>/src/main/java/" *.java`

To create jar

`jar cvfm agent.jar MANIFEST.mf .`

Run agent

`java -cp <local-path-to>/src/main/java -javaagent:agent.jar testinstrumentation/SimpleMain`
