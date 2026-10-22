# FindBack — Smart Campus Lost & Found System

A Java-based, console-driven Smart Campus Lost & Found System designed to help students report, search for, and manage lost and found items on campus. The application uses Object-Oriented Programming (OOP), a layered architecture, JDBC, and MySQL for persistent data storage.

---

## 🎯 Project Objectives

- Provide a structured system for reporting lost and found items.
- Store item records persistently in a relational database.
- Retrieve and search item records.
- Track item status and update records when necessary.
- Demonstrate Java OOP, separation of concerns, database connectivity, and SQL operations.

---

## 🛠️ Technologies & Tools

- **Java:** Application logic and object-oriented design.
- **Maven:** Build automation and project configuration.
- **JDBC:** Connectivity between Java and MySQL.
- **MySQL 8.0:** Relational database management.
- **MySQL Workbench:** Database administration and SQL testing.
- **Git & GitHub:** Version control and source-code hosting.

---

## Architecture & Directory Layout

```text
FindBack/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── findback/
                    ├── Main.java
                    ├── model/
                    │   └── Item.java
                    ├── repository/
                    │   └── ItemRepository.java
                    ├── service/
                    │   └── ItemService.java
                    ├── ui/
                    │   └── MainMenu.java
                    └── database/
                        └── DatabaseConnection.java
```

*Note: Verify the filenames and package declarations against your actual project before treating this directory tree as final.*

---

## 🏗️ Architecture Overview

FindBack follows a layered architecture in which each component has a specific responsibility.

```text
             USER
               |
               v
        +--------------+
        |   MainMenu   |
        | User Interface|
        +--------------+
               |
               v
        +--------------+
        |  ItemService |
        | Business Logic|
        +--------------+
               |
               v
        +------------------+
        | ItemRepository   |
        | Database Queries |
        +------------------+
               |
               v
        +------------------+
        | DatabaseConnection|
        | JDBC Connectivity |
        +------------------+
               |
               v
        +------------------+
        | MySQL findback_db|
        | items table      |
        +------------------+
```

The `Item` model represents the data handled by the application.

---

## 📂 File-by-File Technical Specification

### 1. `model/Item.java`

**Responsibility:** Represents an item reported to the lost and found system.

**Expected data fields:**
- `id` — Unique database identifier.
- `title` — Name or title of the item.
- `category` — Item category.
- `location` — Location where the item was lost or found.
- `status` — Current status, such as `LOST` or `FOUND`.
- `dateReported` — Date and time the item was reported.

**Design considerations:**
- Use constructors appropriate for new and database-retrieved items.
- Encapsulate fields using appropriate access modifiers.
- Provide getters and setters where needed.
- Represent the report date using an appropriate Java date/time type, such as `LocalDateTime`.

### 2. `repository/ItemRepository.java`

**Responsibility:** Handles database operations for item records.

**Database responsibilities:**
- Insert item records.
- Retrieve item records from MySQL.
- Search for items using the supported search criteria.
- Update item status where implemented.

**Technical considerations:**
- Use JDBC and `PreparedStatement` for parameterized queries.
- Use try-with-resources to close database resources.
- Handle `SQLException` appropriately.
- Keep SQL operations separate from menu presentation and user input.

### 3. `service/ItemService.java`

**Responsibility:** Provides the application's item-management operations.

**Known service operations:**
- `addItem(...)` — Adds an item through the repository.
- `getAllItems()` — Retrieves available item records.
- `searchItems(...)` — Searches item records.

**Design considerations:**
- Keep business rules out of the user-interface layer.
- Validate input where appropriate.
- Coordinate repository operations.
- Add further service methods as required by implemented features.

### 4. `ui/MainMenu.java`

**Responsibility:** Provides the console interface for users.

**Menu operations:**
- Report a lost item.
- Report a found item.
- View item records.
- Search for items.
- Update item status.
- Exit the application.

**Implementation considerations:**
- Use `Scanner` for console input.
- Delegate application operations to `ItemService`.
- Display clear success and error messages.
- Handle invalid menu selections without unexpectedly terminating the application.

*Include only options that exist in the current implementation.*

### 5. `database/DatabaseConnection.java`

**Responsibility:** Establishes a connection between the Java application and MySQL.

**Configuration requirements:**
- MySQL server must be running.
- The `findback_db` database must exist.
- Connection settings must match the local environment.
- The MySQL JDBC driver must be available through Maven.

**Security considerations:**
- Do not commit database passwords or other secrets to GitHub.
- Keep environment-specific credentials outside source code.
- Handle connection failures with clear diagnostic messages.

### 6. `Main.java`

**Responsibility:** Serves as the application's entry point.

**Expected responsibilities:**
- Initialize the application.
- Create or invoke the main menu.
- Start the console interaction flow.

The entry point should remain small and delegate menu and business operations to their respective classes.

---

## 🗄️ Database Specification

**Database name:** `findback_db`

**Primary table:** `items`

| Column | Purpose |
|---|---|
| `id` | Primary key and unique item identifier |
| `title` | Item name |
| `category` | Item category |
| `location` | Reported location |
| `status` | Current item status, such as `LOST` or `FOUND` |
| `date_reported` | Report timestamp |

The exact SQL types, nullability, defaults, and constraints should match the actual database schema.

### Database Design Principles

- Use a primary key to uniquely identify each item.
- Use appropriate data types and constraints.
- Use parameterized SQL queries.
- Maintain consistency between Java fields and database columns.
- Avoid storing sensitive database credentials in the repository.

---

## ⚙️ Prerequisites

Before running FindBack, ensure that you have:

- A compatible Java Development Kit (JDK).
- Apache Maven installed or a compatible Maven wrapper.
- MySQL Server 8.0 or a compatible version.
- The required JDBC dependency configured in `pom.xml`.
- The `findback_db` database and required table configured.

---

## ▶️ Compilation & Execution

Open a terminal in the project root directory.

### 1. Compile the project

```bash
mvn clean compile
```

### 2. Run the application

If the Maven Exec Plugin is configured in the project, run:

```bash
mvn exec:java "-Dexec.mainClass=com.findback.Main"
```

If your entry-point class has a different fully qualified name, replace `com.findback.Main` with the actual class name.

---

## 🧪 Testing Checklist

- [ ] Application starts successfully.
- [ ] Database connection succeeds.
- [ ] A lost item can be reported.
- [ ] A found item can be reported.
- [ ] Item records can be retrieved.
- [ ] Item search returns appropriate results.
- [ ] Item status can be updated.
- [ ] Invalid input is handled appropriately.
- [ ] Database records persist after restarting the application.

Mark each item complete only after testing it against the current implementation.

---

## 🚀 Future Improvements

Potential extensions include:

- A graphical interface or web interface.
- Student authentication and authorization.
- More advanced item matching and search.
- Image uploads for reported items.
- Notifications when a matching item is found.
- Automated tests and improved input validation.

These are proposed improvements, not claims about existing functionality.

---

## 📌 Project Status

FindBack is under active development as a Java and MySQL learning project. Its purpose is to apply object-oriented programming, layered architecture, JDBC integration, SQL, and software engineering practices to a practical campus problem.