@echo off
wmic process where "commandline like '%%-jar reportcheck%%'" call terminate
:taskkill /f /im "javaw.exe"
pause