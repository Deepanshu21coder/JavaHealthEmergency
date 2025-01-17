import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class RemedyApppp1 extends Application {
    private Map<String, String> remedies;
    private Map<String, Image> images;

    public RemedyApppp1() {
        remedies = new HashMap<>();
        remedies.put("headache", "Drink plenty of water and rest.");
        remedies.put("cold","**Chili peppers** for pain and soreness: **Capsaicin**, the active component of chili peppers, is a popular topical ingredient for managing pain. It works by causing an area of the skin to get hot, before eventually turning numb.\n" +
        "**Ginger**: This root is often used in teas and cooking. It has anti-inflammatory properties and can help with nausea and digestion.\n" +
        "**Shiitake**: These mushrooms are known for their immune-boosting properties.\n" +
        "**Eucalyptus**: Often used in essential oils, eucalyptus can help with congestion and cold symptoms.\n" +
        "**Lavender**: Known for its calming properties, lavender is often used in aromatherapy to reduce anxiety and promote sleep.\n" +
        "**Mint**: Mint can help with digestion and headaches. Its often consumed as a tea.\n" +
        "**Fenugreek**: This herb can help with digestive problems and reducing inflammation.\n" +
        "**Magnesium**: Often taken as a supplement, magnesium can help with sleep and muscle cramps");
        remedies.put("heart attack", "Perform CPR:");
        remedies.put("cobra bite", "Apply first aid while waiting for EMS staff to get you to the hospital.\n"+
        "Lay or sit down with the bite in a neutral position of comfort.\n"+
        "Remove rings and watches before swelling starts.\n"+
        "Wash the bite with soap and water.\n"+
        "Cover the bite with a clean, dry dressing.\n"+
        "Mark the leading edge of tenderness/swelling on the skin and write the time alongside it.\n");


        

        images = new HashMap<>();
        images.put("headache", new Image("https://c8.alamy.com/comp/CC8466/young-woman-with-having-cold-isolated-CC8466.jpg"));
        images.put("cold", new Image("https://www.urgentcarehouma.com/wp-content/uploads/2020/09/fever-cold-or-flu.jpg"));
        images.put("heart attack", new Image("https://static.wixstatic.com/media/cd436c_a6bb74391ff6479495f4d8e27849cf43~mv2.gif"));
        images.put("cobra bite", new Image("https://bestanimations.com/Animals/Reptiles/snakes/snake-animation-gif-4.gif"));

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Homemade Remedy App");

        Label label = new Label("Select a disease to get a remedy:");
        label.setTextFill(Color.web("#0076a3"));

        ComboBox<String> diseases = new ComboBox<>();
        diseases.getItems().addAll(remedies.keySet());

        TextArea textArea = new TextArea();
        ImageView imageView = new ImageView();
        imageView.setFitHeight(300); // Set the height of the image
        imageView.setFitWidth(300); // Set the width of the image
        imageView.setPreserveRatio(true); // Preserve the aspect ratio

        Button button = new Button("Get Remedy");
        button.setOnAction(e -> {
            String disease = diseases.getValue().toLowerCase();
            String remedy = remedies.get(disease);
            if (remedy != null) {
                textArea.setText("Remedy: " + remedy);
                imageView.setImage(images.get(disease));
            } else {
                textArea.setText("No remedy found for " + disease);
            }
        });

        VBox vbox = new VBox(label, diseases, button, textArea, imageView);
        vbox.setAlignment(Pos.CENTER); // Set the alignment of the VBox to center
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setStyle("-fx-background-color: #add8e6;");

        Scene scene = new Scene(vbox, 800, 600); // Set the initial size of the scene
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true); // Set the stage to full screen
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
