import {Form} from "./Form.js";

export class LoginForm extends Form {

    render () {
        this.element.innerHTML = `
            <div class="grid">
                <div class="align">
                    <form class="form login">
        
                        <div class="form__field">
                            <label for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Username</span></label>
                            <input id="login__username" data-type="username" type="text" name="username" class="form__input" placeholder="Username" required>
                        </div>
        
                        <div class="form__field">
                            <input type="submit" value="Sign In">
                        </div>
                        
                    </form>
                </div>
            </div>
        `;
        this.targetElement.appendChild(this.element);
    }

}