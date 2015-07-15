package com.ziplinegames.moai;

import com.xiaomi.gamecenter.sdk.MiCommplatform;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;
import com.xiaomi.gamecenter.sdk.entry.MiAppType;

public class XmStatistics {
	
	private static String XmappId = "";
	private static String XmappKey = "";

	
	public static void XmInit(){
		
		CommonLog.d("XM","XmInit Start!!");
		XmappId = CommonBaseSdk.GetJsonVal(CommonBaseSdk.sConfigJsonObject,"XmappId","2882303761517359307");
		XmappKey = CommonBaseSdk.GetJsonVal(CommonBaseSdk.sConfigJsonObject,"XmappKey","5211735967307");
		
		CommonLog.d("XM","XmappId  -->  " + XmappId);
		CommonLog.d("XM","XmappKey  -->  " + XmappKey);
		
		MiAppInfo appInfo = new MiAppInfo();
		appInfo.setAppId(XmappId);
		appInfo.setAppKey(XmappKey); 
		appInfo.setAppType(MiAppType.offline); // 单机游戏
		MiCommplatform.Init( CommonBaseSdk.sActivity, appInfo );
		
		CommonLog.d("XM","XmInit Finish!!");
		
		

	}
	
}
