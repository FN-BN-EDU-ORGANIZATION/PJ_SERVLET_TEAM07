<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <link rel="stylesheet" href="resources/css/replax.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/section.css">
    <link rel="stylesheet" href="resources/css/footer.css">
    <link rel="stylesheet" href="resources/css/slide.css">
    <link rel="stylesheet" href="resources/css/head.css">
    <link rel="stylesheet" href="resources/css/footer_bottom.css">

</head>
<body>

    <div id="wrap">
        <header id="header">
            <div class="head">
                <div class="head_bar">
                    <div class="head_member">
                    	<c:if test="${empty ROLE }">
                        <div><a href="${pageContext.request.contextPath }/Join.do">회원가입</a></div>
                        </c:if>
                        <div><a href="#">통합회원인증</a></div>
                        <%
                        	Integer rolevalue = (Integer)session.getAttribute("ROLE");
                        	if(rolevalue==null)
                        	{
                        
                        %>
                        <div><a href="${pageContext.request.contextPath }/login.do">통합허브시스템 로그인</a></div>
                        <%
                        	}
                        %>
                    </div>
                </div>
                <div class="head_search">
                    <div class="logo">
                        <a href=""><img src="resources/img/logo.png" alt="로고이미지"></a>
                    </div>
                    <ul class="nav">
                        <li class="dep1">
                            <a href=""><span>자료검색</span></a>
                            <ul class="dep2">
                                <li><a href="./1-1 통합자료검색.html">통합검색</a></li>
                                <li><a href="./1-2 추천도서.html">추천도서</a></li>
                                <li><a href="./1-3 희망도서신청.html">희망도서신청</a></li>
                            </ul>
                        </li>
                        <li class="dep1">
                            <a href=""><span>대여안내</span></a>
                            <ul class="dep2">
                                <li><a href="./2-1 도서대출.html">도서대출</a></li>
                                <li><a href="./2-2 도서반납.html">도서반납</a></li>
                                <li><a href="./2-3 도서예약.html">대여예약</a></li>
                            </ul>
                        </li>
                        <li class="dep1">
                            <a href=""><span>열린공간</span></a>
                            <ul class="dep2">
                                <li><a href="./3-1 공지사항.html">공지사항</a></li>
                                <li><a href="./3-2 묻고답하기.html">묻고답하기</a></li>
                                <li><a href="./3-3 도서리뷰.html">책리뷰</a></li>
                            </ul>
                        </li>
                        <li class="dep1">
                            <a href=""><span>도서관소개</span></a>
                            <ul class="dep2">
                                <li><a href="./">소개글</a></li>
                                <li><a href="">오는길</a></li>
                            </ul>
                        </li>
                        <li class="dep1">
                            <a href=""><span>나의도서관</span></a>
                            <ul class="dep2">
                                <li><a href="./5-1 나의대여리스트.html">나의 대여리스트</a></li>
                                <li><a href="./5-2 나의책계획.html">나의 책계획</a></li>
                            </ul>
                        </li>
                        <div class="">
                            <a href=""><img src="./css/img/menubar.png" alt="메뉴바"></a>
                        </div>
                    </ul>
                </div>
            </div>            
            <div class="subject">
                <div class="slide slide_wrap">
                    <div class="slide_item"><img src="resources/img/1동.jpg" alt=""></div>
                    <div class="slide_item"><img src="resources/img/2동.jpg" alt=""></div>
                    <div class="slide_item"><img src="resources/img/3동.jpg" alt=""></div>
                    <div class="slide_item"><img src="resources/img/4동.jpg" alt=""></div>
                    <div class="slide_item"><img src="resources/img/university-library-g7ddd99ecd_1280.jpg" alt=""></div>
                    <div class="slide_prev_button slide_button">◀</div>
                    <div class="slide_next_button slide_button">▶</div>
                    <ul class="slide_pagination"></ul>
                </div>
                <script src="resources/js/slide.js">

                </script>
            
                <div class="context_box">
                    <div class="c_box1">책을 읽다</div>
                    <div class="c_box2">책을 통해 세상과 소통하다.</div>
                </div>
            </div>
            <div class="search">
                <form class="search_click">
                    <input type="search">
                    <input type="submit" value="검색">
                </form>
            </div>
            <div class="bin1"></div>
            <div class="ancle">
                <div class="ancle_contents">
                    <div class="ancle1"><a href=""><img src="" alt="1"></a></div>
                    <div class="ancle1"><a href=""><img src="" alt="2"></a></div>
                    <div class="ancle1"><a href=""><img src="" alt="3"></a></div>
                    <div class="ancle1"><a href=""><img src="" alt="4"></a></div>
                    <div class="ancle1"><a href=""><img src="" alt="5"></a></div>
                </div>
            </div>
            <div class="bin2"></div>
        </header>

        <!-- header-->
        <section id="section">

        </section>
        <!-- section -->
        <footer id="footer">
            <div class="footer_top"></div>
            <div class="footer_body"></div>
            <div class="footer_bottom">
                <div class="tedory">
                    <div class="dosu_site">
                        <div><a href=""><img src="" alt=""></a></div>
                        <div><a href=""><img src="" alt=""></a></div>
                        <div><a href=""><img src="" alt=""></a></div>
                        <div><a href=""><img src="" alt=""></a></div>
                        <div><a href=""><img src="" alt=""></a></div>
                    </div>
                    <div class="dosu_nav">
                        <div><a href="">개인정보처리방침</a></div>
                        <div><a href="">영상정보처리방침</a></div>
                        <div><a href="">이용약관</a></div>
                        <div><a href="">도서관서비스헌장</a></div>
                        <div><a href="">저작권보호정책</a></div>
                        <div><a href="">뷰어다운로드</a></div>
                    </div>
                    <div class="dosu_last">
                        <div class="left">
                            <div>
                                <p>경산시 백천동(백천동,백천도서관) 전화 xxx-xxx-xxxx<br/><br/>Copyright ⓒ 백천동 백천도서관.All right reserved.</p>
                            </div>
                        </div>
                        <div class="right">
                            <div>
                                <form action="">
                                    <input type="text">
                                    <input type="submit" value="검색">
                                </form>
                            </div>
                            <div>
                                <form action="">
                                    <input type="text">
                                    <input type="submit" value="검색">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- footer -->
    </div>

</body>
</html>