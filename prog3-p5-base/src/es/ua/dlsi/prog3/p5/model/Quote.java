package es.ua.dlsi.prog3.p5.model;

import java.util.List;

import es.ua.dlsi.prog3.p5.export.IExporter;

public class Quote extends Paragraph implements IBlock{
	
	public Quote(List<IParagraphContent> paragraphContentList) {
		super(paragraphContentList);
	}
  
	public Quote(IParagraphContent paragraphContents) {
		super(paragraphContents);
	}
	
	public String export(IExporter exporter) {
        return exporter.export(this);
    }
}
