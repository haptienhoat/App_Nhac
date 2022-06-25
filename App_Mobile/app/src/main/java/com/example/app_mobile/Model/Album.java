package com.example.app_mobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Album implements Serializable {

@SerializedName("_id")
@Expose
private String id;
@SerializedName("casi")
@Expose
private String casi;
@SerializedName("hinhalbum")
@Expose
private String hinhalbum;
@SerializedName("idalbum")
@Expose
private String idalbum;
@SerializedName("tenalbum")
@Expose
private String tenalbum;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getCasi() {
return casi;
}

public void setCasi(String casi) {
this.casi = casi;
}

public String getHinhalbum() {
return hinhalbum;
}

public void setHinhalbum(String hinhalbum) {
this.hinhalbum = hinhalbum;
}

public String getIdalbum() {
return idalbum;
}

public void setIdalbum(String idalbum) {
this.idalbum = idalbum;
}

public String getTenalbum() {
return tenalbum;
}

public void setTenalbum(String tenalbum) {
this.tenalbum = tenalbum;
}

}