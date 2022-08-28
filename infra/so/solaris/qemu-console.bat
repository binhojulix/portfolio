
@echo off
cls
:menu
cls
color 80

date /t

echo Computador: %computername%        Usuario: %username%
                   
echo            MENU TAREFAS
echo  =============================================
echo * 1. Criar Disco                             * 
echo * 2. Instalar o Sistema Operacional          *
echo * 3. Instalar o Ambiente                     *
echo * 4. Instalar A Aplicacao                    *
echo * 5. Subir Maquina                           *
echo * 6. Sair                                    * 
echo  =============================================

set workdir=%cd%
set aplicacao_dir=\cd de instalação das aplicações
set ambiente_dir=\cd de instalação dos ambientes
set so_dir=cd-instalacao-solaris
set maquina_nome
set maquinas_criadas=maquinas-criadas
set /p opcao= Escolha uma opcao: 
echo ------------------------------
if %opcao% equ 1 goto opcao1
if %opcao% equ 2 goto opcao2
if %opcao% equ 3 goto opcao3
if %opcao% equ 4 goto opcao4
if %opcao% equ 5 goto opcao5
if %opcao% GEQ 6 goto opcao6

:opcao1
cls
set /p maquina_nome= Digite o Nome da maquina:
qemu\qemu-img create -f qcow2 %maquinas_criadas%/%maquina_nome%.img 12G
echo ==================================
echo *      Disco Criado          *
echo ==================================
pause
goto menu

:opcao2
cls
echo            SISTEMAS OPERACIONAIS
echo  =============================================
echo * 1. Solaris 2.6                             * 
echo * 2. Solaris 2.8                             *
echo * 3. Sair                                    * 
echo  =============================================
set /p opcao_so= Escolha o sistema_operacional: 
set arquivos=dir /a:d /b
echo arquivos

if %opcao_so% equ 1 (set v_so=%so_dir%\solaris_2.6_598_sparc.iso)  
if %opcao_so% equ 2 (set v_so=%so_dir%\disco_solaris_8.iso) 
if %opcao_so% GEQ 3 (goto opcao2)
echo %v_so%
qemu\qemu-system-sparc -M SS-5 -m 128 -bios bin\ss5.bin -drive file=%maquinas_criadas%\sft6.img,bus=0,unit=0,media=disk -drive file=%v_so%,bus=0,unit=6,media=cdrom -netdev tap,id=mynet0,ifname=tap0 -net nic,model=lance,netdev=mynet0 -display vnc=:1 
    pause
    cls
    exit
echo ==================================
echo *      Instalar o SO           *
echo ==================================
pause
goto menu

:opcao3
cls
echo ==================================
echo *     Escaneamento de disco       *
echo ==================================
echo *C:\Users\fabio-cptm\Documents\qemu\qemu-system-sparc -M SS-5 -m 128 -bios ss5.bin -drive file=C:\Users\fabio-cptm\Documents\diskbakup\cons8.img,bus=0,unit=0,media=disk -netdev tap,id=mynet0,ifname=tap0 -net nic,model=lance,netdev=mynet0 -display vnc=:1

chkdsk c:
pause
goto menu

:opcao4
cls
control.exe
pause
goto menu

:opcao5
cls
exit

:opcao6
echo ==============================================
echo * Opcao Invalida! Escolha outra opcao do menu *
echo ==============================================
pause
goto menu