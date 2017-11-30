#!/bin/bash

docker exec -i $1 mysql -uroot -ptest1234 prestashop < mysql/initdb/prestashop.sql
