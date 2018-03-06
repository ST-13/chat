import {Form} from "./Form.js";

export class SendMessageForm extends Form {

    constructor (targetElement) {
        super(targetElement);
        this.element.className = 'send-message-form';
        this.userId = null;
        this.chatId = null;
        this.subscribe();
    }

    subscribe () {
        this.element.addEventListener('formSubmit', this.onFormSubmit.bind(this));
    }

    unsubscribe () {
        this.element.removeEventListener('formSubmit', this.onFormSubmit.bind(this));
    }

    onFormSubmit (event) {
        this.postChatMessage(event.detail.message);
        this.element.reset();
    }

    postChatMessage (message) {
        const url = 'http://localhost:8080/sendMessage';
        const xhr = new XMLHttpRequest();

        xhr.open('POST', url, true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send(JSON.stringify({
            "chatId": this.chatId,
            "senderId": this.userId,
            "text": message,
            "time": new Date()
        }));

        xhr.onreadystatechange = () => {
            if (xhr.readyState !== 4) {
                return;
            }

            if (xhr.status !== 200) {
                console.error( xhr.status + ': ' + xhr.statusText );
            }
        };
    }

    render () {
        this.element.innerHTML = `
            <textarea class="message-text-area" data-type="message" name="message-to-send" id="message-to-send" placeholder ="Type your message" rows="3"></textarea>
            <button class="send-button" type="submit">Send</button>
        `;
        this.targetElement.appendChild(this.element);
    }

}