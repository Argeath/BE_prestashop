#!/bin/bash

docker exec -i $1 mysqldump -uroot -p'test1234' --databases prestashop > mysql/initdb/prestashop.sql
