#/bin/sh
src=$1
dst=${src%.*}
g++ $src -o $dst
