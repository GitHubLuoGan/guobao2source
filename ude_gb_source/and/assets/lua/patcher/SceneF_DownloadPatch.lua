LJ� 
 +  7   >)  : )  : )  : )  : )  : '  : '  : '  : ' :	 G  �downloadTaskNumpatchCurSecSpeedpatchCurTimerSizepatchCurDownloadSizepatchSpeedTimerpatchUncompressFinishpatchDownloadFinishFuncpatchServerIPpatchServerAddr	initu  
+   7   >4 7% >G  �3==========SceneF_DownloadPatch ENTER==========	infoLoggersetSceneh  +   7 >+  7>  7 >G  ��patchDownload_entershowSpeedaffirmSqliteDBw  4  7  T�+   7>T�4 >G   �exitApppatchDownload_startDIALOG_RESULT_POSITIVEMOAIDialog�*) :  +   7>'   T�4   T�4 7 T�1 4 7%	  >4 7
%  % )  %	 )
  >T�  7 >T�  7 >0  �G  �patchDownload_exitpatchDownload_start退出继续温馨提示showDialogN检测到需要更新或修补的资源(%dkb)需要下载,是否继续？formatstring 	nd91CHANNEL_NAME_GMOAIDialogcheckAllFilepatchUncompressFinish��   7    T�7   7>)  :  4 % >4  7%  7> =G  newpatcher_decompressopenNextSceneSceneManagerpatcher/SceneG_Decompressrequire	stoppatchSpeedTimer� 
4  7	  T�4 7% >+   7% >' : T�+   7% >  7	 >G  �getPatchServerAddr9未检测到wifi信号，正在用默认方式下载downloadTaskNum.检测到wifi信号！正在用wifi下载setTipnetwork type is wifi!!	infoLoggerconnectionTypeMOAIEnvironment�   +   7   +  7  +  : +  7  >+  +  7 :G   �  setSpeedpatchCurSecSpeedpatchCurTimerSizepatchCurDownloadSize)   +     7   > G    onException�  IQ G�)  +   7 >7'  '   T9�4  >T �7	 	 T
�7	 	 T	� T	�+	 
	 7		 7+ >	 	 T
�+
  
 7

% 7	>
)
 :
 T	�)  T�4	
 7		>	AN�   T�+ 7  T�+ ) :+  7% >+  7>G  4
 7>T �G    � �  patchDownload_exit&下载完成，开始解压……setTippatchUncompressFinish
yieldcoroutinever
patchwriteRecord	sizedecompresshasDecompressedhasDownloadipairs	listgetPatchList� &4 7>:  7   7' >7   74 7>1 1 7   74 7	 >7   7
>1 4 7> 7 >0  �G  ��	�runMOAIThread 
startEVENT_TIMER_LOOPsetListener  	LOOPsetModesetSpannewMOAITimerpatchSpeedTimer�  +  :  +  :+  7% >+   7>G   �  startDownloadPatches正在下载资源setTippatchServerIPpatchServerAddr< 1  +  7 >0  �G  ��selectValidAddr �   4  7> 7  4  7>  T�)  H  7'  4  7> 7> 7>H 
closegetCursorSEEK_END	seek	READ	opennewMOAIFileStreamg  ) +    >  T�)   T� T�4  7  >) H 
�deleteFileMOAIFileSystem�  '  +   7 >74  >T�77	4
 7

% + 74	 7
 >
+ 
 	 >  T�	AN�H ���LOCAL_PATCH_PATHpatch_configWORK_ROOT%s/%s/%sformatstring	size	pathipairs	listgetPatchList�  &+  6 7 4 7% + 74 74 7 >+  6 74 7%	 +  >+  7
  +	 +
 + ) + 7   >G  � �� 	��
�patchServerAddrdownload
%s/%s	sizeREMOTE_PATCH_PATHREMOTE_ROOTpatch_configpatchServerIPhttp://%s/%s/%s/%sformatstring	path�   )  4  +  >T�7  T�)  7  T�+  6) :+  >G  AN�G  ��isDownloadinghasDownloadipairs� b+  67   T�+  67   T�+  6:  '  4 +  >T�7	  	 T
�7	 	AN�+   !% % +  7% >+  7%	 >  T	�  T�4 7%		 
  > + '	  	 T�+  +	 :
		 4
 7

%  +  >
$
	+	 		4
 7

% +  7	 + 7> =

 + 	 7
 >+ 	 7
 >+ 	 7
 >G  �  � �  setProgresssetTimeLeftsetDownloadInfopatchCurSecSpeedgetTimeLeftDesc 剩余时间：%s 大小：%.2fMB/%.2fMBpatchCurDownloadSize资源版本：%d -> %d,formatstringpatchVergetLastVerInfo
patchreadRecordipairsdownloadSizePro���q  +  6 ) : +  6 ) :+  6 ' :+ >G  ��downloadSizeProisDownloadinghasDownload�  +  :  +  :+ >+  7% >G     F正在下载资源, 建议将设备放到信号充足的地方。setTippatchServerIPpatchServerAddr�	 +  6 ) : +  6 ) :+  6 '  :1 +  74 7%   > =+  7 >G  � ��  selectValidAddr(下载资源%d异常，正在重连formatstringsetTip downloadSizeProisDownloadinghasDownload� -+   7 >774 7% + 74 7>4	 7
 % $>'  *
 1 1 1 1	 1
   7 >7   T� : ' 7 ' I� >K�0  �G  �����downloadTaskNumsetPatchSpeedTimer     /patchesaffirmPathMOAIFileSystemLOCAL_PATCH_PATHpatch_configWORK_ROOT
%s/%sformatstringtotalSize	listgetPatchList    G      G      G      G  q  	+  7   >4 7% >G  �2==========SceneF_DownloadPatch EXIT==========	infoLoggeronDestroy�  * A4   % > 4  % >    >4  % >4  % >4  % >4  % >4  % >4  %	 >4	  %
	 >	1
 :

1
 :
1
 :
1
 :
1
 :
1
 :
1
 :
1
 :
1
 1 1 :1 :1! : 1# :"1% :$1' :&1) :(0  �H  onDestroy onPause onResume onKeyDown onEnterFrame startDownloadPatches checkAllFile   getPatchServerAddr setPatchSpeedTimer patchDownload_start patchDownload_exit patchDownload_enter onStart onCreate 	initpatcher/PatchDecompresspatcher/PatchDownloadUtilspatcher/PatchUtilspatcher/PatchDatapatcher/PatchUIpatcher/patch_configconfighp/display/Scenehp/lang/classrequire 