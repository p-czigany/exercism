#!/usr/bin/env bash

main() {
  if [ $# -eq 0 ]; then
    other="you"
  else
    other=$1
  fi
  echo "One for $other, one for me."
}

main "$@"
