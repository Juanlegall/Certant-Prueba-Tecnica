# Gimnasio Energym - Sistema de Gestión de Clases y Reservas

## Requisitos
- Java 17+
- Maven 3.9.11+
- Base de datos: MySQL 5.7.18
- Opcional Frontend: Angular o React
- Pruebas unitarias: JUnit5 / Mockito

## Instalación

1. Clonar el repositorio:
```
https://github.com/Juanlegall/Certant-Prueba-Tecnica.git
```

2. Importar el proyecto en - **IntelliJ IDEA** (recomendado) como proyecto Maven.

3. Configurar la base de datos:
- Crear la base de datos `gimnasioproject`.
- Importar los scripts `Script` y `Datos`.

4. Configurar las credenciales de la base de datos en `application.properties`:
```
spring.datasource.url=jdbc:mysql://localhost:3306/gimnasioproject
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
```


## Ejecución

1. Compilar el proyecto con Maven:
```
mvn clean install
```

2. Ejecutar la aplicación:
```
mvn spring-boot:run
```

3. Acceder al sistema vía navegador:
- `http://localhost:8081/Redirect/login` para login de socios y administradores.

## Datos de ejemplo
- Usuario admin:
  - Usuario: admin
  - Contraseña: admin
- Otros usuarios, socios, clases, reservas y sucursales se generan en el script SQL de ejemplo (`datos`).

## Pruebas
No inclui pruebas unitarias debido a que todavia no tuve la oportunidad de aprender las herrmaientas necesarias. Dicho esto el martes 26/08 empiezo un curso de test

## Consideraciones
- Asegurarse de tener las versiones correctas de Java y Maven.
- Ajustar las configuraciones de la base de datos según tu entorno.
- Para demo rápida, se puede usar H2 en memoria.


