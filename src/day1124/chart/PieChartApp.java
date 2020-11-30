/*	2
	[FX 지원차트]
	PieChart
	LineChart
	AreaChart
	BarChart
	BubbleChart
	ScatterChart

*/
package day1124.chart;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartApp extends Application{
	PieChart pie;
	
	public void start(Stage stage) throws Exception {
		pie = new PieChart();
		
		//파이차트의 데이터 구성하기!
		PieChart.Data s1 = new PieChart.Data("안드로이드폰", 6);	//안드로이드가 60% 차지
		PieChart.Data s2 = new PieChart.Data("아이폰", 3);			//아이폰이 30% 차지
		PieChart.Data s3 = new PieChart.Data("윈도우폰", 1);		//윈도우폰이 10% 차지
		
		//파이차트에 적용
		pie.getData().add(s1);
		pie.getData().add(s2);
		pie.getData().add(s3);
		
		pie.setLegendSide(Side.LEFT);	//안드-빨간색, 윈도우-초록색 표시 자리옮기기
		
		showWindow(stage, pie);
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
