### Components
CLI Application (Java Client):
* Users interact with the system through a command-line interface written in Java.

API Gateway (Custom Java Server):
* Acts as an intermediary between the CLI client and backend, handling API requests and responses.

Authentication (JWT/OAuth) not present in the first iteration:
* Handles user authentication and authorization using JSON Web Tokens (JWT) or OAuth.

Backend (Pure Java):
* The server-side application logic, written in Java, handles business rules, data processing, and interactions with the file storage system.

File Storage (CSV/JSON/XML Files):
* Stores all the data related to users, events, reservations, etc., in files instead of a database.

#### Design

```
                                       +-----------------------+
                                       |     CLI Application   |
                                       |   (Java Client)       |
                                       +-----------|-----------+
                                                   |
                                                   V
                                      +------------------------+
                                      |     API Gateway        |
                                      |  (Custom Java Server)  |
                                      +-----------|------------+
                                                   |
                                                   V
+------------------------+            +------------------------+
|    Authentication      |<---------->|      Backend           |
|     (JWT/OAuth)        |            |    (Pure Java)         |
+------------------------+            +-----------|------------+
                                                   |
                                                   V
                                      +------------------------+
                                      |     File Storage       |
                                      | (CSV/JSON/XML Files)   |
                                      +------------------------+

```