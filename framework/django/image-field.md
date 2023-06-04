이미지를 업로드할 수 있는 모델을 생성하기 위해서는 우선적으로 media 설정이 필요하다. 만약 진행하지 않았다면 해당 [[static-and-media]]를 참고하여 진행하도록 한다.

```python
# models.py
from django.conf import settings

class Post(models.Model):
    image = models.ImageField(upload_to='images/', blank=True)
    ...
```

> 해당 소스코드가 사용된 전체 코드는 [다음 주소](https://github.com/likelionmju/likelionmyongji_lionstagram/blob/master/page/models.py)를 통해서 확인해볼 수 있다.

`Post`라는 글을 작성하기 위한 모델에 `image`라는 필드를 만들었다. 여기에는 models 클래스의 ImageField 메소드가 사용된다.

> upload_to 속성은 이미지 업로드 시 경로를 의미하며, settings.py에서 설정한 media 경로가 기준인 상대 경로를 말한다.

만약 모델이 수정되었으면 마이그레이션을 해주어야 한다.

- `python manage.py makemigrations`
- `python manage.py migrate`

이후 이미지를 활용하기 위한 파이썬 패키지를 설치한다.

- `pip install pillow`

이제 파일 업로드가 가능하게 되었을 것이다. 템플릿 상에서 위 모델로 생성된 글의 이미지를 출력하려 한다면 다음과 같이 사용하면 된다.

```html
<img src="{{post.image.url}}" alt="...">
<!-- post는 Post로 생성된 객체 하나를 의미-->
```