FROM maven:3.6.3-jdk-13 AS packager

RUN mkdir -p /mpp-ms-person

WORKDIR /mpp-ms-person

ADD ./pom.xml .
ADD ./docker-entrypoint.sh /

RUN mvn clean install -X -f ./pom.xml

COPY ./ .


RUN mvn package -Dmaven.test.skip=true && \
    mv ./target/*.jar /run/mpp-ms-person-docker.jar

FROM openjdk:13

COPY --from=packager /run/mpp-ms-person-docker.jar /var/mpp-ms-person/mpp-ms-person-docker.jar
COPY --from=packager /docker-entrypoint.sh /docker-entrypoint.sh

RUN chmod +x /docker-entrypoint.sh

ENTRYPOINT [ "bash", "/docker-entrypoint.sh" ]
