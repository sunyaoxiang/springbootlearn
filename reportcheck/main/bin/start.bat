@echo off
set path=C:\Program Files\Java\jre1.8.0_91\bin
START "reportcheck" "%path%\javaw" -jar reportcheck-0.0.1-SNAPSHOT.jar 
:java -jar reportcheck-0.0.1-SNAPSHOT.jar
pause