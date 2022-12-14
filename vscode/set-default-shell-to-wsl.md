---
title: "Set Default Shell to WSL"
linkTitle: "Set Default Shell to WSL"
date: 2020-11-16
type: docs
draft: false
description: >
  WSL을 VSCode의 기본 쉘로 사용하기
---

1. Click `Ctrl + ,` to open Settings
2. Click tap button `Open Settings(JSON)`
3. Change Value
```JSON
"terminal.integrated.shell.windows":"C:\\Windows\\system32\\wsl.exe",
```
4. store and exit
5. restart VSCode
