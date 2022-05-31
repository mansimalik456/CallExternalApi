package com.externalApi.serviceImp;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.externalApi.dto.VersionDataDto;
import com.externalApi.model.VersionData;
import com.externalApi.repository.VersionRepository;
import com.externalApi.service.VersionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VersionServiceImplementation implements VersionService {
	
	@Autowired RestTemplate restTemplate;
	@Autowired ObjectMapper mapper;
	@Autowired VersionRepository versionRepository;
	
	
	@Override
	public Object saveVersionData() {
		VersionDataDto data = getData();
		VersionData versionData = mapper.convertValue(data,VersionData.class);
		
		return versionRepository.save(versionData);
	}

	public VersionDataDto getData() {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_JSON);
	      HttpEntity <String> requestEntity = new HttpEntity<String>(headers);
	      
	      String url = "https://stage.communication-scaffold.oodleslab.com/chat-api/v1/public/version/BACKEND";
	      ResponseEntity<Object> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Object.class);
		  System.out.println(exchange); 
		  System.out.println("exchanged data is"+exchange.getBody().toString());
		    
		  HashMap convertValue = mapper.convertValue(exchange.getBody(), HashMap.class);
		  VersionDataDto data = mapper.convertValue(convertValue.get("data"), VersionDataDto.class);
		  
		  return data;
	}
	
	public Object createVersion(VersionDataDto version) {
		
		VersionData versionData = mapper.convertValue(version,VersionData.class);
		System.out.println(versionData);
		versionData.setDeploymentDate(LocalDateTime.now());
		return versionRepository.save(versionData);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
