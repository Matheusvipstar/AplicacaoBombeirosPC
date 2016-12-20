/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaobombeirospc;

/**
 *
 * @author mathe
 */
class Local {
    private String endereço, url;

    public Local(String endereço, String url) {
        this.endereço = endereço;
        this.url = url;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}