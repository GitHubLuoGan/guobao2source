LJi     T�+  7  +  76   T�+    > +  79 H �socketsDEFAULT_SOCKET_NAME&  +  7   @ �createSocketR 	 4  +  7>D� 7  >BN�G  �setEnabledsockets
pairsJ   4   +  7> D� 7>BN�G  �updatesockets
pairs�  ? T�+  7:  +  7: +  7: )  : )  : 2  : 2  :	 2  :
 2  : '  : '  : )  : )  : ) : )  : +  7: 2 +  7+  79+  7+  79+  7+  79+  7+  79: )  : G  �callbackupdateWorkingSTATE_WORKINGupdateConnectingSTATE_CONNECTINGupdateTryConnectSTATE_TRYCONNECTupdateIdlestateFuncsSTATE_IDLE
statepackerenabledhSocketreceiveStatuslastKeepLiveTimelastActiveTimerecvBuffersendBufferwriteFDreadFD	port	hostHEARTBEAT_DEFAULTheartbeatTIMEOUT_DEFAULTtimeoutDEFAULT_SOCKET_NAME	name   :  G  callback4  	7    T�    C =G  callback   :  G  packer   :  : G  	port	host   :  G  enabled   :  G  timeout   :  G  heartbeatQ  
  7  ) >  7 +  7>G  �STATE_TRYCONNECTsetState
close�  67  +  7 T�+ 77  >T*�7   T�+ 7+ 7% 7 %	 > = + 7
>7   T�+ 7+ 7% 7 % > = + 7
>+ 7+ 7% 7 % > = + 7
>G  ����=sendAsync(),SendAsync with self.state ~= M.STATE_WORKING3sendAsync(),send buffer is nil when send data!stackTrace.sendAsync(),socket is nil when send data!	nameSocket '%s':%sformat
errorhSocketsendBufferinsertSTATE_WORKING
state%     7   >G  sendAsync� d7    T�+  77 % >'��H 7 + 7 T�+  77 % >'��H 7   T� '   T�'  H + 7 >+ 7	 >'   T�'  H + 7
  T�7  7 >+  7% + 7 >$>7   7 >  T�'��H T�4  7>: + 7  > 2  :   T�+ 7	 >'   T�+ 77  >H ����insertsubgetDeviceTimeMOAISimlastActiveTime	senddumpbufferSocket send:

debugdecodepackerenableDumpSendlenconcatsendBuffer5Socket: flush error, state is not STATE_WORKING!STATE_WORKING
state/Socket: flush error, self.hSocket == nil !	name
errorhSocket�  7    T�G  7 7 6  T�   >T�+  7% 7 >G  �Socket: unkown state:
error
statestateFuncsenabled    G  �  ,+  7 > 7% ) > 7% 3 > 7'  > 77 7 >+ 7	7
  >+ 7	7  >:   7 + 7>4  7>: G  ���getDeviceTimeMOAISimlastActiveTimeSTATE_CONNECTINGsetStatehSocketwriteFDreadFDinsert	port	hostconnectsettimeout timeout onlingertcp-nodelaysetoptiontcp�  B+  7 )  7 '  >)   T�  7 + 7>  7 + 7>G  T � T�7 '   T�4  7	>7 7  T�) + 7
  T�+ 77 + 7%	 4
 7 >
 > =  T
�  7 ) >  7 + 7 >G  ����EV_CONNECTFAIL
closehSockettostring/Socket: timeout! hSocket: %s, timeUsed: %dformat	name
debugenableDebugMsggetDeviceTimeMOAISimlastActiveTimetimeoutEV_CONNECTEDOnEventsSTATE_WORKINGsetStatewriteFDselect� q+  7 7 )  '  >) )   T�  7 >  T	� T�T�+ 7%  >)   T
�  7 + 7>  7 ) >G  7	 + 7
 T2�4  7>7 + 7 T
�  7 + 7>4  7>: 7 '   T�4  7>7 + 7 T�) + 7  T�4 7 +	 7		%
 4 7 > >	 = T�  7 >	  T�)   T
�  7 ) >  7 + 7%	 >G  ����send error
flushhSockettostringsocket timeout %s %dformat	name
printenableDebugMsgTIMEOUT_DEFAULTlastActiveTimeEV_KEEPALIVEHEARTBEAT_DEFAULTlastKeepLiveTimegetDeviceTimeMOAISimSTATE_WORKING
state
closeEV_DISCONNECTEDOnEventssocket select read error!	infotimeoutreceivereadFDselect����� 	 >7    T�+  7  T�+ 77 + 7% 4  > = = 7> 7>+ 7	7
  >+ 7	7  >)  :  2  : 2  : '  :   T�  7 +  7>7   T	�7 7  T�7  77 >G  ����onClosepackerSTATE_IDLEsetStatelastActiveTimerecvBuffersendBufferwriteFDreadFDremoveElement
closeshutdowntostringSocket: close socket: %sformat	name
debugenableDebugMsghSocket�  c* 7  ) '  7 Q$�	 7+
  7

>
 	  
  T� 
  T� T� 7 	 7
 >+	 7		
  >	4		 
	 7	
	>	:	 T�)   T� '	  	 T*�+  7  T	�+ 7%	 7
 % + 7+ 7 > = $		>	  7 +
  7

>7 	 77
 + 7 > =2  
  T	� T	�+	 7		
  >	)  T	� T	�) : : 	 
 F	 ����receiveStatusSocket is not connectedclosedunpackEV_DATAARRIVEDOnEventsconcatdumpbuffer]
	nameSocket receive:[	infoenableDumpPackgetDeviceTimeMOAISimlastActiveTimeinsertdecodepackerMAX_RECEIVE_BYTESreceiverecvBufferhSocket   :  G  
state    G  �  L k4   % > 4  % >4  % >4  % >4  % >  >' :' :' :' :	' :
' :' :' :' :' :' :' :'< :' :) :) :) :% :2  :1 :1 :1 :1! : 1# :"1% :$1' :&1) :(1+ :*1- :,1/ :.11 :013 :215 :417 :619 :81; ::1= :<1? :>1A :@1C :B1E :D1G :F1I :H1K :J0  �H  onTimeout setState receive 
close updateWorking updateConnecting updateTryConnect updateIdle update 
flush 	send sendAsync BeginConnect setHeartbeat setTimeout setEnabled setAddress setPacker OnEvents setEventsCallback 	init updateSockets enableAll get createSocketsocketsSOCKET_DEFAULTDEFAULT_SOCKET_NAMEenableDumpPackenableDumpSendenableDebugMsgHEARTBEAT_DEFAULTTIMEOUT_DEFAULTMAX_RECEIVE_BYTESEV_TIMEDOUTEV_KEEPALIVEEV_CONNECTFAILEV_CONNECTEDEV_DATAARRIVEDEV_DISCONNECTEDEV_CLOSEDSTATE_WORKINGSTATE_CONNECTINGSTATE_TRYCONNECTSTATE_IDLEhp/lang/stringhp/util/Loggerhp/lang/tablesockethp/lang/classrequire 