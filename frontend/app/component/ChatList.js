import {Component} from "./Component.js";

export class ChatList extends Component {

    constructor (targetElement, store) {
        super(targetElement, store, 'ul');
        this.element.className = 'chat-list';
        this.subscribe();
    }

    subscribe () {
        document.addEventListener('chatListStoreLoaded', this.onChatListStoreLoaded.bind(this));
        this.element.addEventListener('click', this.onChatClick.bind(this));
    }

    unsubscribe () {
        document.removeEventListener('chatListStoreLoaded', this.onChatListStoreLoaded.bind(this));
        this.element.addEventListener('click', this.onChatClick.bind(this));
    }

    onChatListStoreLoaded () {
        this.render();
    }

    onChatClick (event) {
        const chatSelectedEvent = new CustomEvent('chatSelected', {
            detail: {
                chatId: event.target.dataset.chatid
            }
        });
        this.element.dispatchEvent(chatSelectedEvent);
    }

    load (userId) {
        this.getUserChatList(userId);
    }

    getUserChatList (userId) {
        const url = 'http://localhost:8080/chats?userId=' + userId;
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
                    const chatList = JSON.parse(xhr.responseText);
                    this.onGetUserChatListSuccess(chatList);
                } catch (e) {
                    console.error( "Некорректный ответ " + e.message );
                }
            }
        };
    }

    onGetUserChatListSuccess (chatList) {
        this.store.loadData(chatList);
    }

    render () {
        this.element.innerHTML = `
            ${this.getChatHtml()}
        `;
        this.targetElement.appendChild(this.element);
    }

    getChatHtml () {
        return this.store.getRange()
            .map((chat) => `<li class="chat-list-item" data-chatid="${chat.id}">${chat.name}</li>`)
            .join(`\n`);
    }

}