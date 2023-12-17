import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class PokeLoader implements IPokeLoader {
    public List<IPokemon> loadPokemon(String filepathToXML) throws FileNotFoundException {
        if (new File(filepathToXML).isFile()) {
            File fileName = new File(filepathToXML);
            List<IPokemon> pokemons = new ArrayList<>();
            try {
                DocumentBuilderFactory dbfNewInstance = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = dbfNewInstance.newDocumentBuilder();
                Document data = docBuilder.parse(fileName);
                NodeList list = data.getElementsByTagName("dataitem");
                for (int index = 0; index < list.getLength(); index++) {
                    Node current = list.item(index);
                    if (current.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) current;
                        String name = element.getElementsByTagName("name").item(0).getTextContent().replaceAll("\\s+","");
                        String HP = element.getElementsByTagName("hp").item(0).getTextContent().replaceAll("\\s+","");
                        String type = element.getElementsByTagName("type1").item(0).getTextContent().replaceAll("\\s+","");
                        String ID = element.getElementsByTagName("pokedex_number").item(0).getTextContent().replaceAll("\\s+","");
                        Pokemon newPokemon = new Pokemon(name, HP, type, ID);
                        pokemons.add(newPokemon);
                    }

                }
                return pokemons;
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            throw new FileNotFoundException("XML file could not be located");
        }
        return null; // Added just to ensure no errors since other return is in a try block
    }
}