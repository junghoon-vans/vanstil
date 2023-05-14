함수 호출 시 생성되며 함수의 `지역변수`, `파라미터`와 `리턴 주소` 등을 담고 있다.
스택에 저장되므로 `스택 프레임(Stack Frame)`이라고도 한다.
함수가 종료되면 스택에서 제거된다.

## 구성 요소

![](https://static.javatpoint.com/compiler/images/activation-record.png)

- Return Value
	- 값을 반환하는 데 사용
- Actual Parameters
	- 함수 호출 시 전달하는 매개변수
- Control Link
	- 호출자의 활성화 레코드를 가리킴
- Access Link
	- 다른 활성화 레코드에 저장된 비로컬 데이터를 참조하는 데 사용
- Saved Machine Status
	- 함수 호출 전 머신의 상태에 대한 정보를 저장
- Local Data
	- 로컬 데이터를 저장
- Temporaries
	- 표현식(Expression) 평가에서 발생하는 값을 저장

## 스택 포인터와 Activation Record

1. `Stack Pointer(SP)`는 초기에 `스택의 상단`을 가리킨다.
2. 함수 호출 시 Activation Record를 할당하기 위해서 `SP를 감소`
3. 함수 종료 시 스택에서 Activation Record를 해제하기 위해 `SP를 증가`

## 출처
- [JavaTPoint - Activation Record](https://www.javatpoint.com/activation-record)