import {ChatMessagesController} from "./controller/ChatMessagesController.js";
import {ApplicationController} from "./controller/ApplicationController.js";
import {LoginFormController} from "./controller/LoginFormController.js";

export class Application {

    constructor () {
        this.initControllers();
    }

    initControllers () {
        new ApplicationController();
        new LoginFormController();
        new ChatMessagesController();
    }

}
