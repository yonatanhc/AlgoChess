[![Build Status](https://travis-ci.org/yonatanhc/AlgoChess.svg?branch=master)](https://travis-ci.org/yonatanhc/AlgoChess)
[![codecov](https://codecov.io/gh/yonatanhc/AlgoChess/branch/master/graph/badge.svg)](https://codecov.io/gh/yonatanhc/AlgoChess)

Informe https://www.overleaf.com/8915945847fknbszjhrhsc

## Instalación previa

Las únicas herramientas necesarias para trabajar en el proyecto son el entorno de desarrollo de Java ([JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)), [Apache Ant](https://ant.apache.org/) para la construcción automatizada y Git para el control de versiones.

```console
$ sudo apt update
$ sudo apt install default-jdk maven git
```

Verificamos que se hayan instalado correctamente:

```console
$ javac -version
javac 11.0.4
$ mvn --version
Apache Maven 3.6.0
Maven home: /usr/share/maven
Java version: 11.0.4, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: es_AR, platform encoding: UTF-8
OS name: "linux", version: "4.15.0-66-generic", arch: "amd64", family: "unix"
$ git --version
git version 2.17.1
```

## Procedimiento

La primera vez se inicia el repositorio local para trabajar:

```console
$ mkdir AlgoChess
$ cd AlgoChess
$ git init
$ git remote add origin https://github.com/yonatanhc/AlgoChess.git
```

Luego se realiza un *pull* del repositorio remoto para obtener la última versión del código:

```console
$ git pull origin master
```

Una vez agregados y/o modificados los archivos necesarios se ejecuta Ant sobre el repositorio local para verificar que el *build* sea exitoso.

Antes de integrar se debe asegurar de que el proceso de construcción resulte satisfactorio de manera local (incluyendo la ejecución de las pruebas):

```console
$ mvn test
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.895 s
[INFO] Finished at: 2019-11-02T20:52:15-03:00
[INFO] ------------------------------------------------------------------------
```

Finalmente se procede a subirlos al repositorio remoto:

```console
$ git add .
$ git commit -m "Comentario del commit"
$ git push origin master
```

Una vez hecho el push, Travis se encarga de ejecutar el script de Ant en el repositorio de integración contínua y se notificará a todos los colaboradores en caso de error.

El historial de construcciones en Travis puede verse [aquí](https://travis-ci.org/yonatanhc/AlgoChess/builds) y la medición de cobertura con CodeCov [aquí](https://codecov.io/gh/yonatanhc/AlgoChess).
