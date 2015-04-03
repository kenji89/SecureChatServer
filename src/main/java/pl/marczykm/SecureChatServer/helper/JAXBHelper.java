package pl.marczykm.SecureChatServer.helper;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBHelper {
	public static <E> String generateString(E object) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(object.getClass());
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    
	    StringWriter sw = new StringWriter();
	    m.marshal(object, sw);
	    
	    return sw.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static <E> E generateObject(String xmlContent, E clazz) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(clazz.getClass());
		Unmarshaller um = context.createUnmarshaller();
		StringReader sr = new StringReader(xmlContent);
	    return (E)um.unmarshal(sr);
	}
}
