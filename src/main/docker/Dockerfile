FROM oraclelinux:6-slim

#RUN yum update -y
RUN yum install -y wget
RUN yum install -y tar
RUN yum install -y unzip
RUN yum install -y mysql-server
RUN mkdir /app

ENV jdk=1.8.0_191
ENV jdk_link=https://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.tar.gz

RUN wget -q --no-check-certificate --no-cookies \
        --header "Cookie: oraclelicense=accept-securebackup-cookie" \
        --output-document=oracle-jdk.tar.gz \
        ${jdk_link} && \
    tar -xzf oracle-jdk.tar.gz && \
    rm oracle-jdk.tar.gz

# Set environment variables
#ENV JAVA_HOME "/jdk-${jdk}"
ENV JAVA_HOME "/jdk${jdk}"
ENV PATH "${PATH}:${JAVA_HOME}/bin:/opt/gradle/gradle-${gradle}/bin"

COPY quickstart-se.jar /app
COPY libs /app/libs
COPY startup.sh /
RUN chmod a+x /startup.sh

ENTRYPOINT service mysqld start && /bin/bash

CMD ["/startup.sh"]
CMD ["java", "-jar", "/app/quickstart-se.jar"]
