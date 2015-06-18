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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log; 
import android.view.Display;
import android.widget.Toast;
 
 
import cn.egame.terminal.paysdk.EgamePay;
import cn.egame.terminal.paysdk.EgamePayListener;
import cn.play.dserv.CheckTool;
import cn.play.dserv.ExitCallBack;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

//////////

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager; 
import android.content.pm.ApplicationInfo;

/////////
 
 
//================================================================//
// MoaiCrittercism
//================================================================//
public class CommonCTCC  extends  CommonBaseSdk {
	 

	public static JsonValue orderParms;
	public static ProgressDialog mProgressDialog;
	public static final String egameAppPackageName = "com.egame";
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

	//SDK初始化	  
	public  void SDKInit(String parms){	 
		Log.d("commonSdk","ctcc init!");
		payCodeConfig.setPayCodeConfig(); 		
		String appid=GetJsonVal(sConfigJsonObject,"appid","0");
		String appkey=GetJsonVal(sConfigJsonObject,"appkey","0");
		EgamePay.init(CommonBaseSdk.sActivity);		
	}
	
	 
	
   private void showToast(String hints) {
       Toast.makeText(sActivity.getApplicationContext(), hints, Toast.LENGTH_SHORT).show();
   }

//退出游戏时
	public void onMDestroy(){
		
		
	}
//是否退出时执行
	public static String V2_exitGame(JsonValue parms){
		
 	Log.d("commonSdk", "V2_exitGame" );
 	
 	CommonBaseSdk.sActivity.runOnUiThread(new Runnable() {		
 		@Override
 		public void run() {
 		
 			CheckTool.exit(CommonBaseSdk.sActivity, new ExitCallBack() { //activity为主Activity

 				@Override
 				public void exit() {
 					//退出游戏操作
 					CommonBaseSdk.sActivity.finish();
 				}

 				@Override
 				public void cancel() {
 					//取消退出，返回游戏
// 					onfinish.callback(false);	 //继续游戏的代码  
 				}
 			});
 			
 		}
 	});
 	
 	return "";
	}

	///打开登陆界面
	public  static String V2_login(JsonValue parms){ 
		//登陆
		//V2_OpenMoreGame(parms);
		 
		 return "OK";
	};
 
 
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
		        channelInfo.add("chn", "ctcc");
		        channelInfo.add("isThirdExit",true);
		        channelInfo.add("isMoreGame",true);
		           
		        Log.d("commonSdk","ResultChannelInfo----->"+ channelInfo.toString());
		        
