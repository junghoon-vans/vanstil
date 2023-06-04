Delete
---

```python
# urls.py
urlpatterns = [
    path('delete/<int:post_id>', views.post_delete, name='post_delete'),
    ...
]
```

```python
# views.py
def post_delete(request, post_id):
    post = get_object_or_404(Post, pk=post_id)
    if post.author == request.user:
        post.delete()
        return redirect('home')
    else:
        return redirect('post_detail', post_id)
```

Update
---

```python
# urls.py
urlpatterns = [
    path('edit/<int:post_id>', views.post_edit, name='post_edit'),
    ...
]
```

```python
# views.py
def post_edit(request, post_id):
    post = get_object_or_404(Post, pk=post_id)
    # 수정 폼 제출
    if request.method == 'POST':
        post.content = request.POST['content']
        # image 파일이 있으면 post 객체에 저장
        if 'image' in request.FILES:
            post.image = request.FILES['image']
        post.save()
        return redirect('/post/'+str(post.id))
    else:
        # 수정 폼
        if post.author == request.user:
            return render(request, 'post_edit.html', {'post': post})
        else:
            return redirect('home')
```