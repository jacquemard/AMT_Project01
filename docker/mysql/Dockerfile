FROM mysql

ENV email nadir.benallal@heig-vd.ch
	
WORKDIR /docker-entrypoint-initdb.d

COPY src/ikea.sql /docker-entrypoint-initdb.d/ikea.sql
