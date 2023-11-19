package xml;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public class EscribirXML {
    public static void main(String[] args) throws TransformerException {
        
        //Construimos el paser a traves del objrto builder
        DOMImplementation implementacion =null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            implementacion = dBuilder.getDOMImplementation();
        
        } catch(ParserConfigurationException ex){
            System.err.println("Error en la creacion del DOM"+ ex);
        }
        
        // Creamos la representacion del documento XML
        Document documento = implementacion.createDocument(null,"Alumno",null);
        documento.setXmlVersion("1.0");
        //<alumnos></alumnos>
        
        //Creo nodo
        // Creo etiqueta
        Element etiqueta = documento.createElement("Nombre");
        //creO texto de la etiqueta
        Text texto = documento.createTextNode("Victroia Porras Ortiz");
        //añadimos la etiqueta
        documento.getDocumentElement().appendChild(etiqueta);
        //añadimos al texto
        etiqueta.appendChild(texto);
        
        //Tranformar de documento xml a archivo xml
        //fuente
        Source fuente = new DOMSource(documento);
        //destino
        File fichXML = new File(System.getProperty("user.home")+ File.separator + "Desktop","alumno.xml");
        Result destino = new StreamResult(fichXML);
        //transformador
        Transformer transformer;
        
        try {
           transformer = TransformerFactory.newInstance().newTransformer(); //creamos un transformer
           transformer.transform(fuente, destino);
        } catch (TransformerException ex) {
            System.err.println("Error en la tRANSFORMACION "+ ex);
        }
   
          
        
    }
}
