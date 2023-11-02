#!/usr/bin/env bash

main() {
  local sum=0
  for (( i=0; i<${#1}; i++ )); do
    digit="${1:i:1}"
    sum=$((sum + digit ** ${#1} ))
  done
  
  if [ $sum -eq "$1" ]; then
    printf "true"
    return 0
  fi
  printf "false"
}

main "$@"
