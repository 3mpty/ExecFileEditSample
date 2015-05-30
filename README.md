# ExecFileEditSample

#### Sample JavaFX application that allow to pass data to other app and retrieve response.

App uses ProcessBuilder to execute jar builded from Editor submodule. It's required to start base application inside assets directory, it will allow to retrieve sample text file and start editor module.

Application passes data by simple args and wait for exit code, default one, 0 tells app to do nothing, exit code 1 tells to get data from standard output and pass it into text area. Editor will return exit code 1 only when save button pressed.

Application require controlfx library as dependency (used only for dialogs).
