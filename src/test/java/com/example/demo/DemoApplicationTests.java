package com.example.demo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

public class DemoApplicationTests {

    TemplateEngine templateEngine = createTemplateEngine();
    WebContext context = new WebContext(new MockHttpServletRequest(), new MockHttpServletResponse(), new MockServletContext());

    @Test
    public void testDefaultTemplateResolver04() throws IOException {
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.ERROR);

        context.setVariable("message", "hello testing");

        String output = templateEngine.process("templates/welcome.html", context);
        assertTrue(output.contains("hello testing"));
    }

    @Test
    public void testDefaultTemplateResolver042() throws IOException {
        context.setVariable("message", "hello testing2");

        String output = templateEngine.process("templates/welcome.html", context);
        assertTrue(output.contains("hello testing2"));
    }

    @Test
    public void testDefaultTemplateResolver0423() throws IOException {
        context.setVariable("message", "hello testing23");

        String output = templateEngine.process("templates/welcome.html", context);
        assertTrue(output.contains("hello testing23"));
    }

    private TemplateEngine createTemplateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(new ClassLoaderTemplateResolver());
        return templateEngine;
    }

}
