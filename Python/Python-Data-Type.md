파이썬 자료형
===

프로그래밍을 하는데 있어서 자료형은 매우 중요하다. 어떤 형태의 데이터를 활용할 것인가에 따라서 사용해야 하는 자료형이 달라지기 때문이다. 프로그래밍을 본격적으로 시작하기에 앞서 파이썬에 어떤 자료형이 존재하는지를 숙지하도록 하자. 

Contents
---
- [숫자형](#숫자형)
  - [종류](#종류)
    - [int](#int)
    - [float](#float)
    - [Complex](#complex)
  - [operations](#operations)
- [문자열 자료형](#문자열-자료형)
  - [표현 방식](#표현-방식)
    - [일반적인 따옴표](#일반적인-따옴표)
    - [연속적인 따옴표](#연속적인-따옴표)
  - [연산](#연산)
    - [더하기](#더하기)
    - [곱하기](#곱하기)
  - [인덱싱과 슬라이싱](#인덱싱과-슬라이싱)
  - [포매팅](#포매팅)
  - [관련함수](#관련함수)
- [리스트 자료형](리스트-자료형)
    - [리스트 인덱싱과 슬라이싱](#리스트-인덱싱과-슬라이싱)
    - [리스트 관련함수](#리스트-관련함수)
    - [리스트 연산](#리스트-연산)
- [튜플 자료형](#튜플-자료형)
- [딕셔너리 자료형](#딕셔너리-자료형)
  - [요소 변경/추가/삭제](#요소-변경추가삭제)
  - [딕셔너리 관련함수](#딕셔너리-관련함수)
- [논리형](#논리형)
    - [관련 연산자](#관련-연산자)
    - [자료형의 참 거짓](#자료형의-참-거짓)

숫자형
---

### 종류
#### int

정수형(integer)은 음의 정수, 양의 정수, 0을 표현할 수 있다.

```python
>>> a = 124
>>> a = -63
>>> a = 0
>>> type(a) # 데이터 자료형 반환
<class 'int'>
```

> 여기서 a는 데이터를 담는 변수이다.

<details><summary>변수란?</summary>

데이터를 저장할 수 있는 공간으로 다양한 자료형들의 값을 담기 위해서 사용한다. 

```python
>>> a = 'python'
>>> a
'python'
>>> a = 3
>>> a
3
```

</details>

#### float

실수형(Floating-point)은 소수점이 포함된 숫자를 말한다.

```python
>>> a = 2.35
>>> type(a)
<class 'float>
```

#### Complex

복소수(Complex) 자료형은 두가지 방법으로 사용 가능하다.

```python
>>> a = complex(1, 3)
>>> a
(1+3j)
>>> type(a)
<class 'complex'>
>>> a = 2-4j
>>> type(a)
<class 'complex'>
```

### operations

| Operation | Result |
|----------|--------|
| x + y | x와 y의 합 |
| x - y | x와 y의 차 |
| x * y | x와 y의 곱 |
| x / y | x와 y의 몫 |
| x // y | x와 y의 몫(소수점 포함) | 
| x % y | x와 y의 나머지 |
| -x | x의 부정 |
| +x | x |
| abs(x) | 절대값 x |
| int(x) | x를 정수로 변환 |
| float(x) | x를 실수로 변환 |
| complex(re, im) | re: 실수부, im: 허수부(기본값 0)
| c.conjugate() | 복소수 c의 켤레복소수 |
| divmod(x, y) | 몫과 나머지(a//b, a%b과 동일) |
| pow(x, y) | x의 y 제곱근 |
| x ** y | x의 y제곱 |

문자열 자료형
---

문자열(String)은 문자의 집합으로 이루어진 것으로 작은 따옴표`(' ')`나 큰 따옴표`(" ")` 사이에 작성한다. 

### 표현 방식

파이썬에서는 다른 언어와 다르게 문자열을 표현하는 방법으로 4가지를 제공한다.
- 작은 따옴표(' ')
- 큰 따옴표(" ")
- 작은 따옴표 3개(''' ''')
- 큰 따옴표 3개(""" """)

#### 일반적인 따옴표

이렇게 다양한 방법을 제공하는 이유는 문자열에 따옴표가 포함되는 경우 다음과 같은 문제가 발생할 수도 있기 떄문이다.

```python
>>> 'I'm not the only one'
  File "<stdin>", line 1
    'I'm not the only one'
       ^
SyntaxError: invalid syntax
```

위와 같은 경우에는 `I`만이 작은 따옴표에 둘러싸여 있기 때문에 `I` 이후에 작성한 문자들은 문자열로 인식되지 못하고 오류가 발생한다.

> 해당 오류는 작은 따옴표가 아니라 큰 따옴표에서도 동일하게 발생할 수 있다.

#### 연속적인 따옴표

작은 따옴표나 큰 따옴표를 세번 감싸는 방식을 사용하면 위와 같은 문제를 해결할 수 있다.

```python
>>> '''I'm not the only one'''
"I'm not the only one"
```

이렇게 사용하게 되면 문자열에 따옴표가 얼마든지 포함되어도 에러가 발생하지 않는다. 

```python
> '''I wish this would be over now
But I know that I still need you here'''
'I wish this would be over now\nBut I know that I still need you here'
```

그냥 따옴표와는 다르게 여러 줄로 개행된 문자열을 표현하는데 사용할 수도 있다.

> 일반적인 따옴표로 여러 줄로 개행된 문자열을 표현하려면 이스케이프 문자를 사용해야 한다.

<details><summary>이스케이프 문자란?</summary>

백슬래시(`\`)와 함께 문자를 조합하여 특수한 기능을 사용하는 것

대표적인 이스케이프 문자는 다음과 같다.

| 이스케이프 문자 | 기능 |
|:-----------:|:---:|
| `\'` | 작은따옴표 출력 | 
| `\"` | 큰따옴표 출력 | 
| `\/` | 슬래시 출력 | 
| `\\` | 역슬래시 출력 | 
| `\n` | 개행 | 

</details>

### 연산

#### 더하기

`'1'+'1'`은 `'11'`이다?

```python
>>> '1' + '1'
'11'
```

문자열 사이에서 더하기 연산자(+)는 문자열을 서로 연결해준다.

숫자 문자열 또한 예외없이 연결만 해주기만 하므로 `'1'+'1'`은 `'11'`이 된다.

#### 곱하기

```python
>>> 'loop ' * 3
'loop loop loop'
```

문자열에서 곱셈 연산자(*)는 문자열을 반복해서 출력한다.

### 인덱싱과 슬라이싱

```python
>>> a = 'Python is simple'
>>> a[0] # a의 0번째 문자를 가져온다.
'P'
>>> a[-6] # a의 뒤에서 6번째 문자를 가져온다.
's'
>>> a[0:6] # a의 0번쨰부터 6번째 문자까지 가져온다.
'Python' 
>>> a[10:] # a의 10번째 이후 문자를 가져온다.
'simple'
>>> a[:] # a의 문자열 전체를 가져온다.
'Python is simple'
```

> index란? 순서가 있는 자료형(문자열, 리스트, 튜플)에서의 요소를 가르키는 번호를 말하며 0번째부터 시작한다.

### 관련함수

```python
>>> a = "Python is simple"
>>> len(a) # 문자열 길이 반환
16
>>> a.upper() # 대문자 변환
'PYTHON IS SIMPLE'
>>> a.lower() # 소문자 변환
'python is simple'
>>> a.replace('simple', 'complicated') # 문자열 치환
'python is complicated'
>>> a.split() # 문자열 나누어 리스트 리턴
['python', 'is', 'complicated']
```

리스트 자료형
---

여러 요소를 묶어서 하나의 변수로 활용하기 위해 사용한다.

```python
>>> a = [1, 'cafe', ['twosome', 'starbucks', 'ediya']]
```

위 리스트는 3개의 요소(숫자형, 문자열, 리스트)를 담고 있다. 이처럼 리스트 자료형에는 어떤 형식의 데이터가 들어가도 상관 없다. 

### 리스트 인덱싱과 슬라이싱

문자열과 마찬가지로 리스트에서도 인덱싱과 슬라이싱이 가능하다.

```python
>>> a[0]
1
>>> a[-1] # 뒤에서 첫번째 요소
['twosome', 'starbucks', 'ediya']
>>> a[-1][2] # 리스트 a 내 리스트의 2번째 요소
'starbucks'
>>> a[:2]
[1, 'cafe']
```

### 라스트 관련함수

```python
>>> cafe = a[-1]
>>> cafe
['twosome', 'starbucks', 'ediya']
>>> len(cafe) # 리스트 길이 반환
3
>>> cafe.sort() # 내림차순 정렬
>>> cafe
['ediya', 'starbucks', 'twosome']
>>> cafe.reverse() # 오름차순 정렬
>>> cafe
['twosome', 'starbucks', 'ediya']
>>> cafe.pop(0) # 선택한 요소 출력 후 삭제
'twosome'
>>> cafe
['starbucks', 'ediya'] 
>>> cafe.append('hollys') # 요소 추가
>>> cafe
['starbucks', 'ediya', 'hollys']
>>> cafe.insert(0, 'twosomeplace') # 0번쨰 자리에 'twosome' 추가
>>> cafe
['twosome', 'starbucks', 'ediya', 'hollys']
```

### 리스트 연산

```python
>>> a = [1, 2, 3]
>>> b = ['a', 'b', 'c'] 
>>> c = a + b
>>> c
[1, 2, 3 , 'a', 'b', 'c']
>>> a * 3
[1, 2, 3, 1, 2, 3, 1, 2, 3]
```

튜플 자료형
---

튜플은 리스트와 거의 비슷하지만 약간의 차이가 있다.

1. 리스트는 []로 감싸지만 튜플은 ()로 감싼다.
2. 리스트와 달리 함수를 이용하여 요소들을 생성, 삭제, 수정하는 것들이 불가능하다.

```python
>>> a = (1, 'cafe', ('twosome', 'starbucks', 'ediya'))
```

> 리스트와 마찬가지로 인덱싱, 슬라이싱, 연산 등은 동일하게 가능하다.

딕셔너리 자료형
---

리스트나 튜플이 인덱스를 이용해서 요소를 불러올 수 있는 것과 달리, 딕셔너리는 `key`라는 문자열로 요소(value)를 불러올 수 있다.

```
딕셔너리명 = {Key1:Value1, Key2:Value2, Key3:Value3, ...}
```

> 딕셔너리는 중괄호로 정의한다.

```python
>>> profile = {'name':'python', 'feature':['simple', 'OOP'], 'version':'3.8.0'}
>>> profile['feature']
['simple', 'OOP']
```

### 요소 변경/추가/삭제
```python
>>> profile['version'] = '3.8.1' # 요소 수정
>>> profile['framework'] = 'django' # 요소 추가
>>> profile
{'name': 'python', 'feature': ['simple', 'OOP'], 'version': '3.8.1', 'framework': 'django'}
>>> del profile['framework'] # 요소 삭제
>>> profile
{'name': 'python', 'feature': ['simple', 'OOP'], 'version': '3.8.1'}
```

### 딕셔너리 관련함수

```python
>>> profile.keys() # 딕셔너리의 key 리스트 반환
dict_keys(['name', 'feature', 'version'])
>>> profile.items() # 딕셔너리의 key-value 리스트 반환
dict_items([('name', 'python'), ('feature', ['simple', 'OOP']), ('version', '3.8.1')])
```

논리형
---

참(True) 혹은 거짓(False)를 나타내는 자료형이다.

> 파이썬에서는 논리형을 첫 글자 대문자로 표기한다. (True 혹은 False)

```python
>>> 1 == 1
True
>>> 3 < 1
False
>>> 3 > 2 and 2 < 1
False
```

### 관련 연산자

#### 등가연산자

- `==` 연산자 : 양쪽 값이 같다
- `!=` 연산자 : 양쪽 값이 다르다

#### 관계연산자

- x `>` y : x는 y보다 크다
- x `<` y : x는 y보다 작다
- x `<=` y : x가 y보다 작거나 같다
- x `>=` y : x가 y보다 크거나 같다
#### 논리연산자

- **`and`** 연산자 : 두 값 모두 참(`True`)일 경우에만 결과가 참(`True`)
- **`or`**  연산자 : 둘 중 하나만 참(`True`)일 경우에 결과가 참(`True`)


### 자료형의 참 거짓

자료형에는 이미 참, 거짓이 정해져 있는 경우도 있다.

```python
>>> bool([1,2,3])
True
>>> bool([])
False
>>> bool(0)
False
>>> bool(3)
True
```

> ""(빈 문자열), [ ](빈 리스트), ()(빈 튜플), {}(빈 딕셔너리), 0 (빈 숫자), None의 경우, 모두 거짓(False)이다.