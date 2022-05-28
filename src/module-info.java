/**
 * @author nous
 *
 */
module Hanabi {
	requires javafx.controls;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;
}
