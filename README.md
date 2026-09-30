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
curl -X POST "http://localhost:8080/api/personajes?claseId=1&ascendenciaId=1&bagajeId=1&herenciaId=1"
```
**Commands**
# Level up
```bash
curl -X PUT "http://localhost:8080/api/personajes/1/subir-nivel"
```
# Level down 
```bash
curl -X PUT "http://localhost:8080/api/personajes/1/bajar-nivel"
```
# Check open options
```bash
curl "http://localhost:8080/api/personajes/1/opciones"
```
# Choose stats / habilities
```bash
curl -X POST "http://localhost:8080/api/personajes/1/estadisticas" -H "Content-Type: application/json" -d '{"stats":["SABIDURIA"]}'
curl -X POST "http://localhost:8080/api/personajes/1/habilidades" -H "Content-Type: application/json" -d '{"hab":["ACROBACIAS"]}'
```
# Assign feat
```bash
curl -X POST "http://localhost:8080/api/personajes/1/dotes?huecoId=1&doteId=1"
```

## 🚧 Current State (<i>In development</i>)
The rules engine is operational and the character lifecycle is fully functional with the creation, leveling up and down and the choice of free stats, skills and feats through dedicated endpoints, but the catalog of contents is still small. The content is 'Hardcoded' except for Traits (Rasgos), which are loaded with a JSON file:
**Ancestries**: 1 (Elf)
**Heritages**: 1 (Artic Elf)
**Classes**: 1 (Fighter (Levels 1-20))
**Backgrounds**: 2 (Guard, Barrister)
**Feats**: 3 (Snagging Strike, Group impression, Quick Coercion)
**Traits**: 195 (Player's guide traits)
**Spells**: 1 (Fireball)
**Equipment**: 1 (Short sword)
- This is the reason ddl-auto is set to create-drop.

## 🗺️ Next Steps
- [ ] Expand content catalog (more ancestries, classes, backgrounds, feats...)
- [ ] Integration tests with @SpringBootTest (unit tests for the rules engine already exist)
- [ ] User authentication / Management for personal characters 
- [ ] Character export Endpoint (PDF or JSON character sheet)
- [ ] Spells and Equipment management

## ⚖️Legal & Licensing
### Software License
The source code, architecture, and logic of this API are licensed under the [MIT License](LICENSE).

### Game Content & Copyright Notice
This API uses trademarks and/or copyrights owned by Paizo Inc., used under Paizo's Community Use Policy (paizo.com/licenses/communityuse). We are expressly prohibited from charging you to use or access this content. This API is not published, endorsed, or specifically approved by Paizo. For more information about Paizo Inc. and Paizo products, visit [paizo.com](https://paizo.com).

- **ORC License Notice:** This product is licensed under the ORC License located at the Library of Congress at TX 9-307-067 and available online at various locations including paizo.com/orclicense and others. All warranties are disclaimed as set forth therein.
- **Attribution:** This product is compatible with and based on ORC Content from:
  - *Pathfinder Core Rulebook* © 2019, Paizo Inc.
  - *Pathfinder Player Core* © 2023, Paizo Inc.
  - *Pathfinder Player Core 2* © 2024, Paizo Inc.
  - Content and definitions retrieved from *Archives of Nethys* (aonprd.com).
- **Translations:** The Spanish translations of the game description and explanations are my own.
- **Spanish Terminology:** Official Spanish terms and names (from Devir / community glossaries) are used solely for consistency with the game's official material.


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
curl -X POST "http://localhost:8080/api/personajes?claseId=1&ascendenciaId=1&bagajeId=1&herenciaId=1"
```
**Comandos**
# Subir de nivel
```bash
curl -X PUT "http://localhost:8080/api/personajes/1/subir-nivel"
```
# Bajar de nivel
```bash
curl -X PUT "http://localhost:8080/api/personajes/1/bajar-nivel"
```
# Ver opciones libres pendientes
```bash
curl "http://localhost:8080/api/personajes/1/opciones"
```
# Elegir estadísticas / habilidades libres
```bash
curl -X POST "http://localhost:8080/api/personajes/1/estadisticas" -H "Content-Type: application/json" -d '{"stats":["SABIDURIA"]}'
curl -X POST "http://localhost:8080/api/personajes/1/habilidades" -H "Content-Type: application/json" -d '{"hab":["ACROBACIAS"]}'
```
# Asignar una dote a un hueco libre
```bash
curl -X POST "http://localhost:8080/api/personajes/1/dotes?huecoId=1&doteId=1"
```

## 🚧 Estado Actual (<i>En desarrollo</i>)
El motor de reglas está operativo y el ciclo de vida del personaje es completamente funcional con la creación, subida y bajada de nivel y elección de estadísticas, habilidades y dotes libres mediante endpoints dedicados, pero el catalogo de contenido aún es reducido. El contenido se encuentra 'hardcodeado' a excepción de los Rasgos, los cuales se introducen mediante un archivo JSON:
**Ascendencias**: 1 (Elfo)
**Herencias**: 1 (Elfo Ártico)
**Clases**: 1 (Guerrero (niveles 1-20))
**Bagajes**: 2 (Guardia, Abogado)
**Dotes**: 3 (Ataque imprevisto, Impresión de Grupo, Intimidación rápida)
**Rasgos**: 195 (Los rasgos del Manual del jugador.)
**Hechizo**: 1 (Bola de Fuego)
**Equipo**: 1 (Espada corta)
- Este es el motivo por el que el ddl-auto está configurado como create-drop.

## 🗺️ Próximos pasos
- [ ] Ampliar el catálogo de contenido (más ascendencias, clases, bagajes, dotes...)
- [ ] Tests de integración con @SpringBootTest(los tests unitarios del motor de reglas ya existen)
- [ ] Autenticación / gestión de usuarios para personajes propios
- [ ] Endpoint de exportación de personaje (PDF o JSON de ficha)
- [ ] Gestión de Hechizos y Equipo

## ⚖️Aviso Legal y Licencias
### Licencia del Código Fuente
El código fuente, la arquitectura y el diseño técnico de esta API están protegidos bajo la [Licencia MIT](LICENSE).
### Contenido del Juego y Marcas Registradas
This API uses trademarks and/or copyrights owned by Paizo Inc., used under Paizo's Community Use Policy (paizo.com/licenses/communityuse). We are expressly prohibited from charging you to use or access this content. This API is not published, endorsed, or specifically approved by Paizo. For more information about Paizo Inc. and Paizo products, visit [paizo.com](https://paizo.com).

- **Aviso sobre la Licencia ORC:**  Este producto está licenciado bajo la Licencia ORC situada en la Biblioteca del Congreso TX 9-307-067 y disponible en linea en varios puntos, incluyendo paizo.com/orclicense y otros. Todas las garantías se detallan en ella.
- **Atribución:** Este producto es compatible con y basado en contenido ORC de: 
  - *Pathfinder Core Rulebook* © 2019, Paizo Inc.
  - *Pathfinder Player Core* © 2023, Paizo Inc.
  - *Pathfinder Player Core 2* © 2024, Paizo Inc.
  - Contenido y definiciones se han obtenido de *Archives of Nethys* (aonprd.com).
- **Traducción:** La traducción de las descripciones y explicaciones está realizada por mí.
- **Términos en Español:** Los términos oficiales y los nombres (de Devir y la comunidad), se utilizan puramente por consistencia con el material oficial del juego.