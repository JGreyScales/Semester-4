package OpenSSL::safe::installdata;

use strict;
use warnings;
use Exporter;
our @ISA = qw(Exporter);
our @EXPORT = qw($PREFIX
                  $BINDIR $BINDIR_REL
                  $LIBDIR $LIBDIR_REL
                  $INCLUDEDIR $INCLUDEDIR_REL
                  $APPLINKDIR $APPLINKDIR_REL
                  $ENGINESDIR $ENGINESDIR_REL
                  $MODULESDIR $MODULESDIR_REL
                  $PKGCONFIGDIR $PKGCONFIGDIR_REL
                  $CMAKECONFIGDIR $CMAKECONFIGDIR_REL
                  $VERSION @LDLIBS);

our $PREFIX             = 'D:\Programming\Semester-4\Mobile and networked systems\week4\Crow_test\vcpkg_installed\vcpkg\blds\openssl\x64-windows-dbg';
our $BINDIR             = 'D:\Programming\Semester-4\Mobile and networked systems\week4\Crow_test\vcpkg_installed\vcpkg\blds\openssl\x64-windows-dbg\apps';
our $BINDIR_REL         = 'apps';
our $LIBDIR             = 'D:\Programming\Semester-4\Mobile and networked systems\week4\Crow_test\vcpkg_installed\vcpkg\blds\openssl\x64-windows-dbg';
our $LIBDIR_REL         = '.';
our $INCLUDEDIR         = 'D:\Programming\Semester-4\Mobile and networked systems\week4\Crow_test\vcpkg_installed\vcpkg\blds\openssl\x64-windows-dbg\include';
our $INCLUDEDIR_REL     = 'include';
our $APPLINKDIR         = 'D:\Programming\Semester-4\Mobile and networked systems\week4\Crow_test\vcpkg_installed\vcpkg\blds\openssl\x64-windows-dbg\ms';
our $APPLINKDIR_REL     = 'ms';
our $ENGINESDIR         = 'D:\Programming\Semester-4\Mobile and networked systems\week4\Crow_test\vcpkg_installed\vcpkg\blds\openssl\x64-windows-dbg\engines';
our $ENGINESDIR_REL     = 'engines';
our $MODULESDIR         = 'D:\Programming\Semester-4\Mobile and networked systems\week4\Crow_test\vcpkg_installed\vcpkg\blds\openssl\x64-windows-dbg\providers';
our $MODULESDIR_REL     = 'providers';
our $PKGCONFIGDIR       = '';
our $PKGCONFIGDIR_REL   = '';
our $CMAKECONFIGDIR     = '';
our $CMAKECONFIGDIR_REL = '';
our $VERSION            = '3.3.0';
our @LDLIBS             =
    # Unix and Windows use space separation, VMS uses comma separation
    split(/ +| *, */, 'ws2_32.lib gdi32.lib advapi32.lib crypt32.lib user32.lib ');

1;
