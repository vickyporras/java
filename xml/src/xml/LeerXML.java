/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author vicky
 */
public class LeerXML {
    
    public static void main(String[] args){
        
        //Construimos el paser a traves del objrto builder
        //Parseamos el documento
        Document documento =null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            File fichXML = new File(System.getProperty("user.home")+ File.separator + "Desktop","alumno.xml");

            documento = dBuilder.parse(fichXML);
            
            
        } catch(ParserConfigurationException ex){
            System.err.println("Error en la creacion del DOM"+ ex);
        } catch (SAXException ex) {
            System.err.println("Error en el parseo"+ ex);
        } catch (IOException ex) {
            System.err.println("Error con el fichero"+ ex);
        }
        
        //Noormalizamos el documento
        documento.getDocumentElement().normalize();
        
        //creamos una lista de los nodos que cuelga de la raiz
        NodeList raiz = documento.getElementsByTagName("Alumno");
        
        //abrimos la etiquet raiz
        System.out.println("<"+documento.getDocumentElement().getNodeName()+">");
       
        //cogemos la lista de elementos dentro de la etiqueta raiz
        NodeList lista = raiz.item(0).getChildNodes();
        for(int i=0; i<lista.getLength();i++){
            //tomamos cada nodo de alumno
            Node d = lista.item(i);
            //ABRI,mos la etiqueta
            System.out.print("<"+d.getNodeName()+">");
            
            //comprobamos que el elemento que cogemos es una etiqueta para carle el texto
            if(d.getNodeType() == Node.ELEMENT_NODE){
                //MOStramos el texto de la etiqueta
                System.out.print(d.getFirstChild().getNodeValue());
            }
            
            
            //CERRAmos la etiqueta
            System.out.println("</"+d.getNodeName()+">");
        }
        
        
        
        
        //cerramos la etiqueta raiz
        System.out.println("</"+documento.getDocumentElement().getNodeName()+">");

        
    }
    
    
}
