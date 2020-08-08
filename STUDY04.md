# 용어모음

### 클라이언트 서버 모델 (Client-Server Model)
- 컴퓨터를 두 그룹으로 분류
  + 클라이언트는 서비스를 사용하는 그룹
  + 서버는 관련 서비스를 제공하는 그룹

### 풀 기반 (Pull-Based)
- 클라이언트가 서버로 정보를 요청
- 점대점(Point-to-Point) 또는 요청 응답(Request-Response)
- 일대일 통신

### 푸시 기반 (Push-Based)
- 작성자(Publisher)가 방출한 이벤트 스트림을 여러 구독자가 수신
- 리액티브(Reactive) 또는 이벤트 주도(Event-Driven)
- 일대다 통신 지원

### 웹 소켓 (Web Socket)
- TCP스트림으로 양방향 이벤트 통신을 지원하는 프로토콜

### 전체 설계부터 완성하기 (BDUF, Big Design Up Front)
- 코딩을 시작하기 전 모든 설계 작업을 완료하는 방식
- 애자일, 반복적 개발 방법론과는 반대되는 개념

### 암호화 해시함수(Cryptographic Hash Function)
- 임의의 길이의 문자열을 입력받아 다이제스트(Digest)라는 출력으로 변환
- 항상 같은 결과를 출력
- 입력을 다이제스트로 변환하는 시간은 매우 빠르지만, 이를 되돌리는 작업은 오래 걸림

### 무차별 대입 (Brute Force)
### 레인보우 테이블 (Rainbow table)
- 미리 해싱된 값들을 저장해놓고 대조해 보는 테이블

### 솔트 (Salt)
- 암호 해싱 함수에 적용하는 임의로 생성된 추가 입력

### 중간자 공격 (Man-in-the-Middle Attack)
- 연결을 가로채 통신되는 데이터를 확인

### 전송 계층 보안 (TLS, Transport Layer Security)
- 연결된 네트워크로 전달되는 데이터의 프라이버시와 무결성을 제공하는 암호화된 프로토콜

### 목(Mock) 객체
- 다른 객체인 척 하는 객체
- 원래 객체가 제공하는 메서드와 공개API를 모두 제공
- 이를 이용해 특정 메서드가 실제 호출되었는지를 확인(Verify)

### hashCode() 메서드의 계약
- 계약을 준수하고 정수값이 고르게 퍼지도록 구현할 경우 HashMap, HashSet의 효율성이 좋아짐
  * result 변수를 만들고 소수를 할당
  * equlas() 메서드가 사용하는 각 필드의 해시코드를 대표하는 int값 계산
  * 기존 결과값에 소수를 곱한 다음, 필드의 해시코드와 합침<br/>
    ex) result = 41 * result + hashCodeOfField;
  * 최신 IDE는 이 코드를자동으로 만들어줌
