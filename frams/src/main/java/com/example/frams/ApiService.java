package com.example.frams;
import com.example.datas.bean.BaseInfo;
import com.example.datas.bean.MainAdEntity;
import com.example.datas.bean.SpecialtyChooseEntity;

import java.util.List;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {
    @GET("ad/getAd")
    Observable<BaseInfo<MainAdEntity>> getAdvert(@QueryMap Map<String,Object> pMap);
    //选择专业接口
    @GET("lesson/getAllspecialty")
    Observable<BaseInfo<List<SpecialtyChooseEntity>>> getSubjectList();
}
