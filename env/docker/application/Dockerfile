FROM webdizz/baseimage-java8:latest

MAINTAINER Izzet Mustafaiev "izzet@mustafaiev.com"

# Set correct environment variables.
ENV	HOME /root
ENV	LANG en_US.UTF-8
ENV	LC_ALL en_US.UTF-8
ENV	DEBIAN_FRONTEND	noninteractive

# set sane locale
RUN	locale-gen en_US.UTF-8

ADD bootiful-app.jar   /bootiful-app.jar

ENV APP_OPTS --application.empty
ENV JAVA_OPTS -Xmx1G
CMD java -jar $JAVA_OPTS /bootiful-app.jar $APP_OPTS

# Clean up APT when done.
RUN	apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*