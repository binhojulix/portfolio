# This Python file uses the following encoding: utf-8
import sys
from PySide2.QtWidgets import QApplication, QWidget


class Main(QWidget):
    def __init__(self):
        QWidget.__init__(self)


if __name__ == "__main__":
    app = QApplication([])
    window = Main()
    window.show()
    sys.exit(app.exec_())
