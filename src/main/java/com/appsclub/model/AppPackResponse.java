package com.appsclub.model;

public class AppPackResponse {

    private Application app;
    private PackType pack;
    private PackApp packApp;
    private Operator operator;

    public AppPackResponse(){
        super();
    }

    public AppPackResponse(Application app, PackType pack, PackApp packApp) {
        super();
        this.app = app;
        this.pack = pack;
        this.packApp = packApp;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public PackType getPack() {
        return pack;
    }

    public void setPack(PackType pack) {
        this.pack = pack;
    }

    public PackApp getPackApp() {
        return packApp;
    }

    public void setPackApp(PackApp packApp) {
        this.packApp = packApp;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
