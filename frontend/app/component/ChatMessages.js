import {Component} from "./Component.js";

export class ChatMessages extends Component{

    render () {
        this.targetElement.innerHTML = `
            <div class="chat">
                <div class="chat__messages">
                    ${this.getMessagesHtml()}
                </div>
            </div>
        `;
    }

    getMessagesHtml() {
        return this.store.getRange()
            .map((messageObj) => `<span class="chat_message">${messageObj.nickname}:${messageObj.text}</span>`)
            .join(`<br>`);
    }

}