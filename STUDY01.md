# 용어모음

### SOLID
- S: Single Responsibility Principle
  + 단일 책임 원칙
  + 한 클래스는 한 기능만 책임져야 한다.
  + 클래스가 바뀌어야 하는 이유는 오직 하나여야 한다.
- O: Open/Closed Principle
  + 개방/폐쇄 원칙
- L: Liskov Substitution Principle
  + 리스코프 치환 원칙
- I: Interface Segregation Principle
  + 인터페이스 분리 원칙
- D: Dependency Inversion Principle
  + 의존관계 역전 원칙

### KISS
- Keep It Short and Simple
  + 코드를 짧고 단순하게 구현<br/>
    ex) 간단한 출력프로그램을 1개의 클래스로 개발 

### DRY
- Don't Repeat Yourself
  + 반복을 제거할 것
    
### final 키워드
- 변수에 사용시 값에 대한 재할당 불가 (단, 객체의 경우 가변가능)

### 캡슐화
- 코드 사용자에게 세부 구현 내용이 감춰져있어, 쉽게 코드가 이해가능하고, 기능을 바꾸기 용이

### 놀람 최소화 원칙
- Principle of Least Surprise
  + 메서드나 클래스의 동작이 누군가가 놀라지 않고 일관성이 유지되도록 코드를 구현할 것을 강조하는 원칙

### 응집도/결합도
- 응집도는 높고, 결합도는 낮은 프로그램이 유지보수하기 수월함.
  + 응집도: 서로 어떻게 관련되어 있는지를 가리키며, 책임이 서로 얼마나 강하게 관련되어 있는지 측정. 높을수록 유지보수하기 좋음.
  + 결합도: 한 기능이 다른 클래스에 얼마나 의존하고 있는지 측정. 높을수록 유지보수하기 힘듦.

### 코드 커버리지
- 테스트 집합이 소프트웨어의 소스코드를 얼마나 테스트했는가를 가리키는 척도
- 통상 70-90% 정도를 유지하는 것이 바람직함. (100%를 채우는것은 비효율)