package com.example.same_location.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.platform.comapi.map.j;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.R.string;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class CityLocation {
	private Handler handler;
	public static String CityName = "";
	private Context context;
	private GPSLocation gpsLocation;
	private String APP_KEY = "CAf55eb281e242dc8b1b1815a545a585";

	public CityLocation(Context context, Handler handler) {
		super();
		this.context = context;
		this.handler = handler;
		gpsLocation = new GPSLocation(context);
		getCityName();
	}

	private void getCityName() {
		String url = "http://api.map.baidu.com/geocoder?output=json&location="
				+ gpsLocation.getLatitude() + "," + gpsLocation.getLongitude()
				+ "&key=" + APP_KEY;
		Log.i("location", url);
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				Log.i("location", "error");
			}

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				Log.i("location", responseInfo.result);
				CityName = AnalysisCity(responseInfo.result);
				Log.i("location", CityName);
				Message message = new Message();
				message.what = 1;
				handler.sendMessage(message);
			}
		});
	}

	private String AnalysisCity(String string) {
		String cityName = "";
		int topindex = string.indexOf("addressComponent");
		int bottomindex = string.indexOf("cityCode");
		string = string.substring(topindex + 18, bottomindex - 2);
		try {
			JSONObject jsonObject = new JSONObject(string);
			cityName = (String) jsonObject.get("city");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return cityName;
	}

}
