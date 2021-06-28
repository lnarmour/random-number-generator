package com.random;

import java.util.Random;
import java.time.LocalDateTime;
import static spark.Spark.*;

class Server {

    public Random r = new Random();

    Server(int serverPort) {
        port(serverPort);
        redirect.get("/", "/api/random");
        path("/api", () -> {
            get("/random", (req, res) -> processHttpRequest(res));
        });
    }

    private String processHttpRequest(spark.Response res) {
        res.type("application/json");
        res.status(200);
        String ret = "{\"value\": \"" + r.nextInt(1000) + "\"}";
        System.out.println("[" + LocalDateTime.now() + "] -> " + ret);
        return ret;
    }
}
