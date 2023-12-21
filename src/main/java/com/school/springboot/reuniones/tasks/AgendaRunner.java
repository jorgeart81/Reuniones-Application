package com.school.springboot.reuniones.tasks;

import com.school.springboot.reuniones.services.ReunionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AgendaRunner implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(AgendaRunner.class);

    @Autowired
    private ReunionService reunionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Meetings list: ");
        reunionService.getAllReuniones().forEach(reunion -> {LOG.info(reunion.toString());});
        LOG.info("End of listing");
    }
}
