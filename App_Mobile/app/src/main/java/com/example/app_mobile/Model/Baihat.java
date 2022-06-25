package com.example.app_mobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Baihat implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("idbaihat")
    @Expose
    private String idbaihat;
    @SerializedName("idalbum")
    @Expose
    private String idalbum;
    @SerializedName("idtheloai")
    @Expose
    private String idtheloai;
    @SerializedName("tenbaihat")
    @Expose
    private String tenbaihat;
    @SerializedName("hinhbaihat")
    @Expose
    private String hinhbaihat;
    @SerializedName("linkbaihat")
    @Expose
    private String linkbaihat;
    @SerializedName("tacgia")
    @Expose
    private String tacgia;
    @SerializedName("casi")
    @Expose
    private String casi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdbaihat() {
        return idbaihat;
    }

    public void setIdbaihat(String idbaihat) {
        this.idbaihat = idbaihat;
    }

    public String getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(String idalbum) {
        this.idalbum = idalbum;
    }

    public String getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(String idtheloai) {
        this.idtheloai = idtheloai;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getHinhbaihat() {
        return hinhbaihat;
    }

    public void setHinhbaihat(String hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }

    public String getLinkbaihat() {
        return linkbaihat;
    }

    public void setLinkbaihat(String linkbaihat) {
        this.linkbaihat = linkbaihat;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

}
