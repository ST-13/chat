import {Controller} from "./Controller.js";
import {LoginForm} from "../component/LoginForm.js";

export class LoginFormController extends Controller {

    init () {
        const targetElement = document.querySelector('.js-app');

        this.loginForm = new LoginForm(targetElement);

        this.addSubscriptions();
    }

    addSubscriptions () {
        document.addEventListener('showLoginForm', this.onShowLoginForm.bind(this));
        this.loginForm.getElement().addEventListener('formSubmit', this.onLoginFormSubmit.bind(this));
    }

    onShowLoginForm () {
        this.loginForm.render();
    }

    onLoginFormSubmit (event) {
        const data = event.detail;
        debugger;
    }

}