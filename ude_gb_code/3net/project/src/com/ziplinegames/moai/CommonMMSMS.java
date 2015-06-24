//----------------------------------------------------------------//
// Copyright (c) 2010-2011 Zipline Games, Inc. 
// All Rights Reserved. 
// http://getmoai.com
//----------------------------------------------------------------//

package com.ziplinegames.moai;

 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import mm.purchasesdk.Purchase; 
import mm.purchasesdk.PurchaseSkin;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log; 
import android.view.Display;
import android.widget.Toast;
 
import com.chinaMobile.MobileAgent;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;


import java.util.HashMap;

 
 
//================================================================//
// MoaiCrittercism
//================================================================//
public class CommonMMSMS  extends  CommonBaseSdk {
	 
	public static Purchase purchase=null;
	public  static IAPListener mListener;

	public static JsonValue orderParms;
	public static ProgressDialog mProgressDialog;
	//cop
	public static String configInfo_1 = "{\"tollgate\":[0], \"gifttype\":4,\"itemstype\":1, \"prob\":[0],\"type\":[0],\"mode\":1,\"sdkid\":1,\"merger\":1}";
	public static String copGameId = "";
	public static String copChannelId = "";
	public static String Ip = "";
	public static String copAddr = "";
	public static int recBuyStyle = 1;
	public static String requestUrl ="http://www.baopiqi.com/api/gift.php?gameid=6&qudao=42&uid=5b92f04bbc41526d&ver=1.0.42&os=android-4.2.2&devices=L39u&ip=182.149.194.45&iccid=89860113881048662744&imsi=460018290507233&ratio=1794x1080";
	//cop
	//格式化GateWay链接
	public static JsonObject SDKFormatGateWay(String uid,JsonObject jsonData)
	{
		JsonObject jsonParms=new JsonObject();
		jsonParms.add("gatewayurl", sConfigJsonObject.get("gateWayUrl").asString());
		jsonParms.add("gatewaypath", sConfigJsonObject.get("gateWayPath").asString());	
		jsonParms.add("uid",uid);	
		jsonParms.add("data", jsonData);
		return jsonParms; 
	}
	
	/*********************************cop*************************************/
//获取本机ip
	
