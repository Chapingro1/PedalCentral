set PI_ADDRESS=root@192.168.1.2
set RELEASE_PATH=build/bin/native/releaseShared/
set LIB_NAME=libkinterop



scp %RELEASE_PATH%%LIB_NAME%.so %PI_ADDRESS%:/usr/lib/
scp %RELEASE_PATH%%LIB_NAME%_api.h %PI_ADDRESS%:/usr/include/

echo "Copying library files done"

