# 용어모음

### 결정 모델과 표기법 (DMN, Decision Model and Notation)
### 최소 기능 제품 (MVP, Minimal Variable Product)
### 테스트 주도 개발 (TDD, Test Driven Development)
- TDD의 철학
  + 테스트 코드를 먼저 만든 후, 이에 맞춰 코드를 구현
- TDD의 장점
  + 테스트를 따로 구현하므로 테스트에 대응하는 요구사항을 한개씩 구현할 때 마다 필요한 요구사항에 집중하고 개선 가능
  + 코드를 올바르게 조직할 수 있음<br/>
    ex) 테스트를 구현하면서 코드에 어떤 공개 인터페이스를 만들어야 하는지 검토가능
  + TDD 주기에 따라 요구사항 구현을 반복하면서 종합적인 테스트 스위트를 완성할 수 있으므로 요구사항을 만족시켰다는 사실을 조금 더 확신 가능, 버그 발생 범위도 줄일 수 있음
  + 테스트를 통과하기 위한 코드를 구현하기 때문에 필요하지 않은 테스트를 구현하는 일(오버엔지니어링)을 줄일 수 있음
- TDD의 주기
  + 실패하는 테스트 구현
  + 모든 테스트 실행
  + 기능이 동작하도록 코드 구현
  + 모든 테스트 실행
  
### 형식추론 (Type Interface)
- 자바10에서 지역 변수 형식 추론 지원
- 컴파일러가 정적 형식을 자동으로 추론해 결정하는 기능<br/>
  ex) AS-IS: Map<String, String> facts = new HashMap<String,String>();<br/>
  ex) TO-BE: Map<String, String> facts = new HashMap<>();
- var 키워드와 사용가능<br/>
  ex) 명시적 형식: Facts env = new Facts();<br/>
  ex) 형식추론: var env = new Facts();
    + var 키워드를 쓰면 final이 아님

### 빌더패턴 (Builder Pattern)
- 단순하게 객체를 만드는 방법을 제공
- 생성자의 파라미터를 분해해서 각각의 파라미터를 받는 여러 메서드로 분리
