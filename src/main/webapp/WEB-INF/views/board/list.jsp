<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/board/write";
	});
	
	$("#btnSearch").click(function() {
		location.href="/board/list?search="+$("#search").val();
	});
	
	
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
				
		//방법1
		// 체크된 대상들을 하나씩 꺼내서 문자열로 합치기
// 		var names = "";
// 		var len = $checkboxes.length;
// 		$checkboxes.each( function(idx) {
// 			names += $(this).val();
			
// 			if( len-1 != idx ) {
// 				names += ",";
// 			}
// 		});
// 		console.log(names);
	
		//방법2
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
// 		console.log("names : " + names);

// 		console.log($checkboxes);
// 		console.log( "map:" + map );	// 맵
// 		console.log( "map->array : " + map.get() );	// 맵->배열
// 		console.log( "array tostring : " + map.get().join(",") ); // toString
		
		
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/board/listDelete")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
	
});

//전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}
</script>

<style type="text/css">
table , th {
	width: 1000px ;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	margin-top: 10%;
}

#title {
	display: inline-block;
	width: 200px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
#pagingBox {
	position: relative;
}
#btnBox {
	position: absolute;
	top: 0;
	bottom: 0;
	right: 0;
	height: 40px;
	margin: auto;
}
</style>

<div id="list">
<table>
	<thead>
		<tr>
			<th>
				<input type="checkbox" id="checkAll" onclick="checkAll();" />
			</th>
			<th style="width: 5%; text-align: center;">No.</th>
			<th style="width: 10%;">구분</th>		
			<th style="width: 30%; text-align: center;">제목</th>
			<th style="width: 15%; text-align: center;">작성자(ID)</th>
			<th style="width: 7%; ">추천수</th>
			<th style="width: 8%; ">조회수</th>
			<th style="width: 20%; text-align: center; ">최종 작성일자</th>
		</tr>
	</thead>

<c:forEach items="${list}" var="b">
	<tr>
		<td>
			<input type="checkbox" name="checkRow" value="${b.no }" />
		</td>
		<td>${b.no }</td>
		<td>${b.kategorie }</td>
		<td id="title"><a href="/board/view?no=${b.no }">${b.title }</a></td>
		<td>${b.name }(${b.id })</td>
		<td>${b.hit }</td>
		<td>${b.view}</td>
		<td><fmt:formatDate value="${b.date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
																	
	<c:set var="i" value="${sum }"/>
	
</c:forEach>

</table>

<button id="btnDelete" class="btn btn-warning pull-left">삭제</button>
<div class="clearfix"></div>

<div id="pagingBox">
<c:import url="/WEB-INF/views/layout/BoardPaging.jsp" />

<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary">글쓰기</button>
</div>
</div>

<div class="form-inline text-center">
	<input class="form-control" type="text" id="search" />
	<button id="btnSearch" class="btn">검색</button>
</div> 
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />