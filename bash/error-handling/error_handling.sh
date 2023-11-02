#!/usr/bin/env bash

function print_name {
  echo "Hello, $*"
}

function validate {
  if [ $# -ne 1 ]; then
    echo "Usage: error_handling.sh <person>"
    exit 1
  fi
}

main() {
  validate "$@"

  print_name "$@"
}

main "$@"
