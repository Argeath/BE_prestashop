FROM php:5.6-apache

COPY ./config/php.ini /usr/local/etc/php/

RUN a2enmod rewrite

# install the PHP extensions we need
RUN apt-get update && apt-get install -y ssmtp libmcrypt-dev libpng12-dev libjpeg-dev \
  && rm -rf /var/lib/apt/lists/*
RUN docker-php-ext-configure gd --with-png-dir=/usr --with-jpeg-dir=/usr
RUN docker-php-ext-install pdo_mysql mcrypt gd mbstring

RUN usermod -u 1000 www-data
RUN chown 1000 /var/www -R

CMD ["apache2-foreground"]
