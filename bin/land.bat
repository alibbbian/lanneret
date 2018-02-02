@echo off

Rem echo %~d0
echo %cd%

set HOME_PATH="D:\workspace_idea\github\weijiaoyi\target\"

Rem 打开lib目录，遍历目录
cd D:\workspace_idea\github\weijiaoyi\target\lib

Rem 拼接classpath字符串
setlocal enabledelayedexpansion
set CLASS_PATH=../classes

for /r %%i in (*.jar) do (
    set CLASS_PATH=!CLASS_PATH!;../lib/%%~ni.jar
)

echo %CLASS_PATH%

cd %HOME_PATH%\bin
echo %cd%
java -classpath %CLASS_PATH% com.bird.lanneret.head.Command shutdown

pause