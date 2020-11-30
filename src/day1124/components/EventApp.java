/*	9
	액선이벤트, 키보드이벤트, 마우스이벤트 처리
*/
package day1124.components;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EventApp extends Application{
	Button bt;
	TextField t;
	ImageView imageView;
	
	public void start(Stage stage) throws Exception {
		//액선이벤트, 키보드이벤트, 마우스이벤트 처리
		bt = new Button("나버튼");
		t = new TextField();
		imageView = new ImageView("https://ncdinos.com/data/player/489_1597466718_15134513_profile.jpg");
		
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		imageView.setPreserveRatio(true);
		
		//이벤트소스와 이벤트핸들러 연결
		/*
		bt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("나 눌렀어?");
			}
		});
		*/
		//객체가 보유한 메서드가 달랑 1개이므로, 함수형 프로그래밍 방식으로 진행해도 될것이다.. 따라서 람다로 표현하자
		bt.setOnAction((e)->{
			System.out.println("눌렀어?");
		});
		
		/*
		t.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				//엔터를 치면
				if(e.getCode() == KeyCode.ENTER) {
					System.out.println("엔터 쳤어?");
				}
			}
		});
		*/
		t.setOnKeyReleased((e)->{
			if(e.getCode() == KeyCode.ENTER) {
				System.out.println("엔터?");
			}
		});
		
		imageView.setOnMouseClicked((e)->{
			System.out.println("마우스 클릭했어?");
		});
		
		FlowPane flow = new FlowPane(bt, t, imageView);	//가변형 인자로 선언된 생성자 이므로
																					//매개변수의 갯수를 실행타임에 결정지을 수 있다
		
		showWindow(stage, flow);
		//test(3,5,6,7);
	}

	public void test(int... x) {	//갯수는 호출자가 결정하는 것임
		System.out.println("당신이 넘긴 매개변수의 수는 " + x.length);
		for(int v:x) {
			System.out.println("값은 "+v);
		}
		
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);	//씬 생성(자료형이 parent인 컨테이너)
		stage.setScene(s);	//생성된 씬을 윈도우에 적용
		stage.show();	//윈도우 보여주기
		stage.setWidth(500);	//너비
		stage.setHeight(500);//높이
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
