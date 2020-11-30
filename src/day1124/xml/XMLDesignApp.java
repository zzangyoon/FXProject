/*	10
	AWT 및 Swing은 순수한 자바코드로만 화면 디자인을 구성해야 하므로 유지보수 하기가 너무너무 어렵다
	이러한 문제를 해결하기 위해 디자인코드와 로직을 분리시켜 지원하는 방식을 이용해보자!
	Fx에서 디자인은 자바뿐만 아니라, xml로도 지원하고 있으며 사실 디자인은 앞으로 자바코드에서는 절대 하지 말아야 한다
	(특수한 경우만 뺴고)
*/
package day1124.xml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class XMLDesignApp extends Application{
	public void start(Stage stage) throws Exception {
		//현재 시점에는 디자인을 담당하는 xml과의 연관성이 없으므로
		//xml을 읽어서 현재 자바 코드로 가져와야 한다
		//DOM vs SAX parsing(현실의 데이터를 xml로 표현했을때) 을 사용하는 것이 아니라,
		//FX에서 지원하는 xml 해석객체를 이용하면 된다 (자체지원)
		URL url = this.getClass().getClassLoader().getResource("day1124/xml/main.fxml");	//같은 클래스 안에있는것 땡겨다 쓰기
		VBox parent = (VBox)FXMLLoader.load(url);
		showWindow(stage, parent);
		
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
