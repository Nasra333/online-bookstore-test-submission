package com.obsms.test.api;

import com.obsms.test.api.service.AppSettingService;
import com.obsms.test.api.service.impl.PreloadedDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = {"com.obsms.test.api"})
@EntityScan(value = {"com.obsms.test.api"})
@ServletComponentScan
public class OnlineBookstoreAppApplication implements ApplicationRunner {

	private final static Logger LOGGER = LoggerFactory.getLogger(OnlineBookstoreAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookstoreAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		LOGGER.info("Application starting ...........");
	}

	@EventListener
	public void readyEvent(ApplicationReadyEvent event) {

		settingService.getAll().iterator().forEachRemaining((e) -> {
			LOGGER.info(e.getAppValue());
		});
	}

	@Autowired
	private AppSettingService settingService;
	@Autowired
	private PreloadedDataService dataService;

}