package org.group28projectjpa.databaseMigration.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Slf4j
public class StartupRunner implements CommandLineRunner {
    private final DatabaseConfig databaseConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("Load roles into database table ...");
        databaseConfig.fillRoleTable();
        log.info("Done ...");
    }
}
