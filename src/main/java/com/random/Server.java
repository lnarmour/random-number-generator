package com.random;

import java.util.Random;
import static spark.Spark.*;

class Server {

    public Random r = new Random();

    Server(int serverPort) {
        port(serverPort);
        redirect.get("/", "/index.html");
        path("/api", () -> {
            get("/random", (req, res) -> processHttpRequest(res));
        });
    }

    private String processHttpRequest(spark.Response res) {
        res.type("application/json");
        res.status(200);
        return "{\"value\": \"" + r.nextInt(1000) + "\"}";
    }
}
