Post Form
---

```html
{% extends 'base.html' %}
    
{% block content %}

<br>
<form action="{% url 'new' %}" method="POST" enctype="multipart/form-data">
    {% csrf_token %}
    <input type="file" name="image">
    <br>
    <textarea name="content" cols="50" rows="10" ></textarea>
    <br>
    <input type="submit" value="글쓰기">
</form>
    
{% endblock %}
```

<주요 개념>
- [[get-and-post]]
- [[csrf-token]]

Url path
---
```python
urlpatterns = [
    path('new', page.views.new, name='new'),
    ...
]
```

View
---

```python
from django.shortcuts import redirect
from django.utils import timezone
    
def new(request):
    if request.method == 'POST':
        post = Post()
        post.author = request.user
        post.content = request.POST['content']
        # image 파일이 있으면 post 객체에 저장
        if 'image' in request.FILES:
            post.image = request.FILES['image']
        post.pub_date = timezone.datetime.now()
        post.save()
        return redirect('/detail/'+str(post.id))
    return render(request, 'new.html')
```