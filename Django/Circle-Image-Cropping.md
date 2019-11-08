Circle Image Cropping
===

아래 코드를 이용하면 폼을 이용해 업로드한 이미지를 원형으로 자를 수 있다.
> 이미지 변형을 위해 `Pillow` 라이브러리를 우선 설치해두어야 한다.

```Python
from PIL import Image, ImageOps, ImageDraw
from io import BytesIO
from django.core.files.uploadedfile import InMemoryUploadedFile

# make circle image
im = Image.open(request.FILES['image'])
im = im.resize((1920, 1920));
bigsize = (im.size[0] * 3, im.size[1] * 3)
mask = Image.new('L', bigsize, 0)
draw = ImageDraw.Draw(mask)
draw.ellipse((0, 0) + bigsize, fill=255)
mask = mask.resize(im.size, Image.ANTIALIAS)
im.putalpha(mask)

output = ImageOps.fit(im, mask.size, centering=(0.5, 0.5))
output.putalpha(mask)

buffer = BytesIO()
output.save(buffer, format='png')

file = InMemoryUploadedFile(
    buffer,
    '{}'.format(request.FILES['image']),
    '{}'.format(request.FILES['image']),
    'image/png',
    buffer.tell(),
    None,
)

profile.image = file
```

해당 코드는 [Lionstagram](https://github.com/likelionmju/likelionmyongji_lionstagram) 프로젝트에서 원형 프로필 사진 업로드 적용을 위해 사용되었다. 해당 소스 코드가 이 프로젝트에서 어떻게 활용되었는지는 [링크](https://github.com/likelionmju/likelionmyongji_lionstagram/blob/master/account/views.py)를 통해 살펴볼 수 있다.
