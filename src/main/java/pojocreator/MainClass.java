package pojocreator;

import java.io.File;
import java.io.IOException;

import com.api.utils.JsonReader;

public class MainClass {

	public static void main(String[] arg) throws IOException {
		CreatePojoFromJson createPojoFromJson = new CreatePojoFromJson();
		
		String outputFileDirectory = "src/main/java/";
		
		File file = new File(outputFileDirectory);
		createPojoFromJson.convertJsonToJavaClass(file,"com.api.model.createStoreModel","CreateStoresResponse",JsonReader.readJsonFile("CreateStoreResponse.json").toJSONString());
	}
}
