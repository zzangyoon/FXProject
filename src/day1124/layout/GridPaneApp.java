/*	3
	GridPane은 AWT의 GridLayout과 기능이 같다(즉, 행과 열로 배치하는 레이아웃)
*/
package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneApp extends Application{
	public void start(Stage stage) throws Exception {
		GridPane parent = new GridPane();
		
		//AWT와는 다르게 컨테이너에 부착시 행, 열 형태가 결정된다
		Button[] btn = new Button[6];
		for(int i=0; i<btn.length; i++) {
			btn[i]= new Button("버튼"+i);
			btn[i].setPrefWidth(100);	//너비
			btn[i].setPrefHeight(100);	//높이
		}
		
		//parent.add(child, 호, 층);
		parent.add(btn[0], 0, 0);
		parent.add(btn[1], 1, 0);
		parent.add(btn[2], 2, 0);
		
		parent.add(btn[3], 0, 1);
		parent.add(btn[4], 1, 1);
		parent.add(btn[5], 2, 1);	
		
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
