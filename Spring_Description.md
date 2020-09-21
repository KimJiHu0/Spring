# Java

#### OOP : 객체지향프로그래밍 / Class를 Memory에 실제 구현한 것

**OOP의 특징** 

- 캡슐화 : 코드는 은닉하고 객체의 기능만 사용
- 추상화 : 여러 객체들을 하나의 추상적인 큰 개념으로 묶은 것
- 상속 : 상위 개념을 하위 개념이 물려받는다.
- 다형성 : 같은 형태로 다른 행위를 한다.



#### **Type Var = Value** 

**기본타입 : Call By Value**

- 정수형 : byte(1byte) / short(2byte) / int(4byte) / long(8byte)
- 실수형 : float(4byte) / double(8byte)
- 문자형 : char(2byte)
- 논리형 : boolean(1byte)

**참조타입 : Call By Reference / 문자형**

- 문자열 : String 
- Object를 상속받는 모든 Class



#### **형변환** 

- 명시적 형변환 : 작은 타입에서 큰 타입으로 형변환 시 명시적
- 묵시적 형변환 : 큰 타입에서 작은타입으로 형변환 시 묵시적



#### Class/ Method

```java
// Class : 설계도
public class Description{
    
    // field (값, 속성)
    
    // constructor (생성자)
    
    // method (기능)
    // 프로그램의 주 진입점
    // 어떤 작업을 수행하기 위한 명령문들의 집합
    // 하나의 이름으로 여러 개의 명령을 일괄 처리하는 모듈
    
    
    // 접근제한자 메모리영역 리턴타입 메소드명( 파라미터, 아규먼트 )
    public static void test(int a, int b){
        
    }
}
```

**접근제한자 :** 접근을 제한한다.

