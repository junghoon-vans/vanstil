---
title: "IOS Build Error"
linkTitle: "IOS Build Error"
date: 2020-11-16
type: docs
draft: false
weight: 1
---

에러메시지
---

```plaintext
flutter failed to build iOS app
Error output from Xcode build:
↳
    ** BUILD FAILED **
Xcode's output:
↳
    Runner.app: resource fork, Finder information, or similar detritus not
    allowed
    Command CodeSign failed with a nonzero exit code
    note: using new build system
    note: building targets in parallel
    note: planning build
    note: constructing build description

Could not build the application for the simulator. Error launching application on iPhone 11 Pro Max.
```

해결 방법
---

- 우선 클라우드(Onedrive 등)가 동기화중인 경로는 사용하지 않음
  - 혹시라도 클라우드가 적용된 폴더에서 작업중이라면 밖으로 이동
- 프로젝트의 루트 경로에서 `xattr -cr .` 명령어 실행
