# Logging #
----------
## Setting that were put to make log4j work in eclipse ##

#### Pom dependency is like this ####

    <l4j.version>1.2.17</l4j.version>
    
    <dependency>
    	<groupId>log4j</groupId>
    	<artifactId>log4j</artifactId>
    	<version>${l4j.version}</version>
    </dependency>

If you are not aware of how to create a maven project, read [this.](#)

#### JVM arguments required ####

    -Dlog4j.configuration=log4j.properties

How to [add](#) JVM arguments in the JDK defined in eclipse.

How to [add](#) JVM arguments before running the application using eclipse

#### Logging properties ####

Please read [this](#) where and how to add log4j.properties in eclipse.

    log4j.rootLogger=ALL, Console
     
    log4j.logger.play=INFO
    
    log4j.logger.jobs.monitor=INFO,JVM
    log4j.additivity.jobs.monitor=false
    
    log4j.logger.utils.http=INFO,HTTP
    log4j.additivity.utils.http=false
     
    # Console
    log4j.appender.Console=org.apache.log4j.ConsoleAppender
    log4j.appender.Console.layout=org.apache.log4j.PatternLayout
    log4j.appender.Console.layout.ConversionPattern=%d{yyyyMMdd,hh.mm.ss} [%-5p] - (%l) %m%n
    
    # Rolling files
    log4j.appender.Rolling=org.apache.log4j.RollingFileAppender
    log4j.appender.Rolling.File=log/application.log
    log4j.appender.Rolling.MaxFileSize=100MB
    log4j.appender.Rolling.MaxBackupIndex=25
    log4j.appender.Rolling.layout=org.apache.log4j.PatternLayout
    log4j.appender.Rolling.layout.ConversionPattern=%d{yyyy.MM.dd.HH.mm.ss.SSSZ} {%t} [%-5p]: %m%n
    
    # JVM logs
    log4j.appender.JVM=org.apache.log4j.RollingFileAppender
    log4j.appender.JVM.File=log/jvm.log
    log4j.appender.JVM.MaxFileSize=100MB
    log4j.appender.JVM.MaxBackupIndex=10
    log4j.appender.JVM.layout=org.apache.log4j.PatternLayout
    log4j.appender.JVM.layout.ConversionPattern=%d{yyyy.MM.dd.HH.mm.ss.SSSZ} [%-5p]: %m%n
    
    # HTTP logs
    log4j.appender.HTTP=org.apache.log4j.RollingFileAppender
    log4j.appender.HTTP.File=log/http.log
    log4j.appender.HTTP.MaxFileSize=100MB
    log4j.appender.HTTP.MaxBackupIndex=10
    log4j.appender.HTTP.layout=org.apache.log4j.PatternLayout
    log4j.appender.HTTP.layout.ConversionPattern=%d{yyyy.MM.dd.HH.mm.ss.SSSZ} {%t} [%-5p]: %m%n

[Log4j.properties explanation]()