- public : (+, 초록색 동그라미) / 어디서나 접근, 참조 가능
- private : (#, 노란다이아) / 상속인 경우 상속된 곳에서만, 아닌경우 같은 패키지 내에서만 접근, 참조 가능
- protected : (-, 빨간 사각형) / 현태 클래스 내에서만 접근, 참조 가능
- default : (~, 파란 삼각형) / 같은 패키지 내에서만 접근, 참조 가능

**메모리영역 :** Static 영역에 저장되는가 아닌가? / 바로 호출되는가 객체생성을 하고 호출해야하는가 차이

- static : (빨간색s) / class.methodname() 으로 바로 실행 가능.
  static field : class전역에 지정되는 변수
  non-static field : 변수 하나하나에 지정되는 변수
- non-static :  class var = new class(); 로 객체 생성 후 var.methodname(); 으로 실행 가능

**리턴타입 :** method를 호출하면 return해주는 값의 타입

- void : return해줄 타입이 없는 경우에는 void
- int / double / ... : return해줄 타입이 int / double / ... 인 경우 해당 타입 작성

**파라미터 :** 메소드 외부에서 전달 된 값을 메소드 내부에서 사용하기 위한 변수

**아규먼트 :** 메소드 외부에서 전달된 값.



#### 제어문

```java
// 조건문

if(조건){
    // if 조건 true일 때 실행 나머지 실행x
}else if(조건){
    // if조건이 false고 else if 조건이 true일 때 실행 나머지 실행x
}else {
    // 위의 두 조건이 false일 때 실행
}

switch(조건){
    case 1:
        // 조건의 값이 1일 때 이 부분 실행
    case 2:
        // 조건의 값이 2 일때 이 부분 실행
}

// 반복문
for(초기식; 조건; 증감식;){
    // 초기식부터 조건에 만족할때까지 반복하면서 증감해준다.
}
// forEach : 향상된 for문

while(조건){
    // 조건이 만족할때까지 반복해준다.
}

do{
    // while의 조건이 true할 때 반복문을 종료해주는데
    // 만일 while(true)여서 바로 종료가 된다 하더라도
    // do부분을 무조건 한 번 실행한 후 종료한다.
}while(조건)
```



#### 배열

**Array :**
	같은 타입의 값을 효과적으로 관리하기 위한 객체 / 참조타입 : 주소값으로 변경 가능
	shallow copy : 주소값만 복사 / 복사본 변경 시 원본도 변경
	deep copy : 객체를 복사하여 새로운 배열을 생성 / 복사본 변경 시 원본 변경x

```java
int arr[]; // 선언
int[] arr = new int[3]; // 배열의 크기를 정의.
arr[0] = 1; // 초기화
arr[1] = 2;
arr[2] = 3;

int[] arr = new int[]{1,2,3} // 선언, 정의, 초기화를 한번에

int[] arr = {1,2,3} // 선언, 초기화

[다차원 배열]
큰 배열을 작은 배열안에 넣어줌
int[][] arr = new int[2][2]; // 2x2의 배열 생성
int[0][0] = 1;
int[0][1] = 2;
int[1][0] = 3;
int[1][1] = 4;

int[][] arr = new int[3][];
arr[0] = new int[1];
arr[1] = new int[2];
arr[2] = new int[3];

```



**Collection :** 

​	같은 타입이 아니어도 여러 개의 값을 효과적으로 관리

- Vector / List : 순서가 있고 중복이 있다.
- ArrayList : 인덱스로 객체를 관리하며 가변배열이다.
- Set : 순서가 없고 중복이 없다.
- Map : {k : v} 형태이고 json형태로 사용할 수 있다. key값은 중복이 없고 value는 중복이 있다.



#### Exception

checked exception : 컴파일 단계에서 오류.
runtime exception : 실행 단계에서 오류 / 주로 개발자의 실수





# JavaScript / Jquery

**javascript** : 스크립트형 언어 (함수형 언어와 비슷) => 문서에 동적인 기능 표현을 위해
인터프리터로 동작한다.

**jquery** : 자바스크립트 라이브러리 (미리 작성된 기능을 모아서 배포해 놓은 것)

**library** : 누군가 이미 완성된 기능들을 배포해놨음
**framework** : 반쯤 만들어져 있는 프로그래밍(공통 기능들이 만들어져 있음)



### **jsp를 컴파일해주는 jasper** : 

tomcat이 jasper을 내장적으로 가지고 있는데 Spring boot에서는 내장서버를 지니고 있어서
jsp를 컴파일 해주는 애가 없음. 그래서 jasper dependecy를 추가해서 jsp를 사용할 것이다.



**servlet** : 자바안에서 html을 응답
**jsp(java server page)** : html안에 java코드가 들어가있는데 서버에서 컴퍼일되서 html을 응답

**request :** Client가 Server에게 요청하는 것
**response :** Server가 Client에게 응답하는 것
**forward :** request Scope에 담긴 값이 유효.(request, response 유지)
**redirect :** request, response가 유지되지 않고 새롭게 생성



### Scope 범위

**page** : 현재 페이지
**request** : 요청받은 곳까지
**session** : 세션이 만료되기 전까지
**application** : 전체에서 사용가능

**el** : 익스프레션랭귀지 ${}
**jstl** : Jsp Standard  Tag Library c태그 fmt태그 등등
**jsp:useBean** : jsp 페이지에서 자바 bean객체를 사용



### MVCpattern

**Model** : 계산처리 db연결 담당 (biz, dao)
**View** : 화면
**Controller** : 요청에 맞는 화면응답 제어

**MVC1** : Model, View, Controller를 나눴지만 완벽하게 나누지 않음.

**MVC2** : Model, View, Controller를 완벽하게 나눔.

**WS** : 정적인 처리 / html , file
**WAS** : 동적인 처리 / jsp



### Spring Framework

Spring Framework로 경량 컨테이더이다.

- OCP : 개발자가 만질 수 있는 부분은 open / 아닌 부분은 close

- AOP : 관점지향 프로그래밍

  - CC(Core Concern) : 주 관심사항
  - CCC(Cross Cutting Concern) : 공통 관심사항

  - JoinPoint : 공통 관심사항(CCC)를 붙일 수 있는 모든 곳
  - PointCut : 공통 관심사항(CCC)를 어느 곳에 붙일지 지정
  - Advice : Aspect라고도 부르며 공통관심사항(CCC)를 묶어놓은 곳
  - Advisor : Advice + PointCut
  - Weaving : 위의 모든 것을 묶어서 실행했을 때 정상작동하는 것
  - proxy : 호출한 target을 가로채서 자기의 것을 출력한다.

- DI/IoC : 의존주입 / 역전제어

  - DI : 값을 주입
    	Parameter : Consturctor
    	Setter : Property

  - IoC : 역전제어
    	강결합 : class와 class가 같은 곳에 붙어있음
    	약결합 : class와 class를 따로 분리해줌.
    	생성하는 곳과 사용하는 곳을 분리하는 것



### SpringMVC

![](https://postfiles.pstatic.net/MjAyMDA5MjFfMjE4/MDAxNjAwNjgwMzQ5MjYz.gra0kOLojB0-RXjvL7QFrVM44D0HznHbV1CN-efgZJQg.nLh1O57FSEBf3OU6R-ftSzjTUs4621mFGk2qCo_HnWog.JPEG.rgusqls/SpringMVC.jpg?type=w773)

- **Listener :** 어떤 XML과 연결해줄지 정해준다.
- **DispatcherServlet :** 어느 Controller과 연결해주는지 지정해준다.
- **HandlerMapping :** Controller에서 Mapping을 통해서 어떤 Method와 연결해줄지 지정한다.
- **ViewResolver :** 어떤 View(jsp)를 보여줄지 정한 후에 Response한다.
- **ModelAndView** : Controller에서 View로 값을 넘겨줄 때 ModelAndView에 값을 담아준다.
- **AOP :** Controller, Service , Respository에서 Log를 찍을 수 있다.
- **Filter :** Client와 Server사이에서 어떠한 작업을 처리하고 FilterChain을 통해 filter와 filter 혹은 filter와 Server를 연결해준다.
- **Interceptor :** Controller에서 D/S 혹은 D/S에서 Controller로 넘어갈 때 거치는 곳인데 넘겨줄지 말지 제어해준다.