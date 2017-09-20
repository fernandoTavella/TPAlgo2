package anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)


public @interface BotonAnnotation
{
		String nombre() default "submit";
		float posHorizontal() default 0;
		float posVertical() default 0;
		int ancho() default 0;
		int largo() default 0;
}
