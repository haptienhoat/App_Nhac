package com.example.app_mobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Casi implements Serializable {

@SerializedName("_id")
@Expose
private String id;
@SerializedName("hinhcasi")
@Expose
private String hinhcasi;
@SerializedName("idcasi")
@Expose
private String idcasi;
@SerializedName("tencasi")
@Expose
private String tencasi;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getHinhcasi() {
return hinhcasi;
}

public void setHinhcasi(String hinhcasi) {
this.hinhcasi = hinhcasi;
}

public String getIdcasi() {
return idcasi;
}

public void setIdcasi(String idcasi) {
this.idcasi = idcasi;
}

public String getTencasi() {
return tencasi;
}

public void setTencasi(String tencasi) {
this.tencasi = tencasi;
}

}