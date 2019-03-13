# Sample - Test Automation Framework
### Introduction
> Sample GUI and Rest tests with Screenplay pattern

# Usage
## Execution
 - to execute selected tests fill desired tags in `SampleRunner.class` and run it.
 - to execute all desired tests concurrently, run maven command
```sh
clean:clean verify
```
 - In addition, a browser (chrome,firefox) can be specified by providing the following variable.
   By default, the project looks for it in sample.properties file which is set to chrome.
```sh
clean:clean verify -Dbrowser=firefox
```

## Reporting
 - Reports are stored in `target -> site -> serenity -> index.html`. For the report to be generated, the above-mentioned maven command has to be executed.
