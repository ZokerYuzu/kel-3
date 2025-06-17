import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class SplitMenuButtonApp : Application() {
    override fun start(primaryStage: Stage) {
        // Buat SplitMenuButton
        val splitMenuButton = SplitMenuButton()
        splitMenuButton.text = "Pilih Opsi"

        // Tambahkan item ke SplitMenuButton
        val item1 = MenuItem("Opsi 1")
        val item2 = MenuItem("Opsi 2")
        val item3 = MenuItem("Opsi 3")

        splitMenuButton.items.addAll(item1, item2, item3)

        // Event handler untuk menu item
        item1.setOnAction {
            println("Opsi 1 dipilih")
        }
        item2.setOnAction {
            println("Opsi 2 dipilih")
        }
        item3.setOnAction {
            println("Opsi 3 dipilih")
        }

        // Event handler untuk tombol utama (bukan menu)
        splitMenuButton.setOnAction {
            println("Tombol utama diklik")
        }

        // Tambahkan ke layout
        val root = StackPane(splitMenuButton)
        val scene = Scene(root, 300.0, 200.0)

        primaryStage.title = "Contoh SplitMenuButton"
        primaryStage.scene = scene
        primaryStage.show()
    }
}

fun main() {
    Application.launch(SplitMenuButtonApp::class.java)
}
