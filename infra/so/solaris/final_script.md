#cria disco qemu-img create -f qcow.sparc.qcow2 9663676416

#sun4u com HD e CD (boot from cd)
C:\Users\fabio-cptm\Documents\qemu\qemu-syste
m-sparc64 -drive file=c:\Users\fabio-cptm\Documents\diskbakup\cptm12.qcow,bus=0,
unit=0,media=disk -drive file=C:\Users\fabio-cptm\Documents\diskbakup\so\solaris
_2.6_598_sparc.iso,bus=0,unit=1,media=cdrom,readonly=on


