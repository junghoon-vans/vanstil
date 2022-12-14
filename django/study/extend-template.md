---
title: "Extend Template"
linkTitle: "Extend Template"
date: 2020-11-16
type: docs
draft: false
weight: 6
---

장고에서는 템플릿 상에서 중복되는 코드를 줄이게 도와주는 `템플릿 상속`이라는 기능을 제공한다.

방법
1. 중복되는 부분으로만 구성된 템플릿 생성
2. 해당 템플릿에서 공통되지 않게 하려는 부분만 `{% block %}` 태그를 활용해서 감싼다.

예를 들어서 템플릿 하나를 재사용하는데 이때 달리하고 싶은 부분이 브라우저 탭 상에 출력되는 title이랑 body에 들어가는 내용이라 해보자

```html
<head>
<meta charset="UTF-8">
<title>{% block title %}<!-- override -->{% endblock %}</title>
<!-- favicon.ico -->
<link rel="shortcut icon" href="{% static '/page/images/favicon.ico' %}">
<!-- CSS Styles -->
<link rel="stylesheet" href="{% static '/page/css/style.css' %}">
</head>
<body>
{% block content %}
<!-- override -->
{% endblock %}
</body>
```

위 템플릿은 이러한 경우에 활용할 수 있는 예시이다. 상속의 개념으로 보았을 때 해당 템플릿은 부모 템플릿이며, 이것을 기반으로 한 새로운 자식 템플릿을 생성하는 것도 가능하다.

아래 템플릿은 위에서 작성한 `base.html`을 상속하는 새로운 템플릿이다.

```html
<!-- base.html을 상속한다는 것을 명시 -->
{% extends 'base.html' %}

{% block title %}
<!-- override -->
{% endblock %}

{% block content %}
<!-- override -->
{% endblock %}
```

이렇게 작성해주기만 하면 부모 템플릿에서 작성한 코드를 작성하지 않더라도 동일하게 적용되며, `{% block %}` 태그 사이에 코드를 작성하면 부모 템플릿과 공통된 부분을 공유하면서 차이가 있는 템플릿을 생성할 수 있다.