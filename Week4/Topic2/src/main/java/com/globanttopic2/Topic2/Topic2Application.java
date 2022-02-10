package com.globanttopic2.Topic2;

import com.globanttopic2.Topic2.domain.controllers.PrinterController;
import com.globanttopic2.Topic2.domain.enums.PrinterType;
import com.globanttopic2.Topic2.domain.UI.UIMenu;
import com.globanttopic2.Topic2.domain.configuration.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Topic2Application
{

	public static Scanner input = new Scanner(System.in);
	public static ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);

	public static PrinterType PRINTER_TYPE = PrinterType.NONE;

	public static void main(String[] args)
	{

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Topic2Application.class, args);


		APPLICATION_CONTEXT.getBean(UIMenu.class).showMenu();

		configurableApplicationContext.close();
	}

}
