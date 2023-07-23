## 비트컴퓨터 야구게임 과제 구현

### 기능 요구사항
- 사용자로부터 1부터 9까지 서로 다른 수로 이루어진 수를 입력받는다.
- 잘못된 입력을 받을 시, 적절한 에러 메세지를 출력한다.
  - 에러 메세지 출력 후, 다시 입력을 받을 수 있어야 한다.
- 사용자가 도전시, 그 결과를 출력한다.
  - 출력 형식: N S:a B:b O:c
    - N:도전 횟수
    - a:숫자와 위치가 모두 같은 경우(개수)
    - b:숫자가 다른 자리에 있는 경우(개수)
    - c:숫자가 없는 경우(개수)
- 정답을 맞출 경우 도전 횟수와 게임 시간이 기록한다.
  - 기록은 순위를 가진다.
    - 도전 횟수가 낮은 기록이 높은 순위를 가진다.
    - 도전 횟수가 같을 경우, 게임 시간이 낮은 기록이 높은 순위를 가진다.

### 실행 결과 예시
```text
1234
3자리 숫자를 입력해주세요. (값의 범위 1 ~ 9)
asdf
숫자를 입력해주세요.
123
1 - S:0, B:1, O:2
456
2 - S:0, B:1, O:2
296
3 - S:0, B:0, O:3
358
4 - S:0, B:0, O:3
715
5 - S:2, B:0, O:1
714
6 - S:3, B:0, O:0 (종료)
```
    
### 게임 저장 예시
```text
1위 125/2 0분 21초
2위 458/3 0분 13초
3위 243/4 0분 37초
4위 475/6 0분 41초
5위 689/6 1분 2초
6위 913/6 1분 8초
7위 714/6 2분 0초
8위 814/8 0분 53초
9위 357/10 1분 41초
10위 926/11 4분 10초
```
