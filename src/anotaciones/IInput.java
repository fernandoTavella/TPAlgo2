package anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IInput // extends Annotation
{
	String label() default "";
}
