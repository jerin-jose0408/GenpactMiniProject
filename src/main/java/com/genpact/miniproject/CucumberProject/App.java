package com.genpact.miniproject.CucumberProject;

/**
 * Hello world!
 *
 */
import org.apache.logging.log4j.*;


public class App 
{
private static Logger log=LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        log.info("Hello world");
        log.error("Hello world");
        log.trace("Hello World");
        log.fatal("Hello world");
        log.debug("hello world");
    }
}
