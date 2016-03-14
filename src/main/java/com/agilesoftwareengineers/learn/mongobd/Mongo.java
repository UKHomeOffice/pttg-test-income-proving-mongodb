package com.agilesoftwareengineers.learn.mongobd;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.apache.commons.io.IOUtils;
import org.bson.Document;
import java.io.IOException;
import java.util.stream.IntStream;


public class Mongo {

    public static void main(String args[]) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        MongoCollection<Document> applicants = new MongoClient().getDatabase("test").getCollection("applicants");

        applicants.drop();

        IntStream.range(1, 7).forEach(i -> {

            String document = null;
            String resource = String.format("applicant%d.json", i);

            try {

                document = IOUtils.toString(classLoader.getResourceAsStream(resource));
            }
            catch (IOException e) {

            }

            applicants.insertOne(Document.parse(document));
        });

        System.out.println("Applicants collection now contains: " + applicants.count());
    }
}
