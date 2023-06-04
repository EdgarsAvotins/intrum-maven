FROM maven:3.9.2-amazoncorretto-11-debian

WORKDIR /app

COPY . /app

RUN mvn compile

ENTRYPOINT /bin/sh