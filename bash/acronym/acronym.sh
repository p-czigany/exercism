#!/usr/bin/env bash

main() {
  IFS=" -_*"

  for word in $1; do
    echo -n "${word:0:1}" | tr '[:lower:]' '[:upper:]'
  done

  IFS=" "
}

main "$@"
