FROM quay.io/ukhomeofficedigital/openjdk8:v0.1.2

USER root

ADD pttg-test-loader-mongodb*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/code/app.jar"]
