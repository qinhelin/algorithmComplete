#/bin/sh

set -x
find ./src | grep "\.cpp$" | xargs sh build_cpp.sh 
