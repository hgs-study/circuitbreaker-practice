# circuitbreaker-practice
Resilience4j를 이용한 CircuitBreaker/Retry practice

## CircuitBreaker
+ 외부호출(8081)시 10번 중 FailureRate(실패율,오류율)이 50%일 경우 CircuitBreaker 오픈
![image](https://user-images.githubusercontent.com/76584547/158066639-592e87ed-7ee6-45f4-9f9c-624d15e9f7d3.png)


## Retry
+ 2초에 한 번씩 총 3번 리트라이 (실패)
![image](https://user-images.githubusercontent.com/76584547/158066517-4eaace71-4a3f-40ee-80c2-067fbf8f2891.png)

+ 2초에 한 번씩 총 3번 리트라이 (성공)
![image](https://user-images.githubusercontent.com/76584547/158066546-2b6c788c-b60f-4420-b7a9-20947e940654.png)
