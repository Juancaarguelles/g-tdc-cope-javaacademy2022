package com.globanttopic2.Topic2.domain.configuration;

import com.globanttopic2.Topic2.domain.controllers.PrinterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.globanttopic2.Topic2")
public class AppConfig
{
}
