FROM docker-registry-default.172.16.5.80.nip.io/openshift/oc-kafka:latest
USER root
RUN rm -rf /kafka
RUN mkdir /kafka
RUN chown -R 1001:0 /kafka && chmod -R ug+rw /kafka

USER 1001
