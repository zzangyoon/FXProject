/*	3
	코로나 현황을 지역별로 표현
*/
package day1124.chart;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartApp extends Application{
	BarChart bar;
	CategoryAxis x;	//x축으로 사용할 객체 (유럽, 북미, 아시아...)
	NumberAxis y;	//y축으로 사용할 객체(코로나 감염자 수)
	
	public void start(Stage stage) throws Exception {
		x = new CategoryAxis();
		y = new NumberAxis();
		
		//x,y 축에 라벨 달기
		x.setLabel("Area");
		y.setLabel("Numbers");
		
		//데이터 구성! XYChartSeries 이용하자!
		XYChart.Series s = new XYChart.Series();
		s.setName("아시아");
		s.getData().add(new XYChart.Data("20만명", 20));
		
		XYChart.Series s2 = new XYChart.Series();
		s2.setName("유럽");
		s2.getData().add(new XYChart.Data("68만명", 68));
		
		XYChart.Series s3 = new XYChart.Series();
		s3.setName("북미");
		s3.getData().add(new XYChart.Data("300만명", 300));
				
		bar = new BarChart(x, y);
		
		bar.setLegendSide(Side.RIGHT);
		
		//bat 차트에 데이터 적용
		bar.getData().addAll(s, s2, s3);
		
		showWindow(stage, bar);
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
