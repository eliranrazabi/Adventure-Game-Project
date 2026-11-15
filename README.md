# Java & OOP Adventure — Student Starter

Theme: Robot Areana.

```bash
java -version
mvn test
mvn exec:java -Dexec.mainClass=edu.starter.Game
```

If the Maven exec plugin is unavailable, compile the starter directly:

```bash
mkdir -p build
javac -d build src/main/java/edu/starter/*.java
java -cp build edu.starter.Game
```

