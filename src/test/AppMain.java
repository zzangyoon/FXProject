/*	1
 	1. javaFX
 	2. Swing
 	3. 중립적 클래스
 	이 중 중립적 클래스이다
 	fx로 만드려면 extends Application 해주면 된다
*/
package test;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application{
									/* javaFX 어플리케이션을 정의하기 위해서는 반드시 Application 추상클래스를 상속받아야 한다! */
	
	/*	FX application 생명주기 메서드가 지원됨 */
	
	public AppMain() {
		System.out.println("AppMain() 생성자 메서드 호출 by "+Thread.currentThread().getName());
	}
	
	/*하나의 stage(윈도우)에 하나의 scene(무대)가 올 수 있다*/
	
	//어플리케이션이 실행할 준비가 되면 호출되는 메서드
	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("start() 메서드 호출 by "+Thread.currentThread().getName());
		//매개변수로 받은 stage 변수가 어플리케이션의 윈도우이다!
		
		//무대를 정의한다! (FX에서는 윈도우에 반드시 하나의 Scene 이 존재해야함)
		VBox parent = new VBox();		//수직으로 컴포넌트를 배치하는 레이아웃 객체
														//FlowLayout과 비슷한 객체
		
		Scene s = new Scene(parent);	//Parent란? 부모의 클래스를 의미하는 것이 아니라, 
														//객체간 포함관계에서 바깥쪽 컨테이너를 의미
														//Swing과 비유하자면, 레이아웃 자체가 Parent 이다!
		
		Button bt = new Button("나버튼");
		bt.setPrefWidth(200);
		bt.setPrefHeight(40);
		
		//버튼을 parent에 부착하기
		parent.getChildren().add(bt);
		javafx.scene.control.TextField t = new javafx.scene.control.TextField("test");
		parent.getChildren().add(t);
		
		//scene을 윈도우에 부착
		stage.setScene(s);
		
		bt.setOnAction((e)->{
			System.out.println("클릭했어?");
		});
		
		
		stage.setMaxWidth(500);
		stage.setMaxHeight(500);
		stage.show(); //윈도우 보이게
	}
	
	/*	어플리케이션 시작 전, 초기화를 담당하는 메서드이다. 따라서 초기화 할게 없다면 재정의는 필수는 아니다
	 	생성자 vs init()	누가 더 먼저 태어날까
	 	생성자 : 인스턴스가 태어날때 호출되는 메서드(더 시점 빠르다)
	 	init() : 태어난 이후에, 초기화 작업에 사용되는 메서드	*/
	@Override
	public void init() throws Exception {
		//자바의 쓰레드의 메서드 중 현재 실행중인 쓰레드 정보를 얻기위한 메서드
		//Thread.currentThread().getName();
		System.out.println("init() 메서드 호출 by "+Thread.currentThread().getName());
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("stop() 메서드 호출 by "+Thread.currentThread().getName());
	}
		
	public static void main(String[] args) {
		System.out.println("launch() 메서드 호출 by "+Thread.currentThread().getName());
		launch(args);	//실행명령어 > start 메서드가 호출되서 window를 만든다
	}

}
