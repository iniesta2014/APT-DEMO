package come.example.qiaowenhao.testcompiler;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.util.Set;

//告诉编译器该注解处理器的存在,并在编译时自动在META-INF/services下生成javax.annotation.processing.Processor文件
@AutoService(Process.class)
//指定编译的java版本
@SupportedSourceVersion(SourceVersion.RELEASE_7)
//指定处理的注解
@SupportedAnnotationTypes({"come.example.qiaowenhao.annotationlib.Test"})
public class TestProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        //创建方法
        MethodSpec methodSpec = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello world")
                .build();
        //创建类
        TypeSpec typeSpec = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(methodSpec)
                .build();
        //创建java文件
        JavaFile file = JavaFile.builder("come.example.qiaowenhao", typeSpec)
                .build();
        try {
            file.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            //
        }
        return true;
    }
}
