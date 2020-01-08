[Error 해결] how to fix a corrupt zsh history
===

에러 발생
---

WSL으로 깃 작업을 하던 중 예상치 못한 오류로 컴퓨터 셧다운 이후 해당 오류 발생

```bash
zsh: corrupt history file /home/jeonghun/.zsh_history
```

에러 해결
---

```bash
cd ~
mv .zsh_history .zsh_history_bad
strings .zsh_history_bad > .zsh_history
fc -R .zsh_history
rm ~/.zsh_history_bad
```
