@echo off
SET NUC=backend\

:menu
echo .
echo .
echo Menu Spring Boot Sample :
echo install Install All
echo cu Run a use case
echo cuh Help for use cases
echo launch Launch all SRV 
echo inm mvn install model
echo indao mvn install dao
echo inu mvn install util
echo inS  mvn install SRV S
echo jrS  java run SRV S
rem echo tmSM Test a mapper M for service S
echo S=c client,a account,t transaction, u uti
rem echo Mappers:
rem echo M=c create, u update, l list, g get, d delet
echo x Reload Menu

set /P OP=Opcion: 
goto %OP%
goto menu


rem  ------- Use cases -------------------
rem You need to have groovy 3.0> installed.
rem groovy\bin must be in the path and set GROOVY_HOME
rem You also can download groovy.zip, and set up
rem the variables in scripst\dogroovy.bat

:cu
set /P CU=Use case: 
start "Use case" cmd.exe /c "cd scripts & dogroovy.bat CU %CU%  & pause"
goto menu

:cuh
echo Use case help
start "Caso uso" cmd.exe /c "cd scripts & dogroovy.bat HELP & pause"
goto menu

rem Shortcut use cases
:cu
rem $ es =
start "CU Account Create" cmd.exe /c "dogroovy.bat POST cra & pause"
goto menu


rem -------- instalar componentes -------------



:install
echo Instalar toda la aplicacion
set WD=%CD%
echo WD:%WD%

cd %NU%
start "Install all" cmd.exe /c "cd %NUC% & mvn clean install -DskipTests & pause"
goto menu


:instal_end
cd %WD%
echo %CD%
goto menu

:launch
start "java run srv Client" cmd.exe /c "cd %NUC%srv-client & java -Dspring.profiles.active=dev -jar .\target\srv-client-1.0.0-SNAPSHOT.jar & pause"
start "java run srv Account" cmd.exe /c "cd %NUC%srv-account & java -Dspring.profiles.active=dev -jar .\target\srv-account-1.0.0-SNAPSHOT.jar & pause"
start "java run srv Transaction" cmd.exe /c "cd %NUC%srv-transaction & java -Dspring.profiles.active=dev -jar .\target\srv-transaction-1.0.0-SNAPSHOT.jar & pause"
goto menu


:inm
start "Install model" cmd.exe /c "cd %NUC%model-sbsample & mvn clean install -DskipTests & pause"
goto menu

:indao
start "Install dao-sbsample" cmd.exe /c "cd %NUC%dao-sbsample & mvn clean install -DskipTests & pause"
goto menu

:inc
start "Install srv-client" cmd.exe /c "cd %NUC%srv-client & mvn clean install -DskipTests & pause"
goto menu

:ina
start "Install srv-account" cmd.exe /c "cd %NUC%srv-account & mvn clean install -DskipTests & pause"
goto menu

:int
start "Install srv-transaction" cmd.exe /c "cd %NUC%srv-transaction & mvn clean install -DskipTests & pause"
goto menu

:inca
start "Install cli-account" cmd.exe /c "cd %CLI%cli-account & mvn clean install -DskipTests & pause"
goto menu

:inct
start "Install cli-transaction" cmd.exe /c "cd %CLI%cli-transaction & mvn clean install -DskipTests & pause"
goto menu

:inu
start "Install util-sbsample" cmd.exe /c "cd %NUC%util-sbsample & mvn clean install -DskipTests & pause"
goto menu

:jrc
start "java run srv-client" cmd.exe /c "cd %NUC%srv-client & java -Dspring.profiles.active=dev -jar .\target\srv-client-1.0.0-SNAPSHOT.jar & pause"
goto menu

:jra
start "java run srv-account" cmd.exe /c "cd %NUC%srv-account & java -Dspring.profiles.active=dev -jar .\target\srv-account-1.0.0-SNAPSHOT.jar & pause"
goto menu

:jrt
start "java run srv-transaction" cmd.exe /c "cd %NUC%srv-transaction & java -Dspring.profiles.active=dev -jar .\target\srv-transaction-1.0.0-SNAPSHOT.jar & pause"
goto menu


rem ------------------------------

:srd
start "Spring run srv Account" cmd.exe /c "cd %NUC%srv-account & mvn spring-boot:run -Dspring-boot.run.profiles=dev & pause"
goto menu



:tmrdg
start "Test Mapper srv-acount" cmd.exe /c "cd %NUC%svr-client & mvn test -Dtest=CreateAccountMapperTest & pause"
goto menu

rem Cris private scripts
rem =====================



:eclipse
start cmd.exe /c "cd C:\apps\eclipse & eclipse.exe & exit"
goto menu



:x
rem Reloads this menu calling an extra batch
start scripts\domenu.bat
exit


