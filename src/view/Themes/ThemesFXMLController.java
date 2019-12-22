package view.Themes;

import controller.IMainController;

public class ThemesFXMLController {

    private IMainController controller;

    public ThemesFXMLController(IMainController controller){
        this.controller = controller;
    }

    public void chooseCharacter(){
        controller.switchView("Question");
    }

    public void backToMenu(){
        controller.switchView("MainMenu");
    }
}
