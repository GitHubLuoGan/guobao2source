LJ�	 + F+    T�+ 7 % >) : 2  : )  : )  : )  : )  : '
 : ' :	 ' :
 '
 : 2  : '  : 2  : 2  : '  : 2  : '  : 3 2  :: 3 : ) : ) : 3 3 :3 :3  :!3" :#3$ :%3& :': 4) 7*>:( G  ��newMOAIDataBufferioBuffermd5save sqlstringCUPDATE `filelib` set `md5` = #MD5 WHERE `filename` = #FILENAMEmd5load sqlstring=SELECT `md5` FROM `filelib` WHERE `filename` = #FILENAMEdelete sqlstring7DELETE FROM `filelib` WHERE `filename` = #FILENAME	save sqlstringWREPLACE INTO `filelib`(`filename`,`content`,`md5`) VALUES(#FILENAME,#CONTENT,#MD5)	load sqlstringGSELECT `content`,`md5` FROM `filelib` WHERE `filename` = #FILENAMEcreatedb sqlstring~                    CREATE TABLE `filelib`(`filename` STRING PRIMARY KEY ASC,`content` BLOB,`md5` TEXT);
                 fileNamedbbUseDBbDBFirst  downloadingcallbacks out输出文件路径urlhttp地址id fileName
retry sample_ctxIOTaskmaxTaskIderrorTaskspendingTotalpendingNormpendingHighworkingTaskTotalworkingTasksmaxRetrymaxConcurrentTaskmaxConcurrentTask_3GmaxConcurrentTask_WIFI
dbdirresHostresHTTPresRemoteRootmd5TabledownIfNotAvailable!ResourceManager:initialize()
debug    G  "  7   :  H maxTaskIdT   7   T
�4  >D�	 7
 >	BN�G  	data
pairscallbacks� p) 7  7)  '  Q.�	  T,�+    T�+ 7+ 7%	   7
 % >
 = = 4 	  7 %
 > =    7 >   T�T�  T�   T�T	� 7	7	

 7
>:) T �)  :  )  :)   T�+   T		�+ 7+	 7		%
  7>	 = 	  T�77		 T�77	9	T�7:	 7
 >) 77	)
  9
	7:77	)
  9
	  T	�	 7
  >)  :)  :G  ����callbacks_callCBfileNamedownloadingworkingTaskTotalworkingTasks_addTaskObjiderrorTasksmaxRetry
retryurlcode %d,%s
errorhttpTask	dataoutsaveFilegetStringtonumberContent-LengthgetResponseHeaderContent-Length %sformat
debug_owner_ctxIOTask�t  7   T�7 79T�7 797  : G  pendingTotalpendingHighidpendingNormallowCancel� A4   >D:�7 7  T8�)  94 7>	 74
 7

>+    T	�+ 7+	 7		%
	 7
>	 = 	 77

>	 77
 >	 7%
 7 >	 7%
 % >	 7>::7 97  : 7  : T�T�BN�G  ���pendingTotalworkingTaskshttpTask_ctxIOTaskperformAsyncno-cacheCache-ControlresHost	HostsetHeader_onHttpCallbacksetCallbacksetUrlurlHTTP GET %sformat
debugHTTP_GETsetVerbnewMOAIHttpTaskmaxConcurrentTaskworkingTaskTotal
pairs�  $+    T�+ 7 + 7%  > = )  '   7  7 >  T�7  7> T�+ 7  7> )   F ����
cleargetString	loadioBuffer&ResourceManager:_loadFromDisk(%s)format
debug�  <+    T�+ 7 + 7%  > = 7 777 7  T�+ 7+ 7%  > = * + F *   T� 7	7	
> :77	 
 '  >	
 7	>	T� T	�AN�
 7	>		 )
  '  F	 ����
reset
urowsbind_blob	bindsqlstringpreparefile not found: %s
error_sqlitedb	stmt	loaddb$ResourceManager:_loadFromDB(%s)format
debug�  +    T�+ 7 + 7%  > = )   7  7 >  T�7  7> 7  7>H ���
cleargetString	loadioBuffer)ResourceManager:_loadMD5FromDisk(%s)format
debug�  =+    T�+ 7 + 7%  > = 7 777 7  T�+ 7% >G    T� 7	7
> :  T�+ 7%  >G  77 	 '
  >	 7>T� T�AN�	 7> )	  '
  F ���
reset
urowsbind_blob	bindload file fail:sqlstringpreparecannot find sqlite db!
error_sqlitedb	stmtmd5loaddb'ResourceManager:_loadMD5FromDB(%s)format
debug�  +    T�+ 7 + 7%  > = ) 7  7 > 7  7 > 7  7>H ���
clear	savesetStringioBuffer$ResourceManager:_saveToDisk(%s)format
debug�  5+    T�+ 7 + 7%  > = 7 77 77*   T�	 77
> :7	7	

  '  >

	  '  >

  ' + 7 > =
 7
>

  7
>
H ���
reset	stepmd5bind_blob	bindsqlstringprepare	stmt_sqlitedb	savedb"ResourceManager:_saveToDB(%s)format
debug�  +    T	�+ 7 + 7%   > = ) 7  7 > 7  7 > 7  7>H ���
clear	savesetStringioBuffer*ResourceManager:_saveMD5ToDisk(%s,%s)format
debug�  .+    T	�+ 7 + 7%   > = 7 77 77)    T� 77	> :7	7
	 
 '  >		 
 '  >	
 7	>		 
 7	>	H ���
