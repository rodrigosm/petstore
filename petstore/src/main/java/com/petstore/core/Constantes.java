package com.petstore.core;

import io.restassured.http.ContentType;

public interface Constantes {

	String APP_BASE_URL = "https://petstore.swagger.io";
	Integer APP_PORT = 443;  // http -> 80
	String APP_BASE_PATH = "";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 5000L;
}
