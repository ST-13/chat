import {Form} from "./Form.js";

export class SendMessageForm extends Form {

    constructor (targetElement) {
        super(targetElement);
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
            "chatId": 1,
            "senderId": 1,
            "text": message
        }));

        xhr.onreadystatechange = () => {
            if (xhr.readyState !== 4) {
                return;
            }

            if (xhr.status !== 200) {
                alert( xhr.status + ': ' + xhr.statusText );
            }
        };
    }

    render () {
        this.element.innerHTML = `
            <div class="chat-message clearfix">

                <textarea data-type="message" name="message-to-send" id="message-to-send" placeholder ="Type your message" rows="3"></textarea>
                        
                <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
                <i class="fa fa-file-image-o"></i>
                
                <button type="submit">Send</button>
            
            </div>
        `;
        this.targetElement.appendChild(this.element);
    }

}