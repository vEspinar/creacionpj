# API REST / Backend para Creación y Gestión de Personajes de Rol PF2e

[ 🇪🇸 Español](#español)|[ 🇬🇧|🇺🇸 English](#english)

## **English**
## 📝Summary:
Backend for the creation and management of role-playing characters (Pathfinder 2e) developed in Java using Spring Boot. Implements rules engine, class, ancestry, general and skill feat requirement validations, statistics dynamic computations and leveling up.

## 💻Technologies used:
- **Java 21**
- **Spring Boot / Hibernate**
- **PostgreSQL**
- **Maven**

## ⚠️Requirements:
To install and run this API you must have already installed:
- JDK 21
- PostgreSQL
- Maven

## Configuration & Installation:
**Clone Repository:**
```bash
git clone https://github.com/vEspinar/creacionpj.git
cd creacionpj
```

**Configuration of PostgreSQL Database:**
- Create a new PostgreSQL database named `creacionpj`
- Define the environment variables `DB_USER` & `DB_PASSWORD`
```bash
# Linux / macOS
export DB_USER=postgres
export DB_PASSWORD=your_password
```
```powershell
# Windows (PowerShell)
$env:DB_USER="postgres"
$env:DB_PASSWORD="your_password"
```
- Keep in mind that ddl-auto is set to create-drop for testing, meaning the data will be erased and rewritten each run.

**Run**
```bash
mvn spring-boot:run
```
API Runs at `http://localhost:8080`. To create a Character as an example (Check the proper Ids with `GET /api/clases`, `/api/razas`, etc.):
```bash
curl -X POST "http://localhost:8080/api/personajes?claseId=1&razaId=1&bagajeId=1&subRazaId=1"
```

## ⚖️Legal
This API uses trademarks and/or copyrights owned by Paizo Inc., used under Paizo's Community Use Policy (paizo.com/licenses/communityuse). We are expressly prohibited from charging you to use or access this content. This API is not published, endorsed, or specifically approved by Paizo. For more information about Paizo Inc. and Paizo products, visit [paizo.com](https://paizo.com).

The Spanish translations of the game description and explanations are my own.
Official Spanish terms and names (from Devir / community glossaries) are used solely for consistency with the game's official material.


## **Español**

## 📝Resumen:
Backend desarrollado en Java mediante Spring Boot para la gestión de personajes de rol (Pathfinder 2e). Implementa el motor de reglas del juego, validación de requisitos de dotes de clase, de herencia, generales y de habilidad, cálculo dinámico de estadísticas y subidas de nivel.

## 💻Tecnologías utilizadas

- **Java 21**
- **Spring Boot / Hibernate**
- **PostgreSQL**
- **Maven**

## ⚠️Requisitos previos

Para poder ejecutar la aplicación es necesario tener instalado:
- JDK 21
- PostgreSQL
- Maven

## ⚙️Configuración e Instalación

**Clonar el repositorio:**
```bash
git clone https://github.com/vEspinar/creacionpj.git
cd creacionpj
```

**Configurar la Base de Datos en PostgreSQL:**
- Crear una Base de Datos en PostgreSQL con nombre `creacionpj`
- Definir las variables de entorno `DB_USER` y `DB_PASSWORD`
```bash
# Linux / macOS
export DB_USER=postgres
export DB_PASSWORD=tu_contraseña
```
```powershell
# Windows (PowerShell)
$env:DB_USER="postgres"
$env:DB_PASSWORD="tu_contraseña"
```
- Tener en cuenta que ddl-auto está configurado como create-drop para las pruebas.

**Ejecutar**
```bash
mvn spring-boot:run
```
La API queda en `http://localhost:8080`. Ejemplo para crear un personaje (consulta los ids reales con `GET /api/clases`, `/api/razas`, etc.):
```bash
curl -X POST "http://localhost:8080/api/personajes?claseId=1&razaId=1&bagajeId=1&subRazaId=1"
```

## ⚖️Legal
This API uses trademarks and/or copyrights owned by Paizo Inc., used under Paizo's Community Use Policy (paizo.com/licenses/communityuse). We are expressly prohibited from charging you to use or access this content. This API is not published, endorsed, or specifically approved by Paizo. For more information about Paizo Inc. and Paizo products, visit [paizo.com](https://paizo.com).

La traducción de las descripciones y explicaciones está realizada por mí.
Los términos oficiales y los nombres (de Devir y la comunidad), se utilizan puramente por consistencia con el material oficial del juego.