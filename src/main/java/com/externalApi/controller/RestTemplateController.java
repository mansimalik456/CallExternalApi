package com.externalApi.controller;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.externalApi.service.VersionService;

@RestController
public class RestTemplateController {
	
	  @Autowired  VersionService versionService;

	  @GetMapping("/save")
	  public @ResponseBody Object saveData() {
		  return versionService.saveVersionData();
	  }

}
