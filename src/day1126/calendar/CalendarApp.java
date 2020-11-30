package day1126.calendar;

import java.util.Calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class CalendarApp extends Application{
	ChoiceBox ch_yy;	//연도
	ChoiceBox ch_mm;	//월
	Button bt;
	TilePane tilePane;
	int startDayOfWeek;	//해당 월의 시작 요일(1부터 시작함)
	int lastDate;	//각 월의 마지막날
	Box[] box = new Box[7*6];	//empty
	
	public void start(Stage stage) throws Exception {
		BorderPane borderPane = FXMLLoader.load(this.getClass().getClassLoader().getResource("day1126/calendar/layout.fxml"));
		
		//루트 하위에 등록된 객체 찾아나서기~
		//js의 document.getElementById("ch_yy");	와 원리가 같다!
		ch_yy = (ChoiceBox)borderPane.lookup("#ch_yy");	//아이디 앞에 #
		ch_mm = (ChoiceBox)borderPane.lookup("#ch_mm");	//아이디 앞에 #
		bt = (Button)borderPane.lookup("#bt");
		tilePane = (TilePane)borderPane.lookup("#tilePane");
		
		initDate();	//초이스박스 초기화!
		createTitle();	//요일 구성하기
		createDateBox();	//날짜박스 생성하기!
		
		getStartDayOfWeek();	//시작요일 구하기
		getLastDate();	//마지막일 구하기

		bt.setOnAction((e)->{
			getStartDayOfWeek();	//시작요일 구하기
			getLastDate();	//마지막일 구하기
			printData();	//초기화 후 글씨 써넣기
		});
		
		/*	연습이었음!
		//49개의 셀을 생성하여 보더페인의 센터에 붙이자!
		for(int i=0; i<7*6; i++) {
			Box box = new Box(Integer.toString(i),100,100);
			tilePane.getChildren().add(box);
		}
		*/
		
		
		showWindow(stage, borderPane);
	}
	
	public void initDate() {		
		for(int i=2020; i>=1990; i--) {
			ch_yy.getItems().add(i);
		}
		//ch_yy.getSelectionModel().select(0);	//n번째 요소가 선택되어 있게
		ch_yy.getSelectionModel().selectFirst();//무조건 처음요소가 선택되어 있게
		
		for(int i=1; i<=12; i++) {
			ch_mm.getItems().add(i);
		}
		ch_mm.getSelectionModel().selectFirst();
	}
	
	//요일7 박스 생성하기
	public void createTitle() {
		for(int i=0; i<Days.values().length; i++) {
			Box box = new Box(Days.values()[i].toString(), 100, 100);
			tilePane.getChildren().add(box);
		}
	}
	
	//행:6, 열:7
	public void createDateBox() {
		for(int i=0; i<7*6; i++) {
			box[i] = new Box(Integer.toString(i), 100, 100);
			tilePane.getChildren().add(box[i]);
		}
	}
	
	//해당 월의 시작 요일 구하기(왜? 그래야 해당 요일부터 1일씩 출력하므로!)
	//주의!!! 요일은 1부터 시작함, 월은 0부터 시작함
	public void getStartDayOfWeek() {
		//날짜 객체를 하나 만든다(왜? 조작하려고)
		Calendar cal = Calendar.getInstance();	//현재날짜
		//System.out.println(cal);
		
		//이 현재날짜를 내가 원하는 날짜로 왜곡시켜야 한다
		//cal.set(2020, 10, 1); //2020.11.01일로 조작했다
		int yy = (Integer)ch_yy.getValue();
		int mm = (Integer)ch_mm.getValue();
		cal.set(yy, mm-1, 1);	//초이스박스에서 얻어온 년, 월로 조작하기
		
		//조작된 상태의 날짜 객체에게 현재 요일을 물어보자
		startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("조작된 월의 시작 요일은 : "+startDayOfWeek);
	}
	
	//해당 월이 몇일까지 있는지 구하기
	public void getLastDate() {
		Calendar cal = Calendar.getInstance();
		
		int yy = (Integer)ch_yy.getValue();
		int mm = (Integer)ch_mm.getValue();
		
		//주의! 해당 월을 0일로 세팅하면, 즉 날짜만 조작해도 월이 자동으로 변환된다
		cal.set(yy, mm, 0);	//여기 mm은 자동으로 -1이 되므로, mm-1 할필요 없다!!!
		
		//조작된 상태이므로 현재 객체가 몇일에 와있는지 조사하자
		lastDate = cal.get(Calendar.DATE);	//너 몇일이니? 물어봄
		System.out.println(lastDate);
	}
	
	//생성된 박스들을 대상으로, 내부의 텍스트 출력하기!
	public void printData() {
		//모든 박스를 다시 초기화!
		for(int i=0; i<box.length; i++) {
			box[i].erase();
		}
		
		//주의!!! 출력하기 전에, 유저가 선택한 년, 월을 이용하여 startDayofWeek, lastDate를 다시 구해야함
		getStartDayOfWeek();
		getLastDate();
		
		//각 월에 알맞는 데이터 출력
		//반복문에서 i의 역할은 날짜출력이 아니라, 단지 반복문의 횟수를 결정하기 위한...
		int n=1;	//1일부터 1씩 증가하며 출력될 날짜 출력용 변수
		for(int i=(startDayOfWeek-1); i<((startDayOfWeek-1)+lastDate); i++) {	//i=시작요일; (배열이므로 -1)i<해당월의 일수;
			//캔버스(박스).renderText( , , );
			box[i].renderText(Integer.toString(n));
			n++;
		}
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);	//씬 생성(자료형이 parent인 컨테이너)
		stage.setScene(s);	//생성된 씬을 윈도우에 적용
		stage.show();	//윈도우 보여주기
		stage.setWidth(730);	//너비
		stage.setHeight(800);//높이
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
