FROM maven:3.5-jdk-8-alpine
RUN ls -l
WORKDIR /usr/src/Inci_e5a
COPY . /usr/src/Inci_e5a/
RUN mvn package
EXPOSE 8090
CMD ["java", "-jar", "target/Inci_e5a-0.1.1.jar", "--spring.kafka.bootstrap-servers=kafka:9092","--spring.data.mongodb.uri = mongodb://admin:uo251836@ds147420.mlab.com:47420/sistema_incidencias"]