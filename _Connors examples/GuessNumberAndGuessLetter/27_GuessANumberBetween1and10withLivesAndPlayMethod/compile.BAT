@ECHO OFF

REM ---------------------------------------------------------------------
REM the directory path to javac.exe on your machine may be different
REM from the path I have between the double quotes below to this may
REM need to be changed in order for compile to work on your machine
REM ---------------------------------------------------------------------

REM Remove any previously compiled versions

if exist .\App.class del .\App.class

REM Compile the java code

"C:\Program Files\Java\jdk1.7.0_09\bin\javac.exe" App.java

PAUSE

