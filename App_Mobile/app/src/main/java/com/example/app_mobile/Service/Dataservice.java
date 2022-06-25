package com.example.app_mobile.Service;

import com.example.app_mobile.Model.Album;
import com.example.app_mobile.Model.Baihat;
import com.example.app_mobile.Model.Casi;
import com.example.app_mobile.Model.Tacgia;
import com.example.app_mobile.Model.Theloai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Dataservice {
    @GET("baihat")
    Call<List<Baihat>> GetDataBanner();
    @GET("theloai")
    Call<List<Theloai>> GetCategory();
    @GET("casi")
    Call<List<Casi>> GetCasi();
    @GET("album")
    Call<List<Album>> GetAlbum();
    @GET("tacgia")
    Call<List<Tacgia>> GetTacgia();

    @GET("baihat/id")
    Call<List<Baihat>> GetDanhsachbaihat(@Query("idbaihat") String idbaihat);

    @GET("baihat/album")
    Call<List<Baihat>> GetDanhsachbaihatAlbum(@Query("idalbum") String idalbum);

    @GET("baihat/theloai")
    Call<List<Baihat>> GetDanhsachbaihatTheloai(@Query("idtheloai") String idtheloai);
    @GET("baihat/tacgia")
    Call<List<Baihat>> GetDanhsachbaihatTacgia(@Query("tacgia") String tacgia);

    @GET("baihat/casi")
    Call<List<Baihat>> GetDanhsachbaihatCasi(@Query("casi") String casi);

    @GET("baihat/search")
    Call<List<Baihat>> GetSearchBaihat(@Query("tukhoa") String tukhoa);

    @GET("album/search")
    Call<List<Album>> GetSearchAlbum(@Query("tukhoa") String tukhoa);

    @GET("theloai/search")
    Call<List<Theloai>> GetSearchTheloai(@Query("tukhoa") String tukhoa);

    @GET("casi/search")
    Call<List<Casi>> GetSearchCasi(@Query("tukhoa") String tukhoa);

    @GET("tacgia/search")
    Call<List<Tacgia>> GetSearchTacgia(@Query("tukhoa") String tukhoa);
}
