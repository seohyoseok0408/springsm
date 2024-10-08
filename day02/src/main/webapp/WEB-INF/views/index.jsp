<%--
  Created by IntelliJ IDEA.
  User: hyoseokseo
  Date: 2024. 10. 7.
  Time: AM 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Main Page h1</h1>
    <h2>Main Page h2</h2>
    <h3>Main Page h3</h3>
    <h4>Main Page h4</h4>
    <h5>Main Page h5</h5>
    <h6>Main Page h6</h6>
    <p>p태그는 문단 태그이다. 하나의 문단을 만들 때 쓰인다.</p>
    <p>게다가 블록 요소여서 항상 새로운 줄에서 시작!</p>
    <b>b태그는 굵게 태그이다.</b>

    <ol>
        <li>ol 태그는 순차 목록을 정의한다.</li>
        <li>목록 항목은 li태그를 사용하면 된다.</li>
    </ol>

    <ul>
        <li>ol 태그는 비순차 목록을 정의한다.</li>
        <li>목록 항목은 li태그를 사용하면 된다.</li>
    </ul>
    <li>li는 목록 항목을 정의한다.</li>

    <a href="http://www.naver.com" title="good">네이버링크!, title 속성으로 추가정보 제공됨</a>
    <br>
    <img src="/img/dog.png" width="300px" alt="이미지가 로드되지 않을시 대체 텍스트" />

    <div>
        <p>div 태그는 웹 페이지의 구조와 레이아웃을 구성! + CSS 스타일 적용하기 위해 다른 요소들을 그룹화하는데 사용</p>
    </div>
    <span>
        <p>span 태그는 클래스 아이디 스타일 등 적용 위함. </p>
    </span>

    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>나이</th>
                <th>성별</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>홍길동</td>
                <td>20</td>
                <td>남</td>
            </tr>
            <tr>
                <td>김철수</td>
                <td>25</td>
                <td>남</td>
            </tr>
            <tr>
                <td>박영희</td>
                <td>22</td>
                <td>여</td>
            </tr>
        </tbody>
    </table>

    <h2><a href="/next">Next 페이지로 이동하기</a></h2>
    <h3>${name}</h3>
    <h3>${msg}</h3>
</body>
</html>
