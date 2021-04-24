# product-pinpoint
Aplicación de ejemplo que sirve como base al tutorial de la `Integración de Pinpoint APM con Spring Boot` de adictosaltrabajo.com.
Puedes revisar el tutorial en [la siguiente página web](https://www.adictosaltrabajo.com/2021/01/25/integracion-de-pinpoint-apm-con-spring-boot/)

# Requisitos
Estos son las versiones con las que se ha probado: 
* Maven 3
* Java 8
* Docker (>2.2)
* Docker-compose (>1.25)

# Arranque

Antes de nada, para saber de qué estamos hablando, léete el tutorial que es muy sencillo de usar.

Estos son los comandos a ejecutar para levantar todo:

* Abrimos una terminal para levantar las dependencias con la base de datos
```bash
docker-compose up
```

* Descargamos servidor pinpoint
```bash
git clone https://github.com/naver/pinpoint-docker.git
cd pinpoint-docker
git checkout 1.8.5
--- editar los ficheros para hacer buen funcionamiento de los agentes ---
docker-compose pull && docker-compose up
```

* Abrimos otra terminal para levantar la aplicación Java
```bash
mvn clean install
./runWithAgent.sh
```

