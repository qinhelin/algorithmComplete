#/bin/sh

set -x
find ./src | grep "\.exe$" | xargs rm
