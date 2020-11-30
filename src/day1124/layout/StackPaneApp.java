/*	4
	StackPane : Stack 구조로 쌓을 수 있는 레이아웃, AWT의 CardLayout과 동일한 기능
	CardLayout은 페이지 처리에 사용되지만, 우리는 페이지 전환처리를 직접 제작하여 CardLayout을 사용할 필요가 없었다
*/
package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneApp extends Application{
	public void start(Stage stage) throws Exception {
		StackPane parent = new StackPane();
		//버튼 4개를 쌓을 예정
		Button bt1 = new Button("버튼1");
		Button bt2 = new Button("버튼2");
		Button bt3 = new Button("버튼3");
		Button bt4 = new Button("버튼4");
		
		//먼저 쌓이는 버튼을 보다 크게 처리
		bt1.setPrefSize(100, 100);
		bt2.setPrefSize(150, 150);
		bt3.setPrefSize(200, 200);
		bt4.setPrefSize(250, 250);
		
		//버튼 4부터 넣어보자! (버튼1이 제일 위에 올라오게)
		parent.getChildren().add(bt4);
		parent.getChildren().add(bt3);
		parent.getChildren().add(bt2);
		parent.getChildren().add(bt1);
		
		showWindow(stage, parent);
	}
	
	//복사해온것
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
