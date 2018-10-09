package com.appsclub.controller;

public class EmpRestURIConstants {

	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_EMP = "/rest/emps";
	public static final String CREATE_EMP = "/rest/emp/create";
	public static final String DELETE_EMP = "/rest/emp/delete/{id}";
	public static final String GET_ALL_NAME_ID = "/rest/emps/name={name}&id={id}";

	public static final String DUMMY_APP = "/rest/app/dummy";
	public static final String GET_APP = "/rest/app/{id}";
	public static final String GET_ALL_APP = "/rest/apps";
	public static final String CREATE_APP = "/rest/app/create";
	public static final String DELETE_APP = "/rest/app/delete/{id}";

	public static final String APPPACK_GET_OP_PACK = "/rest/apps/operator={operator}&pack={pack}";
}
