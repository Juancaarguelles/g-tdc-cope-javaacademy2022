package com.metereologic;

import com.metereologic.persistence.models.MetereologicalData;
import com.metereologic.service.logicBusiness.MetereologicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MetereologicServiceApplication implements CommandLineRunner {

	@Autowired
	private MetereologicalDataService metereologicalDataService;

	public static void main(String[] args) {
		SpringApplication.run(MetereologicServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.addInfo();
		this.getInfo();
	}

	public void getInfo()
	{
		this.metereologicalDataService.listAll().forEach(System.out::println);
	}

	private void addInfo()
	{


		MetereologicalData metereologicalData1 = new MetereologicalData(LocalDate.of(2022, 8, 26), new BigDecimal("78.3"),
				new BigDecimal("23.456"), new BigDecimal("45.678"), "Bogotá DC", "Cundinamarca");

		MetereologicalData metereologicalData2 = new MetereologicalData(LocalDate.of(2021, 4, 12), new BigDecimal("87.1"),
				new BigDecimal("33.48"), new BigDecimal("45.678"), " Los Angeles", "California");

		MetereologicalData metereologicalData3 = new MetereologicalData(LocalDate.of(2022, 8, 26), new BigDecimal("99.6"),
				new BigDecimal("21.459"), new BigDecimal("45.211"), "Las Vegas", "Nevada");

		List<MetereologicalData>metereologicalDatas1 = new ArrayList<>(Arrays.asList(metereologicalData1, metereologicalData2, metereologicalData3));
		metereologicalDatas1.stream().forEach(this.metereologicalDataService::save);
	}

}
