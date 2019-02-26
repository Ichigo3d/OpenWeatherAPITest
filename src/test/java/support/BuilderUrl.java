package support;
// this class build URL from parameters, getting from Constants class
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class BuilderUrl {

    String baseURL = XMLReader("baseUrl");
    String paramToken = XMLReader("paramToken");
    String token = XMLReader("token");
    String paramAnd = XMLReader("paramAnd");
    String q = XMLReader("q");
    String comma = XMLReader("comma");
    String paramCity = XMLReader("paramCity");
    String paramCountryCode = XMLReader("paramCountryCode");

    String fullURL = uRLBuilder(baseURL, paramToken, token, paramAnd, q, comma, paramCity, paramCountryCode);


    public static String uRLBuilder(String baseURL, String paramToken, String token, String paramAnd, String q, String comma, String paramCity, String paramCountryCode){


        String result;

        StringBuilder str = new StringBuilder(baseURL);

        result = String.valueOf(str.append(paramToken)
                .append(token)
                .append(paramAnd)
                .append(q)
                .append(paramCity)
                .append(comma)
                .append(paramCountryCode));

        return result;
    }


    public static String XMLReader(String tag){
        String resultString = "";
        try {
            File inputFile = new File("/Users/matveii/IdeaProjects/comredditAPItest/src/test/java/support/Url.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("urlFull");


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    resultString = eElement
                            .getElementsByTagName(tag)
                            .item(0)
                            .getTextContent();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public String getUrl() {

        return fullURL;
    }
}
