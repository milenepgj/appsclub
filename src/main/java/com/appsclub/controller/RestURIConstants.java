package com.appsclub.controller;

public class RestURIConstants {

	public static final String GET_APP = "/rest/apps/id={id}";
	public static final String GET_ALL_APP_BY_COUNTRY = "/rest/apps/country={country}";
	public static final String GET_ALL_APP = "/rest/apps";
	public static final String APP_GET_OP_PACK = "/rest/apppack/operator={operator}&pack={pack}";
	public static final String APP_GET_BY_COUNTRY = "/rest/apppack/country={country}";

	public static final String GET_OP = "/rest/operators/{id}";
	public static final String GET_ALL_OP = "/rest/operators";

	public static final String GET_PACK_APP_ID = "/rest/packs/{id}";
	public static final String GET_ALL_PACK_APP = "/rest/packs";

	public static final String GET_PACK_TYPE_APP_ID = "/rest/packtype/id={id}";
	public static final String GET_ALL_PACK_TYPE_APP = "/rest/packtype";
	public static final String GET_ALL_PACK_TYPE_BY_COUNTRY_PACKNAME = "/rest/packtype/country={country}&packname={packname}";

}
