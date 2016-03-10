package com.agilesoftwareengineers.learn.mongobd;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.text.ParseException;

import static java.util.Arrays.asList;

public class Mongo {

    public static void main(String args[]) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> applicants = db.getCollection("applicants");

        applicants.drop();
        insertData(applicants);

        System.out.println("Applicants collection now contains::" + applicants.count());
    }

    private static void insertData(MongoCollection<Document> applicants) throws ParseException {
        applicants.insertOne(
                new Document("applicant",
                        new Document()
                                .append("forename", "Harry")
                                .append("surname", "Callahan")
                                .append("nino", "QQ123456A"))
                        .append("incomes", asList(
                                new Document()
                                        .append("payDate", "01/01/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.11"),
                                new Document()
                                        .append("payDate", "01/02/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.11"),
                                new Document()
                                        .append("payDate", "01/03/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.11"),
                                new Document()
                                        .append("payDate", "01/04/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.11"),
                                new Document()
                                        .append("payDate", "01/05/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.11"),
                                new Document()
                                        .append("payDate", "01/06/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.11")
                        ))
                        .append("total", "£9996.66")
                        .append("links", asList(
                                new Document()
                                        .append("rel", "self")
                                        .append("href", "http://localhost:4567/incomeproving/v1/applicants/QQ123456A"),
                                new Document()
                                        .append("rel", "sponsors")
                                        .append("href", "http://localhost:4567/incomeproving/v1/applicants/QQ123456A/sponsors")
                        ))
        );

        //QQ654321A
        applicants.insertOne(
                new Document("applicant",
                        new Document()
                                .append("forename", "Harry")
                                .append("surname", "Callahan")
                                .append("nino", "QQ654321A"))
                        .append("incomes", asList(
                                new Document()
                                        .append("payDate", "01/01/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£1000.00"),
                                new Document()
                                        .append("payDate", "01/02/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£1000.00"),
                                new Document()
                                        .append("payDate", "01/03/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£1000.00"),
                                new Document()
                                        .append("payDate", "01/04/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£3000.00"),
                                new Document()
                                        .append("payDate", "01/05/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£1000.00"),
                                new Document()
                                        .append("payDate", "01/06/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£1000.00"),
                                new Document()
                                        .append("payDate", "01/07/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£2500.00"),
                                new Document()
                                        .append("payDate", "01/08/2015")
                                        .append("employer", "Sheffield Spice")
                                        .append("income", "£1000.00"),
                                new Document()
                                        .append("payDate", "01/09/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/10/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/11/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/12/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00")
                        ))
                        .append("total", "£18164.00")
                        .append("links", asList(
                                new Document()
                                        .append("rel", "self")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ654321A"),
                                new Document()
                                        .append("rel", "sponsors")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ654321A/sponsors")
                        ))
        );

        applicants.insertOne(
                new Document("applicant",
                        new Document()
                                .append("forename", "Harry")
                                .append("surname", "Callahan")
                                .append("nino", "QQ023987A"))
                        .append("incomes", asList(
                                new Document()
                                        .append("payDate", "01/01/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "10/01/2015")
                                        .append("employer", "Halifax PLC")
                                        .append("income", "£2000.00"),
                                new Document()
                                        .append("payDate", "01/02/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "10/02/2015")
                                        .append("employer", "Halifax PLC")
                                        .append("income", "£2000.00"),
                                new Document()
                                        .append("payDate", "01/03/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "10/03/2015")
                                        .append("employer", "Halifax PLC")
                                        .append("income", "£2000.00"),
                                new Document()
                                        .append("payDate", "01/04/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "10/04/2015")
                                        .append("employer", "Halifax PLC")
                                        .append("income", "£2000.00"),
                                new Document()
                                        .append("payDate", "10/05/2015")
                                        .append("employer", "Halifax PLC")
                                        .append("income", "£2000.00"),
                                new Document()
                                        .append("payDate", "10/06/2015")
                                        .append("employer", "Halifax PLC")
                                        .append("income", "£2000.00")
                        ))
                        .append("total", "£18664.00")
                        .append("links", asList(
                                new Document()
                                        .append("rel", "self")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ023987A"),
                                new Document()
                                        .append("rel", "sponsors")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ023987A/sponsors")
                        ))
        );

        applicants.insertOne(
                new Document("applicant",
                        new Document()
                                .append("forename", "Harry")
                                .append("surname", "Callahan")
                                .append("nino", "QQ987654A"))
                        .append("incomes", asList(
                                new Document()
                                        .append("payDate", "04/01/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "04/02/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "20/05/2015")
                                        .append("employer", "Pizza Hut LTD")
                                        .append("income", "£2500.00"),
                                new Document()
                                        .append("payDate", "20/06/2015")
                                        .append("employer", "Pizza Hut LTD")
                                        .append("income", "£1666.00")
                        ))
                        .append("total", "£7498.00")
                        .append("links", asList(
                                new Document()
                                        .append("rel", "self")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ987654A"),
                                new Document()
                                        .append("rel", "sponsors")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ987654A/sponsors")
                        ))
        );

        applicants.insertOne(
                new Document("applicant",
                        new Document()
                                .append("forename", "Harry")
                                .append("surname", "Callahan")
                                .append("nino", "QQ765432A"))
                        .append("incomes", asList(
                                new Document()
                                        .append("payDate", "01/02/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/03/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/04/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/05/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/06/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/07/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/08/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/09/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/10/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1666.00"),
                                new Document()
                                        .append("payDate", "01/11/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1500.00"),
                                new Document()
                                        .append("payDate", "01/12/2015")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£1000.00"),
                                new Document()
                                        .append("payDate", "01/01/2016")
                                        .append("employer", "Flying Pizza Ltd")
                                        .append("income", "£2500.00")
                        ))
                        .append("total", "£19994.00")
                        .append("links", asList(
                                new Document()
                                        .append("rel", "self")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ765432A"),
                                new Document()
                                        .append("rel", "sponsors")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ765432A/sponsors")
                        ))
        );


        // QQ769875A
        applicants.insertOne(
                new Document("applicant",
                        new Document()
                                .append("forename", "Harry")
                                .append("surname", "Callahan")
                                .append("nino", "QQ769875A"))
                        .append("incomes", null)
                        .append("links", asList(
                                new Document()
                                        .append("rel", "self")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ769875A"),
                                new Document()
                                        .append("rel", "sponsors")
                                        .append("href", "http://localhost:4567/incomeproving/applicants/QQ769875A/sponsors")
                        ))
        );


    }
}
