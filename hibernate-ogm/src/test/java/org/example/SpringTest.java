package org.example;

import org.example.app.Context;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by roby on 22/02/17.
 */
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Context.class);
        annotationConfigApplicationContext.start();
        System.out.println(annotationConfigApplicationContext.toString());
    }
}
