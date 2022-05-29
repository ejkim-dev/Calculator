# Calculator

아래 영상에 나오는 간단한 계산기 앱을 먼저 구현해 본 코드다.

🎥 <b>IntelliJ IDEA 탐구생활 웨비나 - 안드로이드 개발자를 위한 코드 작성 팁 - 정석준</b>

[![(click👆🏻)](https://i.ytimg.com/an_webp/vJpfYuaFayU/mqdefault_6s.webp?du=3000&sqp=CJKgzZQG&rs=AOn4CLBq4kA01KkaP9G_-OL14sl8bAG2uQ)](https://www.youtube.com/watch?v=vJpfYuaFayU)


Jetpack 아키텍처 구성요소 중 LiveData와 ViewModel을 사용하였고, 레이아웃은 ConstraintLayout을 사용하였다.

하지만 다 만들고 영상을 보니, 코드 아키텍처에 관한 것이 아니고 정말 에디터 활용하는 팁이 담긴 영상이었다.

그래도 기왕 만들었으니 간단하게 설명하자면
1. 화면 부분
 - ConstraintLayout과 chainStyle을 이용하여 넓은 화면에서 ui가 같이 커지도록 했다.

2. 로직 부분
 - Activity에는 최대한 Ui 세팅만 담으려고 했다.
 - ViewModel에는 Ui를 직접 변경하지 않기위해 고민했다.
 - 테스트를 해보면서 발생할 수 있는 예외 처리에 신경썼다.

최대한 라이브러리 추가 없이 심플하고 빠르게 2시간 정도 만들려고 했는데 막상 만들고보니 4시간이나 걸렸다.
코드도 좀 개선하고 싶은 부분이 있는데 일단 앱 동작하는 것까지 확인하고 영상을 보고 집으로 갔다.

📍 오늘의 피드백은
 - 예상보다 두배가 걸렸다. 시간 계획을 세울 때 좀 더 자세하게 세우자. (ex. view - 몇분, 로직 1..3 몇분)
 - 회사에서 일하는 것만으로 코딩 실력을 키우기는 힘들다는 것을 느꼈다. 공부하는 시간을 확보하자.

레퍼런스 참고
- [앱에서 Jetpack 라이브러리 사용 ☝️](https://developer.android.com/jetpack/getting-started?hl=ko#use_a_jetpack_library_in_your_app)
- [ViewModel 개요 ☝️](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ko)
