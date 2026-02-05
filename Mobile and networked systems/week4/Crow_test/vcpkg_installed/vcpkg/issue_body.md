Package: openssl:x64-windows@3.3.0#1

**Host Environment**

- Host: x64-windows
- Compiler: MSVC 19.44.35211.0
-    vcpkg-tool version: 2024-06-10-02590c430e4ed9215d27870138c2e579cc338772
    vcpkg-readonly: true
    vcpkg-scripts version: 6f1ddd6b6878e7e66fcc35c65ba1d8feec2e01f8

**To Reproduce**

`vcpkg install `

**Failure logs**

```
-- Downloading https://github.com/openssl/openssl/archive/openssl-3.3.0.tar.gz -> openssl-openssl-openssl-3.3.0.tar.gz...
-- Extracting source C:/Users/JG/AppData/Local/vcpkg/downloads/openssl-openssl-openssl-3.3.0.tar.gz
-- Applying patch cmake-config.patch
-- Applying patch command-line-length.patch
-- Applying patch script-prefix.patch
-- Applying patch windows/install-layout.patch
-- Applying patch windows/install-pdbs.patch
-- Applying patch unix/android-cc.patch
-- Applying patch unix/move-openssldir.patch
-- Applying patch unix/no-empty-dirs.patch
-- Applying patch unix/no-static-libs-for-shared.patch
-- Using source at D:/Programming/Semester-4/Mobile and networked systems/week4/Crow_test/vcpkg_installed/vcpkg/blds/openssl/src/nssl-3.3.0-961d78b8a1.clean
-- Downloading https://github.com/StrawberryPerl/Perl-Dist-Strawberry/releases/download/SP_5380_5361/strawberry-perl-5.38.0.1-64bit-portable.zip -> strawberry-perl-5.38.0.1-64bit-portable.zip...
-- Found external ninja('1.12.1').
-- Getting CMake variables for x64-windows
-- Downloading https://www.nasm.us/pub/nasm/releasebuilds/2.16.01/win64/nasm-2.16.01-win64.zip;https://gstreamer.freedesktop.org/src/mirror/nasm-2.16.01-win64.zip;https://vcpkg.github.io/assets/nasm/nasm-2.16.01-win64.zip -> nasm-2.16.01-win64.zip...
-- Getting CMake variables for x64-windows
-- Downloading https://download.qt.io/official_releases/jom/jom_1_1_4.zip;https://mirrors.ocf.berkeley.edu/qt/official_releases/jom/jom_1_1_4.zip;https://mirrors.ukfast.co.uk/sites/qt.io/official_releases/jom/jom_1_1_4.zip -> jom_1_1_4.zip...
-- Prerunning x64-windows-dbg
-- Building x64-windows-dbg
-- Prerunning x64-windows-rel
-- Building x64-windows-rel
-- Fixing pkgconfig file: D:/Programming/Semester-4/Mobile and networked systems/week4/Crow_test/vcpkg_installed/vcpkg/pkgs/openssl_x64-windows/lib/pkgconfig/libcrypto.pc
-- Fixing pkgconfig file: D:/Programming/Semester-4/Mobile and networked systems/week4/Crow_test/vcpkg_installed/vcpkg/pkgs/openssl_x64-windows/lib/pkgconfig/libssl.pc
-- Fixing pkgconfig file: D:/Programming/Semester-4/Mobile and networked systems/week4/Crow_test/vcpkg_installed/vcpkg/pkgs/openssl_x64-windows/lib/pkgconfig/openssl.pc
-- Downloading https://mirror.msys2.org/mingw/mingw64/mingw-w64-x86_64-pkgconf-1~2.2.0-1-any.pkg.tar.zst;https://repo.msys2.org/mingw/mingw64/mingw-w64-x86_64-pkgconf-1~2.2.0-1-any.pkg.tar.zst;https://mirror.yandex.ru/mirrors/msys2/mingw/mingw64/mingw-w64-x86_64-pkgconf-1~2.2.0-1-any.pkg.tar.zst;https://mirrors.tuna.tsinghua.edu.cn/msys2/mingw/mingw64/mingw-w64-x86_64-pkgconf-1~2.2.0-1-any.pkg.tar.zst;https://mirrors.ustc.edu.cn/msys2/mingw/mingw64/mingw-w64-x86_64-pkgconf-1~2.2.0-1-any.pkg.tar.zst;https://mirror.selfnet.de/msys2/mingw/mingw64/mingw-w64-x86_64-pkgconf-1~2.2.0-1-any.pkg.tar.zst -> msys2-mingw-w64-x86_64-pkgconf-1~2.2.0-1-any.pkg.tar.zst...
-- Downloading https://mirror.msys2.org/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst;https://repo.msys2.org/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst;https://mirror.yandex.ru/mirrors/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst;https://mirrors.tuna.tsinghua.edu.cn/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst;https://mirrors.ustc.edu.cn/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst;https://mirror.selfnet.de/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst -> msys2-msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst...
[DEBUG] To include the environment variables in debug output, pass --debug-env
[DEBUG] Trying to load bundleconfig from C:\Program Files\Microsoft Visual Studio\2022\Community\VC\vcpkg\vcpkg-bundle.json
[DEBUG] Bundle config: readonly=true, usegitregistry=true, embeddedsha=6f1ddd6b6878e7e66fcc35c65ba1d8feec2e01f8, deployment=VisualStudio, vsversion=17.0
[DEBUG] VS telemetry not opted in, disabling metrics
[DEBUG] Feature flag 'binarycaching' unset
[DEBUG] Feature flag 'compilertracking' unset
[DEBUG] Feature flag 'registries' unset
[DEBUG] Feature flag 'versions' unset
[DEBUG] Feature flag 'dependencygraph' unset
Downloading https://mirror.msys2.org/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst
Downloading https://repo.msys2.org/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst
Downloading https://mirror.yandex.ru/mirrors/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst
Downloading https://mirrors.tuna.tsinghua.edu.cn/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst
Downloading https://mirrors.ustc.edu.cn/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst
Downloading https://mirror.selfnet.de/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst
error: Failed to download from mirror set
error: https://mirror.msys2.org/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst: failed: status code 404
error: https://repo.msys2.org/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirror.yandex.ru/mirrors/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirrors.tuna.tsinghua.edu.cn/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirrors.ustc.edu.cn/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst: failed: status code 404
error: https://mirror.selfnet.de/msys2/msys/x86_64/msys2-runtime-3.4.10-4-x86_64.pkg.tar.zst: failed: status code 404
[DEBUG] D:\a\_work\1\s\src\vcpkg\base\downloads.cpp(997): 
[DEBUG] Time in subprocesses: 0us
[DEBUG] Time in parsing JSON: 10us
[DEBUG] Time in JSON reader: 0us
[DEBUG] Time in filesystem: 2010us
[DEBUG] Time in loading ports: 0us
[DEBUG] Exiting after 8.5 s (8499804us)

CMake Error at scripts/cmake/vcpkg_download_distfile.cmake:32 (message):
      
      Failed to download file with error: 1
      If you are using a proxy, please check your proxy setting. Possible causes are:
      
      1. You are actually using an HTTP proxy, but setting HTTPS_PROXY variable
         to `https://address:port`. This is not correct, because `https://` prefix
         claims the proxy is an HTTPS proxy, while your proxy (v2ray, shadowsocksr
         , etc..) is an HTTP proxy. Try setting `http://address:port` to both
         HTTP_PROXY and HTTPS_PROXY instead.
      
      2. If you are using Windows, vcpkg will automatically use your Windows IE Proxy Settings
         set by your proxy software. See https://github.com/microsoft/vcpkg-tool/pull/77
         The value set by your proxy might be wrong, or have same `https://` prefix issue.
      
      3. Your proxy's remote server is out of service.
      
      If you've tried directly download the link, and believe this is not a temporary
      download server failure, please submit an issue at https://github.com/Microsoft/vcpkg/issues
      to report this upstream download server failure.
      

