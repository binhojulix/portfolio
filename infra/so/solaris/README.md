# qemu
Opção 1
    cria um disco com o qemu de acordo com o nome dado na entrada
    qemu\qemu-img create -f qcow2 %nome_maquina%.qcow2 12G
Opçao 2
    sobe uma máquina com o disco criado da opção 1
    qemu\qemu-system-sparc -M SS-5 -m 128      -bios bin\ss5.bin -drive file=maquinas-criadas\sft6.img,bus=0,unit=0,media=disk -drive file=cd-instacao-solaris\solaris_2.6_598_sparc.iso,bus=0,unit=6,media=cdrom -netdev tap,id=mynet0,ifname=tap0 -net nic,model=lance,netdev=mynet0 -display vnc=:1 
 
 
qemu-system-sparc -M SS-5 -m 128 -bios ss5.bin -drive file=disk.img,bus=0,unit=0,media=disk -drive file=solaris-2.6-sparc.iso,bus=0,unit=6,media=cdrom -net nic -net tap -display vnc=:1

instalar openvn e criar uma tap com o nome tap
