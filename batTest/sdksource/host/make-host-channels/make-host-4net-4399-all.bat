pushd ..
call make-host.bat 4net 4399 0 true
_tools\notifu /t info /d 10000 /p 友情提示 /m 生成最新android包完成，请到_packages目录下查看apk包
popd