---
title: "Static & Media"
linkTitle: "Static & Media"
date: 2020-11-16
type: docs
draft: false
weight: 7
---

정적 파일이란?
---

웹 사이트를 구성하는 `html, css, script, image` 파일 등을 의미하는데 보통 장고에서는 정적 파일은 html을 제외한 `css, js, image` 파일을 말한다.

django 정적 파일 유형
---

장고에서 정적파일을 사용하는 방법에는 두 가지가 존재한다.

1. static - 페이지에서 사용하는 기본적인 파일
2. media - 유저가 서비스를 이용하는 중에 발생하는 파일

풀어서 설명하면 개발단계에서부터 정의되는 파일들이 `static`이고, 개발자가 아닌 이용자가 서비스를 이용하는 과정에서 발생하는 데이터(업로드 등)를 바로 `media`이다.

정적 파일 사용법
---

### static

- `STATICFILES_DIRS` : 개발 단게에서 사용하는 정적 파일 위치를 나타냄
- `STATIC_URL` : Static 파일에 접근하기 위한 url
- `STATIC_ROOT` : 실제 서비스 운영 중에 사용되는 정적 파일 위치를 나타냄

```python
# settings.py

STATIC_URL = '/static/'
STATICFILES_DIRS = [
	os.path.join(BASE_DIR, 'app_name', 'static'),
]
STATIC_ROOT = os.path.join(BASE_DIR, 'static')
```

Shell에서 `python manage.py collectstatic` 명령어 실행

> staticfiles_dirs에서 static_root 경로로 옮김


### media

- `MEDIA_URL` : Media 파일에 접근하기 위한 url
- `MEDIA_ROOT` : 업로드되는 파일이 저장되는 위치

```python
# settings.py

MEDIA_URL = '/media/'
MEDIA_ROOT= os.path.join(BASE_DIR, 'media')
```

```python
# urls.py
from django.conf import settings
from django.conf.urls.static import static

urlpatterns += static('/media/', document_root=settings.MEDIA_ROOT)
```