@echo off

Rem ####================================================####
Rem ####
Rem ####================================================####

set SRC_PATH=D:\workspace_idea\github\out\production\lanneret
set OUT_PATH=C:\Users\Administrator\desktop\

d:
cd %SRC_PATH%

jar -cvf %OUT_PATH%lanneret.jar */

echo success from %SRC_PATH% to %OUT_PATH%lanneret.jar

pause