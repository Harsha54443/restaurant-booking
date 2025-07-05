package com.interview;

import com.interview.controller.BookingController;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;

public class Main {
    public static void main(String[] args) {
        MuServerBuilder builder = MuServerBuilder.httpServer().withHttpPort(8080);
        new BookingController().registerRoutes(builder);
        MuServer server = builder.start();
        System.out.println("Server started at: " + server.uri());
    }
}
