package anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface Siguiente {
		String nombre() default "Siguiente";
		String next() default "";
		String validate() default "";
		String label() default "continuar";
}
