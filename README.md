# I-Wish

I-Wish is a JavaFX desktop gift-contribution app. It provides registration/sign-in, friend requests, wish-list CRUD, friend wish-list viewing, partial contributions, funding notifications, a server console, and a persistent embedded H2 database.

## Run

In one terminal, start the server:

```bash
cd I-Wish
mvn -q exec:java -Dexec.mainClass=iti.iwish.server.ServerConsoleApp
```

In another terminal, start the client:

```bash
mvn javafx:run
```

The client also offers **Start local demo server** from its welcome screen. The database is created at `~/.iwish/iwish-db` on first start. Run `src/main/resources/schema.sql` in H2/MySQL-compatible tooling to inspect or initialize the schema separately.

The shared host and port are in `src/main/resources/server.properties`. To run the client against a server on another computer, replace `127.0.0.1` with that computer's local IP address and use the same port on both sides.

## NetBeans

1. In NetBeans, choose **File > Open Project** and select the `I-Wish` folder (or its `pom.xml`).
2. Let NetBeans load the Maven dependencies, then right-click the project and choose **Run**. The included `nbactions.xml` starts the JavaFX client.
3. To run the standalone server console, open **Window > IDE Tools > Terminal** and run:

   ```bash
   mvn exec:java -Dexec.mainClass=iti.iwish.server.ServerConsoleApp
   ```

   Alternatively, use **Start local demo server** from the client’s welcome page.

## Demonstration flow

1. Start the local server, then register two accounts.
2. From one account, send a friend request; accept it from the other account.
3. Add a wish from the starter catalog, open **Discover** as the friend, and contribute.
4. Fund the remaining balance to see completion notifications for the receiver and every buyer.


## Team contributions

| Member | Role |
| --- | --- |
| Omar Abdelazim | Database schema, JDBC repository, project documentation and Server LifeCycle |
| Mazen Mahmoud | JavaFX client, visual design, and user experience |
| Mohamed Salama | API models, request/response handling, and network configuration |
| Youssif Nabil | Feature testing, demo scenarios, and API models|
