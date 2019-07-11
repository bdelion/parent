@echo off

rem Remember current working directory to revert to it after processing
set old_cd=%CD%

rem Change directory to project root
cd /d "%~dp0\.."

rem Display plugin updates
call mvn org.codehaus.mojo:versions-maven-plugin:display-plugin-updates -Dmaven.version.rules="file:///%~dp0/rules.xml"

rem Revert working directory
cd /d "%old_cd%"

rem Keep results visible
pause