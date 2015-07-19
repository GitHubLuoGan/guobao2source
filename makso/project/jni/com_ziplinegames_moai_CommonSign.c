// #include "com_ziplinegames_moai_CommonSign.h"

// JNIEXPORT void JNICALL Java_com_ziplinegames_moai_CommonSign_validateSign(JNIEnv *evn, jclass jc, jstring str) 
// {
// 	return;
   
// }


#include "com_ziplinegames_moai_CommonSign.h"

JNIEXPORT void JNICALL Java_com_ziplinegames_moai_CommonSign_validateSign(JNIEnv *env, jclass jc, jstring str){

    char* pt = (char*)(*env)->GetStringUTFChars(env,str,NULL); 
    char* mySign = "6a8802c99d7dd56e01045047ab79a41e";

    jclass dpclazz = (*env)->FindClass(env,"com/ziplinegames/moai/CommonSign");

    if(dpclazz==0){

        LOGI("find class error");
        return;

    }

    LOGI("find class ");


    //2 寻找class里面的方法

    //   jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);

    jmethodID method1 = (*env)->GetMethodID(env,dpclazz,"outputString","(Ljava/lang/String;)V");

    if(method1==0){

        LOGI("find method1 error");
        return;

    }
    return;

    LOGI("find method1 ");

    //3 .调用这个方法
    //    void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);


    if(pt != mySign) { (*env)->CallVoidMethod(env,method1,"fuck");}
    else { (*env)->CallVoidMethod(env,method1,"succeess");}
}