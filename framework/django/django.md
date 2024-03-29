- 파이썬을 기반으로 하는 오픈소스 웹 애플리케이션 프레임워크이다.
  > 프레임워크는 애플리케이션 개발에 필요한 기본 뼈대를 제공하는 것을 말한다.
  django는 웹 백엔드 구축에 필요한 다양한 기능들을 제공하고 있다.

- 2020년 1월 기준 django 최신 버전: `v3.0.2`
- django 소프트웨어 재단에 의해 개발이 진행되고 있다.
  - 공식 사이트: https://www.djangoproject.com/
  - 공식 개발문서: https://docs.djangoproject.com/ko/3.0/

django의 구조
---

- 고전적인 MVC 디자인 패턴을 변형한 MTV 패턴을 따른다.
  - M(Model)
  - T(Template)
  - V(View)
  > MVC 디자인 패턴과 유사하지만, 몇가지 차이가 존재한다.

django의 특징
---

- 웹 백엔드 개발에 필수적인 기능을 기본적으로 제공한다.
  - 데이터베이스 관리
  - 사용자 인증 시스템
  - 관리자 인터페이스
  - 세션 관리 기능
  - CSRF, SQL인젝션 방지와 같은 보안 대책

- 추가로 필요한 기능들은 외부 패키지를 이용하여 편리하게 구현 가능하다.
  - django를 위한 수많은 재사용 가능한 앱
    https://pypi.org/
  - 파이썬을 기반의 다양한 패키지
    https://djangopackages.org

대표적인 서비스
---
- 인스타그램
- 핀터레스트
