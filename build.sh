#!/usr/bin/bash
#
# Author: Josh Grant
# Date  : 08/03/2016
#
# BasicClientServer
# Build Script (.sh)

# Declare timestamp function
timestamp() {
  date +"[%T]"
}

# Start
echo "$(timestamp): Initialising build"

# Remove previous bin
cd "./bin/"
echo "$(timestamp): Clearing out ./bin/"
    if [ -a "./BasicClient.class" ]
        then
            echo "$(timestamp): Clearing out ./BasicClient.class"
            rm ./BasicClient.class
            echo "$(timestamp): Cleared out ./BasicClient.class"
    fi
    if [ -a "./BasicServer.class" ]
        then
            echo "$(timestamp): Clearing out ./BasicServer.class"
            rm ./BasicServer.class
            echo "$(timestamp): Cleared out ./BasicServer.class"
    fi
echo "$(timestamp): Cleared out ./bin/"
cd ..

# Build bins
echo "$(timestamp): Building Client/Server bytecode"

    # Build BasicClient
    echo "$(timestamp): Building BasicClient.java bytecode"
    echo "$(timestamp): Dumping javac output to javac_build_log.txt"
    echo "$(timestamp): Beginning BasicClient.java compilation" > "./javac_build_log.txt"
    nohup javac -g -verbose "./src/BasicClient.java" -d "./bin/" > "./javac_build_log.txt"
    echo "$(timestamp): Finished building BasicClient.java bytecode"
    
    # Build BasicServer
    echo "$(timestamp): Building BasicServer.java bytecode"
    echo "$(timestamp): Dumping javac output to javac_build_log.txt"
    echo "$(timestamp): Beginning BasicServer.java compilation" > "./javac_build_log.txt"
    nohup javac -g -verbose "./src/BasicServer.java" -d "./bin/" > "./javac_build_log.txt"
    echo "$(timestamp): Finished building BasicServer.java bytecode"

echo "$(timestamp): Finished building Client/Server bytecode"

# Verify Bytecode in ./bin/
cd "./bin/"
echo "$(timestamp): Verifying compiled bytecode present in ./bin/"
    if [ -a "./BasicClient.class" ]
        then
            echo "$(timestamp): Verified ./BasicClient.class"
    fi
    if [ -a "./BasicServer.class" ]
        then
            echo "$(timestamp): Verified ./BasicServer.class"
    fi
echo "$(timestamp): Verified compiled bytecode present in ./bin/"
cd ..

# Finish
echo "$(timestamp): Build complete"