reset	stepbind_blob	bindsqlstringprepare	stmt_sqlitedbmd5savedb(ResourceManager:_saveMD5ToDB(%s,%s)format
debugZ     T�7   T�2 ;: T�4 77  >G  insert
tablecallbacks� .7  6  T�  7  	 >T#�3 : :  7 >:+  7% 7		 7

  >:::2 ;: 7  9  T�7 79T�7 797  : H �pendingTotalpendingHighpendingNormcallbacksallowCancelouturlresRemoteRootresHTTP%s/%s/%sformatid_newIdfileName_owner 
retry addCallbackdownloading� 	 7  4  >D�)  97  : BN�  T�7 4  >D�)  97  : BN�G  pendingHighpendingTotal
pairspendingNormG   	4  7 >D�)  :BN�G  httpTaskworkingTasks
pairs�   >7  T�7  :  7  T�7 : 7  T�7 : 7  T�7 : 7  T�7 : 7  T�7 : 4   T�4 74 7	 T�7 :
 T	�4 7 T�7 :
 T�7 :
 7  T�7 : 7  T�7 : G  downIfNotAvailablemaxRetryCONNECTION_TYPE_WWANmaxConcurrentTaskCONNECTION_TYPE_WIFIconnectionTypeMOAIEnvironmentmaxConcurrentTask_3GmaxConcurrentTask_WIFImd5TableresHostresHTTPremoteRootresRemoteRoot� 	 '7    T�+  7% >G   '   T
�4  >D�)  :)  9BN�7 '   T�  7 7 >7 '   T�  7 7 >G  �pendingNormpendingHigh_processPendingpendingTotalhttpTask
pairserror task is nil!
errorerrorTasks+  +  7  % % @ �//+	gsub� g  7   > +    T�+ 7+ 7%  4	 
 >	4
  >
 = = * '  	  7 
 >7	 6		
	 T
�	 T
�)
 T�)
  
 T$�7   T�  7  >     T�  7	  >   T�  7	  >     T�  7  >     T�
 T�  7
   )  > T�  T	�  	  T�) T�) )  >   F ���newTask_loadFromDisk_loadFromDBbDBFirstmd5TableloadMD5tostring'ResourceManager:loadFile(%s,%s,%s)format
debugnormalizePath e 7    T�) H +  7 7  >	  T�7    T�) H ) H �	find
dbdir� 	 %+    T�+ 7 + 7%  > = )  7   T�  7  >  T�  7  > T	�  7  > 4 7 >H ���deleteFileMOAIFileSystemnormalizePath_deleteFromDBisInDBbDBFirst#ResourceManager:deleteFile(%s)format
debug� 
 &+    T�+ 7 + 7%  > = 7 77 77)    T� 77> :7	 ' 	 > 7
>  7>H ���
reset	step	bindsqlstringprepare	stmt_sqlitedbdeletedb&ResourceManager:_deleteFromDB(%s)format
debug� 
 .+    T�+ 7 + 7%  > =   7  >   7  > )  '  7   T�  7  >  T�  7  	 > T�  7  	 > H ���_saveToDisk_saveToDBisInDBbDBFirstnormalizePath!ResourceManager:saveFile(%s)format
debug�  /+    T�+ 7 + 7%  > = )  7   T�  7  >   T�  7  > T�  7  >   T�7   T�  7  >  T�)  H ���bUseDB_loadMD5FromDisk_loadMD5FromDBbDBFirst ResourceManager:loadMD5(%s)format
debug�  +    T	�+ 7 + 7%   > = ) 7   T�  7   > T�  7   > H ���_saveMD5ToDisk_saveMD5ToDBbDBFirst#ResourceManager:saveMD5(%s,%s)format
debug�   +7  : : : :7
  T�4  >D	�4 
 > T	�7	
  T�7	
 7
>)  :	
B	N	�7 7>)  :7   T�4 7 >:G  	opensqlite3
closefinalize	stmt
table	type
pairs_sqlitedbfileName
dbdirbUseDBbDBFirstdb� 
 !+    T�+ 7 + 7% > = 7   T	�7 77 7 77@ T
�+    T�+ 7 + 7%	 > = G  ���  not use DB, do nothingsqlstring	exec_sqlitedbcreatedbdbbUseDBResourceManager:createDB()format
debug    G      G      G      H #     7   @ getFilePath,     7   ) )  ) @ loadFile� 	 N [4   % > 4  % >4  % >) ) ) '�  >1 :1 :1	 :1 :
1 :1 :1 :1 :1 :1 :1 :1 :1 :1 :1! : 1# :"1% :$1' :&1) :(1+ :*1- :,1/ :.11 :013 :215 :417 :619 :81; ::1= :<1? :>1A :@1C :B1E :D1G :F1I :H1K :J1M :L0  �H  readFile getPath getFilePath clearPaths removePath addPath createDB 
setDB saveMD5 loadMD5 saveFile _deleteFromDB deleteFile isInDB loadFile normalizePath update config resetWorkingTask resetPendingTask newTask addCallback _saveMD5ToDB _saveMD5ToDisk _saveToDB _saveToDisk _loadMD5FromDB _loadMD5FromDisk _loadFromDB _loadFromDisk _processPending _addTaskObj _onHttpCallback _callCB _newId destroy initializehp/lang/stringhp/util/Loggerhp/lang/classrequire 