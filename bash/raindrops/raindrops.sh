#!/usr/bin/env bash

main() {
  # local not_divisible=true
  # if [ $(("$1" % 3)) -eq 0 ]; then
  #   printf "Pling"
  #   not_divisible=false
  # fi
  # if [ $(("$1" % 5)) -eq 0 ]; then
  #   printf "Plang"
  #   not_divisible=false
  # fi
  # if [ $(("$1" % 7)) -eq 0 ]; then
  #   printf "Plong"
  #   not_divisible=false
  # fi
  # if [ "$not_divisible" = true ]; then
  #   echo "$@"
  # fi
  (("$1" % 3)) || result+=Pling
  (("$1" % 5)) || result+=Plang
  (("$1" % 7)) || result+=Plong
  echo "${result:-$1}"
}

main "$@"
