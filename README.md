# hwplib

한글과 컴퓨터(한컴)에서 만든 워드프로세서 "한글"의 파일에 대한 라이브러리입니다.

본 라이브러리는 JAVA로 구현되었으며, 한글 파일의 하부 구조인 Microsoft Compound File의 부분은 Apache-POI의 POIFS File System을 사용하여 처리합니다.
본 라이브러리는 한글과컴퓨터의 한글 문서 파일(.hwp) 공개 문서를 참고하여 개발하였습니다. 한컴에서 제공하는 문서(HWP 5.0)는 아래URL에서 받을 수 있습니다. 

http://www.hancom.com/etc/hwpDownload.do?gnb0=269&gnb1=271&gnb0=101&gnb1=140

2017.8.21
=========================================================================================
* URL로 부터 읽는 기능 추가 - osc91 님 요청

```java
		String url = "http://ocwork.haansoft.com/sample/sample.hwp";
		HWPFile hwpFile = HWPReader.fromURL(url); 
```

2017.6.1
=========================================================================================
* 저장 모듈 완료
	- TestEditingHWPFile.java, TestReWritingHWPFile.java 참고
```java
	// 파일을 열어서
	String filename = "sample_hwp\\test-blank.hwp"; 
	HWPFile hwpFile = HWPReader.fromFile(filename); 
	
	if (hwpFile != null) {
	
	    // 첫번째 구역/문단에 문자열 추가하고
		Section s = hwpFile.getBodyText().getSectionList().get(0);
		Paragraph firstParagraph = s.getParagraph(0);
		firstParagraph.getText().addString("이것은 추가된 문자열입니다.");

		// 다른 이름으로 저장
		String writePath = filename.substring(0, 11) + "ed-" + filename.substring(11);
		HWPWriter.toFile(hwpFile, writePath);
	}
```

2017.4.26
=========================================================================================
* 구버전에서 만든 파일 읽기 오류 수정 - quantum123님 요청
	- 5.0.0.6, 5.0.2.4.1, 5.0.0.3, 5.0.1.6, 5.0.3.0.1, 5.0.0.5, 5.0.1.7 버전

2017.4.14
=========================================================================================
* 한 장 이상의 긴 문단을 읽지 못하는 문제 해결

2017.4.4
=========================================================================================
* 누름틀 필드 텍스트 찾기 기능 
	- 필드 텍스트가 여러 줄일때 처리 
	- 필드 텍스트에 컨트롤이 포함되었을 경우 처리
	- FieldFinder.getClickHereText() 에서 필드 텍스트에 컨트롤이 포함되었을 경우 처리를 위해 TextExtractMethod temInField 매개변수를 추가하였습니다.
```java
	String text1 = FieldFinder.getClickHereText(hwpFile, "필드1", TextExtractMethod.OnlyMainParagraph);
```

2017.3.29
=========================================================================================
* 누름틀 필드 텍스트 찾기 기능 완료 - musasin84님 요청
	- test/TestGettingClickHereFieldText.java 파일 참고 
```java
	HWPFile hwpFile = HWPReader.fromFile(filename);
	String text1 = FieldFinder.getClickHereText(hwpFile, "필드이름");
```

2017.3.20
=========================================================================================
* 누름틀 필드 컨트롤 읽기 오류 수정


2017.1.6
=========================================================================================

* 텍스트 추출기 모듈을 추가하였습니다. 
 	- TextExtractor.extract()의 두번째 파라미터 값에 따라 세가지 추출 방법을 구현했습니다.
		- OnlyMainParagraph // 메인 문단에 포함된 텍스트만 추출함
		- InsertControlTextBetweenParagraphText // 컨트롤의 텍스트를 문단 텍스트 사이에 삽입하여 추출함
		- AppendControlTextAfterParagraphText // 컨트롤의 텍스트를 문단 텍스트 뒤에 추가하여 추출함
	- test/TestExtractingText.java 파일 참고 <br> 
```java
	HWPFile hwpFile = HWPReader.fromFile(filename); 
	String hwpText = TextExtractor.extract(hwpFile, TextExtractMethod.InsertControlTextBetweenParagraphText);
```

* 읽기 모듈에서 버그 수정하였습니다.
* 소스 인코딩을 euc-kr에서 utf-8로 변경하였습니다. 


2016.12.23 
=========================================================================================
* 이 번 배포버전은 읽기 모듈 까지만 구현되었습니다. 쓰기 모듈은 추후 상황을 봐서 구현할 계획입니다.
	- 각각의 객체들과 객체에 포함된 메소스들에 대해선 "/doc" 디렉토리에 있는 javadoc 문서를 참고하시기 바랍니다.
```java
	// 파일을 읽는다. 
	HWPFile hwpFile = HWPReader.fromFile(filename);  			
	
	// 파일에서 첫번째 구역을 얻는다. 
	Section s = hwpFile.getBodyText().getSectionList().get(0); 		
	
	// 첫번째 구역에서 첫번째 문단을 얻는다. 
	Paragraph p = s.getParagraphList().get(0);				
	...		
```
