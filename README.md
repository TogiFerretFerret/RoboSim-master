# RoboSim
A FTC Simulator
BTW, uhhhh if you want auto map updating
Go to the root of the project and run this (zsh and bash)
```zsh
alias mloop="while True; do cat map.txt; sleep 0.1; clear; done"
mloop
```
This will not work correctly in IntelliJ, due to line spacing
It should work in the terminal though

For Windows, just run map.ps1