package es.ua.dlsi.prog3.p5.client;

import es.ua.dlsi.prog3.p5.export.html.HTMLExporter;
import es.ua.dlsi.prog3.p5.export.markdown.MarkdownExporter;
import es.ua.dlsi.prog3.p5.model.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This test evaluates the correct creation of an object hierarchy to represent a document
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 31/10/22
 */
public class ExampleDocumentCreatorTest {
    private Document document;

    private void compareResults(String fileWithExpectedContent, String result) {
        try {
            URL url = this.getClass().getResource(fileWithExpectedContent);
            if (url == null) {
                throw new RuntimeException("Cannot find file '" + fileWithExpectedContent + "'");
            }
            java.nio.file.Path path = java.nio.file.Paths.get(url.toURI());
            List<String> lines = Files.readAllLines(path);
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : lines) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            String fileContent = stringBuilder.toString().trim(); // trim to remove trailing spaces
            assertEquals(fileContent, result.trim());
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("This should not fail", e);
        }
    }

    @Before
    public void setup() {
        ExampleDocumentCreator exampleDocumentCreator = new ExampleDocumentCreator();
        document = exampleDocumentCreator.createExample();
    }

    @Test
    public void testHTML() {
        String html = document.export(new HTMLExporter());
        compareResults("example_document.html", html);
    }

    @Test
    public void testMarkdown() {
        String md = document.export(new MarkdownExporter());
        compareResults("example_document.md", md);
    }
}
