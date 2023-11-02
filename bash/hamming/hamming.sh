#!/usr/bin/env bash

main() {
  if [ "$#" -ne 2 ]; then
    echo "Usage: hamming.sh <string1> <string2>"
    exit 1
  fi

  if [ "${#1}" -ne "${#2}" ]; then
    echo "strands must be of equal length"
    exit 1
  fi

  local diff=0
  for ((i = 0; i < ${#1}; i++)); do
    if [ "${1:i:1}" != "${2:i:1}" ]; then
      ((diff++))
    fi
  done
  echo "$diff"
}

main "$@"
