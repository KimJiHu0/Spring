# SpringMVC

> Spring framework 기반으로 트랜잭션 처리가 DI 및 AOP적용을 쉽게 할 수 있어.
> 개인적으로 쉽게 생각하자면 JAVA로 MVC하던 것과 똑같지만 사용하는 것은 Spring기반이라는 게 다르다고 생각해
>
> 
>
> ### SpringMVC 흐름도
>
> ![](https://postfiles.pstatic.net/MjAyMDA4MzFfMjI4/MDAxNTk4ODc0MzMxMTQ0.zDGgkjr1nsieblO0xEkqDVUc6ZAzPzNR__8ycctYu08g.WIqMZ8jnYEJK_JaLWIJPfAPxgh_LRAl61FoMQgWdKXsg.PNG.rgusqls/image.png?type=w773)
>
> - **Listener :** request를 어떤 XML과 연결해줄지 정하는 애라고 볼 수 있어.
> - **DispatcherServlet :** 요청에 맞는 XML을 가져왔다면 DispatcherServlet를 거쳐야돼.
>   얘는 요청된 것이 어느 Controller를 들어가야하는지 연결해줄거야.
> - Controller을 거치게 된다면 Service, Repository을 갔다가 DB의 값을 가지고 와서 순차적으로 다시
>   올라가서 DispatcherServlet를 다시 가
> - **ViewResolver :**  어떤 view를 보여줄지 제어해주는 애라고 보면 돼.
>   DispatcherServlet가 db에서 값을 가져온 후에 요청 페이지를 연결할 때 들리는 곳이지.
>   이곳에서 사용자가 원하는 jsp 혹은 html을 뿌려줘.
>
> 
>
> 
>
> ### MVC 주요 구성요소
>
> ![](https://postfiles.pstatic.net/MjAyMDA4MzFfMjA2/MDAxNTk4ODc0NzUxMzkz.be4QmQ6HidU1cEf35_0aRrDZa2weDYyKFxDuwiFla18g.k0dzNdNM9sqXr-VSDWbNzC9ziDX4O1UYydtW1JOIfAQg.PNG.rgusqls/image.png?type=w773)
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 
>
> 