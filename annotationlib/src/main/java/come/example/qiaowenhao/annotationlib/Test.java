package come.example.qiaowenhao.annotationlib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解作用在类上,且是编译时注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Test {
    String path();
}
