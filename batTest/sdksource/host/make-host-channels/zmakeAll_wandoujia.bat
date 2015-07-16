@echo off
setlocal Enabledelayedexpansion

::for %%i in (make-host-*.bat) do call %%i
::for %%i in (make-host-*.bat) do call %%i true

pushd wdj
::for %%i in (make-host-*.bat) do call %%i
for %%i in (make-host-*.bat) do call %%i true
popd

pushd ..\_packages
for %%i in (*-debug.apk) do (
	set R=%%i
	set T=!R:~0,-10!.apk
	ren !R! !T!
)
for %%i in (*-release.apk) do (
	set R=%%i
	set T=!R:~0,-12!.apk
	ren !R! !T!
)
popd

echo 打包完成！
pause