# study.realworld-software-development

### 개요
실전 자바 소프트웨어 개발 (한빛미디어, 2020)

### ATM 요구사항
+ 첫번째 요구사항
  - 은행 입출금 내역의 총 수입과 총 지출은 각각 얼마인가? 결과는 양수인가 음수인가?
  - 특정 달엔 몇 건의 입출금 내역이 발생했는가?
  - 지출이 가낭 높은 상위 10건은 무엇인가?
  - 돈을 가장 많이 소비하는 항목은 무엇인가?
+ 첫번째 추가요구사항
  - CSV 파서를 테스트하는 유닛 테스트를 몇개 더 추가해보자
  - 특정 날짜 범위에서 최대, 최소 거래 내역을 찾는 다양한 집계연산을 추가해보자
  - 월별, 설명별로 지출을 그룹화한 히스토그램을 반환해보자
  
+ 두번째 요구사항
  - 특정 입출금 내역을 검색할 수 있는 기능. 예를 들어 주어진 날짜 범위 또는 특정 범주의 입출금 내역 얻기
  - 검색 결과의 요약 통계를 텍스트, HTML 등 다양한 형식으로 만들기
+ 두번째 추가요구사항
  - JSON, XML 등 다양한 데이터 형식으로 내보내는 기능 추가해보자
  - 입출금 내역 분석기에 기본 GUI를 추가해보자
  
  
### 문서관리 요구사항
+ 첫번째 요구사항
  - 문서 관리 시스템은 기존 환자 정보 파일을 읽어 색인을 추가하고 검색할 수 있는 형태의 정보를 변환
  - 문서의 형태는 아래 3개의 형식이다
    * 리포트: 환자 상담내용을 기록한 본문
    * 우편물: 특정 주소로 발송되는 텍스트
    * 이미지: 엑스레이 사진을 저장 (용량이 큼)
  - 각 문서는 관리 대상 파일의 경로와 누구의 기록물인지 정보를 포함
  - 다양한 종류의 문서에서 특정 정보를 포함하는 문서가 검색 되어야 함<br/>
    ex) 본문에 "AAA"를 포함하는 우편물 검색
  - 미래에 문서의 형태는 늘어날 수 있음
  