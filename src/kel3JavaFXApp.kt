import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.stage.Stage
import javafx.application.Application
import javafx.application.Application.launch

class kel3JavaFXApp : Application() {

    private lateinit var logArea: TextArea

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Kel-3"

        // ===== Judul =====
        val titleLabel = Label("JavaFX Kelompok 3")
        titleLabel.font = Font.font("Arial", FontWeight.BOLD, 20.0)
        val titleLabel1 = Label("Nama-nama Anggota Kelompok 3\n"+"1. Yudha Pratama\n" +
                "2. M Sahru Ramadhan\n" +
                "3. Aswan Indra Natalis Pakpahan\n" +
                "4. Puan Lutviana Kharisma Balqis\n" +
                "5. Vika Lestari\n" +
                "6. Nayla Fidiananta")
        titleLabel1.font = Font.font("Arial", FontWeight.BOLD, 12.0)

        // ===== SplitMenuButton =====
        val splitMenuLabel = Label("SplitMenuButton:")
        splitMenuLabel.font = Font.font(null, FontWeight.BOLD, 14.0)

        val splitMenuButton = SplitMenuButton()
        splitMenuButton.text = "File Operations"
        val splitItem1 = MenuItem("New File")
        val splitItem2 = MenuItem("Open File")
        val splitItem3 = MenuItem("Save File")
        splitMenuButton.items.addAll(splitItem1, splitItem2, splitItem3)

        splitItem1.setOnAction { splitMenuButton.text = "New File"; log("SplitMenu: New File") }
        splitItem2.setOnAction { splitMenuButton.text = "Open File"; log("SplitMenu: Open File") }
        splitItem3.setOnAction { splitMenuButton.text = "Save File"; log("SplitMenu: Save File") }

        // ===== Toggle Buttons =====
        val toggleLabel = Label("ToggleButton:")
        toggleLabel.font = Font.font(null, FontWeight.BOLD, 14.0)

        val toggle1 = ToggleButton("Bold")
        val toggle2 = ToggleButton("Italic")
        val toggle3 = ToggleButton("Underline")

        toggle1.setOnAction { log("Toggle: Bold ${if (toggle1.isSelected) "ON" else "OFF"}") }
        toggle2.setOnAction { log("Toggle: Italic ${if (toggle2.isSelected) "ON" else "OFF"}") }
        toggle3.setOnAction { log("Toggle: Underline ${if (toggle3.isSelected) "ON" else "OFF"}") }

        val toggleBox = VBox(5.0, toggle1, toggle2, toggle3)

        // ===== RadioButtons =====
        val radioLabel = Label("RadioButton:")
        radioLabel.font = Font.font(null, FontWeight.BOLD, 14.0)

        val radioGroup = ToggleGroup()
        val radio1 = RadioButton("Small").apply { toggleGroup = radioGroup }
        val radio2 = RadioButton("Medium").apply { toggleGroup = radioGroup }
        val radio3 = RadioButton("Large").apply { toggleGroup = radioGroup }

        radio1.setOnAction { log("Radio: Small Di Pilih") }
        radio2.setOnAction { log("Radio: Medium Di Pilih") }
        radio3.setOnAction { log("Radio: Large Di Pilih") }

        val radioBox = VBox(5.0, radio1, radio2, radio3)

        // ===== CheckBoxes =====
        val checkLabel = Label("CheckBox:")
        checkLabel.font = Font.font(null, FontWeight.BOLD, 14.0)

        val check1 = CheckBox("Enable Notifications")
        val check2 = CheckBox("Auto Save")
        val check3 = CheckBox("Dark Mode")
        val check4 = CheckBox("Show Line Numbers")

        check1.setOnAction { log("Check: Notifications ${status(check1)}") }
        check2.setOnAction { log("Check: Auto Save ${status(check2)}") }
        check3.setOnAction { log("Check: Dark Mode ${status(check3)}") }
        check4.setOnAction { log("Check: Line Numbers ${status(check4)}") }

        val checkBox = VBox(5.0, check1, check2, check3, check4)

        // ===== ChoiceBox =====
        val choiceLabel = Label("ChoiceBox:")
        choiceLabel.font = Font.font(null, FontWeight.BOLD, 14.0)

        val choiceBox = ChoiceBox<String>()
        choiceBox.items.addAll("Java", "Python", "C++", "Kotlin")
        choiceBox.value = "Java"
        choiceBox.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
            log("ChoiceBox: $newValue Di Pilih")
        }

        // ===== ComboBox =====
        val comboLabel = Label("ComboBox:")
        comboLabel.font = Font.font(null, FontWeight.BOLD, 14.0)

        val comboBox = ComboBox<String>()
        comboBox.items.addAll("Windows", "macOS", "Linux")
        comboBox.value = "Windows"
        comboBox.isEditable = true
        comboBox.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
            log("ComboBox: $newValue Di pilih")
        }

        // ===== Log Area =====
        val logLabel = Label("Activity Log:")
        logLabel.font = Font.font(null, FontWeight.BOLD, 14.0)

        logArea = TextArea()
        logArea.isEditable = false
        logArea.prefRowCount = 8
        logArea.promptText = "Log aktivitas akan tampil di sini"

        val clearBtn = Button("Clear Log")
        clearBtn.setOnAction { logArea.clear() }

        // ===== Layout Utama =====
        val content = VBox(15.0)
        content.padding = Insets(20.0)
        content.alignment = Pos.TOP_LEFT

        content.children.addAll(
            titleLabel, titleLabel1,
            Separator(),
            splitMenuLabel, splitMenuButton,
            Separator(),
            toggleLabel, toggleBox,
            Separator(),
            radioLabel, radioBox,
            Separator(),
            checkLabel, checkBox,
            Separator(),
            choiceLabel, choiceBox,
            Separator(),
            comboLabel, comboBox,
            Separator(),
            logLabel, logArea, clearBtn
        )

        // Bungkus dengan ScrollPane
        val scrollPane = ScrollPane(content)
        scrollPane.isFitToWidth = true

        val scene = Scene(scrollPane, 500.0, 700.0)
        primaryStage.scene = scene
        primaryStage.show()
    }

    private fun log(msg: String) {
        logArea.appendText("$msg\n")
    }

    private fun status(cb: CheckBox) = if (cb.isSelected) "enabled" else "disabled"

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(kel3JavaFXApp::class.java)
        }
    }
}
