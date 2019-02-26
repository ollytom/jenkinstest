FROM openjdk:11-jre-slim

COPY target/classes/ /tmp/
WORKDIR /tmp
USER nobody
CMD [ "java",  "helloworld/HelloWorld" ]
