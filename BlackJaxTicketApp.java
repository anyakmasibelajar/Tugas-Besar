package com.tugasbesar.tugasbesar;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BlackJaxTicketApp extends Application {

    private Stage primaryStage;
    private Scene scene1, scene2, scene3, scene4, scene5, scene6;
    private Label subtotalLabel;
    private int regulerPrice = 100000;
    private int vipPrice = 150000;
    private int vvipPrice = 200000;
    private int regulerQuantity = 0;
    private int vipQuantity = 0;
    private int vvipQuantity = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        // Scene 1
        GridPane gridPane1 = new GridPane();
        gridPane1.setPadding(new Insets(40, 40, 40, 40));
        gridPane1.setVgap(10);
        gridPane1.setHgap(10);

        Label descLabel = new Label("Welcome to Black Jax Concert Ticket Sales! \n\n" +
                "For Sale!\n" +
                "Black Jax Music of Spheres\n" +
                "\nVenue \t : Stadium of Jakarta\n" +
                "Date \t : Jan 30th 2024\n" +
                "\nTickets available\n" +
                "Exchange tickets with seller at Box Office Stadium Jakarta");
        descLabel.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
        descLabel.setWrapText(true);
        GridPane.setConstraints(descLabel, 0, 0, 2, 1);

        Label ticketCategoryLabel = new Label("Ticket Category");
        GridPane.setConstraints(ticketCategoryLabel, 0, 2);

        Label regulerLabel = new Label("Reguler \t = Rp. 100.000");
        GridPane.setConstraints(regulerLabel, 0, 3);

        Label vipLabel = new Label("VIP \t \t = Rp. 150.000");
        GridPane.setConstraints(vipLabel, 0, 4);

        Label vvipLabel = new Label("VVIP \t = Rp. 200.000\n");
        GridPane.setConstraints(vvipLabel, 0, 5);


        Button buyTicketButton = new Button("  Buy Ticket  ");
        buyTicketButton.setOnAction(e -> {
            primaryStage.setScene(scene2);
        });
        GridPane.setConstraints(buyTicketButton, 5, 8);

        gridPane1.getChildren().addAll(descLabel, ticketCategoryLabel, regulerLabel, vipLabel, vvipLabel, buyTicketButton);

        scene1 = new Scene(gridPane1, 555, 455);

        // Scene 2
        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(40, 40, 40, 40));
        gridPane2.setVgap(10);
        gridPane2.setHgap(10);

        Label headsc2Label = new Label("Ticket Category");
        GridPane.setConstraints(headsc2Label, 0, 0);

        Label regulerPriceLabel = new Label("\tReguler \t = Rp. 100.000 \t\t\t");
        GridPane.setConstraints(regulerPriceLabel, 0, 1);

        Label vipPriceLabel = new Label("\tVIP \t \t = Rp. 150.000 \t\t\t");
        GridPane.setConstraints(vipPriceLabel, 0, 2);

        Label vvipPriceLabel = new Label("\tVVIP \t = Rp. 200.000 \t\t\t");
        GridPane.setConstraints(vvipPriceLabel, 0, 3);

        regulerPriceLabel.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
        vipPriceLabel.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
        vvipPriceLabel.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");


        subtotalLabel = new Label("\tSubTotal \t : Rp. 0");
        GridPane.setConstraints(subtotalLabel, 0, 4);

        Label Labelnone1 = new Label("\n");
        GridPane.setConstraints(Labelnone1, 0, 5);

        Spinner<Integer> regulerSpinner = new Spinner<>(0, 10, 0);
        regulerSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            regulerQuantity = newValue;
            updateSubtotalLabel();
        });
        GridPane.setConstraints(regulerSpinner, 8, 1);

        Spinner<Integer> vipSpinner = new Spinner<>(0, 10, 0);
        vipSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            vipQuantity = newValue;
            updateSubtotalLabel();
        });
        GridPane.setConstraints(vipSpinner, 8, 2);

        Spinner<Integer> vvipSpinner = new Spinner<>(0, 10, 0);
        vvipSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            vvipQuantity = newValue;
            updateSubtotalLabel();
        });
        GridPane.setConstraints(vvipSpinner, 8, 3);

        /*Label nonLabel = new Label("");
        GridPane.setConstraints(nonLabel, 0, 10);*/

        Button checkoutButton = new Button(" Checkout ");
        checkoutButton.setOnAction(e -> {
            if (regulerQuantity == 0 && vipQuantity == 0 && vvipQuantity == 0) {
                showAlert("Pilih setidaknya satu jenis tiket!");
            } else {
                primaryStage.setScene(scene3);
            }
        });
        GridPane.setConstraints(checkoutButton, 8, 19);

        // Set up transitions for back buttons
        Button backButtonScene2 = new Button(" Back ");
        backButtonScene2.setOnAction(e -> primaryStage.setScene(scene1));
        GridPane.setConstraints(backButtonScene2, 0, 19);

        gridPane2.getChildren().addAll(regulerPriceLabel, vipPriceLabel, vvipPriceLabel, subtotalLabel, Labelnone1, regulerSpinner, vipSpinner, vvipSpinner, checkoutButton, backButtonScene2, headsc2Label);

        scene2 = new Scene(gridPane2, 555, 455);

        // Scene 3
        GridPane gridPane3 = new GridPane();
        gridPane3.setPadding(new Insets(40, 40, 40, 40));
        gridPane3.setVgap(10);
        gridPane3.setHgap(10);

        Label headsc3Label = new Label("Data Pembeli");
        GridPane.setConstraints(headsc3Label, 4, 0);

        Label usernameLabel = new Label("Nama \t\t  :");
        GridPane.setConstraints(usernameLabel, 4, 1);

        TextField usernameField = new TextField();
        GridPane.setConstraints(usernameField, 6, 1);

        Label emailLabel = new Label("Email \t \t  :");
        GridPane.setConstraints(emailLabel, 4, 2);

        TextField emailField = new TextField();
        GridPane.setConstraints(emailField, 6, 2);

        Label phoneLabel = new Label("Nomor Telepon :");
        GridPane.setConstraints(phoneLabel, 4, 3);

        TextField phoneField = new TextField();
        GridPane.setConstraints(phoneField, 6, 3);

        Button submitButton = new Button("  Submit  ");
        GridPane.setConstraints(submitButton, 7, 24);

        Button backButtonScene3 = new Button(" Back ");
        backButtonScene3.setOnAction(e -> primaryStage.setScene(scene2));
        GridPane.setConstraints(backButtonScene3, 1, 24);

        gridPane3.getChildren().addAll(usernameLabel, usernameField, emailLabel, emailField, phoneLabel, phoneField, submitButton, backButtonScene3, headsc3Label);

        scene3 = new Scene(gridPane3, 555, 455);

        // Scene 4
        GridPane gridPane4 = new GridPane();
        gridPane4.setPadding(new Insets(40, 40, 40, 40));
        gridPane4.setVgap(10);
        gridPane4.setHgap(10);

        Label headsc4Label = new Label("Data Pembeli");
        GridPane.setConstraints(headsc4Label, 1, 0);

        Label nameLabel = new Label("- Nama \t\t\t\t : ");
        GridPane.setConstraints(nameLabel, 1, 1);

        Label emailLabelScene4 = new Label("- Email \t\t\t\t : ");
        GridPane.setConstraints(emailLabelScene4, 1, 2);

        Label phoneLabelScene4 = new Label("- No. Telp \t\t\t : ");
        GridPane.setConstraints(phoneLabelScene4, 1, 3);

        Label headsc42Label = new Label("Jenis Tiket");
        GridPane.setConstraints(headsc42Label, 1, 5);

        Label regulerQuantityLabel = new Label("- Reguler \t\t\t\t : ");
        GridPane.setConstraints(regulerQuantityLabel, 1, 6);

        Label vipQuantityLabel = new Label("- VIP \t\t\t\t : ");
        GridPane.setConstraints(vipQuantityLabel, 1, 7);

        Label vvipQuantityLabel = new Label("- VVIP \t\t\t\t : ");
        GridPane.setConstraints(vvipQuantityLabel, 1, 8);

        Label totalHargaLabel = new Label("Total Harga \t\t\t : ");
        GridPane.setConstraints(totalHargaLabel, 1, 10);

        Label nameLabelValue = new Label();
        GridPane.setConstraints(nameLabelValue, 2, 1);

        Label emailLabelValue = new Label();
        GridPane.setConstraints(emailLabelValue, 2, 2);

        Label phoneLabelValue = new Label();
        GridPane.setConstraints(phoneLabelValue, 2, 3);

        Label regulerQuantityValue = new Label();
        GridPane.setConstraints(regulerQuantityValue, 2, 6);

        Label vipQuantityValue = new Label();
        GridPane.setConstraints(vipQuantityValue, 2, 7);

        Label vvipQuantityValue = new Label();
        GridPane.setConstraints(vvipQuantityValue, 2, 8);

        Label totalHargaValue = new Label();
        GridPane.setConstraints(totalHargaValue, 2, 10);

        Label none4Label = new Label("\t\t\t\t\t\t");
        GridPane.setConstraints(none4Label, 2, 18);

        Button nextButtonScene4 = new Button("  Next  ");
        nextButtonScene4.setOnAction(e -> {
            primaryStage.setScene(scene5);
        });
        GridPane.setConstraints(nextButtonScene4, 8, 18);


        // Set up transitions for back buttons
        Button backButtonScene4 = new Button(" Back ");
        backButtonScene4.setOnAction(e -> primaryStage.setScene(scene3));
        GridPane.setConstraints(backButtonScene4, 1, 18);


        gridPane4.getChildren().addAll(
                nameLabel, emailLabelScene4, phoneLabelScene4,
                regulerQuantityLabel, vipQuantityLabel, vvipQuantityLabel,
                totalHargaLabel, nameLabelValue, emailLabelValue, phoneLabelValue,
                regulerQuantityValue, vipQuantityValue, vvipQuantityValue,
                totalHargaValue, nextButtonScene4, backButtonScene4, none4Label, headsc4Label, headsc42Label
        );

        scene4 = new Scene(gridPane4, 555, 455);


        // Scene 5
        GridPane gridPane5 = new GridPane();
        gridPane5.setPadding(new Insets(40, 40, 40, 40));
        gridPane5.setVgap(10);
        gridPane5.setHgap(10);

        Label paymentMethodLabel = new Label("Metode Pembayaran \t :");
        GridPane.setConstraints(paymentMethodLabel, 0, 0);

        ComboBox<String> paymentMethodComboBox = new ComboBox<>();
        paymentMethodComboBox.getItems().addAll("Transfer Bank\t\t\t\t\t\t", "E-wallet");
        GridPane.setConstraints(paymentMethodComboBox, 1, 0);

        Label bankLabel = new Label("Bank \t \t \t \t :");
        GridPane.setConstraints(bankLabel, 0, 1);

        ComboBox<String> bankComboBox = new ComboBox<>();
        bankComboBox.getItems().addAll("Mandiri (1480020042993 - AN.Roni)\t", "BCA (0980445151 - AN.Rahmat)", "BNI (0359241722 - AN.Rahma)", "BRI (0624 0102 1384 506 - AN.Bagas)");
        bankComboBox.setDisable(true);
        GridPane.setConstraints(bankComboBox, 1, 1);

        Label eWalletLabel = new Label("E-wallet \t \t \t \t :");
        GridPane.setConstraints(eWalletLabel, 0, 2);

        ComboBox<String> eWalletComboBox = new ComboBox<>();
        eWalletComboBox.getItems().addAll("Shopeepay (081254126998 - Rafa)\t\t", "Dana (081250970010 - Dimas)");
        eWalletComboBox.setDisable(true);
        GridPane.setConstraints(eWalletComboBox, 1, 2);

        paymentMethodComboBox.setOnAction(e -> {
            if ("Transfer Bank\t\t\t\t\t\t".equals(paymentMethodComboBox.getValue())) {
                bankComboBox.setDisable(false);
                eWalletComboBox.setDisable(true);
            } else if ("E-wallet".equals(paymentMethodComboBox.getValue())) {
                bankComboBox.setDisable(true);
                eWalletComboBox.setDisable(false);
            }
        });

        Button nextButtonScene5 = new Button("  Next  ");
        nextButtonScene5.setOnAction(e -> {
            if (paymentMethodComboBox.getValue() == null) {
                showAlert("Pilih metode pembayaran!");
            } else {
                primaryStage.setScene(scene6);
            }
        });
        GridPane.setConstraints(nextButtonScene5, 2, 26);

        // Set up transitions for back buttons
        Button backButtonScene5 = new Button(" Back ");
        backButtonScene5.setOnAction(e -> primaryStage.setScene(scene4));
        GridPane.setConstraints(backButtonScene5, 0, 26);


        gridPane5.getChildren().addAll(paymentMethodLabel, paymentMethodComboBox, bankLabel, bankComboBox, eWalletLabel, eWalletComboBox, nextButtonScene5, backButtonScene5);

        scene5 = new Scene(gridPane5, 555, 455);


        // Scene 6
        GridPane gridPane6 = new GridPane();
        gridPane6.setPadding(new Insets(40, 40, 40, 40));
        gridPane6.setVgap(10);
        gridPane6.setHgap(10);

        Label instructionLabel = new Label("\nAtas nama pengirim");
        GridPane.setConstraints(instructionLabel, 2, 0);

        Label pengirimLabel = new Label("Atas nama \t : ");
        GridPane.setConstraints(pengirimLabel, 2, 1);

        TextField pengirimField = new TextField();
        GridPane.setConstraints(pengirimField, 3, 1);

        Label none5Label = new Label("\t\t\t");
        GridPane.setConstraints(none5Label, 3, 28);

        Button endButton = new Button(" Finish ");
        endButton.setOnAction(e -> {
            if (pengirimField.getText().isEmpty() || paymentMethodComboBox.getValue() == null) {
                showAlert("Kolom input harus diisi!");
            } else {
                saveToFile(usernameField.getText(), emailField.getText(), phoneField.getText(),
                        regulerQuantity, vipQuantity, vvipQuantity,
                        paymentMethodComboBox.getValue(), pengirimField.getText());

                showAlert2("Anda berhasil membeli tiket!\nE-ticket akan dikirim ke email setelah pembayaran selesai!");
                Platform.exit();
            }
        });
        GridPane.setConstraints(endButton, 7, 28);

        // Set up transitions for back buttons
        Button backButtonScene6 = new Button(" Back ");
        backButtonScene6.setOnAction(e -> primaryStage.setScene(scene5));
        GridPane.setConstraints(backButtonScene6, 1, 28);


        gridPane6.getChildren().addAll(pengirimLabel, pengirimField, instructionLabel, endButton, backButtonScene6, none5Label);

        scene6 = new Scene(gridPane6, 555, 455);

        // Set up transitions for next button
        submitButton.setOnAction(e -> {
            if (usernameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty()) {
                showAlert("Semua kolom harus diisi!");
            } else if (!emailField.getText().endsWith("@gmail.com")) {
                showAlert("Email tidak valid!");
            } else if (!phoneField.getText().matches("08\\d+")) {
                showAlert("Nomor telepon tidak valid!");
            } else {
                nameLabelValue.setText(usernameField.getText());
                emailLabelValue.setText(emailField.getText());
                phoneLabelValue.setText(phoneField.getText());
                regulerQuantityValue.setText(String.valueOf(regulerQuantity));
                vipQuantityValue.setText(String.valueOf(vipQuantity));
                vvipQuantityValue.setText(String.valueOf(vvipQuantity));
                int totalHarga = regulerQuantity * regulerPrice + vipQuantity * vipPrice + vvipQuantity * vvipPrice;
                totalHargaValue.setText("Rp. " + totalHarga);
                primaryStage.setScene(scene4);
            }
        });

        // Set up transitions continued
        primaryStage.setTitle("Ticket BlackJax");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    private void updateSubtotalLabel() {
        int subtotal = regulerQuantity * regulerPrice + vipQuantity * vipPrice + vvipQuantity * vvipPrice;
        subtotalLabel.setText("\tSubTotal \t : Rp. " + subtotal);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAlert2(String message) {
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information");
        alert2.setHeaderText(null);
        alert2.setContentText(message);
        alert2.showAndWait();
    }


    private void saveToFile(String name, String email, String phone,
                            int regulerQuantity, int vipQuantity, int vvipQuantity,
                            String paymentMethod, String senderName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pembeli_data.txt", true))) {
            // Adding buyer data to the file
            writer.write("Nama: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Nomor Telepon: " + phone + "\n");
            writer.write("Reguler: " + regulerQuantity + "\n");
            writer.write("VIP: " + vipQuantity + "\n");
            writer.write("VVIP: " + vvipQuantity + "\n");

            // Adding payment method and sender's name
            writer.write("Metode Pembayaran: " + paymentMethod + "\n");
            writer.write("Atas Nama Pengirim: " + senderName + "\n");
            writer.write("\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}