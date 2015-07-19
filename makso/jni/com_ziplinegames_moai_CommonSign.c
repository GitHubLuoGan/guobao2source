// #include "com_ziplinegames_moai_CommonSign.h"

// JNIEXPORT void JNICALL Java_com_ziplinegames_moai_CommonSign_validateSign(JNIEnv *evn, jclass jc, jstring str) 
// {
// 	return;
   
// }


#include "com_ziplinegames_moai_CommonSign.h"

JNIEXPORT void JNICALL Java_com_ziplinegames_moai_CommonSign_validateSign(JNIEnv *env, jclass obj, jstring str){

    char* pt = (char*)(*env)->GetStringUTFChars(env,str,0); 
    char* mySign = "6a8802c99d7dd56e01045047ab79a41e";

    jclass dpclazz = (*env)->FindClass(env,"com/ziplinegames/moai/CommonSign");


    if(dpclazz==0){return;}

    //2 寻找class里面的方法
    //   jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
    //非静态 (*jniEnv)->GetMethodID(jniEnv, TestProvider, "sayHello","(Ljava/lang/String;)V");

    jmethodID method1 = (*env)->GetStaticMethodID(env,dpclazz,"outputString","(Ljava/lang/String;)V");

    if(method1==0){ return;}

//非静态(*jniEnv)->CallVoidMethod(jniEnv, mTestProvider, sayHello,jstrMSG);
    if(pt != mySign) { (*env)->CallStaticVoidMethod(env,dpclazz,method1,(*env)->NewStringUTF(env,"fuck") );}
    else { (*env)->CallStaticVoidMethod(env,dpclazz,method1,(*env)->NewStringUTF(env,"success") );}
}