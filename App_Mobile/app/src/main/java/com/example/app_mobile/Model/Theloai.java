package com.example.app_mobile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Theloai implements Serializable {

@SerializedName("_id")
@Expose
private String id;
@SerializedName("hinhtheloai")
@Expose
private String hinhtheloai;
@SerializedName("idtheloai")
@Expose
private String idtheloai;
@SerializedName("tentheloai")
@Expose
private String tentheloai;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getHinhtheloai() {
return hinhtheloai;
}

public void setHinhtheloai(String hinhtheloai) {
this.hinhtheloai = hinhtheloai;
}

public String getIdtheloai() {
return idtheloai;
}

public void setIdtheloai(String idtheloai) {
this.idtheloai = idtheloai;
}

public String getTentheloai() {
return tentheloai;
}

public void setTentheloai(String tentheloai) {
this.tentheloai = tentheloai;
}

}