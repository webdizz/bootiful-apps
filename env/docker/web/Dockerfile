FROM webdizz/nginx:latest

MAINTAINER Izzet Mustafaiev "izzet@mustafaiev.com"

# Set correct environment variables.
ENV	HOME /root
ENV	LANG en_US.UTF-8
ENV	LC_ALL en_US.UTF-8
ENV	DEBIAN_FRONTEND	noninteractive

# set sane locale
RUN	locale-gen en_US.UTF-8

ADD static/env/nginx/nginx.conf     /usr/local/nginx/conf/nginx.conf
ADD static/env/nginx/includes       /usr/local/nginx/conf/includes
ADD static/env/nginx/sites-enabled/bootiful-app.conf  /usr/local/nginx/conf/sites-enabled/bootiful-app.conf
ADD static/static                   /usr/local/nginx/html

# Clean up APT when done.
RUN	apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*