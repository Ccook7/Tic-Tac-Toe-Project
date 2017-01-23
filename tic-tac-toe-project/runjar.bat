@echo off
set ROOT_REL_PATH=..
set ROOT_ABS_PATH=
pushd %ROOT_REL_PATH%
set ROOT_ABS_PATH=%CD%
popd

set JAVA=%ROOT_ABS_PATH%\Java\bin

echo %path%|find /i "%JAVA:"=%">nul  || set path=%JAVA%;%path%

set project=%1

call java -jar %project%\libs\tic-tac-toe-1.0.jar
