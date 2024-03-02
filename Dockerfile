FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk11
COPY ./build/libs/web3-1.0.war /opt/jboss/wildfly/standalone/deployments/
