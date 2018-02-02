@echo off

Rem echo %~d0
echo %cd%

set HOME_PATH="D:\workspace_idea\github\weijiaoyi\target\"

Rem 打开lib目录，遍历目录
cd D:\workspace_idea\github\weijiaoyi\target\lib

Rem 拼接classpath字符串
setlocal enabledelayedexpansion
set CLASS_PATH=classes

for /r %%i in (*.jar) do (
    set CLASS_PATH=!CLASS_PATH!;lib/%%~ni.jar
)

echo %CLASS_PATH%

set JAVA_OPTS=-Xms64m -Xmx128m

cd %HOME_PATH%
echo %cd%

java %JAVA_OPTS% -classpath %CLASS_PATH% com.bird.lanneret.head.Command start

pause