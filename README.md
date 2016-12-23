# hwplib

한글과 컴퓨터(한컴)에서 만든 워드프로세서 "한글"의 파일에 대한 라이브러리입니다.

본 라이브러리는 JAVA로 구현되었으며,  한글 파일의 하부 구조인 Microsoft Compound File의 읽기 부분은  Apache-POI의 POIFS File System을 사용하여 처리합니다.
	
본 라이브러리는 한글과컴퓨터의 한글 문서 파일(.hwp) 공개 문서를 참고하여 개발하였습니다.

이 번 배포버전은 읽기 모듈 까지만 구현되었습니다. 쓰기 모듈은 이 번 배포버전의 배포 상황을 봐서 추후에 구현할 예정입니다.

사용법은 

HWPFile hwpfile = HWPReader.fromFile(filename); 

filename인 한글 파일을 읽어서  HWPFile 객체를 생성한 후 이 객체의 get  매소스를 이용하여 원하는 정보를 반환 받아서 사용하시면 됩니다.

각각의 객체들과 객체에 포함된 메소스들에 대해선 "/doc" 디렉토리에 있는 javadoc 문서를 참고하실 바랍니다.

요구사항이나 질문이 있으시면 issue로 올려주세요.

한컴에서 제공하는 문서(HWP 5.0)는 아래URL에서 받을 수 있습니다. 

http://www.hancom.com/etc/hwpDownload.do?gnb0=269&gnb1=271&gnb0=101&gnb1=140
