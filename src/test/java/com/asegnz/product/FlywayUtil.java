package com.asegnz.product;

import org.flywaydb.core.Flyway;

import java.util.HashMap;
import java.util.Map;

public class FlywayUtil {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/postgres";
        final String user = "postgres";
        final String password = "password";
        Map<String, String> map = new HashMap<>();
        //map.put("flyway.baselineVersion", "1000");
        Flyway flyway = Flyway.configure().dataSource(url, user, password).configuration(map).load();
        flyway.clean();
        //flyway.baseline();
    }
}
