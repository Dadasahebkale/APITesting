package seriliazationdeseriliazation;

import org.apache.juneau.html.HtmlParser;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.xml.XmlParser;
import org.apache.juneau.xml.XmlSerializer;

public class ProductTest {

	public static void main(String[] args) {
		// Serialization
		//pojo to json
		JsonSerializer jsonserializer=JsonSerializer.DEFAULT_READABLE;
		String sellerNames[]= {"Neon Enterprise","ABC Software","XYZ IT Solution"};
		Product product=new Product("MacBookPro", 1000, "Green",sellerNames);
		
		String json=jsonserializer.serialize(product);
		System.out.println(json);
	
		//POJO to xml
		
		XmlSerializer xmlSerializer=XmlSerializer.DEFAULT_NS_SQ_READABLE;
		String xml=xmlSerializer.serialize(product);
		System.out.println(xml);
		//POJO to HTML
		HtmlSerializer htmlSerializer=HtmlSerializer.DEFAULT_SQ_READABLE;
		String html=htmlSerializer.serialize(product);
		System.out.println(html);
		
		//deSerialization
		//joson to pojo
		
		JsonParser jsonParser=JsonParser.DEFAULT;
		
		String jsonValue="{\r\n"
				+ "	\"color\": \"Green\",\r\n"
				+ "	\"name\": \"MacBookPro\",\r\n"
				+ "	\"price\": 1000,\r\n"
				+ "	\"sellerNames\": [\r\n"
				+ "		\"Neon Enterprise\",\r\n"
				+ "		\"ABC Software\",\r\n"
				+ "		\"XYZ IT Solution\"\r\n"
				+ "	]\r\n"
				+ "}";
		Product pro= jsonParser.parse(jsonValue, Product.class);
		System.out.println(pro);
//		pro.getColor();
//		pro.getPrice();
//		pro.getSellerNames()
		XmlParser xmlp=XmlParser.DEFAULT;
		String xmlValue="<object>\r\n"
				+ "	<color>Green</color>\r\n"
				+ "	<name>MacBookPro</name>\r\n"
				+ "	<price>1000</price>\r\n"
				+ "	<sellerNames>\r\n"
				+ "		<string>Neon Enterprise</string>\r\n"
				+ "		<string>ABC Software</string>\r\n"
				+ "		<string>XYZ IT Solution</string>\r\n"
				+ "	</sellerNames>\r\n"
				+ "</object>";
		Product xmlparser=xmlp.parse(xmlValue, Product.class);
		System.out.println(xmlparser);
		
		HtmlParser htmlParser=HtmlParser.DEFAULT;
		String htmlValue="<table>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>color</td>\r\n"
				+ "		<td>Green</td>\r\n"
				+ "	</tr>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>name</td>\r\n"
				+ "		<td>MacBookPro</td>\r\n"
				+ "	</tr>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>price</td>\r\n"
				+ "		<td>1000</td>\r\n"
				+ "	</tr>\r\n"
				+ "	<tr>\r\n"
				+ "		<td>sellerNames</td>\r\n"
				+ "		<td>\r\n"
				+ "			<ul>\r\n"
				+ "				<li>Neon Enterprise</li>\r\n"
				+ "				<li>ABC Software</li>\r\n"
				+ "				<li>XYZ IT Solution</li>\r\n"
				+ "			</ul>\r\n"
				+ "		</td>\r\n"
				+ "	</tr>\r\n"
				+ "</table>";
		
		Product htmlparser=htmlParser.parse(htmlValue, Product.class);
		System.out.println(htmlparser);
	}

	
}
