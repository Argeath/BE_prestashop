#!/bin/bash

docker exec -i business_psdb_1 mysql -uroot -ptest1234 < mysql/initdb/prestashop.sql
