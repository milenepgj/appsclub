package com.appsclub.controller;


/**
 * Constantes relacionadas aos endpoints
 */

public class RestURIConstants {

	public static final String GET_APP_BY_NAME = "/rest/apps/name={name}";
	public static final String GET_ALL_APP_BY_COUNTRY = "/rest/apps/country={country}";
    public static final String GET_ALL_APP_BY_COUNTRY_PACKNAME = "/rest/apps/packname={packname}&country={country}";
	public static final String GET_ALL_APP = "/rest/apps";
	public static final String GET_ALL_PACK_APP = "/rest/operatorapppacks";
	public static final String APP_GET_OP_PACK = "/rest/operatorapppacks/operator={operator}&pack={pack}";
	public static final String GET_OP_BY_NAME = "/rest/operators/name={name}";
	public static final String GET_ALL_OP = "/rest/operators";
	public static final String GET_PACK_TYPE_APP_NAME = "/rest/packtype/name={name}";
	public static final String GET_ALL_PACK_TYPE_APP = "/rest/packtype";
	public static final String GET_ALL_PACK_TYPE_BY_COUNTRY_PACKNAME = "/rest/packtype/country={country}&packname={packname}";
	public static final String GET_PACKAPP_NAME = "/rest/packapp/name={name}";
	public static final String GET_ALL_PACKAPP_BY_COUNTRY = "/rest/packapp/country={country}";
	public static final String GET_ALL_PACKAPP = "/rest/packapp";
}
