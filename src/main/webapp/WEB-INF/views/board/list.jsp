<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
 
   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


  <!-- List CSS -->
<style type="text/css">
table, th {
	width: 1000px;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	margin-top: 3%;
	list-style: none;
}

#btnWrite {
	position: absolute;
	margin-left: 980px;
}

#title {
	text-overflow: ellipsis;
	white-space: nowrap;
	word-wrap: normal;
	width: 100px;
	overflow: hidden;
}
</style>
<script type="text/javascript">
	function mem_block() {
		alert( "비밀글입니다." ) ;
		}

</script>

<script type="text/javascript">

$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/board/write.do";
	});
	
	$("#btnSearch").click(function() {
		location.href="/board/list?search="+$("#search").val();
	});
	
	// 체크박스 href 제거
	$("tr").click(function(event){		
	});
	
	$(":checkbox").click(function(event){
		event.stopPropagation() ;
	});
	
	$('#listTable').delegate('tr', 'click', function (event) {
		if($(event.target).is('input:checkbox')) {
	} else{
		
	}
	});
	
	$("#th_checkAll").click(function(event){
		if( $("#th_checkAll").is(':checked') ){
	        $("input[name=checkRow]").prop("checked", true);
	      }else{
	        $("input[name=checkRow]").prop("checked", false);
	      }
	});
	
	$("#btnDelete").click(function(event){
		var checkRow = "";
		var blank = "" ;
		$( "input[name='checkRow']:checked").each ( function(){
			checkRow = checkRow + $(this).val()+",";
		});
		checkRow = checkRow.substring(0,checkRow.lastIndexOf( ","));
		console.log(checkRow);
		
		
		if ( checkRow != null && checkRow != blank){
			if ( confirm( "삭제하시겠습니까?" ) == true ) {
				
			
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/board/listDelete.do")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "checkRow")
					.attr("value", checkRow)
			);
		$(document.body).append($form);
		$form.submit(); }
		} else {
			alert("선택된 사항이 없습니다.")
			return false ;
		}
	});
	
/* 	var id = $('#checkRow').val(); // 상세보기 수정 버튼 클릭시 띄울것
	$('#'+id).click(function(event){
		var check = prompt('비밀번호를 입력해주세요.' , '' );
		var no = $('#checkRow').val();
		console.log( check ) ;
		console.log(no);
		
		
		if ( check != null ) {
			// 전송 폼
			var $form = $("<form>")
				.attr("action", "/board/check/pw.do")
				.attr("method", "post")
				.append(
					$("<input>")
						.attr("type", "hidden")
						.attr("name", "check")
						.attr("value", check)		
				)
				.append(
						$("<input>")
						.attr("type", "hidden")
						.attr("name", "no")
						.attr("value", no)	
						);
			$(document.body).append($form);
			$form.submit(); }
			 else {
				alert("값이 잘못되었습니다.")
				return ;
			}
	}); */
	
});
</script>

<div class="container">

<div id="list">
<table class="table" id="listTable">
	<thead>
		<tr>
			<th>
				<input type="checkbox" id="th_checkAll" name="checkAll"/>
			</th>
			<th style="width: 5%; text-align: center;">No.</th>
			<th style="width: 15%;">카테고리</th>		
			<th style="width: 25%; text-align: center;">제목</th>
			<th style="width: 15%; text-align: center;">작성자(ID)</th>		
			<th style="width: 7%; ">추천수</th>
			<th style="width: 8%; ">조회수</th>
			<th style="width: 15%; text-align: center; ">최종 작성일자</th>
			<th style="width: 10%; text-align: center; ">구분</th>
		</tr>
	</thead>
<tbody class="tbody">
<c:forEach items="${list}" var="list" >
	<c:if test="${list.ojt_board_block eq 0 }">
	<tr onclick="location.href='/board/view.do?ojt_board_no=${list.ojt_board_no }'">
	</c:if>
	<c:if test="${list.ojt_board_block eq 1 }">
		<c:if test="${list.mem_id eq loginid }">
			<tr onclick="location.href='/board/view.do?ojt_board_no=${list.ojt_board_no }'">
		</c:if>
 		<c:if test="${list.mem_id != loginid }">
			<tr onclick="mem_block();">
		</c:if>
		<c:if test="${list.ojt_board_nick eq null && list.mem_id != loginid}">
			<tr onclick="mem_block();">
		</c:if>
		<c:if test="${list.ojt_board_nick != null }">
			<tr onclick="location.href='/board/pwListCheck.do?ojt_board_no=${list.ojt_board_no }'">
		</c:if> 
	</c:if>
		<td>
			<input type="checkbox" name="checkRow" value="${list.ojt_board_no }" id="checkRow"/>
		</td>
		<td>${list.rnum }</td>
		<td>${list.ojt_board_category }</td>
		
		<c:if test="${list.file_count >= 1 }">
		<c:if test="${list.ojt_board_import eq 0 }">
		<td id="title">${list.ojt_board_title }[첨부파일]</td>
		</c:if>
		<c:if test="${list.ojt_board_import eq 1 }">
		<td id="title">[중요]${list.ojt_board_title }[첨부파일]</td>
		</c:if>
		</c:if>
		
		<c:if test="${list.file_count eq 0 }">
		<c:if test="${list.ojt_board_import eq 0 }">
		<td id="title">${list.ojt_board_title }</td>
		</c:if>
		<c:if test="${list.ojt_board_import eq 1 }">
		<td id="title">[중요]${list.ojt_board_title }</td>
		</c:if>
		</c:if> 
		
		<c:if test="${list.ojt_board_nick == null }">
		<td>${list.mem_name }(${list.mem_id })</td>
		</c:if>
		<c:if test="${list.ojt_board_nick != null }">
		<td>${list.ojt_board_nick }</td>
		</c:if>
		<td>${list.ojt_board_recommend }</td>
		<td>${list.ojt_board_hit}</td>
		<td>${list.last_date }</td>
		<c:if test="${list.ojt_board_block eq 0 }">
		<td><span class="glyphicon glyphicon-eye-open"></span></td>
		</c:if>
		<c:if test="${list.ojt_board_block eq 1 }">
		<td><span class="glyphicon glyphicon-eye-close"></span></td>
		</c:if>
		
	</tr>
															
	<c:set var="list" value="${sum }"/>
</c:forEach>
</tbody>
</table>
<button id="btnDelete" class="btn btn-warning pull-left">삭제</button>
<button id="btnWrite" class="btn btn-primary">글쓰기</button>

<div class="clearfix"></div>

<div id="pagingBox">
<c:import url="/WEB-INF/views/tilesView/BoardPaging.jsp" />

</div> 
</div>
</div>
