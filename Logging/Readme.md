# How to run Logging Module?
1. `mvn clean install`
2. Check the `pom.xml` `exec-maven-plugin` - this plugin is used to run executable jar using mvn.
3. Note: you can pass cmd args using `exec-maven-plugin`
4. To run appln: `mvn exec:java`
5. To view console logs goto "Run" tab in intellij and expand the application dropdown.