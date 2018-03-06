import {Controller} from "./Controller.js";
import {LoginForm} from "../component/LoginForm.js";
import {Chat} from "../component/Chat.js";

export class ApplicationController extends Controller {

    init () {
        const targetElement = document.querySelector('.js-app');

        this.loginForm = new LoginForm(targetElement);
        this.chat = new Chat(targetElement);

        this.subscribe();
        this.showLoginForm();
    }

    subscribe () {
        this.loginForm.addEventListener('userInfoLoaded', this.onUserInfoLoaded.bind(this));
    }

    onUserInfoLoaded (event) {
        this.hideLoginForm();
        this.chat.loadContent(event.detail);
    }

    showLoginForm () {
        if (this.loginForm.hidden) {
            this.loginForm.setVisible(true);
        }
        this.loginForm.render();
    }

    hideLoginForm () {
        this.loginForm.setVisible(false);
    }
}