import {Component} from "./Component.js";

export class ChatMessages extends Component {

    constructor (targetElement, store) {
        super(targetElement, store, 'ul');
        this.element.className = 'chat-messages';
        this.subscribe();
    }

    subscribe () {
        document.addEventListener('messagesStoreLoaded', this.onMessagesStoreLoaded.bind(this));
    }

    unsubscribe () {
        document.removeEventListener('messagesStoreLoaded', this.onMessagesStoreLoaded.bind(this));
    }

    onMessagesStoreLoaded () {
        this.render();
    }

    load (chatId) {
        this.startPolling(chatId);
    }

    startPolling (chatId) {
        this.stopPolling();
        this.intervalId = setInterval(this.getChatMessages.bind(this, chatId), 1000);
    }

    stopPolling () {
        if (this.intervalId) {
            clearInterval(this.intervalId);
        }
    }

    getChatMessages (chatId) {
        const url = 'http://localhost:8080/messages?chatId=' + chatId;
        const xhr = new XMLHttpRequest();

        xhr.open('GET', url, true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send();

        xhr.onreadystatechange = () => {
            if (xhr.readyState !== 4) {
                return;
            }

            if (xhr.status !== 200) {
                console.error( xhr.status + ': ' + xhr.statusText );
            } else {
                try {
                    const chatMessages = JSON.parse(xhr.responseText);
                    this.onGetChatMessagesSuccess(chatMessages);
                } catch (e) {
                    console.error( "Некорректный ответ " + e.message );
                }
            }
        };
    }

    onGetChatMessagesSuccess (chatMessages) {
        this.store.loadData(chatMessages);
    }

    render () {
        this.element.innerHTML = `
            ${this.getMessagesHtml()}
        `;
        this.targetElement.appendChild(this.element);
    }

    getMessagesHtml() {
        return this.store.getRange()
            .map((message) => `<li class="chat_message">${message.senderId}: ${message.text}</li>`)
            .join(`<br>`);
    }

}