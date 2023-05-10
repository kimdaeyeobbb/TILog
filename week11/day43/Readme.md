# 프로젝트 관련 개인학습 내용 

## [Spring] form validation check

- 사용자가 특정 로직을 수행 했을 경우 잘못된 입력으로 인해 애플리케이션이 오작동을 하면 안됨.
<br>따라서 `검증`을 통해 이를 처리해주어야 함

- `th:field =*{필드명}`
  - field 식별


- `th:if="{#fields.hasErrors('필드명')}"`
  - 해당 필드에서 오류가 발생할경우
  - `th:errors"*{필드명}"`과 같이 에러가 발생한 필드를 재출력함

<br>