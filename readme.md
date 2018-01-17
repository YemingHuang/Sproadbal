## Sproadbal

Demo project of Spring boot 2 + JSP + Netflix Eureka to achieve federated cluster of web service components.

Sproadbal = Spring + load balance


### Caveats
If you run WebApplication from main class as it is, Intellij will look for `$ROOT/src/main/webapp` rather than `$MODULE_DIR/src/main/webapp`.

To overcome this weirdness, you will have to explicitly change the working directory in run configuration to `$MODULE_DIR$`

### Todo
<s>Setup example jsp feature</s>
* Selenium Test
* Some DB connection
* Login page
* Spring security
