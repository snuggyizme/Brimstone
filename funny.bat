@echo off
setlocal enabledelayedexpansion

echo ================================
echo Mindustry Mod Texture Checker
echo ================================
echo.

set ROOT=%cd%

echo Checking from: %ROOT%
echo.

if not exist assets (
    echo ERROR: No assets folder found.
    echo Expected: assets/sprites/
    pause
    exit /b
)

if not exist assets\sprites (
    echo ERROR: No sprites folder found.
    echo Expected: assets/sprites/
    pause
    exit /b
)

echo Scanning sprite files...
echo.

set foundDrillBase=0
set foundDrillTop=0
set foundDrillRot=0

for /r assets\sprites %%f in (*) do (
    set file=%%~nxf

    echo Found: %%f

    echo !file! | findstr /i "drill-mark-1.png" >nul
    if !errorlevel! == 0 set foundDrillBase=1

    echo !file! | findstr /i "drill-mark-1-top.png" >nul
    if !errorlevel! == 0 set foundDrillTop=1

    echo !file! | findstr /i "drill-mark-1-rotator.png" >nul
    if !errorlevel! == 0 set foundDrillRot=1

    echo !file! | findstr /i ".png.png" >nul
    if !errorlevel! == 0 (
        echo WARNING: Double extension detected -> %%f
    )

    echo !file! | findstr /i ".PNG" >nul
    if !errorlevel! == 0 (
        echo WARNING: Uppercase extension -> %%f
    )
)

echo.
echo ================================
echo Drill Texture Check
echo ================================

if %foundDrillBase%==1 (
    echo OK: drill-mark-1 base found
) else (
    echo MISSING: drill-mark-1.png
)

if %foundDrillTop%==1 (
    echo OK: drill-mark-1-top found
) else (
    echo MISSING: drill-mark-1-top.png
)

if %foundDrillRot%==1 (
    echo OK: drill-mark-1-rotator found
) else (
    echo MISSING: drill-mark-1-rotator.png
)

echo.
echo ================================
echo Done
echo ================================
pause