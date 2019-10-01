Changing Directory Colors
===

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
