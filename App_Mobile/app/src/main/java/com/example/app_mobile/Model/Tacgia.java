package com.example.app_mobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tacgia implements Serializable {

@SerializedName("_id")
@Expose
private String id;
@SerializedName("hinhtacgia")
@Expose
private String hinhtacgia;
@SerializedName("idtacgia")
@Expose
private String idtacgia;
@SerializedName("tentacgia")
@Expose
private String tentacgia;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getHinhtacgia() {
return hinhtacgia;
}

public void setHinhtacgia(String hinhtacgia) {
this.hinhtacgia = hinhtacgia;
}

public String getIdtacgia() {
return idtacgia;
}

public void setIdtacgia(String idtacgia) {
this.idtacgia = idtacgia;
}

public String getTentacgia() {
return tentacgia;
}

public void setTentacgia(String tentacgia) {
this.tentacgia = tentacgia;
}

}