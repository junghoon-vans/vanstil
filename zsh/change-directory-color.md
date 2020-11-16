---
title: "Changing Directory Color"
linkTitle: "Changing Directory Color"
date: 2020-11-16
type: docs
draft: false
weight: 4
description: >
  Syntax-Highlighting의 디렉터리 강조 색상 변경
---

1. Pick a dircolors theme from Github [repository](https://github.com/seebi/dircolors-solarized)

2. Download files in the user's HOME

```vi
# Download dircolors.ansi-dark
curl https://raw.githubusercontent.com/seebi/dircolors-solarized/master/dircolors.ansi-dark --output ~/.dircolors
```

3. Edit ~/.zshrc
```
# set dircolors
eval `dircolors ~/.dircolors`
```
