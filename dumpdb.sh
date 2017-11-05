#!/bin/bash

docker exec -i business_psdb_1 mysqldump -uroot -p'test1234' --databases prestashop > mysql/initdb/prestashop.sql
