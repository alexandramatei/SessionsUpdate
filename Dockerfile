FROM amazoncorretto:11

COPY build/libs/SessionsUpdate-0.0.1-SNAPSHOT.jar .

EXPOSE 8082

CMD ["java", "-jar", "/SessionsUpdate-0.0.1-SNAPSHOT.jar" ]

