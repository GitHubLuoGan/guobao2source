::================================================================::
:: Copyright (c) 2010-2011 Zipline Games, Inc.
:: All Rights Reserved.
:: http://getmoai.com
::================================================================::

	@echo off
	setlocal
	set CYGWIN=nodosfilewarning
	set channelname=%1%
	set channel_lua_name=%2%
	set projectSrc=%channelname%
	set isdecode=%6%

	if %channelname%==%channel_lua_name% (
		set projectSrc=build_%channelname%
		) else (
		set projectSrc=build_%channelname%_%channel_lua_name%
		)

	adb kill-server
	bash run-host.sh %*

	if %ERRORLEVEL% == 2 (
		set install_cmd=ant release
		set ERRORLEVEL=0
	) else (
		set install_cmd=ant debug
	)
	
	if %ERRORLEVEL% == 0 (
		pushd %projectSrc%\project
 			call ant clean
 			call %install_cmd%
		popd
		if not exist _packages md _packages		 
		copy %projectSrc%\project\bin\*-debug.apk _packages\


		if "%isdecode%" == "true" (
		copy %projectSrc%\project\bin\*-unsigned.apk _packages\
		call decodeAndResign.bat %channelname% %channel_lua_name% 1.1 guobao ::此处版本只影响显示名字
		) else (
		echo %isdecode%
		copy %projectSrc%\project\bin\*-release.apk _packages\
		)
	)

	endlocal
