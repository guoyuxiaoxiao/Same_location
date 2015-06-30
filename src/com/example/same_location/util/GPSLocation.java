package com.example.same_location.util;


import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;

public class GPSLocation {

	private Double Latitude;// 纬度
	private Double Longitude;// 经度
	private String serviceName;// 获得位置服务的名称
	private LocationManager locationManager;// 获得位置服务的管理对象
	private Location location = null;
	private Context context;

	public Double getLatitude() {
		return Latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public GPSLocation(Context context) {
		super();
		this.context = context;
		serviceName = context.LOCATION_SERVICE;
		locationManager = (LocationManager) context
				.getSystemService(serviceName);
		location = locationManager
				.getLastKnownLocation(locationManager.GPS_PROVIDER);
		updateToNewLocation(location);
		/** 服务管理对象的监听器 */
		// 参数1：定位的方式 参数2：监听更新间隔时间(ms) 参数3：监听更新的距离(m) 参数4：监听的方法
		locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,
				2000, 10, new LocationListener() {
					public void onStatusChanged(String provider, int status,
							Bundle extras) {
					}

					public void onProviderEnabled(String provider) {
					}

					public void onProviderDisabled(String provider) {
					}

					public void onLocationChanged(Location location) {
						updateToNewLocation(location);
					}
				});
	}

	private void updateToNewLocation(Location location) {
		if (location != null) {
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			this.Latitude = latitude;
			this.Longitude = longitude;
		} else {
			Log.i("error", "location is null");
		}
	}

	
	
	// 此段代码是得到当前GPS的状态 （开启 true 关闭 false）
	public boolean isGPSEnable(Context context) {

		String str = Settings.Secure.getString(context.getContentResolver(),
				Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
		Log.v("GPS", str);
		if (str != null) {
			return str.contains("gps");
		} else {
			return false;
		}
	}
}
