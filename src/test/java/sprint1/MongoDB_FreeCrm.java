package sprint1;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB_FreeCrm {
	
	//mongo db test
	
	MongoClient mongoClient = null;
	MongoDatabase db = null;

	@BeforeClass
	public void beforeClass() {
		try {
			// STEP 1: Connect to database
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDatabase("freecrm");
			System.out.println("Connect to database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	@Test(enabled = false)
	public void test() throws Exception {
		try {
			
			// STEP 2: Get Collection
			MongoCollection<Document> table = db.getCollection("companiestable");
			// STEP 3: Extract Data
			//BasicDBObject searchQuery = new BasicDBObject();
			//searchQuery.put("company", "Amazon");
			FindIterable<Document> cursor = table.find();
			
			// STEP 4: Iterate over data
			for (Document obj : cursor) {
				System.out.println(obj.toString());
				
				
			}
			
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() throws Exception {
		try {
			// STEP 2: Get Collection
			MongoCollection<Document> table = db.getCollection("companiestable");
			// STEP 3: Extract Data
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("company", "unitedhealth");
			FindIterable<Document> cursor = table.find(searchQuery);
			
			// STEP 4: Iterate over data
			for (Document obj : cursor) {
				
				
				String companyName = obj.getString("company");
				System.out.println(companyName);
				//System.out.println(obj.toString());
				
				
			}
			
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	

}
