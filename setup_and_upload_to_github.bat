@echo off
chcp 65001 >nul
title 🚀 Springboot-cart-backend GitHub 自動上傳工具
cd /d "C:\Users\student\eclipse-workspace\Springboot-cart-backend"

echo ===============================================
echo   🚀 開始初始化、設定與上傳到 GitHub
echo ===============================================
echo.

REM 檢查 Git 是否存在
git --version >nul 2>&1
if errorlevel 1 (
    echo ❌ 未安裝 Git，請先到 https://git-scm.com/downloads 下載並安裝！
    pause
    exit /b
)

REM 檢查是否已設定全域帳號
for /f "tokens=*" %%i in ('git config --global user.name') do set GITUSER=%%i
if "%GITUSER%"=="" (
    echo 🔸 尚未設定 Git 使用者名稱與 Email
    set /p uname=請輸入你的 GitHub 使用者名稱（例如 keyadny10）: 
    set /p uemail=請輸入你的 GitHub Email（註冊用的信箱）: 
    git config --global user.name "%uname%"
    git config --global user.email "%uemail%"
    echo ✅ 已設定 Git 身分。
)

REM 初始化 Git
if not exist ".git" (
    echo 🔸 尚未初始化 Git，正在建立...
    git init
    git branch -M main
    git remote add origin https://github.com/keyadny10/Springboot-cart-backend.git
) else (
    echo 🔹 已偵測到 Git 儲存庫。
)

echo.
echo 🔹 新增所有檔案...
git add .

REM 建立 commit
set /p msg=請輸入提交說明 (commit message): 
if "%msg%"=="" set msg=Update project
git commit -m "%msg%" 2>nul || echo ⚠️ 沒有新變更可提交。

echo.
echo 🔹 檢查 main 分支...
git branch | find "main" >nul || git branch -M main

echo.
echo 🔹 上傳至 GitHub...
git push -u origin main

echo.
echo ===============================================
echo ✅ 上傳完成！請到 GitHub 查看成果：
echo    👉 https://github.com/keyadny10/Springboot-cart-backend
echo ===============================================
pause
