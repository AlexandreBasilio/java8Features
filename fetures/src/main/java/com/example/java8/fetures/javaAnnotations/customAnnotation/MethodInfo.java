package com.example.java8.fetures.javaAnnotations.customAnnotation;

import java.lang.annotation.*;

/*
Annotation rules:
    1) Annotation methods can’t have parameters.
    2) Annotation methods return types are limited to primitives, String, Enums, Annotation or array of these.
    3) Java Annotation methods can have default values.
    4) Annotations can have meta annotations attached to them. Meta annotations are used to provide information about the annotation.

    Target annotation
    If Target meta-annotation is not present, then annotation can be used on any program element.

    Inherited annotation
    If user queries the annotation type on a class declaration, and the class declaration has no annotation for this type,
     then the class’s superclass will automatically be queried for the annotation type.
     This process will be repeated until an annotation for this type is found, or the top of the class hierarchy (Object) is reached.

    Documented
    If a type declaration is annotated with Documented, its annotations become part of the public API of the annotated elements.
 */

@Documented                  //  indicates that elements using this annotation should be documented by javadoc and similar tools.
@Target(ElementType.METHOD)  //  indicates the kinds of program element to which an annotation type is applicable
@Inherited                   //  indicates that an annotation type is automatically inherited
@Retention(RetentionPolicy.RUNTIME)  //  indicates how long annotations with the annotated type are to be retained.
public @interface MethodInfo {

    String author() default "Alexandre";
    String date();
    int revision() default 1;
    String comments();

}