		        JsonRpcCall(Lua_Cmd_ResultChannelInfo,channelInfo);  
		    }	
		/*********************************cop*************************************/
		
	public static String V2_openMoreGame(JsonValue parms){
			//CheckTool.more(CommonBaseSdk.sActivity);//用不了
				
				Log.d ("commonSdk","V2_openMoreGame");
				try{
					
					Log.d ("commonSdk","V2_openMoreGame --> Normal");
					
					Intent intent = CommonBaseSdk.sActivity.getPackageManager().getLaunchIntentForPackage(egameAppPackageName);
					CommonBaseSdk.sActivity.startActivity(intent);
				}catch(Exception ex){
					
					Log.d ("commonSdk","V2_openMoreGame --> Exception");
					
					Intent intent = new Intent("android.intent.action.VIEW");
					intent.setData(Uri.parse("http://play.cn/"));
					CommonBaseSdk.sActivity.startActivity(intent);
				}
				return "true";
	}

		
	///打开支付界面
	public static String V2_OpenPay(JsonValue parms)
	{ 
		try { 
			
			
			orderParms = parms;
			Log.d("commonSdk","uniPay ---> " + parms.toString());
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
            bConfig.money=total;
            bConfig=payCodeConfig.getPayCodeConfig(bConfig);
            
            
            HashMap<String, String> payParams=new HashMap<String, String>();
			payParams.put(EgamePay.PAY_PARAMS_KEY_TOOLS_ALIAS, bConfig.payCode);
			payParams.put(EgamePay.PAY_PARAMS_KEY_TOOLS_DESC,"");
			ctccPay(payParams);
			
            /*if(checkNetworkAvailable(CommonBaseSdk.sActivity))  
	        { 
            
	        //当前有可用网络  
	        }  
	        else   
	        {  
        	Toast.makeText(CommonBaseSdk.sActivity, "请先连接网络！", Toast.LENGTH_SHORT).show();
           //当前无可用网络  
	        }  */
          
			
		} catch (Exception e) { 
			Log.e("commonSdk", "OpenPay is Error:"+e.getMessage());
		}		
		
		 return "OK";
	}

	

	private static void ctccPay(HashMap<String, String> payParams){
		final Builder dialog=new Builder(CommonBaseSdk.sActivity);
		dialog.setTitle("中国电信支付");
		
		EgamePay.pay(CommonBaseSdk.sActivity, payParams,new EgamePayListener() {
			@Override
			public void paySuccess(Map<String, String> params) {
				//dialog.setMessage("道具"+params.get(EgamePay.PAY_PARAMS_KEY_TOOLS_DESC)+"支付成功");
				//dialog.show();
				JsonObject jsonParms=new JsonObject();
				jsonParms.add("code", 1);
				jsonParms.add("msg", "支付成功");
				jsonParms.add("payData",CommonCTCC.orderParms.asObject());				 
				//计费成功
				CommonBaseSdk.JsonRpcCall(CommonBaseSdk.Lua_Cmd_PayResult,jsonParms);
				
				
			}
			
			 	
			@Override
			public void payFailed(Map<String, String> params, int errorInt) {
				//dialog.setMessage("道具"+params.get(EgamePay.PAY_PARAMS_KEY_TOOLS_DESC)+"支付失败：错误代码："+errorInt);
				//dialog.show();
				String msg="支付失败：错误代码："+errorInt;
				if(errorInt==-100) msg="Activity对象为空";
				if(errorInt==-101) msg="计费文件未找到或者数据读取异常";
				if(errorInt==-102) msg="无法读取当前应用信息";
				if(errorInt==-103) msg="应用校验失败，申报信息和当前产品不一致";
				if(errorInt==-104) msg="非电信用户";
				if(errorInt==-200) msg="初始化失败，无法进行计费";
				if(errorInt==-201) msg="计费回调对象为空";
				if(errorInt==-202) msg="计费道具别名错误";
				if(errorInt==-203) msg="渠道ID数据异常";
				if(errorInt==-204) msg="SERVICE_CODE 数据异常";
				if(errorInt==-205) msg="自定义参数格式异常";
				if(errorInt==-206) msg="计费方法调用过快";
				if(errorInt==-207) msg="计费短信发送失败"; 
					
				JsonObject jsonParms=new JsonObject();
				jsonParms.add("code", errorInt);
				jsonParms.add("msg", msg);
				jsonParms.add("payData",CommonCTCC.orderParms.asObject());				 
				//计费成功
				CommonBaseSdk.JsonRpcCall(CommonBaseSdk.Lua_Cmd_PayResult,jsonParms);
			}
			
			
			@Override
			public void payCancel(Map<String, String> params) {
				//dialog.setMessage("道具"+params.get(EgamePay.PAY_PARAMS_KEY_TOOLS_DESC)+"支付已取消");
				//dialog.show();
				JsonObject jsonParms=new JsonObject();
				jsonParms.add("code", 0);
				jsonParms.add("msg", "支付已取消");
				jsonParms.add("payData",CommonCTCC.orderParms.asObject());				 
				//计费成功
				CommonBaseSdk.JsonRpcCall(CommonBaseSdk.Lua_Cmd_PayResult,jsonParms);
			}
		});
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
			// 设置连接参数...conn.setRequestProperty("xx", "xx");
			conn.setConnectTimeout(10000); // 10s timeout
			// conn.setRequestProperty("accept", "*/*");
			// conn.setRequestProperty("", "");
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
	

 
}

