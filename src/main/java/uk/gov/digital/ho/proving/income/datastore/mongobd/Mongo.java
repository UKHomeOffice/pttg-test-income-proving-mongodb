package uk.gov.digital.ho.proving.income.datastore.mongobd;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.apache.commons.io.IOUtils;
import org.bson.Document;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.stream.IntStream;

public class Mongo {

    private static String MONGO_HOST_ENV_NAME = "MONGODB_HOST";
    private static String MONGO_PORT_ENV_NAME = "MONGODB_PORT";

    private static String MONGO_HOST_DEFAULT = "127.0.0.1";

    /*
     * Settings for pt-i-test environment:
     *  - Use the mongodb ELB host
     *  - Use the HTTPS port to get through the firewall
     *
     * MONGODB_HOST=pt-i-test-internalelb-mongodb.dsp.notprod.homeoffice.gov.uk
     * MONGODB_PORT=443
     */

    public static void main(String args[]) throws IOException {
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

        MongoCollection<Document> applicants = getMongoClient().getDatabase("test").getCollection("applicants");
        //MongoCollection<Document> applicants = new MongoClient("localhost", 8888).getDatabase("test").getCollection("applicants");
        applicants.drop();

        Resource[] mappingLocations = patternResolver.getResources("classpath*:applicant*.json");

        for (Resource mappingLocation : mappingLocations) {
            String document = null;
            try {
                document = IOUtils.toString(mappingLocation.getInputStream());
            } catch (IOException e) {
                System.out.println("Error loading json from classpath: " + e);
            }

            System.out.println("Adding document from: " + mappingLocation.getURI());

            applicants.insertOne(Document.parse(document));
        }

        System.out.println("Applicants collection now contains: " + applicants.count());

        MongoCollection<Document> applications = getMongoClient().getDatabase("test").getCollection("applications");
        //MongoCollection<Document> applications = new MongoClient("localhost", 8888).getDatabase("test").getCollection("applications");
        applications.drop();

        mappingLocations = patternResolver.getResources("classpath*:application*.json");

        for (Resource mappingLocation : mappingLocations) {
            String document = null;
            try {
                document = IOUtils.toString(mappingLocation.getInputStream());
            } catch (IOException e) {
                System.out.println("Error loading json from classpath: " + e);
            }

            System.out.println("Adding document from: " + mappingLocation.getURI());

            applications.insertOne(Document.parse(document));
        }

        System.out.println("Applicants collection now contains: " + applications.count());
    }

    /*quick hack to allow overriding by environment variables
    * port will be ignore if host not specified */
    private static MongoClient getMongoClient() {
        final String envValue = System.getenv(MONGO_HOST_ENV_NAME);
        final String host = (envValue != null && !envValue.isEmpty()) ? envValue : MONGO_HOST_DEFAULT;

        final String port = System.getenv(MONGO_PORT_ENV_NAME);
        boolean useHost = (host != null && !host.isEmpty());
        boolean usePort = (port != null && !port.isEmpty());
        MongoClient client = null;
        if (useHost) {
            if (usePort) {
                client = new MongoClient(host, Integer.parseInt(port));
            } else {
                client = new MongoClient(host);
            }
        } else {
            client = new MongoClient();
        }
        System.out.println("MongoClient invoked using host[" + host + "] and port [" + port + "]");
        return client;
    }
}
