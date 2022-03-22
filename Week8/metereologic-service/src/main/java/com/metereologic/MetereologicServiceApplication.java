package com.metereologic;

import com.metereologic.persistence.models.Location;
import com.metereologic.persistence.models.MetereologicalData;
import com.metereologic.service.logicBusiness.LocationService;
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
	private LocationService locationService;
	@Autowired
	private MetereologicalDataService metereologicalDataService;

	public static void main(String[] args) {
		SpringApplication.run(MetereologicServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.addInfo();
		this.getInfo();
		this.lastTest();
	}

	public void getInfo()
	{
		this.locationService.listAll().forEach(System.out::println);
		this.metereologicalDataService.listAll().forEach(System.out::println);
	}

	private void addInfo()
	{
		Location lo1 = new Location( new BigDecimal("23.5"), new BigDecimal("34.56"), "Bogota", "Cundinamarca");
		Location lo2 = new Location( new BigDecimal("23.57"), new BigDecimal("32.6"), "Los Angeles", "California");
		Location lo3 = new Location( new BigDecimal("23.54"), new BigDecimal("34.34"), "Texas", "Houston");

		List<Location>locations = new ArrayList<>(Arrays.asList(lo1, lo2, lo3));
		locations.stream().forEach(this.locationService::save);

		MetereologicalData metereologicalData1 = new MetereologicalData(LocalDate.of(2022, 8, 26), new BigDecimal("78.3"));
		MetereologicalData metereologicalData2 = new MetereologicalData(LocalDate.of(2022, 3, 12), new BigDecimal("89.5"));
		MetereologicalData metereologicalData3 = new MetereologicalData(LocalDate.of(2022, 6, 5), new BigDecimal("103.4"));


		metereologicalData1.setLocation(this.locationService.getById(1));
		metereologicalData2.setLocation(this.locationService.getById(2));
		metereologicalData3.setLocation(this.locationService.getById(3));


		List<MetereologicalData>metereologicalDatas1 = new ArrayList<>(Arrays.asList(metereologicalData1, metereologicalData2, metereologicalData3));
		metereologicalDatas1.stream().forEach(this.metereologicalDataService::save);
	}

	private  void lastTest()
	{

		MetereologicalData metereologicalData1 = new MetereologicalData(LocalDate.of(2000, 1, 25), new BigDecimal("104.6"));
		metereologicalData1.setLocation(this.locationService.getById(1));
		this.metereologicalDataService.save(metereologicalData1);
	}

}
