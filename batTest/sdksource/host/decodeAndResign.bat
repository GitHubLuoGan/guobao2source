
	@echo off
	setlocal
	set CYGWIN=nodosfilewarning
	
	set channel_name=%1%
	set channel_lua_name=%2%
	set version_name=%3%
	set gameName=%4%
	set mymonth=%DATE:~5,2%
	set day=%date:~8,2%

	echo %channel_lua_name%

	set packagePath=%cd%\_packages
	set mmXmlPath=%cd%\project\%channel_name%_%channel_lua_name%
	set keyPath=%cd%\key\%channel_name%_key

	if "%channel_name%"=="%channel_lua_name%" (
		set apk_name=%gameName%_V%version_name%_AllInOne_%channel_name%_%mymonth%%day%-release-unsigned.apk
		set signPackageName=%gameName%_V%version_name%_AllInOne_%channel_name%_%mymonth%%day%-release.apk
		echo "equal"
		) else (
		set apk_name=%gameName%_V%version_name%_AllInOne_%channel_name%_%channel_lua_name%_%mymonth%%day%-release-unsigned.apk
		set signPackageName=%gameName%_V%version_name%_AllInOne_%channel_name%_%channel_lua_name%_%mymonth%%day%-release.apk
		echo "unequal"
		)

	echo "++++++++++++++++++++++++++++++反编译进行中+++++++++++++++++++++++++++++++++"
	set xml1=%mmXmlPath%\CopyrightDeclaration.xml
	set xml2=%mmXmlPath%\mmiap.xml
	
	echo %xml1%
	echo %xml2%
	copy %xml1% %cd%
	copy %xml2% %cd%
	

	
	if exist %xml1% (
	_tools\apktool\aapt r %packagePath%\%apk_name% CopyrightDeclaration.xml mmiap.xml
	_tools\apktool\aapt a %packagePath%\%apk_name% CopyrightDeclaration.xml mmiap.xml
	del mmiap.xml
	del CopyrightDeclaration.xml
	echo "+++++++++++++++++++++++++++反编译完成，签名中+++++++++++++++++++++++++++++++"
	jarsigner -verbose -keystore %keyPath% -signedjar %packagePath%\%signPackageName% %packagePath%\%apk_name% 3gu 
	del %cd%\_packages\%apk_name%
	echo "+++++++++++++++++++++++++++签名完成+++++++++++++++++++++++++++++++"
	
		) else (

		echo "不存在MM计费文件，反编译结束！！！！"
		)

	endlocal
