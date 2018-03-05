import {Controller} from "./Controller.js";

export class ApplicationController extends Controller {

    init () {
        setTimeout(function () {
            // document.dispatchEvent(new Event('loadChatMessages'));
            document.dispatchEvent(new Event('showLoginForm'));
        }, 1000);
    }
}