	public static String getNetIp() {
		URL infoUrl = null;
		InputStream inStream = null;
		try {
			infoUrl = new URL("http://1111.ip138.com/ic.asp");
			URLConnection connection = infoUrl.openConnection();
		  
			HttpURLConnection httpConnection = (HttpURLConnection)connection;
			int responseCode = httpConnection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK)
			{
				inStream = httpConnection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inStream,"gb2312"));
				StringBuilder strber = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null)
					strber.append(line + "\n");
				inStream.close();
				System.out.println("net-result----->"+strber);
				//从反馈的结果中提取出IP地址
				int start = strber.indexOf("[");
				int end = strber.indexOf("]", start + 1);
				line = strber.substring(start + 1, end);
				return line;
			}
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//获取cop请求串
	public static String getRequestUrl(){
		
		String reseultUrl = "";
		
		try {
			
			
			copGameId = CommonBaseSdk.GetJsonVal(sConfigJsonObject,"copGameId","53");
			copChannelId = CommonBaseSdk.GetJsonVal(sConfigJsonObject,"copChannelId","42");
			Ip = getNetIp();
			copAddr = CommonBaseSdk.GetJsonVal(sConfigJsonObject,"copAddr","http://www.baopiqi.com/api/");
			String deviceCode = Secure.getString(sActivity.getBaseContext().getContentResolver(), Secure.ANDROID_ID);
			
			Log.d("commonSdk", "requestUrl----->copGameId" + copGameId);
			Log.d("commonSdk", "requestUrl----->copChannelId" + copChannelId);
			Log.d("commonSdk", "requestUrl----->Ip" + Ip);
			Log.d("commonSdk", "requestUrl----->copAddr" + copAddr);
			Log.d("commonSdk", "requestUrl----->deviceCode" + deviceCode);
			
			
			TelephonyManager mTelephonyMgr = (TelephonyManager)sActivity.getSystemService(Context.TELEPHONY_SERVICE);
			String imsi = mTelephonyMgr.getSubscriberId();
			String iccid = mTelephonyMgr.getSimSerialNumber();
			String version = "";
			
			Log.d("commonSdk", "requestUrl----->imsi" + imsi);
			Log.d("commonSdk", "requestUrl----->iccid" + iccid);
			
		
			 try {
			        PackageManager manager = sActivity.getPackageManager();
			        PackageInfo info = manager.getPackageInfo(sActivity.getPackageName(), 0);
			        version = info.versionName;
			        
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    
			    Log.d("commonSdk", "requestUrl----->version" + version);
			    
			    String device =  android.os.Build.MODEL;
			    device = device.replace(' ', '_');
			    
			    Log.d("commonSdk", "requestUrl----->device" + device);
			    
			    Display mDisplay = sActivity.getWindowManager().getDefaultDisplay();
			    String W = String.valueOf(mDisplay.getWidth());
			    String H = String.valueOf(mDisplay.getHeight());
			    
			    String ratio = W + 'x' +H;
			    
			    Log.d("commonSdk", "requestUrl----->ratio" + ratio);

			   
			    reseultUrl = copAddr + "gift.php?" + "gameid=" +copGameId + "&qudao=" +copChannelId + "&uid=" +deviceCode + "&ver=" +version;
			    reseultUrl = reseultUrl + "&os=" +"android-"+android.os.Build.VERSION.RELEASE  + "&devices=" +device +"&ip=" +Ip +"&iccid=" +iccid + "&imsi=" + imsi +"&ratio=" +ratio ;
			    
			 
			    Log.d("commonSdk","copRequestUrl------->" + reseultUrl);
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		return reseultUrl;
	}
	
	public void doCop(){
		
		requestUrl = getRequestUrl();
		Log.d("commonSdk", "requestUrl----->" + requestUrl);
		
 		String configInfo = sendGet(requestUrl);
 		configInfo = configInfo.replace(":,", ":1,");
 		
 		JsonObject dataJson;
 		try{
 			dataJson = JsonObject.readFrom(configInfo);
 		    
 		}catch(Exception e){
 			dataJson = JsonObject.readFrom(configInfo_1);
 		}
	
 		Log.d("commonSdk","copDataRespon------->" + dataJson.toString());
 		recBuyStyle = CommonBaseSdk.GetJsonValInt(dataJson, "gifttype", 1);
 		
 		if(recBuyStyle > 10){
 		recBuyStyle = recBuyStyle%10 + 1;
 		}
 		else { recBuyStyle = recBuyStyle/10 + 1; }
 		
	}
	
	/*********************************cop*************************************/	
	
	
	
	public void ResultChannelInfo(){
	         
			Log.d("commonSdk","ResultChannelInfo");	
			
			doCop();	
			
	        JsonObject channelInfo=new JsonObject();
	        channelInfo.add("recBuyStyle", recBuyStyle);
	        channelInfo.add("chn", "mm");
	           
	        Log.d("commonSdk","ResultChannelInfo----->"+ channelInfo.toString());
	        
	        JsonRpcCall(Lua_Cmd_ResultChannelInfo,channelInfo);  
	    }	
	/*********************************cop*************************************/
	
	
	//SDK初始化	  
	public  void SDKInit(String parms){	 	
		Log.d("commonSdk", "mmInit");
			
		MMInit("");
	}
	
	public void MMInit(String parms){
		payCodeConfig.setPayCodeConfig();
		
		Log.d("commonSdk", "MMIniting .....");
		
		if(purchase==null)
			purchase = Purchase.getInstance();
		
		Log.d("commonSdk", "MMInit --->  purchase ="+purchase.toString());
		
		IAPHandler iapHandler = new IAPHandler(CommonBaseSdk.sActivity);
		mListener = new IAPListener(CommonBaseSdk.sActivity, iapHandler);
		
		Log.d("commonSdk", "MMInit --->  mListener ="+mListener.toString());
		Log.d("commonSdk", "MMInit --->  sActivity ="+sActivity.toString());
		
		String appid=GetJsonVal(sConfigJsonObject,"appid","0");
		String appkey=GetJsonVal(sConfigJsonObject,"appkey","0");
		
		Log.d("commonSdk", "MMInit --->  appid ="+appid);
		Log.d("commonSdk", "MMInit --->  appkey ="+appkey);
		
		purchase.setAppInfo(appid, appkey,PurchaseSkin.SKIN_SYSTEM_ONE);  // 设置计费应用ID和Key (必须)
		try { 
			
			Log.d("commonSdk", "purchase.init.....");
			purchase.init(sActivity, mListener); //初始化，传入监听器
          

		} catch (Exception e) {
			Log.e("commonSdk", "purchase.init error....." + e.getMessage());
			return;
		}
		
	}
	
	

	
   private void showToast(String hints) {
       Toast.makeText(sActivity.getApplicationContext(), hints, Toast.LENGTH_SHORT).show();
   }

public void onMResume(){
	Log.d("commonSdk", "onMResume ---->" + sActivity.getLocalClassName() );
	   MobileAgent.onResume(sActivity); 
	}
   
   public void onMPause(){	
	   
	   Log.d("commonSdk", "onMPause ---->" + sActivity.getLocalClassName() );
	   MobileAgent.onPause(sActivity); 
	   
	} 


//退出游戏时
	public void onMDestroy(){
		
	 
	}

	///打开登陆界面
	public  String OpenLogin(JsonValue parms){ 
		//登陆
	 
		 return "OK";
	};

    
	///打开支付界面
	public static String V2_OpenPay(JsonValue parms)
	{ 
		Log.d("commonSdk", "mmsmsPay:   "+ parms.toString() );
		try { 
			orderParms=parms;
			JsonObject _json = parms.asObject();
			
            JsonObject  payinfoJson=_json.get("payInfo").asObject();
            JsonObject  userinfoJson=_json.get("userInfo").asObject();
            
            String OrderNo=GetJsonVal(payinfoJson,"orderno","000");

            int price=GetJsonValInt(payinfoJson,"price",0);

            int total=GetJsonValInt(payinfoJson,"total",0);

            String number=GetJsonVal(payinfoJson,"number","0");
            String roleId=GetJsonVal(userinfoJson,"roleId","12345678912345677");
            if(roleId.length()>16) roleId=roleId.substring(0, 16);
           
            
            payCodeConfig bConfig=new payCodeConfig();
            bConfig.number=number;
            bConfig.money=price;
            bConfig=payCodeConfig.getPayCodeConfig(bConfig);
            if(checkNetworkAvailable(CommonBaseSdk.sActivity))  
	        {  
            	Log.d("commonSdk", "PayInfo:   price "+ String.valueOf(price));
            	Log.d("commonSdk", "PayInfo:   code  "+ bConfig.payCode);
	            purchase.order(CommonBaseSdk.sActivity, bConfig.payCode,1,"",true, mListener);
	        //当前有可用网络  
	        }  
	        else   
	        {  
        	Toast.makeText(CommonBaseSdk.sActivity, "请先连接网络！", Toast.LENGTH_SHORT).show();
            //当前无可用网络  
	        }  
          
			
		} catch (Exception e) { 
			
			System.err.println(e);
			
		}		
		
		 return "OK";
	}

	///SDK会员中心 
	public String OpenMemberCenter(JsonValue parms){
		  
		 return "OK";	
	}
	 
	///退出游戏
	public String ExitGame(JsonValue parms){
		  return "OK";	 
	}
 
	
	//角色信息
	public String SetCharInfo(JsonValue parms){
		 
		return "";
	}


		/********************* 发送buy_m请求 *************************/
	/**
	 * @param url
	 *            传入的url,包括了查询参数
	 * @return 返回get后的数据
	 */
	public static String sendGet(String url) {
		String result = "";
		// String
		URL realURL = null;
		URLConnection conn = null;
		BufferedReader bufReader = null;
		String line = "";
		try {
			realURL = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("url 格式错误");
		}
		try {
			conn = realURL.openConnection();
			conn.setConnectTimeout(10000); // 10s timeout
			conn.connect(); // 连接就把参数送出去了 get方法
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接错误");
		}
		try {
			bufReader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			while ((line = bufReader.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取数据错误");
		} finally {
			// 释放资源
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/********************* 发送buy_m请求 *************************/
 
	
	/**
	 * 将字符串转成MD5值
	 * 
	 * @param string
	 * @return
	 */
	public static String stringToMD5(String string) {
		byte[] hash;

		try {
			hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}

		return hex.toString().substring(8, 24);
	}
	
	public static boolean checkNetworkAvailable(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {
			return false;
		} else {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						NetworkInfo netWorkInfo = info[i];
						if (netWorkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
							return true;
						} else if (netWorkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
							return true;
						}
					}
				}
			}
		}

		return false;

	}
	    
	
	public static void showProgress(String tips)
	{
		mProgressDialog = new ProgressDialog(CommonBaseSdk.sActivity);
		mProgressDialog.setMessage(tips);
		mProgressDialog.setIndeterminate(true);
		mProgressDialog.setCancelable(false);
		mProgressDialog.show();
	}
	
	public static void hideProgress()
	{ 
		if(mProgressDialog != null)
		{
			mProgressDialog.cancel();
			mProgressDialog = null;
		} 
	}
	

 
}