Call Stack (most recent call first):
  scripts/cmake/vcpkg_download_distfile.cmake:270 (z_vcpkg_download_distfile_show_proxy_and_fail)
  scripts/cmake/vcpkg_acquire_msys.cmake:25 (vcpkg_download_distfile)
  scripts/cmake/vcpkg_acquire_msys.cmake:124 (z_vcpkg_acquire_msys_download_package)
  scripts/cmake/vcpkg_acquire_msys.cmake:212 (z_vcpkg_acquire_msys_download_packages)
  scripts/cmake/vcpkg_find_acquire_program(PKGCONFIG).cmake:52 (vcpkg_acquire_msys)
  scripts/cmake/vcpkg_find_acquire_program.cmake:121 (include)
  scripts/cmake/vcpkg_fixup_pkgconfig.cmake:193 (vcpkg_find_acquire_program)
  C:/Users/JG/AppData/Local/vcpkg/registries/git-trees/7407c8c4bb89f961d5e57afb101329454b4771ab/install-pc-files.cmake:32 (vcpkg_fixup_pkgconfig)
  C:/Users/JG/AppData/Local/vcpkg/registries/git-trees/7407c8c4bb89f961d5e57afb101329454b4771ab/portfile.cmake:69 (include)
  scripts/ports.cmake:175 (include)



```

**Additional context**

<details><summary>vcpkg.json</summary>

```
{
  "dependencies": [
    "crow",
    "asio",
    "openssl"
  ]
}

```
</details>
