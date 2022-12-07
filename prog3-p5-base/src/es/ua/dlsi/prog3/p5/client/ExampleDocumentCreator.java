package es.ua.dlsi.prog3.p5.client;

import java.util.ArrayList;
import java.util.List;

import es.ua.dlsi.prog3.p5.model.*;

/**
 * This class is used for the evaluation of the assignment
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 31/10/22
 */
public class ExampleDocumentCreator  {
    /**
     * --- IMPLEMENT this method ---
     * 
     * @return Document object
     * @throws EditorException 
     */
    public Document createExample() {
        Document document = new Document();
    	
        try {
			document.add(new Heading("Heading",1));
		} catch (EditorException e1) {
			throw new RuntimeException();
		}
        document.add(new Paragraph(new Text("Some text to introduce the article")));
        
        List<IParagraphContent> comp = new ArrayList<IParagraphContent>();
        comp.add(new Text("Something someone said:"));
        
        LinkParagraphContentDecorator link = new LinkParagraphContentDecorator(new Text("original cite site"),"https://www.somesite.edu");
        comp.add(link);
        
        document.add(new Quote(comp));
        try {
			document.add(new Heading("First section", 2));
		} catch (EditorException e1) {
			throw new RuntimeException();
		}
        
        document.add(new Paragraph(new Text("Example of text decorators:")));
        
        List<IBlock> comp1 = new ArrayList<IBlock>();
        comp1.add(new Text("Raw text"));
        comp1.add(new ItalicsTextDecorator(new Text("Italics")));
        comp1.add(new BoldTextDecorator(new Text("Bold")));
        comp1.add(new StrikeThroughDecorator(new Text("Strike through")));
        comp1.add(new ItalicsTextDecorator(new BoldTextDecorator(new StrikeThroughDecorator(new Text("The three above")))));
        comp1.add(new Paragraph(new Text("Raw text inside a paragraph")));
        
        
        document.add(new OrderedListBlock(comp1));
        try {
			document.add(new Heading("Code block",3));
		} catch (EditorException e) {
			throw new RuntimeException();
		}
        document.add(new CodeBlock("class PROG3 {}","java"));
        document.add(new HorizontalRule());
        document.add(new Paragraph(new Image("https://web.ua.es/secciones-ua/images/layout/logo-ua.jpg","UA logo")));
        
        return document;
    }
}
