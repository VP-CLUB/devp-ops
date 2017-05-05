FROM adfinissygroup/k8s-mariadb-galera-centos:v002
MAINTAINER chenwei <waj_615@qq.com>
USER root
RUN chmod -R 777 /var/lib/mysql
VOLUME ["/var/lib/mysql"]
USER 27
ENTRYPOINT ["/usr/bin/container-entrypoint.sh"]
